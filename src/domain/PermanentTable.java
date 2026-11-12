package domain;

public class PermanentTable extends Table {

    private String id;
    private static int PermanentTableCounter = 0;

    public PermanentTable(int id, int capacity) {
        super(id, capacity);
    }

    private static String generateTablePermanentId() {
        String generated = String.format("TP%002d", PermanentTableCounter);
        return generated;
    }
    ///// BASIC GETTERS AND SETTERS /////
    public String getId() {
        return id;
    }

    public void setId(String id) {
        String permanentTableId = generateTablePermanentId(); 
        this.id = permanentTableId;
    }    

    @ Override
    public String getTableType() {
        return "Permanent Table";
    }
}
