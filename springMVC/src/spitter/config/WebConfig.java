package spitter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by admin on 2017/2/8.
 */
@Configuration
@EnableWebMvc//启用spring MVC
@ComponentScan("spitter.web")
public class WebConfig extends WebMvcConfigurerAdapter{

    @Bean//配置jsp视图解析器
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
      /*  在查找的时候， 它会在视图名称上加一个特定的前缀和后缀（ 例如， 名为home的视图将会解析为WEB-INFviews/home.jsp）*/
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
       // super.configureDefaultServletHandling(configurer);
        //配置静态资源处理
        configurer.enable();//我们要求DispatcherServlet将对静态资源的请求转发到Servlet容器中默认的Servlet上,而不是使用DispatcherServlet本身来处理此类请求
    }
}
