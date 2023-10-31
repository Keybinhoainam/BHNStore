package B19DCCN445;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import B19DCCN445.config.StorageProperties;
import B19DCCN445.service.StorageService;



@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class BhnStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BhnStoreApplication.class, args);
	}
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args->{
			storageService.init();
		});
	}
}
