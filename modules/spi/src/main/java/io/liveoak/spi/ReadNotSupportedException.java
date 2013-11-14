package io.liveoak.spi;

/**
 * @author Bob McWhirter
 */
public class ReadNotSupportedException extends ResourceException {

    public ReadNotSupportedException(String path) {
        super(path, "Read not supported for '" + path + "'" );
    }
}