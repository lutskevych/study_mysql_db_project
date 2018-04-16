package utils;

import lombok.Getter;

import java.util.Map;

public class ApartmentsFilter {
    @Getter
    private Map<String, String> map;

    public static Builder newBuilder() {
        return new ApartmentsFilter().newBuilder();
    }

    public class Builder {
        private Builder() {}
        public Builder setDistrict(String district) {
            map.put("district", district);
            return this;
        }

        public Builder setStreet(String street) {
            map.put("street", street);
            return this;
        }

        public Builder setBuilding(String building) {
            map.put("building", building);
            return this;
        }

        public Builder setFlat(String flat) {
            map.put("flat", flat);
            return this;
        }

        public Builder setSquare(String square) {
            map.put("square", square);
            return this;
        }

        public Builder setRoomNumbers(String roomNumbers) {
            map.put("roomNumbers", roomNumbers);
            return this;
        }

        public Builder setPrice(String price) {
            map.put("price", price);
            return this;
        }

        public ApartmentsFilter build() {
            return ApartmentsFilter.this;
        }
    }
}
