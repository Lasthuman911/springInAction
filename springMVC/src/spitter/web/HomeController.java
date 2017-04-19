package spitter.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Name: admin
 * Date: 2017/3/27
 * Time: 9:21
 */
@Controller//声明为一个控制器，也可以用@component,效果是一样的
@RequestMapping({"/","/homepage"})//home()方法能够映射到对“/”和“homepage”的GET请求
public class HomeController {

   // @RequestMapping(value = "/", method = RequestMethod.GET)//处理对“/“ 的GET请求
    @RequestMapping(method = RequestMethod.GET)
    public String home(){
        return "home";//视图名为home
    }
}
