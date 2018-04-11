package data;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class BasicTable<T extends BasicTableRow> {

    @Setter @Getter
    private String tableName;

    private List<T> tableRowList;

    public List<T> getRowList() {
        return tableRowList;
    }

    public void setRowList(List<T> rowList) {
        tableRowList = rowList;
    }

    public void addRowList(List<T> rowList) {
        for (T row : rowList) tableRowList.add(row);
    }

    public void addRow(T row) {
        tableRowList.add(row);
    }
}
