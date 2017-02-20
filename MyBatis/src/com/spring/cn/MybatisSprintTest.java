package com.spring.cn;

import com.model.Durable;
import com.model.Idurable.IdurableOperation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by admin on 2017/2/14.
                */
        public class MybatisSprintTest {
            private static ApplicationContext ctx;

            static {
                ctx = new ClassPathXmlApplicationContext("com/spring/config/applicationContext.xml");
            }

            public static void main(String[] args){
                IdurableOperation mapper = (IdurableOperation) ctx.getBean("userMapper");

                Durable durable = mapper.selectDurableByDurableName("LLList");

                System.out.println(durable.getDurableType());

    }
}
