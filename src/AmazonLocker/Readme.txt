# We are going to design Amazon Logistic system from scratch.

This will be just a high level design at first and we will try to improve.

CommonUtil:

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

ProductManager:

Here we intend to handle the most basic product at a high level. So lets jump right in :p