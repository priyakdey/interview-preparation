package com.priyakdey;

import java.util.*;

/**
 * @author Priyak Dey
 */
public class P3829 {

    // NOTE: rewrite this using custom queue(LRU) for cancelRider
    // to be O(1)

    class RideSharingSystem {

        private final Deque<Integer> riders;
        private final Deque<Integer> drivers;

        public RideSharingSystem() {
            this.riders = new ArrayDeque<>();
            this.drivers = new ArrayDeque<>();
        }

        public void addRider(int riderId) {
            riders.offer(riderId);
        }

        public void addDriver(int driverId) {
            drivers.offer(driverId);
        }

        public int[] matchDriverWithRider() {
            if (riders.isEmpty() || drivers.isEmpty()) {
                return new int[]{-1, -1};
            }

            int riderId = riders.poll();
            int driverId = drivers.poll();
            return new int[]{driverId, riderId};
        }

        public void cancelRider(int riderId) {
            riders.remove(riderId);
        }
    }


}
