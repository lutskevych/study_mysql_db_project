package data;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ApartmentsTableRow extends BasicTableRow {
    private String district;
    private String street;
    private String building;
    private int flat;
    private float square;
    private int roomNumbers;
    private int price;

    @Override
    public void printRow() {
        String format = "| %-15s| %-15s| %-15s| %-15s| %-15s| %-15s| %-15s| %-15s|\n";
        System.out.printf(format, id, district, street, building, flat, square, roomNumbers, price);
    }
}
