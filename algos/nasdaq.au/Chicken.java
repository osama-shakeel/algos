package com.nasdaq.au;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

interface Bird {
    Egg lay();
}

class Chicken implements Bird, Callable < Bird > {
    public Chicken() {
    }

    public static void main(String[] args) throws Exception {
        Chicken chicken = new Chicken();
        System.out.println(chicken instanceof Bird);
        Chicken babyChick = (Chicken)chicken.lay().hatch();
        System.out.println(babyChick != chicken);
    }

	@Override
	public Egg lay() {
		return new Egg(this);
	}

	@Override
	public Bird call() throws Exception {
		return new Chicken();
	}
}

class Egg {
	private Callable<Bird> createBird;
	private boolean hasHatched = false;

    public Egg(Callable<Bird> createBird) {
    	this.createBird = createBird;
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public Bird hatch() throws Exception {
    	if (!hasHatched) {
        	ExecutorService executorService = Executors.newSingleThreadExecutor();
        	Future < Bird > futureBird = executorService.submit(this.createBird);
        	hasHatched = true;
        	return futureBird.get();
    	}
    	throw new IllegalStateException("Egg already hatched");
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }
}