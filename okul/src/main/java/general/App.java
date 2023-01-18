package general;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class App {

    public static void main(String[] args) {

        SpringApplication.run(App.class, args);
//        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(s -> System.out.println(s.toUpperCase()));

    }
}
