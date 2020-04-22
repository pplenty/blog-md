package com.pplenty.config;

import com.pplenty.CustomBeanScopeApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by yusik on 2020/04/21.
 */
@SpringBootTest(classes = {CustomBeanScopeApplication.class, TestBeanConfig.class})
class TwiceScopeTest {

    @Autowired
    ApplicationContext applicationContext;

    @DisplayName("2번만 유지 되는 빈 스코프")
    @Test
    void get() {

        // given
        String beanName = "onlyTwice";

        // when
        Object scopedBean1 = applicationContext.getBean(beanName);
        Object scopedBean2 = applicationContext.getBean(beanName);
        Object scopedBean3 = applicationContext.getBean(beanName);
        Object scopedBean4 = applicationContext.getBean(beanName);
        System.out.println("1st getBean : " + scopedBean1);
        System.out.println("2nd getBean : " + scopedBean2);
        System.out.println("3rd getBean : " + scopedBean3);
        System.out.println("4th getBean : " + scopedBean4);

        // then
        assertThat(scopedBean1).isEqualTo(scopedBean2);
        assertThat(scopedBean2).isNotEqualTo(scopedBean3);
        assertThat(scopedBean3).isEqualTo(scopedBean4);
    }
}