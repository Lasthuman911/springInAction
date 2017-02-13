package springinaction.ORM.standard;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.dao.DataAccessException;
import springinaction.ORM.CTORM.SQLLogUtil;
import springinaction.ORM.exception.ErrorSignal;
import springinaction.ORM.exception.nanoFrameDBErrorSignal;
import springinaction.ORM.nanoFrameServiceProxy;
import springinaction.ORM.object.ObjectUtil;
import springinaction.ORM.standard.util.OrmStandardEngineUtil;

import java.util.List;

import static javafx.scene.input.KeyCode.O;

/**
 * Created by admin on 2017/2/13.
 */
public class OrmStandardEngine<KEY extends KeyInfo, DATA extends DataInfo> implements ApplicationContextAware
{
    protected ApplicationContext applicationContext;
    private Log log = LogFactory.getLog(OrmStandardEngine.class);

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        this.applicationContext = applicationContext;
    }

    public DATA selectByKeyForUpdate(KEY keyInfo) throws nanoFrameDBErrorSignal
    {
        return (DATA) execute("select.for.update", keyInfo);
    }

    protected Object execute(String queryType, Object dataObject) throws nanoFrameDBErrorSignal
    {

        String sql = "";
        int resultSize= 0;
        List resultList =null;
        try
        {
            if (queryType.equalsIgnoreCase("select") || queryType.equalsIgnoreCase("select.for.update"))
            {
                KeyInfo keyInfo = OrmStandardEngineUtil.getKeyInfo(dataObject);
                if (ObjectUtil.isNullOrNullString(keyInfo))
                    throw new nanoFrameDBErrorSignal(ErrorSignal.NullPointKeySignal, ObjectUtil.getString(keyInfo), queryType, "key can't be null");

                sql = OrmStandardEngineUtil.generateSqlStatement("select", dataObject);
                if (queryType.equalsIgnoreCase("select.for.update"))
                    sql += "FOR UPDATE";
                resultList = queryForList(sql,OrmStandardEngineUtil.getSelectOrDeleteBindObjects(dataObject));

                if (resultList.size() == 0)
                {
                    throw new nanoFrameDBErrorSignal(ErrorSignal.NotFoundSignal,ObjectUtil.getString(OrmStandardEngineUtil.getKeyInfo(dataObject)),
                            SQLLogUtil.getLogFormatSqlStatement(sql,OrmStandardEngineUtil.getSelectOrDeleteBindObjects(dataObject),log));
                }
            }
            else
            {
                sql = OrmStandardEngineUtil.generateSqlStatement(queryType,dataObject);
                if (queryType.equalsIgnoreCase("delete"))
                    resultSize = update(sql,OrmStandardEngineUtil.getSelectOrDeleteBindObjects(dataObject),ObjectUtil.getString(OrmStandardEngineUtil.getKeyInfo(dataObject)));
                else if (queryType.equalsIgnoreCase("update"))
                    resultSize = update(sql,,ObjectUtil.getString(OrmStandardEngineUtil.getKeyInfo(dataObject)));
                else if (queryType.equalsIgnoreCase("insert"))
                    ;
                else
                {

                }
                if (resultSize==0)
                {

                }
                return  resultSize;
            }
        }catch (DataAccessException e)
        {

        }
        return ;
    }

    private int update(String sql, Object[] args, String  keyString) throws nanoFrameDBErrorSignal{
        String logFormatSql = SQLLogUtil.getLogFormatSqlStatement(sql,args,log);
        int result =0;
        try
        {
            SQLLogUtil.logBeforeExecuting(logFormatSql,log);
            if (args == null)
                result = nanoFrameServiceProxy.getSqlTemplate().getJdbcTemplate().update(sql);
            else
                result = nanoFrameServiceProxy.getSqlTemplate().getJdbcTemplate().update(sql,args);
        }
        catch (DataAccessException e)
        {
            if (keyString != null)
            {
                throw ErrorSignal.getNotifyException(e, keyString, logFormatSql);
            }
            else
            {
                throw ErrorSignal.getNotifyException(e, ObjectUtil.getString(args), logFormatSql);
            }
        }
        SQLLogUtil.logAfterUpdate(result,log);
        return result;
    }

    private List queryForList(String sql, Object... args) throws nanoFrameDBErrorSignal
    {
        List resultList = null;
        String logFormatSql = SQLLogUtil.getLogFormatSqlStatement(sql,args, log);

        try
        {
            SQLLogUtil.logBeforeExecuting(logFormatSql,log);

            if (ArrayUtils.isEmpty(args))
                resultList =  nanoFrameServiceProxy.getSqlTemplate().getJdbcTemplate().queryForList(sql);
            else
            {

                if (args.length == 1 && args[0] == null)
                    resultList = nanoFrameServiceProxy.getSqlTemplate().getJdbcTemplate().queryForList(sql);
                else
                    resultList = nanoFrameServiceProxy.getSqlTemplate().getJdbcTemplate().queryForList(sql, args);

            }
        }catch (DataAccessException e){
            throw ErrorSignal.getNotifyException(e,ObjectUtil.getString(args),logFormatSql);
        }
        SQLLogUtil.logAfterQuery(resultList,log);
        return resultList;

    }


}
