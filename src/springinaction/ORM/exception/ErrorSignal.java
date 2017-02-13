package springinaction.ORM.exception;

import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataAccessException;

import java.sql.SQLException;

/**
 * Created by admin on 2017/2/10.
 */
public class ErrorSignal
{
    public final static String NotActive = "NotActive";
    public final static String NullPointKeySignal = "NullPointKeySignal";
    public final static String NoDefineServiceBean = "NoDefineServiceBean";
    public static final String DataAccessException = "DataAccessException";
    public final static String DuplicateNameSignal = "DuplicateNameSignal";
    public final static String InvalidQueryState = "InvalidQueryState";
    public final static String NotFoundSignal = "NotFoundSignal";
    public final static String NoServiceRegistered = "NoServiceRegistered";
    public final static String NotDefineObjectAttributeSignal = "NotDefineObjectAttributeSignal";
    public final static String InvalidQueryType = "InvalidQueryType";

    public static nanoFrameDBErrorSignal getNotifyException(DataAccessException e, String bindSet, String sql)
    {
        Throwable cause = e.getMostSpecificCause();
        if (cause != null && cause instanceof SQLException)
        {
            return getNotifyException((SQLException) cause, bindSet, sql);
        }
        return new nanoFrameDBErrorSignal(ErrorSignal.DataAccessException, bindSet, sql, e);
    }

    public static nanoFrameDBErrorSignal getNotifyException(SQLException e, String bindSet, String sql)
    {
        String errorCode;
        if (e.getErrorCode() == 1)
            errorCode = ErrorSignal.DuplicateNameSignal;
        else
            errorCode = ErrorSignal.DataAccessException;

        if (StringUtils.isNotEmpty(bindSet) && StringUtils.isNotEmpty(sql))
            return new nanoFrameDBErrorSignal(errorCode, bindSet, sql, e);
        else if (StringUtils.isNotEmpty(sql))
            return new nanoFrameDBErrorSignal(errorCode, sql, e);
        else
            return new nanoFrameDBErrorSignal(errorCode, e);
    }
}
