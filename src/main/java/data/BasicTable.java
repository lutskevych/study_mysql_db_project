package data;

import java.util.List;

public class BasicTable<ApartmentsTableRow extends BasicTableRow> implements Table<ApartmentsTableRow> {

    private List<ApartmentsTableRow> apartmentsRows;

    public List<ApartmentsTableRow> getRowList() {
        return apartmentsRows;
    }

    public void setRowList(List<ApartmentsTableRow> rowList) {
        apartmentsRows = rowList;
    }

    public void addRowList(List<ApartmentsTableRow> rowList) {

    }

    public void addRow(ApartmentsTableRow row) {

    }

    public void updateRow(int index, ApartmentsTableRow row) {

    }

    public void removeRow(int index) {

    }
}
