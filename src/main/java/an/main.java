package an;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "an", "an.controller", "an.model", "an.respository", "an.service","dto" })
public class main {
	public static void main(String[] args) {

		SpringApplication.run(main.class, args);
	}
}
