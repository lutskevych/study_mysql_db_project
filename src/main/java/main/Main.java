package main;

import data.ApartmentsTableRow;
import data.BasicTable;
import dbmanager.RequestsManager;
import utils.ApartmentsFilter;

public class Main {

    public static void main(String[] args) {
        RequestsManager rm = new RequestsManager();
        ApartmentsFilter filter = ApartmentsFilter.newBuilder()
                .setStreet("Skarbowcow")
                .setRoomNumbers("1")
                .setPrice("250")
                .build();
        BasicTable<ApartmentsTableRow> apartments = rm.selectApartmentsWithParameters(filter);
//        BasicTable<ApartmentsTableRow> apartments = rm.selectAllFromApartments();
        apartments.printTable();
    }
}
