import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(basePackages = {
        "com.cbat.usermanager"
        ,"com.cbat.exception"
        , "com.cbat.core"
        ,"com.cbat.monitor"})
@EnableSwagger2
@SpringBootApplication
public class CbatWebApplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(CbatWebApplication.class, args);

    }
}
