package domain;

public class TemporaryTable extends Table {
    private String note;

    public TemporaryTable(int id, int capacity, String note) {
        super(id, capacity);
        setNote(note);
    }

    ///// BASIC GETTERS AND SETTERS /////

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
