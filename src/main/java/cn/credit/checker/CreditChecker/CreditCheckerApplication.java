package cn.credit.checker.CreditChecker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CreditCheckerApplication {

	private static final Logger log = LoggerFactory.getLogger(CreditCheckerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CreditCheckerApplication.class, args);
	}
}
