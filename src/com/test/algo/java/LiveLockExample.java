package com.test.algo.java;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Example of livelock.
 *
 * @author Rahul
 */
public class LiveLockExample {

    public static void main(String [] argv) throws Exception {
        Lock spoon = new ReentrantLock();
        FoodConsumer husband = new FoodConsumer(spoon , "Husband");
        FoodConsumer wife = new FoodConsumer(spoon,"Wife");

        husband.setPartner(wife);
        wife.setPartner(husband);

        Thread husbandThread = new Thread(husband);
        husbandThread.setDaemon(true);
        Thread wifwThread = new Thread(wife);
        wifwThread.setDaemon(true);

        husbandThread.start();
        wifwThread.start();


        TimeUnit.SECONDS.sleep(10L);

    }

    private static class FoodConsumer implements Runnable {
        private Lock lock;
        private String consumerName;
        private FoodConsumer partner;
        private boolean hungry = true;

        public FoodConsumer(Lock lock,String consumerName) {
            this.lock = lock;
            this.consumerName = consumerName;
        }

        public void setPartner(FoodConsumer consumer) {
            this.partner = consumer;
        }

        @Override
        public void run() {
            while(true) {
                eat();
                try {
                    TimeUnit.MILLISECONDS.sleep(10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void eat() {
            boolean unlocked = false;
            try {
                lock.lock();

                if(partner.isHungry()) {
                    System.out.println("My partner is hungry , I will let him/her eat. Partner name " + partner.consumerName);
                    lock.unlock();
                    unlocked = true;
                    return;
                }
                System.out.println("Partner done eating , I will eat now.My name " + consumerName);
                hungry = false;
            } finally {
                if(!unlocked) {
                    lock.unlock();
                }
            }
        }

        private boolean isHungry() {
            return this.hungry;
        }
    }
}
