package org.drg.springcourt.security;

public class Constants {

    // Spring Security
    public static final String LOGIN_URL = "/api/v1/jwt/login";
    public static final String CREATE_USERS_URL = "/api/v1/users/";
    public static final String GET_USERS_URL = "/api/v1/users/";
    public static final String GET_USER_BY_USER_ID_URL = "/api/v1/users/{userId}";
    public static final String GET_USER_WHO_ME_URL = "/api/v1/users/me";
    public static final String HEADER_AUTHORIZATION_KEY = "Authorization";
    public static final String TOKEN_BEARER_PREFIX = "Bearer ";

    // JWT
    public static final String ISSUER_INFO = "whatever";
    public static final String SUPER_SECRET_KEY = "12341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234";
    public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 day

}
