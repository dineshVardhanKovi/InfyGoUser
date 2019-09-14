package com.dinesh.infyGo.user.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfyGoUserConfig {
	@Bean
	public DozerBeanMapper beanMapper() {
		return new DozerBeanMapper();
	}
}
