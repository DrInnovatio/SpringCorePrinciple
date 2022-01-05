package hello.core.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.testng.annotations.Test;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class Singleton {

    @Test
    void singletonBeanFind(){
        AnnotationConfigApplicationContext ac =  new AnnotationConfigApplicationContext(SingletonBean.class);
        SingletonBean singletonBean1 =  ac.getBean(SingletonBean.class);
        SingletonBean singletonBean2 =  ac.getBean(SingletonBean.class);

        System.out.println("SingletonBean1 "  + singletonBean1);
        System.out.println("SingletonBean2 "  + singletonBean2);

        assertThat(singletonBean1).isSameAs(singletonBean2);
    }
    @Scope("singleton")
    static class SingletonBean {
        @PostConstruct
        public void init(){
            System.out.println("SingletonBean.init");
        }
        @PreDestroy
        public void destroy(){
            System.out.println("SingletonBean.destroy");
        }
    }
}
