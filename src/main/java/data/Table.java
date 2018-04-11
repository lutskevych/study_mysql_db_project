package data;

import java.util.List;

public interface Table<T extends BasicTableRow> {
    List<T> getRowList();
    void setRowList(List<T> rowList);
    void addRowList(List<T> rowList);
    void addRow(T row);
    void updateRow(int index, T row);
    void removeRow(int index);
}
