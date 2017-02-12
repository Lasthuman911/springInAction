package springinaction.ORM.exception;

/**
 * Created by admin on 2017/2/11.
 */
public class nanoFrameDBErrorSignal extends nanoFrameErrorSignal {
    private String sql ="";
    private String dataKey ="";
    public nanoFrameDBErrorSignal(String errorCode, String msg) {
        super(errorCode, msg);
    }

    public nanoFrameDBErrorSignal(String errorCode, Throwable throwable)
    {
        super(errorCode, throwable.getMessage(), throwable);
    }

    public nanoFrameDBErrorSignal(String errorCode, String dataKey, String sql, Throwable throwable)
    {

        super(errorCode, String.format("%s [DataKey=%s] [Sql=%s]", throwable.getMessage(), dataKey, sql), throwable);
        this.dataKey = dataKey;
        this.sql = sql;
    }

    public nanoFrameDBErrorSignal(String errorCode, String sql, Throwable throwable)
    {
        super(errorCode, String.format("%s [Sql=%s]", throwable.getMessage(), sql), throwable);
        this.sql = sql;
    }
    public nanoFrameDBErrorSignal(String errorCode, String dataKey, String sql)
    {
        super(errorCode, String.format("[DataKey=%s] [Sql=%s]", dataKey, sql));
        this.dataKey = dataKey;
        this.sql = sql;
    }

}
