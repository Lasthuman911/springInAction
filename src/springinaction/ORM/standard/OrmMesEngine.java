package springinaction.ORM.standard;

import springinaction.ORM.exception.FrameworkErrorSignal;
import springinaction.ORM.exception.NotfoundSignal;

/**
 * Created by admin on 2017/2/13.
 */
public class OrmMesEngine<KEY extends KeyInfo,DATA extends DataInfo> extends OrmStandardEngine<KEY, DATA> {
    public DATA selectByKeyForUpdate(KEY keyInfo) throws NotfoundSignal,FrameworkErrorSignal{
        try {
            DATA result = (DATA) super.selectByKeyForUpdate(keyInfo);
        }
    }
}
