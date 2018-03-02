package org.sid.security;

public class SecurityConstants {
	public static final String SECRET = "cctk@capgemini";
	public static final long EXPIRATION_TIME = 864_000_000; //10 days
	public static final String TOKEN_PREFIX = "Bearer ";
	public static String HEADER_STRING = "Authorization";
}
