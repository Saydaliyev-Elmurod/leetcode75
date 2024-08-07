package leetcode75.design.parkingSystem;

class ParkingSystem {
    int big;
    int medium;
    int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.small = small;
        this.medium = medium;
    }

    public boolean addCar(int carType) {
        if (carType == 1 && big > 0) {
            big -= 1;
            return true;
        } else if (carType == 2 && medium > 0) {
            medium -= 1;
            return true;
        } else if (carType == 3 && small > 0) {
            small -= 1;
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */