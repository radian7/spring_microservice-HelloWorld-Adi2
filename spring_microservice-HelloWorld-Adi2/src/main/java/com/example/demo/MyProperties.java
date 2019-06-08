package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

//@RefreshScope
//@Configuration
//@ConfigurationProperties("config")
public class MyProperties {

    private String testkey;

	public String getTestkey() {
		return testkey;
	}

	public void setTestkey(String testkey) {
		this.testkey = testkey;
	}



}
