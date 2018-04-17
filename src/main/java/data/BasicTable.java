package data;

import java.util.List;

public class BasicTable<T extends BasicTableRow> {

    private List<String> headers;
    private List<T> tableRowList;

    public BasicTable(List<String> headers, List<T> tableRowList) {
        this.headers = headers;
        this.tableRowList = tableRowList;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    public List<String> getHeaders() {
        return headers;
    }

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

    public void printTable() {
        System.out.print("|");
        for (String columnName : headers) {
            System.out.printf(" %-15s|", columnName.toUpperCase());
        }
        System.out.println();
        for (BasicTableRow row : tableRowList) {
            row.printRow();
        }

    }
}
