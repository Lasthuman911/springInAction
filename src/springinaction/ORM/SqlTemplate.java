package springinaction.ORM;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import springinaction.ORM.exception.nanoFrameDBErrorSignal;

/**
 * Created by admin on 2017/2/11.
 */
public class SqlTemplate implements InitializingBean{
    private static Log log = LogFactory.getLog(SqlTemplate.class);
    private JdbcTemplate jdbcTemplate;

    public int update(String sql, Object... args) throws nanoFrameDBErrorSignal
    {
        int result =0;
        result = getJdbcTemplate().update(sql,args);
        return result;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
