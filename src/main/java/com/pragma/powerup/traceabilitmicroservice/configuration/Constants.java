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
    public static final String EMPLOYEE_ROLE_NAME = "ROLE_EMPLOYEE";
    public static final String PAGE_NOT_VALID_MESSAGE = "The Page index is not present or has a negative value";
    public static final String SIZE_PAGE_NOT_VALID_MESSAGE = "The Page size is not present or is <= 0";
    public static final String NOT_PRESENT_MESSAGE = " is not present";
    public static final Integer PENDING_ORDER_STATUS_INT_VALUE = 1;
    public static final Integer IN_PROGRESS_ORDER_STATUS_INT_VALUE = 2;
    public static final Integer READY_ORDER_STATUS_INT_VALUE = 3;
    public static final Integer DELIVERED_ORDER_STATUS_INT_VALUE = 4;

    public static final Integer CANCELLED_ORDER_STATUS_INT_VALUE = 5;
    public static final String PENDING_ORDER_STATUS_VALUE = "PENDING";
    public static final String IN_PROGRESS_ORDER_STATUS_VALUE = "IN PROGRESS";
    public static final String READY_ORDER_STATUS_VALUE = "READY";
    public static final String DELIVERED_ORDER_STATUS_VALUE = "DELIVERED";
    public static final String CANCELLED_ORDER_STATUS_VALUE = "CANCELLED";

    public static final String MAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+(\\.[a-zA-Z0-9]+)$";
}
