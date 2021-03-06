/*
 * Copyright 2013 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at http://www.eclipse.org/legal/epl-v10.html
 */
package io.liveoak.stomp.client.protocol;

import io.liveoak.stomp.Stomp;
import io.liveoak.stomp.client.StompClient;
import io.netty.channel.Channel;

/**
 * @author Bob McWhirter
 */
public interface StompClientContext {
    void setConnectionState(StompClient.ConnectionState connectionState);

    void setChannel(Channel channel);

    void setVersion(Stomp.Version version);

    String getHost();

    String getLogin();

    String getPasscode();

    StompClient getClient();
}
