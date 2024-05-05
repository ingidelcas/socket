package com.thread;

import java.util.Random;

public class Hilo extends Thread{
    private final Integer number;
    private final Random rnd;

    private Integer pom;

    public Hilo(int number, long seed) {
        this.number = number;
        this.rnd = new Random(seed);
    }

    @Override
    public void run() {
         this.pom = rnd.nextInt(101);
    }

    public Integer getPom() {
        return pom;
    }
}
