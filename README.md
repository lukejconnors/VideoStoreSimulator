VideoStoreSimulator
===================
Author: Luke Connors

There are 14 different classes used to run the simulator.

The Video class represents all the videos that will in the simulation. Each Video has a 
title, has a price per day, and is composed of one Catagory. Catagory is another class, 
which defines the genre or category of the video. The price per day of a Video is 
dependent on the Catagory of the Video, so Video gets its price per day from its 
respective Catagory.

The Catagory class is an abstract class with 5 subclasses. These subclasses represent 
video genres. They are Comedy, Drama, Horror, NewRelease, and Romance. They each keep 
track of their individual price per night to rent and the maximum number of days they can 
be rented for. They vary in price with NewRelease being the most expensive and Comedy 
being the cheapest. For this simulation, they all have a maximum rental length of 7 days.

The Store class is the class that represents a video store. A Store has two lists of 
videos to keep track of the Videos it has. One list for the available Videos it has in the 
store and another one for the Videos that are currently checked out.

A Store also keeps track of how much money it has. When a Rental is made, the Store is 
responsible for processing the rental by updating its list of available videos and 
unavailable videos. The same is true when a rental is returned.

The Rental class represents a rental from the store that is made by a Customer. A rental 
keeps track of the Customer who has made the rental (the owner), the number of videos in 
the rental (there is a maximum of 3), the list of videos in the rental, and the total cost 
of the rental. A Rental is created by a Customer. The customer must specify the due date 
for the rental and the videos in the rental (maximum of 3). Then the Rental will calculate 
the total cost of the rental. Lastly, the Rental is sent to the Store to be processed.

The Customer class is an abstract class with 3 subclasses. A Customer represents a 
customer that rents from the store. A Customer has a name and keeps track of all of its 
rentals. A Customer is responsible for figuring out if they are able to rent, they need to 
make sure the store has enough videos and they have less than 3 videos (the maximum number 
a single Customer can have at once). In addition a Customer is responsible for checking 
there if any their Rentals are due, and if so returning them. Lastly a Customer is 
responsible for creating rentals before passing them to the store to be processed. The 3 
subclasses for Customer are Hoarder, Breezy, and Regular. All are the same except for 
their renting patterns. A Hoarder always rents 3 videos on one Rental for the maximum 
number of days. A Breezy customer will rent 1-2 videos on one Rental always for 2 days. A 
Regular customer will rent 1-3 videos on one Rental for 3-5 days.

Lastly the Simulator class only has a main function and is in charge of running the 
simulation. The simulation starts by initiating a store with a list of available videos of 
all categories and a list of 10 customers of all types that will rent from the store. This 
simulation runs for 35 days and 34 nights. For each day, first it tells each customer to 
check their rentals to see if they are due. Then the simulation makes a list of all the 
customers that are able to rent, picks a random number of them, and tells them to go rent 
from the store. After the simulation is done running, it prints the available videos in 
the store, the videos that are currently rented, and the amount of money the store made 
over the course of the simulation.

To compile, in terminal navigate to the folder /simulator then enter the following command:
	javac -d bin src/luke/*.java

To run, in terminal navigate to the folder /simulator/bin then enter the following command:
	java luke.Simulator