# backtraking_maze_mine
Algorithm implementation for
Solution through "backtracking"

See PDF on: https://docs.google.com/document/d/1HRbpfoH_UrKZf4glPlNo_NGuJrUQGye1bGWqRvydKHE/pub

The problem of "Military - Explore territory"!

Scenario: A military man has the important task of entering a hostile territory, exploring all the possibilities of existing paths and mapping a safe path to a final coordinate. There are obstacles that prevent him from pursuing, he needs to check if paths allow passage. He needs to deactivate the land mines that exist along that path. The main objective of the military is to bring back a map indicating all and the best safe route, marking for the other military the free passage coordinates and the location of each mine found and deactivated.
 
Backtracking: To solve this problem it is necessary to implement a backtracking and recursive algorithm. The proposal is similar to the implementations of the proposed labyrinth solutions with small adjustments to satisfy the initial proposal.
 
Rules for implementation:
The terrain will be interpreted by an array of NxM dimensions, where each coordinate is 1km x 1km;
Any obstacles are represented by 1, including walls that limit the terrain;
Active mines are represented by 9 and have an operating cost of 4 points;
The free walking parts are represented by 0 and have an operating cost of 1 point;
The final destination of the military, will be indicated as 4 and has no cost of operation;
When the military man finds a way that leads him to the end, he must score all the way with the number 3;
When the soldier finds a landmine by the way, he should mark it as 7;
Any piece of land that is not used in the path must remain marked 0 or 9;
 
Results: The recursive backtracking algorithm runs from the position x (1), y (1), all possible paths with the order (north, south, east and west), marking the position as 3 for path used, 7 for Mine and 8 for final position. Every time you find a dead-end path, the recursion will drop to the last valid path. 

Input Matrix:
 <br>(1, 1, 1, 1,) // first state
 <br>(1, 0, 0, 1,)
 <br>(1, 9, 0, 1,)
 <br>(1, 0, 4, 1,)
 <br>(1, 1, 1, 1 ); Where the walls are represented by 1, the paths free by 0, 4 as the end, and the mines by number 9.

The algorithm will mark the valid path with 3, mines found by 7, and the end by 8.

At the end, all valid states (paths found) are stored in a list of states in the Search class. If you need to debug, enable the enable_debug attribute using the commented //first.enableDebug () method;

The FindBest class is just to find the best path.

compile: javac Search.java State.java FindBest.java
<br>run: java Search

The final output result is something like this: 
<br>Run:<br>
Path found!
<br>1 1 1 1 
<br>1 3 0 1 
<br>1 7 0 1 
<br>1 3 8 1 
<br>1 1 1 1 

Cost path: 6
Traveled path: 4Km
<br>y(1), x(1), land: free pass, cost: 1
<br>y(2), x(1), land: mine down, cost: 4
<br>y(3), x(1), land: free pass, cost: 1
<br>y(3), x(2), land: end found, cost: 0

---------------------------------------------

Path found!
<br>1 1 1 1 
<br>1 3 0 1 
<br>1 7 3 1 
<br>1 0 8 1 
<br>1 1 1 1 

Cost path: 6
Traveled path: 4Km
<br>y(1), x(1), land: free pass, cost: 1
<br>y(2), x(1), land: mine down, cost: 4
<br>y(2), x(2), land: free pass, cost: 1
<br>y(3), x(2), land: end found, cost: 0

---------------------------------------------

Path found!
<br>1 1 1 1 
<br>1 3 3 1 
<br>1 9 3 1 
<br>1 0 8 1 
<br>1 1 1 1 

Cost path: 3
Traveled path: 4Km
<br>y(1), x(1), land: free pass, cost: 1
<br>y(1), x(2), land: free pass, cost: 1
<br>y(2), x(2), land: free pass, cost: 1
<br>y(3), x(2), land: end found, cost: 0

---------------------------------------------

Path found!
<br>1 1 1 1 
<br>1 3 3 1 
<br>1 7 3 1 
<br>1 3 8 1 
<br>1 1 1 1 

Cost path: 8
Traveled path: 6Km
<br>y(1), x(1), land: free pass, cost: 1
<br>y(1), x(2), land: free pass, cost: 1
<br>y(2), x(2), land: free pass, cost: 1
<br>y(2), x(1), land: mine down, cost: 4
<br>y(3), x(1), land: free pass, cost: 1
<br>y(3), x(2), land: end found, cost: 0

--------------- end debug ---------------

We found 4 path(s)! For view, enable debug!
<br>1 1 1 1 
<br>1 3 3 1 
<br>1 9 3 1 
<br>1 0 8 1 
<br>1 1 1 1 
<br>The best path :) with only: cost 3 and travaled 4Km
<br>BUILD SUCCESSFUL
