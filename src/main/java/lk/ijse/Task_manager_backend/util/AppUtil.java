package lk.ijse.Task_manager_backend.util;

import java.util.UUID;

public class AppUtil {
    public static String generateTaskId() {
        return "TID-"+ UUID.randomUUID();
    }
    public static String generateUserId() {
        return "UID-"+ UUID.randomUUID();
    }
}
