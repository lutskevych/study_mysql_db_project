package data;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ApartmentsTable {
    private int id;
    private String district;
    private String street;
    private String building;
    private int flat;
    private float square;
    private int roomNumbers;
    private int price;
}
