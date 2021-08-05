# Lists

This repo contains two types of lists, ArrayList and LinkedList.

# ArrayList

It is better to you use ArrayList for getting access to specific item, since in terms of efficiency, it is O(1) to gain access for a specific item.

Requires fixed size, i.e. memory, though, I added a resize method that allows to resize the list.


# LinkedList

There are two major differences between LinkedList and ArrayList, first of all, LinkedLists don't required fixed size, i.e. you can infinitelly add elements.
Second, it is less efficient to gain access to specific items in a LinkedList, since we need to traverse the list itself. 
To make it clear, to get element at position i, we need to traverse through i-1 elements, which can be a bit problematic with large lists.
