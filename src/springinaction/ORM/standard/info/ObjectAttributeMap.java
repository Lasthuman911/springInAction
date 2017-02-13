package springinaction.ORM.standard.info;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Created by admin on 2017/2/13.
 */
public class ObjectAttributeMap implements ApplicationContextAware, InitializingBean, Serializable {
    public static String Standard_Type = "Standard";
    public final static String ExtendedC_Type = "ExtendedC";
    private ApplicationContext context;

    private Map<String, List<ObjectAttributeDef>> objectAttributeDefList = new ConcurrentHashMap<String, List<ObjectAttributeDef>>();

    @Override
    public void afterPropertiesSet() throws Exception {
        load();
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

    public synchronized void load() {

    }

    public List<ObjectAttributeDef> getAttributeNames(String typeName, String attributeTypeName) {
        return this.getMap().get(typeName + "." + attributeTypeName);
    }

    public Map<String, List<ObjectAttributeDef>> getMap() {
        return objectAttributeDefList;
    }
}
