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