package com.xhlim.jdk18;

import java.util.function.Supplier;

/**
 * @author xhlim@outlook.com
 * @create 2017-09-13 14:17
 */
public class Car {

    public static Car create(Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car car) {
        System.out.println("Following the " + car.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }
}
