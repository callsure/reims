package olg.reims.log;

/**
 * 数据库保存日志的基类
 * 2021/6/9
 * Created by runshu.lin
 */
public abstract class BaseLog {

    public abstract void save();

    String serializeToString() {
        return this.toString();
    }
}
