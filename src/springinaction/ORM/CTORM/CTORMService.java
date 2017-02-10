package springinaction.ORM.CTORM;

import springinaction.ORM.common.CommonUtil;
import springinaction.ORM.exception.ErrorSignal;
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
        //TODO
     /*   if (!CTORMUtil.validateKeyParam(dataInfo,keySet.toArray()).isEmpty())
            throw new nanoFrameDBErrorSignal(ErrorSignal.NullPointKeySignal, param,
                    SQLLogUtil.getLogFormatSqlStatement(sql, param, CTORMUtil.getLogger()));*/
        List<Object> binSet = CTORMUtil.makeNonkeyParam(dataInfo);
        keySet.addAll(binSet);
        param = CommonUtil.toStringFromCollection(binSet.toArray());

        int result = GenericServiceProxy.getSqlMesTemplate().update();
    }
}
