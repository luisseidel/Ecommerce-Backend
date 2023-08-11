package com.seidelsoft.SpringEcommerceBackend.config;

import org.apache.catalina.filters.CorsFilter;

import java.util.Arrays;
import java.util.List;

public class HeadersUtils {

	public static final String[] ALLOWED_METHODS = {"GET", "POST", "PUT", "DELETE", "OPTIONS"};
	public static final String[] ALLOWED_ORIGINS = {"http://localhost:4200", "http://localhost:4200/", "https://localhost:4200", "https://localhost:4200/"};
	public static final String[] ALLOWED_HEADERS = {CorsFilter.DEFAULT_ALLOWED_HTTP_HEADERS, CorsFilter.RESPONSE_HEADER_ACCESS_CONTROL_ALLOW_ORIGIN};

	public static List<String> getAllowedHeadersArray() {
		return Arrays.asList(ALLOWED_HEADERS);
	}
	public static List<String> getAllowedOriginsArray() {
		return Arrays.asList(ALLOWED_ORIGINS);
	}
	public static List<String> getAllowedMethodsArray() {
		return Arrays.asList(ALLOWED_METHODS);
	}

}
