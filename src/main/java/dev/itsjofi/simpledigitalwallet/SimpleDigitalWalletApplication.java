package dev.itsjofi.simpledigitalwallet;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEncryptableProperties
@SpringBootApplication
public class SimpleDigitalWalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleDigitalWalletApplication.class, args);
	}

}
