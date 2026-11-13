package domain;

import java.util.ArrayList;
import java.util.List;

import util.IdManager;

public class TemporaryTable extends Table {
    
    private String id;
    private String note;
    private static final String PREFIX = "T_TAB";

    private static final List<String> existingIds = new ArrayList<>();

    public TemporaryTable(int numericId, int capacity, String note) {
        super(capacity);
        setId(numericId);
        setNote(note);
    }

    ///// BASIC GETTERS AND SETTERS /////
    
    public String getId() {
        return id;
    }

    public void setId(int numericId) {
        IdManager.generateAndRegisterId(numericId, PREFIX, id, existingIds);
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        if (note == null || note.isBlank()) {
            throw new IllegalArgumentException("Note cannot be empty");
        }
        this.note = note;
    }    

    @ Override
    public String getTableType() {
        return "Temporary Table";
    }

}
