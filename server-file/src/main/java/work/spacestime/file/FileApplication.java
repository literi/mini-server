package work.spacestime.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages={"work.spacestime"})
public class FileApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileApplication.class, args);
	}
}