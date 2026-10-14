class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        int[] locations = new int[1001];

        // Record passenger pickups and drop-offs
        for (int[] trip : trips) {

            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            locations[from] += passengers;
            locations[to] -= passengers;
        }

        int currentPassengers = 0;

        // Calculate passengers at each location
        for (int i = 0; i < locations.length; i++) {

            currentPassengers += locations[i];

            if (currentPassengers > capacity) {
                return false;
            }
        }

        return true;
    }
}