package domain;

public class TemporaryTable extends Table {
    
    private String note;
    private static final String PREFIX = "T_TAB";

    public TemporaryTable(int numericId, int capacity, String note) {
        super(capacity);
        setId(numericId);
        setNote(note);
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
    public String getPrefix() {
        return PREFIX;
    }

    @ Override
    public String getTableType() {
        return "Temporary Table";
    }

}
