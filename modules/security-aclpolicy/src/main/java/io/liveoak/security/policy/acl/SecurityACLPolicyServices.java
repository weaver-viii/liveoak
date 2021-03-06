package io.liveoak.security.policy.acl;

import io.liveoak.spi.Services;
import org.jboss.msc.service.ServiceName;

/**
 * @author Bob McWhirter
 */
public class SecurityACLPolicyServices {
    private static final ServiceName ACL_POLICY = Services.LIVEOAK.append("acl-policy");

    public static ServiceName policy(String appId, String resourceId) {
        return ACL_POLICY.append("policy", appId, resourceId);
    }
}
