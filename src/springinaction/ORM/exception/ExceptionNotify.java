package springinaction.ORM.exception;

import org.springframework.core.NestedRuntimeException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * Created by admin on 2017/2/11.
 */
public class ExceptionNotify {
    public static RuntimeException getNotifyException(Throwable e){

        if (e instanceof DuplicateNameSignal)
            return (DuplicateNameSignal) e;
        else if (e instanceof NotFoundSignal)
            return (NotFoundSignal) e;
        else if (e instanceof InvalidStateTransitionSignal)
            return (InvalidStateTransitionSignal) e;
        else if (e instanceof FrameworkErrorSignal)
            return (FrameworkErrorSignal) e;
        else if (e instanceof nanoFrameDBErrorSignal)
        {
            nanoFrameDBErrorSignal ne = (nanoFrameDBErrorSignal) e;
            if (ErrorSignal.NotFoundSignal.equals(ne.getErrorCode()))
            {
                throw new NotFoundSignal(ne, ne.getDataKey(), ne.getSql());
            }
            else if (ErrorSignal.DuplicateNameSignal.equals(ne.getErrorCode()))
            {
                throw new DuplicateNameSignal(ne, ne.getDataKey(), ne.getSql());
            }
            else if (ErrorSignal.DataAccessException.equals(ne.getErrorCode()))
            {
                Throwable te = ne.getCause();

                if (te instanceof SQLException)
                {
                    throw getNotifyException((SQLException) te, ne.getDataKey(), ne.getSql());
                }
                else if (te instanceof EmptyResultDataAccessException)
                    throw new NotFoundSignal(te, ne.getDataKey(), ne.getSql());
                else if (te instanceof DataAccessException)
                    throw getNotifyException((DataAccessException) te, ne.getDataKey(), ne.getSql());
            }
            else if (ErrorSignal.NullPointKeySignal.equals(ne.getErrorCode()))
            {
                throw new FrameworkErrorSignal(ExceptionKey.NullPointKey_Exception, ne, ne.getDataKey());
            }
            return ne;
            //			return new FrameworkErrorSignal(ExceptionKey.UnExpected_Exception, ne, ne.getMessage());
            //			return new FrameworkErrorSignal(ExceptionKey.UnExpected_Exception, ne, ne.getMessage(), ne.getBindSet(), ne.getSql());
        }
        else if (e instanceof nanoFrameErrorSignal)
        {
            return (nanoFrameErrorSignal) e;
        }
        else if (e instanceof SQLException)
        {
            return getNotifyException((SQLException) e, "", "");
        }
        else if (e instanceof DataAccessException)
        {
            return getNotifyException((DataAccessException) e, "", "");
        }
        else if (e instanceof InvocationTargetException)
        {
            Throwable targetEx = ((InvocationTargetException) e).getTargetException();
            return getNotifyException(targetEx);
        }
        else if (e instanceof NestedRuntimeException)
        {
            Throwable t = ((NestedRuntimeException) e).getMostSpecificCause();
            if (t == null)
                t = e;
            return new FrameworkErrorSignal(ExceptionKey.UnExpected_Exception, t, t.getClass().getSimpleName()
                    + ":"
                    + t.getMessage());
        }
        else
        {
            return new FrameworkErrorSignal(ExceptionKey.UnExpected_Exception, e, e.getClass().getSimpleName()
                    + ":"
                    + e.getMessage());
        }

    }
}
