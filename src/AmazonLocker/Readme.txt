# We are going to design Amazon Logistic system from scratch. This is going to be a full fledged design so that we can practically think about everything.

This will be just a high level design at first and we will try to improve.

CommonUtils:

It will have the most common features which we will be using throughout our project. An example of this is Dimen.

Dimen such as product dimen, shelve dimen or may be Locker dimen and so on.

Customer:

In this package we are going to implement class for User and decide how user is going to interact with Amazon Locker when they purchase a product and upon its delivery.
For now we will just try to make a purchase. For now we will suppose product gets delivered to nearest locker to user.

Advance: We will keep and observable at Locker shelve, once product arrives at the locker facility to alert user of the pin to unlock,
or maybe make payment and so on...
Another, onces user unlocks the locker, we will update management for available locker and so on and so forth.

Ledger:

This package is intended to match the user and product all the transactions are complete..In short to keep consistency in transaction.

LockerManager:

This package is the main package. It has many features of the locker. We will maintain many shelves in it so, this is going to be tricky. We expect everything to be dynamic, shelves could be different. Different operating styles. So on and so forth.

Logistics:

Self explanatory. It is going to fun to implement Logistics :p

Lets get started


LogisticsManager:

Logistics Manager will control Package Facilities.
It will decide what package goes from which package facility to which package facility based upon destination.
If we are to nearest locker to user, we will simply drop package to desired locker.

We are going to use pin codes and represent them as graphs in which path exists.

Our PS would be: Find the shortest path from A to B i.e A PackageFacility to B PackageFacility for a Package package.

Questions:

Q. Is it best to decide which locker we are going to store package early on or not ? Keeping in mind user customer perspective first and logistics second!
-> Answer is no! We cannot hold package more than K days. So obviously, if we choose static behaviour, we are never going to make use of resource properly.
-> Its best to decide LockerFacility once Package reaches last PackageFacility.

So, basically we are going to adopt, First come first serve facility. (Win Win or Loss? )

Q. What about the priority customer? Are all customer treated equal? What about those who are making good profits to company?


---

PackageManager Class manages the package.

Q. Find the shortest path from A to B i.e Start PackageFacility to End PackageFacility for a Package package.
-> This would be done by LogisticsManager Class.

Basically PackageManager class will ask LogisticsManager class to send it from start to end. LogisticsManager decides the shortest path using graphs.

Now it decides path i.e Package Facilities. We than have to send package through that route. This is done through PackageTrackingQueue.

What it does it basically keep track of the route of the package, keep updating the tracker. This is important. As whenever Package Manager wants to know where the package is, it simple refers to package tracker.

Now we are using observers. This is because each package facility has its own processing. After that is done, we can process the package for further journey and so on.

---

Now that is done, we have created a basic logistic framework. We will keep updating some bugs, and corner cases in between.

But now we can focus on Amazon Locker itself.

-> When package reaches the end facility, we now have to decide the nearest locker. As we have already build some basics, this can be easily done with the help of LockerManager.

LockerManager decides what lockers to target / available / unavailable and so on.

Lets code and have fun with that ;)


--- Designing LockerManager, Locker, ShelveManger and Shelve class.

Do we need interface for LockerManger or ShelveManager?

-> For this, we have to answer if we are going to answer if we are going to use Object of LockerManager Class anywhere else and make specific access to some function.

Is delivery to locker considered as a complete process from Logistic partner end?
Q. What is the most optimal way to provide shelves to package which have a dynamic timing. We have to treat each package dimen into consideration so on and so forth.

The main thing here is to maintain consistency.

-> Things will depend on how package arrive. So order of arrival at last package facility determines what locker is assigned.

With this we depend less on PackageManager. So it doesnot have to worry. Our idea of using a common tracker will help it to get runtime state of package.

1. Package is allocated a locker
2. Package is waiting for a locker to get free.

Two trivial things might happen.

How I think of it is:

1. Every Packing facility will maintain a AlmostReachedQueue which will have packages which just needs to get delivered to the locker now.
2. Each package facility will observe nearby lockers, and as soon as any of shelve is available, it with the help of LockerManager will assign it to locker.

Simple.
