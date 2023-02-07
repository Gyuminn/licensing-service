package com.optimagrowth.license;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class LicenseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LicenseServiceApplication.class, args);
	}

	// 애플리케이션을 다른 언어에 적응할 수 있도록 하는 필수 요구사항인 국제화 추가
	// 메시지를 조회할 때 Locale을 설정하지 않으면 messageSource는 LocaleResolver로 설정된 디폴트 로케일을 사용.
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		// US를 기본 로케일로 설정한다.
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		// 메시지가 발견되지 않아도 에러를 던지지 않고 대신 메시지 코드를 반환한다.
		messageSource.setUseCodeAsDefaultMessage(true);
		// 언어 프로퍼티 파일의 기본 이름을 설정한다.
		// 예를 들어 이탈리아에 있다면 'Locale.IT'를 사용하고 'messages_it.properties'라는 파일을 갖는다.
		messageSource.setBasenames("messages");
		return messageSource;
	}

}
