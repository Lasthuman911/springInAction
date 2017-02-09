package springinaction.ORM.CTORM;

/**
 * Created by admin on 2017/2/9.
 */
public class CTORMService<DATA> {
    public void insert(DATA dataInfo){
        String tableName = CTORMUtil.getTableNameByClassName(dataInfo.getClass());
    }
}
