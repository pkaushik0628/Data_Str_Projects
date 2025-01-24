------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all they need to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: CS 150 Project 3: Truck-WareHouse Transportation System
PURPOSE OF PROJECT: To use different data structures to simulate a delivery system
VERSION or DATE: 5/5/2024
HOW TO START THIS PROJECT: First run the main method of the GenerateInputs, and then run the main method in Clock class
AUTHORS: Padmanabh Kaushik

Reflections:

(a) The functionalities that you planned to implement.

I planned to implement the following functionalities:

(1) Inputs will be randomly generated at the beginning, and the clock should be able to read the inputs and initialize arrays of warehouses and trucks
(2) Each warehouse will generate a number of shipments to be delivered
(3) The trucks will be generated a random location, after which the truck will start moving to the nearest warehouse
(4) The Warehouse will do the loading and unloading operation, and will send the release the truck when the operation is complete
(5) After loading/unloading is completed, the trucks will move to the next pickup or drop-off destination

(b) The functionalities that you actually finished.

I finished all the functionalities excluding (4). Right now, it seems that my action() method of WareHouse is not working properly, for
which trucks are not being released properly after they are being loaded/unloaded. This is impacting the motion of trucks across the 
simulation, whenever a truck gets stuck in the warehouse.

(c) Why did you fail to implement some of the functionalities? How could you fix the problem?

I should have united tested my warehouse class more properly. Although all of my other classes work properly on an individual level,
I should have designed other test to ensure that the objects interact with each other properly on a systemic level. 

As far as the implementation of (4) is concerned, I think it arises due to the way the trucks are interacting with the warehouses,
and that the warehouses are sometimes storing a copy of the trucks with them. This can be fixed by turning a truck to null in the loading deck
at the required instance. However, while correcting this error, I ran out of time, and didn't have the opportunity to fix this.

(d) What is the lesson learned from the project?

Through this project, I learned about using different data structures to do real world simulations. I also learned about integrating various 
data structures, and understood how multiple classes and objects interact at a systemic level. I also learned a lot about debugging and finding
issues within  a larger system.

Although I couldn't create a perfect project, the project taught me a lot about time management. In future, I'll ensure that I budget enough time
for unit testing and system level testing, besides the actual implementation.
