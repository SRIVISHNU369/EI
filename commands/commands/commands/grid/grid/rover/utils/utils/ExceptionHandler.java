package utils;

public class ExceptionHandler {
    public static void handle(Exception ex) {
        Logger.log("[ERROR] " + ex.getMessage());
    }
}
