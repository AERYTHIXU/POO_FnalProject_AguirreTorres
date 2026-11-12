package util;

import java.util.List;

public class IdManager {
    
    public static String generateAndRegisterId(int numericId, String prefix, String currentId,
        List<String> classExistingIds) {
        if (numericId < 0) {
            throw new IllegalArgumentException("The ID number cannot be negative");
        }
        
        String formatedId = String.format("%s%03d", prefix, numericId);

        if (classExistingIds.contains(formatedId) && !formatedId.equals(currentId)) {
            throw new IllegalArgumentException("The ID " + formatedId + " is already registered");
        }

        if (currentId != null) {
            classExistingIds.remove(currentId);
        }

        classExistingIds.add(formatedId);
        return formatedId;
    }
}
