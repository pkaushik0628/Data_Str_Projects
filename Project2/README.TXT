------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all they need to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Project 2 - Doubling List
PURPOSE OF PROJECT: To Construct a Doubling List
VERSION or DATE: 04/15/2024
HOW TO START THIS PROJECT: Run the main method to see list implementation
AUTHORS: Padamabh Kaushik
USER INSTRUCTIONS: None

In this project, a doubling list was implemented. A doubling list initially consists of a head and a tail. 
As the size of the doubling list increases, nodes having arrays as a power of 2 are added to the list.
In this project, the following methods were implemented to the design the functionality of the array list:
add(E item), add(int pos, E item), remove(int pos), toStringInternal(),toStringInternal(ListIterator iter),
find(NodeInfo info), size(), listIterator(int index).

The add and remove methods seem to be working for most cases, however, I ran out of time to unit test it for
maximum possibilities. Remove menthods works properly, as well and the other methods in the Doubling List Iterator.
The list seems to ge growing in size appropriately as new items are added.

While implementing a list errors, I ran into errors implementing the add method with
position. It took a long time to figure out the left and right shifts. Additionally, while
creating the node class, I realized the nodes should hold arrays instead of Array Lists.
While I aimed to replace the whole implementation with arrays instead of aray lists, however,
I ran out of time decided to keep the implementation with array list and decided to focus
on other functionalities.


