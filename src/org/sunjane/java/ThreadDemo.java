package org.sunjane.java;

public class ThreadDemo {

	public static void threadDemo(String[] args) {
		Test test;

		// test for join
//		test = new JoinTest();
//		test.printTest();
		
		//test for deadlock
		test = new DeadlockTest();
		test.printTest();

	}
}

abstract class Test {
	public void printTest(){};
}

// test for join
class JoinTest extends Test{
	
	@Override
	public void printTest() {
		System.out.println("start main thread " + Thread.currentThread().getName());

		FatherThread f = new FatherThread();
		f.start();
		try {
			f.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end main thread " + Thread.currentThread().getName());
	}
}

class FatherThread extends Thread {
	public void run() {

		System.out.println("start father thread " + this.getName());
		ChildThread c = new ChildThread();
		c.start();
		try {
			c.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end father thread " + this.getName());
		
	}
}

class ChildThread extends Thread {
	public void run() {
		System.out.println("start child thread " + this.getName());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end child thread " + this.getName());
	}
}



// deadlock time
// right?
class MyRunnable implements Runnable{
    Object a;
    Object b;
    public MyRunnable(Object a, Object b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public void run() {
        while(true){
            synchronized (a) {
                synchronized (b) {
                    System.out.println(Thread.currentThread().getName()+" is running");
                }
            }
        }
    }
}

class DeadlockTest extends Test{
    public void printTest() {
        Object a = new Object();
        Object b = new Object();
        MyRunnable myRunnable1 = new MyRunnable(a, b);
        MyRunnable myRunnable2 = new MyRunnable(b, a);
        Thread threadA = new Thread(myRunnable1,"t1");
        Thread threadB = new Thread(myRunnable2,"t2");
        threadA.start();
        threadB.start();
    }
}