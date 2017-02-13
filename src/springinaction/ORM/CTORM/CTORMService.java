package springinaction.ORM.CTORM;

import springinaction.ORM.common.CommonUtil;
import springinaction.ORM.exception.ErrorSignal;
import springinaction.ORM.exception.nanoFrameDBErrorSignal;
import springinaction.ORM.generic.validation.GenericServiceProxy;

import java.util.List;

/**
 * Created by admin on 2017/2/9.
 */
public class CTORMService<DATA> {
    public void insert(DATA dataInfo){
        String tableName = CTORMUtil.getTableNameByClassName(dataInfo.getClass());
        String sql = CTORMUtil.getInsertSql(dataInfo.getClass(),tableName);

        List<Object> keySet = CTORMUtil.makeKeyParam(dataInfo);

        String param = CommonUtil.toStringFromCollection(keySet.toArray());

        if (!CTORMUtil.validateKeyParam(dataInfo,keySet.toArray()).isEmpty())
            throw new nanoFrameDBErrorSignal(ErrorSignal.NullPointKeySignal, param,
                    SQLLogUtil.getLogFormatSqlStatement(sql, param, CTORMUtil.getLogger()));
        List<Object> binSet = CTORMUtil.makeNonkeyParam(dataInfo);
        keySet.addAll(binSet);
        param = CommonUtil.toStringFromCollection(binSet.toArray());

        int result = GenericServiceProxy.getSqlMesTemplate().update(sql, keySet.toArray());

        //TODO
        Object o = (Object)param;
        if (result == 0)
            //TODO why string->objec
            throw new nanoFrameDBErrorSignal(ErrorSignal.InvalidQueryState, param,
                    SQLLogUtil.getLogFormatSqlStatement(sql, param, CTORMUtil.getLogger()));
    }

    public void delete(DATA dataInfo) throws nanoFrameDBErrorSignal{
        List<Object> keySet = CTORMUtil.makeKeyParam(dataInfo);
        delete(dataInfo.getClass(),keySet.toArray());
    }

    public void delete(Class clazz,Object... keyValue) throws nanoFrameDBErrorSignal{
        Object dataInfo = CTORMUtil.createDataInfo(clazz);

        String tableName = CTORMUtil.getTableNameByClassName(dataInfo.getClass());

        String sql = CTORMUtil.getDeleteSql(dataInfo.getClass(),tableName);

        String param = CommonUtil.toStringFromCollection(keyValue);

        if (!CTORMUtil.validateKeyParam(dataInfo, keyValue).isEmpty())
            throw new nanoFrameDBErrorSignal(ErrorSignal.NullPointKeySignal, param,
                    SQLLogUtil.getLogFormatSqlStatement(sql, param, CTORMUtil.getLogger()));


        int result = GenericServiceProxy.getSqlMesTemplate().update(sql,keyValue);

        if (result == 0){
            throw new nanoFrameDBErrorSignal(ErrorSignal.NotFoundSignal,param
            ,SQLLogUtil.getLogFormatSqlStatement(sql,param,CTORMUtil.getLogger()));
        }
    }
}
