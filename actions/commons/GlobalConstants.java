package commons;

import org.bouncycastle.pqc.crypto.newhope.NHSecretKeyProcessor;

public class GlobalConstants {
    // System Infor
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");

    // App Infor User
    public static final String DEV_USER_URL = "https://demo.nopcommerce.com/";
    public static final String STAGING_USER_URL = "https://staging.nopcommerce.com/";
    public static final String LIVE_USER_URL = "https://live.nopcommerce.com/";

    // App for Admin
    public static final String DEV_ADMIN_URL = "https://admin-demo.nopcommerce.com/";
    public static final String STAGING_ADMIN_URL = "https://admin-staging.nopcommerce.com/";
    public static final String LIVE_ADMIN_URL = "https://admin-live.nopcommerce.com/";
    public static final String ADMIN_USERNAME = "user01";
    public static final String ADMIN_PASSWORD = "guru99com";

    // Wait Infor
    public static final long SHORT_TIMEOUT = 10;
    public static final long LONG_TIMEOUT = 30;
    // Download / upload file
    public static final String UPLOAD_PATH = PROJECT_PATH + "/uploadFiles";
    public static final String DOWNLOAD_PATH = PROJECT_PATH + "/downloadFiles";
}