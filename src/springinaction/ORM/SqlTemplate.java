package springinaction.ORM;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import springinaction.ORM.CTORM.SQLLogUtil;
import springinaction.ORM.exception.ErrorSignal;
import springinaction.ORM.exception.nanoFrameDBErrorSignal;
import springinaction.ORM.object.ObjectUtil;

/**
 * Created by admin on 2017/2/11.
 */
public class SqlTemplate implements InitializingBean {
    private static Log log = LogFactory.getLog(SqlTemplate.class);
    private JdbcTemplate jdbcTemplate;

    public int update(String sql, Object... args) throws nanoFrameDBErrorSignal {
        String logFormatSql = SQLLogUtil.getLogFormatSqlStatement(sql, args, log);
        int result = 0;
        try {
            SQLLogUtil.logBeforeExecuting(logFormatSql, log);
            if (args == null)
                result = getJdbcTemplate().update(sql);
            else
                result = getJdbcTemplate().update(sql, args);
        } catch (DataAccessException e) {
            throw ErrorSignal.getNotifyException(e, ObjectUtil.getString(args), logFormatSql);
        }
        SQLLogUtil.logBeforeExecuting(logFormatSql, log);
        return result;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
