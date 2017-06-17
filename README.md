# backtraking_maze_mine
Algorithm to explore exploring possible paths in a land with mines and walls. Backtracking problem
From an array (n)x(m), the recursive backtracking algorithm must explore all possibilities of valid paths to the destination represented by the value 4

Input Matrix:
 <br>{{1, 1, 1, 1}, // first state
 <br>{1, 0, 0, 1},
 <br>(1, 9, 0, 1)
 <br>{1, 0, 4, 1},
 <br>{1, 1, 1, 1}; Where the walls are represented by 1, the paths free by 0, 4 as the end, and the mines by number 9.

The algorithm will mark the valid path with 3, mines found by 7, and the end by 8.

At the end, all valid states (paths found) are stored in a list of states in the Search class. If you need to debug, enable the enable_debug attribute using the commented //first.enableDebug () method;

The FindBest class is just to find the best path.

compile: javac Search.java State.java FindBest.java
run: java Search

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
