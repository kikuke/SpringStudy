package com.kikuke.toy1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class SimpleRPGApplication {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SimpleRPGApplication.class);
        Launcher launcher = ac.getBean(Launcher.class);

        launcher.play();
    }
}
