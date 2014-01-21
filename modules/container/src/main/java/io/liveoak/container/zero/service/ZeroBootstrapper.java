package io.liveoak.container.zero.service;

import io.liveoak.container.extension.ExtensionInstaller;
import io.liveoak.container.zero.extension.ZeroExtension;
import org.jboss.msc.inject.Injector;
import org.jboss.msc.service.Service;
import org.jboss.msc.service.StartContext;
import org.jboss.msc.service.StartException;
import org.jboss.msc.service.StopContext;
import org.jboss.msc.value.InjectedValue;

/**
 * @author Bob McWhirter
 */
public class ZeroBootstrapper implements Service<Void> {
    @Override
    public void start(StartContext context) throws StartException {
        try {
            this.extensionInstallerInjector.getValue().load( "zero", new ZeroExtension() );
        } catch (Exception e) {
            throw new StartException(e);
        }
    }

    @Override
    public void stop(StopContext context) {

    }

    @Override
    public Void getValue() throws IllegalStateException, IllegalArgumentException {
        return null;
    }

    public Injector<ExtensionInstaller> extensionInstallerInjector() {
        return this.extensionInstallerInjector;
    }

    private InjectedValue<ExtensionInstaller> extensionInstallerInjector = new InjectedValue<>();
}
