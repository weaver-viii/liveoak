package io.liveoak.container.extension;

import java.util.Properties;

import io.liveoak.container.tenancy.ConfigurationManager;
import io.liveoak.spi.RequestContext;
import io.liveoak.spi.client.Client;
import io.liveoak.spi.resource.RootResource;
import io.liveoak.spi.resource.async.Responder;

/**
 * @author <a href="mailto:mwringe@redhat.com">Matt Wringe</a>
 * @author Ken Finnigan
 */
public class SystemResourceWrappingResource extends ConfigResourceWrappingResource {

    public SystemResourceWrappingResource(ConfigurationManager configManager, RootResource delegate, Properties envProps, Client client) {
        super(configManager, delegate, envProps, client);
    }

    @Override
    public String extensionId() {
        return ((ExtensionConfigurationManager)configManager).extensionId();
    }

    @Override
    public boolean resourceVersioned() {
        return false;
    }

    @Override
    public String versionedResourcePath() {
        return null;
    }

    @Override
    public void delete(RequestContext ctx, Responder responder) throws Exception {
        ConfigVersioningResponder configVersioningResponder = new ConfigVersioningResponder(responder, resourceVersioned(), versionedResourcePath(), this.client, ctx.securityContext());
        delegate().delete(ctx, new DeleteResponder(configVersioningResponder));
    }
}
