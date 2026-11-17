package domain;

public class PermanentTable extends Table {

    private static final String PREFIX = "P_TAB";

    public PermanentTable(int numericId, int capacity) {
        super(capacity);
        setId(numericId);
    }


    @ Override
    public String getPrefix() {
        return PREFIX;
    }

    @ Override
    public String getTableType() {
        return "Permanent Table";
    }
}
