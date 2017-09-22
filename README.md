# Thread-Exercises 2

Programs for the following can be found in startCodeForThreadExercises-master

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

program for the following code can be found in Blockingqueue program! 

Assignment 2
program has been made in in the default package!
a)

More threads so we can produce the numbers faster! One thread can produce just as many numbers as 4, but slower.
more threads to produce so that the consumer doesnt run out, the way its done now the consumer should be overwhelmet with numbers to work with.  
i would use put since put waits for the queue to have room if its full. This way no numbers get lost.
I would use take since it also waits for the queue to be filled if its empty, and we are not interested in pulling out nulls from the queue.

b-c-d-e-f can be found in day2.rndnumberprodcon package in the startCodeForThreadExercises-master.

Assignment 3

program can be found in the package day2.webscrappadon

a-b-c

// D 
No, wichever thread fills the Q2 (producedDocuments) will get its document in the fron of the queue, and will be the first to be printed. Since there are 4 threads doing this

e

Assignment 5

program can be found in package deadlock

 
The program fails because the 2 threads locks the methods and only releases them once their done with both their tasks. meaning they lock each out out of completing.
Deadlock discovers that a deadlock has occured!!!
i fixed it by putting the release methods earlier so that the arrays doesnt get locked.
it can be random what document gets added first.
