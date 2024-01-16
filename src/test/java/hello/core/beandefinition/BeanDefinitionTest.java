package hello.core.beandefinition;

import hello.core.AppConfig;
import hello.core.xml.XmlAppContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {

    // ApplicationContext 에는 getBeanDefinition이 없다
    // Java Code 를 통해 Bean을 등록하는 경우... -> FactoryBean을 통해 등록하는 방식...
//    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    // Generic bean
    GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(name);
            System.out.println("name = " + name +
                               " beanDefinition = " + beanDefinition);
        }
    }

}
