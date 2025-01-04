import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "repositories", "services" })
public class ProjectConfig {
    @Bean
    Integer twoHundredTwentyFive() {
        return 2025;
    }
}
