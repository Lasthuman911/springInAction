package spitter.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 扩
 * 展AbstractAnnotationConfigDispatcherServletInitializer的任意类都会自动地配置DispatcherServlet和Spring应用上下文， Spring的应用上下文会位于应用程序 的Servlet上下文之中
 * Created by admin on 2017/2/8.
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     *GetServletConfigClasses()方法返回的带有@Configuration注解的类将会用来定义DispatcherServlet应用上下文中的bean
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {//指定配置类,我们要
     /*   求DispatcherServlet加载应用上下文时， 使用定义在WebConfig配置类（使用Java配置） 中的bean*/
        return new Class<?>[]{WebConfig.class};
    }

    /**
     * getRootConfigClasses()方法返回的带有@Configuration注解的类将会用来配置ContextLoaderListener创建的应用上下文中的bean
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};//将DispatcherServlet映射到“/”
    }
}
