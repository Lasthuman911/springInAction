package springinaction.ORM.generic.validation;

import springinaction.ORM.SqlMesTemplate;
import springinaction.ORM.common.BundleUtil;

/**
 * Created by admin on 2017/2/10.
 */
public class GenericServiceProxy {
    public static SqlMesTemplate getSqlMesTemplate(){
        return (SqlMesTemplate) BundleUtil.getBundleServiceClass(SqlMesTemplate.class);
    }
}
