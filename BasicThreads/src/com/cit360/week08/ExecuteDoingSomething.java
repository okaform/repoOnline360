package com.cit360.week08;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteDoingSomething {
    public static void main(String[] args) {
        ExecutorService myService = Executors.newFixedThreadPool(3); //This holds 3 threads
        // if we have more then it will have to wait until the next one is done

        DoingSomething ds1 = new DoingSomething("bob", 25, 1000);
        DoingSomething ds2 = new DoingSomething("Sally", 10, 500);
        DoingSomething ds3 = new DoingSomething("Billy", 5, 250);
        DoingSomething ds4 = new DoingSomething("Hannah", 5, 100);
        DoingSomething ds5 = new DoingSomething("Annie", 1, 50);


        myService.execute(ds1);
        myService.execute(ds2);
        myService.execute(ds3);
        myService.execute(ds4);
        myService.execute(ds5);

        myService.shutdown();  //this waits until all the threads are completed nicely
                              //shutdown now shuts down immediately

    }
}
