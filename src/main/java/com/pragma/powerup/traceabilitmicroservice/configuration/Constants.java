package com.pragma.powerup.traceabilitmicroservice.configuration;

public class Constants {



    private Constants() {
        throw new IllegalStateException("Utility class");
    }


    public static final String RESPONSE_ERROR_MESSAGE_KEY = "error";
    public static final String WRONG_CREDENTIALS_MESSAGE = "Wrong credentials or role not allowed";
    public static final String SWAGGER_TITLE_MESSAGE = "Traceability API Pragma Power Up";
    public static final String SWAGGER_DESCRIPTION_MESSAGE = "Traceability microservice";
    public static final String SWAGGER_VERSION_MESSAGE = "1.0.0";
    public static final String SWAGGER_LICENSE_NAME_MESSAGE = "Apache 2.0";
    public static final String SWAGGER_LICENSE_URL_MESSAGE = "http://springdoc.org";
    public static final String SWAGGER_TERMS_OF_SERVICE_MESSAGE = "http://swagger.io/terms/";
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String ERROR_PARSING_MESSAGE = "Error parsing a request variable";
    public static final String MAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+(\\.[a-zA-Z0-9]+)$";
}
