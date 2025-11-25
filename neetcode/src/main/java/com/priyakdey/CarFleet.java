package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {
        int length = position.length;
        Car[] cars = new Car[length];

        for (int i = 0; i < length; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }

        Arrays.sort(cars, Comparator.comparingInt((Car p) -> p.position).reversed());

        int count = 0;

        Deque<Double> stack = new ArrayDeque<>();
        for (Car car : cars) {
            double timeToReachDest = (double) (target - car.position) / car.speed;

            if (stack.isEmpty()) {
                stack.push(timeToReachDest);
            } else if (stack.peek() >= timeToReachDest) {
                continue;
            } else {
                stack.pop();
                stack.push(timeToReachDest);
                count++;
            }

        }

        return count + (stack.isEmpty() ? 0 : 1);
    }

    private record Car(int position, int speed) {
    }

    // target=10
    // position=[0,4,2]
    // speed=[2,1,3]

    public static void main(String[] args) {
        var a = new CarFleet();
        var b = a.carFleet(10, new int[]{0, 4, 2}, new int[]{2, 1, 3});
        System.out.println(b);
    }

}
