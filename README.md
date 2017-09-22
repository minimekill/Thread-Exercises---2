# Thread-Exercises 2

Assignment 1

a) 

Takes time because the new class has to connect to a server and retrieve the document to initiate the document count

b)

Simple because we just add "extends Thread" in the TagCounter, and the class already has a run method wich now just overrides the run.
Just gotta make sure to "start" the thread and not just run it, else no thread will be made.

c)

By calling run we do not start a new thread. by starting a new thread the run method will be run wich in this case has been overritten by our method.

They are empty because the main thread tries to write out without waiting for the threads to actually fill the values we want to write out.

This is fixed by telling the main thread to wait for the 3 threads to be done, by using the shutdown method in executorservice.

d)

1,3 s    when running with 4 threads. This is including the main thread
2,4 s    when running with just one thread
we were expecting that running the program with threads would be faster as we saw it was. The Computer had 4 processors, in princible one for each thread (But apperently thats not what really happens due to concurrency where one thread is stopped for a short time while another runs).

Assignment 2


