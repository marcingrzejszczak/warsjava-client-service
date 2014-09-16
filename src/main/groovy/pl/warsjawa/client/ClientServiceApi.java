package pl.warsjawa.client;

public class ClientServiceApi {
    public static final String API_URL = "/api" ;
    public static final String CLIENT_URL = "/client" ;
    public static final String APPLICATION = "application";
    public static final String APP_NAME = "vnd.pl.warsjawa.client-service";
    public static final String JSON_V1 = ".v1+json";
    public static final String APP_JSON_V1 = APP_NAME + JSON_V1;
    public static final String APP_API_VERSION_1 = APPLICATION + "/" + APP_JSON_V1;

    public static final String REPORTING_NAME = "vnd.pl.warsjawa.reporting-service";
    public static final String REPORTING_JSON_V1 = REPORTING_NAME + JSON_V1;
    public static final String REPORTING_API_VERSION_1 = APPLICATION + "/" + REPORTING_JSON_V1;
}
