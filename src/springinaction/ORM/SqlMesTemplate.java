package springinaction.ORM;

import springinaction.ORM.exception.DuplicateNameSignal;
import springinaction.ORM.exception.ExceptionNotify;
import springinaction.ORM.exception.FrameworkErrorSignal;
import springinaction.ORM.exception.nanoFrameDBErrorSignal;

/**
 * Created by admin on 2017/2/10.
 */
public class SqlMesTemplate {
    private SqlTemplate sqlTemplate = null;

    public int update(String sql, Object... args) throws DuplicateNameSignal, FrameworkErrorSignal {
        try {
            return this.sqlTemplate.update(sql, args);
        } catch (nanoFrameDBErrorSignal e) {
            throw ExceptionNotify.getNotifyException(e);
        }
    }
}
