package domain;

import java.util.ArrayList;
import java.util.List;

import util.IdManager;

public class PermanentTable extends Table {

    private String id;
    private static final String PREFIX = "P_TAB";

    private final static List<String> existingIds = new ArrayList<>(); 

    public PermanentTable(int numericId, int capacity, String id) {
        super(capacity);
        setId(numericId);
    }

    ///// BASIC GETTERS AND SETTERS /////
    @ Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(int numericId) {
        this.id = IdManager.generateAndRegisterId(numericId, PREFIX, id, existingIds);
    }

    public static String getPrefix() {
        return PREFIX;
    }

    @ Override
    public String getTableType() {
        return "Permanent Table";
    }
}
