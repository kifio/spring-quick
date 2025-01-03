package me.kifio;

import org.springframework.context.annotation.*;

@ComponentScan("me.kifio")
@Configuration
public class ProjectConfig {

    @Bean()
    Parrot parrot() {
        Parrot p = new Parrot();
        p.setName("Koko");
        return p;
    }

//    @Bean
//    Kid kid(Parrot parrot) {
//        Kid leo = new Kid();
//        leo.name = "Leo";
//        leo.parrot = parrot;
//        return leo;
//    }
}
