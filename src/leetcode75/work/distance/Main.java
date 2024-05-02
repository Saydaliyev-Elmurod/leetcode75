package leetcode75.work.distance;

public class Main {
    public static void main(String[] args) {
        System.out.println(calculateDistance(41.361252, 69.177301, 41.32863,69.23671).intValue());
    }
    private static Double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Radius of the Earth in kilometers
        final int R = 6371000;

        // Convert latitude and longitude from degrees to radians
        double lat1Radians = Math.toRadians(lat1);
        double lon1Radians = Math.toRadians(lon1);
        double lat2Radians = Math.toRadians(lat2);
        double lon2Radians = Math.toRadians(lon2);

        // Calculate the differences
        double latDiff = lat2Radians - lat1Radians;
        double lonDiff = lon2Radians - lon1Radians;

        // Calculate the distance using the Haversine formula
        double a =
                Math.pow(Math.sin(latDiff / 2), 2)
                        + Math.cos(lat1Radians) * Math.cos(lat2Radians) * Math.pow(Math.sin(lonDiff / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Calculate the distance
        return R * c;
    }
}
