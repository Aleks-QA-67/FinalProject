package common;

public class TestConfig {
    public static String getBaseUrl() { return ConfigLoader.get("base.url"); }
    public static String getApiBaseUrl() { return ConfigLoader.get("api.base.url"); }
    public static long getTimeout() { return Long.parseLong(ConfigLoader.get("timeout")); }
    public static boolean isLoggingEnabled() { return Boolean.parseBoolean(ConfigLoader.get("logging.enabled")); }
    public static String getAdminLogin() { return ConfigLoader.get("admin.login"); }
    public static String getAdminPassword() { return ConfigLoader.get("admin.password"); }
    public static String getDefaultProductName() { return ConfigLoader.get("default.product.name"); }
    public static String getDefaultProductPrice() { return ConfigLoader.get("default.product.price"); }

    public static void printConfig() {
        System.out.println("=== Конфигурация ===");
        System.out.println("URL: " + getBaseUrl());
        System.out.println("API URL: " + getApiBaseUrl());
        System.out.println("TIMEOUT: " + getTimeout());
        System.out.println("LOGGING: " + isLoggingEnabled());
        System.out.println("PRODUCT: " + getDefaultProductName() + " / " + getDefaultProductPrice() + " ₽");
        System.out.println("====================");
    }
}