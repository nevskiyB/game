package com.mygdx.battle.physics;


public class PhysicsThread {
    Thread thread = new Thread(new Runner());

    private class Runner implements  Runnable {

        @Override
        public void run() {

        }
    }

    public void start() {
        thread.start();
    }
}
