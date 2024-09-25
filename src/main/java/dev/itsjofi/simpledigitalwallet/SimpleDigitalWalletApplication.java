package dev.itsjofi.simpledigitalwallet;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEncryptableProperties
@EnableFeignClients
@SpringBootApplication
public class SimpleDigitalWalletApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();

		System.setProperty("DB_HOST", dotenv.get("DB_HOST"));
		System.setProperty("DB_PORT", dotenv.get("DB_PORT"));
		System.setProperty("DB_NAME", dotenv.get("DB_NAME"));
		System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
		System.setProperty("JASYPT_ENCRYPTOR_PASSWORD", dotenv.get("JASYPT_ENCRYPTOR_PASSWORD"));

		SpringApplication.run(SimpleDigitalWalletApplication.class, args);

	}

}
