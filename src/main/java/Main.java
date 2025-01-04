import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.SomeService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var year = context.getBean("twoHundredTwentyFive", Integer.class);
        var year2 = context.getBean("twoHundredTwentyFive", Integer.class);

        var service1 = context.getBean(SomeService.class);
        var service2 = context.getBean(SomeService.class);

        System.out.println("year2 == year: " + (year2 == year));
        System.out.println("service1 == service2: " + (service1 == service2));
        System.out.println("service2.getSomeRepo() == service1.getSomeRepo(): " + (service2.getSomeRepo() == service1.getSomeRepo()));
    }
}
