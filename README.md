# e_challenge_elevator_problem

# Elevator Problem

This test is about a building having several elevators in different states.
For example, each elevator can be at a different level, and can be going up, or down.

The objective of this exercise is to write a program that will identify which elevator will be served once a request for an elevator is registered.

Please note these rules : 
 - An elevator is requested by default from <b>top</b> floor. </br>
 - An elevator can be resting on a given floor, going up or going down. </br>
 - An elevator switch automatically his direction when reaching the edges of the building (means the first and top floors).
 - An elevator can not switch its direction in the middle of a building.

   For example: in a building of 10 floors, an elevator at the 3rd floor and ascending can 
   never go down before reaching the 10th floor. And vice versa.

- An elevator is never in between floors.

# Solution

Foobar is a Python library for dealing with word pluralization.

## Installation

To answer this problem I used the "Factory" and "State" Design Patterns.

```
+------------------------------------------------+                                                              
|                   Building                     |                                                              
--------------------------------------------------                                                              
| -numberOfFloors : int                          |       +-----------------------------------------------+      
| -elevators      : Map<String,Elevator>         |       |               ElevatorFactory                 |      
--------------------------------------------------       -------------------------------------------------      
| +requestElevator(int destination) : String     |-----> |                                               |      
| +requestElevator()                : String     |       -------------------------------------------------      
| +move(String id, String action)   : void       |       |  +createElevator(String elevator) : Elevator  |      
| +stopAt(String id, int floor)     : void       |       +-----------------------------------------------+      
+------------------------------------------------+                                  |                           
                |                                                                   |                           
                |                 +---------------------------------------+         |                           
                |                 |                Elevator               |         |                           
                |                 -----------------------------------------         |                           
                |                 | -id       : String                    |         |                           
                |                 | -floor    : int                       |<--------+                           
                +---------------> | -state    : State                     |                                     
                                  | -stopping : boolean                   |                                     
                                  -----------------------------------------                                     
                                  | +move(String action)       : void     |                                     
                                  | +distance(int destination) : int      |                                     
                                  +---------------------------------------+                                     
                                                     |                                                          
                                                     |                                                          
                                                     |                                                          
                                                     v                                                          
                              +---------------------------------------------+                                   
                              |                     State                   |                                   
                              -----------------------------------------------                                   
                              | -state : String                             |                                   
                              -----------------------------------------------                                   
                              | +distance(int floor, int destination) : int |                                   
                              |                                             |                                   
                              +---------------------------------------------+                                   
                                                     ^                                                          
                                                     |                                                          
                          +--------------------------|--------------------------+                               
                          |                          |                          |                               
                          |                          |                          |                               
                          |    +--------------------------------------------+   |                               
                          |    |                     Rest                   |   |                               
                          |    ----------------------------------------------   |                               
                          |    |                                            |   |                               
                          |    ----------------------------------------------   |                               
                          |    |+distance(int floor, int destination) : int |   |                               
                          |    +--------------------------------------------+   |                               
   +--------------------------------------------+        +--------------------------------------------+         
   |                     Up                     |        |                     Down                   |         
   ----------------------------------------------        ----------------------------------------------         
   |                                            |        |                                            |         
   ----------------------------------------------        ----------------------------------------------         
   |+distance(int floor, int destination) : int |        |+distance(int floor, int destination) : int |         
   +--------------------------------------------+        +--------------------------------------------+    
```
