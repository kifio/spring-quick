package me.kifio;

import org.springframework.context.annotation.*;

public class Main {
    public static void main(String[] args) {
//        Parrot p = new Parrot();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());

        p.setName("Riki");

        Parrot p2 = context.getBean(Parrot.class);
        System.out.println(p2.getName());

        Kid k = context.getBean(Kid.class);
        System.out.println(k);
    }
}