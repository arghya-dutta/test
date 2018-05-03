package com.example.starter;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestClient {

	private static String baseUrl = "http://services.groupkt.com/state/get/%1/%2";

	private RestTemplate template;

	public RestClient(RestTemplateBuilder builder) {
		template = builder.build();
	}

	public String search(String countryCode, String stateCode) {
		String url = baseUrl.replace("%1", countryCode).replace("%2", stateCode);
		return template.getForObject(url, String.class);
	}
}
