package olg.reims.core.exception;

/**
 * 2021/6/17
 * Created by runshu.lin
 */
public class ServerBootstrapException extends RuntimeException {

    public ServerBootstrapException(String msg) {
        super(msg);
    }

    public ServerBootstrapException(String msg, Exception e) {
        super(msg, e);
    }
}
