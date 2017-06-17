# backtraking_maze_mine
Algorithm to explore exploring possible paths in a land with mines and walls. Backtracking problem
From an array (n) x (m), the recursive backtracking algorithm must explore all possibilities of valid paths to the destination represented by the value 4

Input Matrix:
{{1, 1, 1, 1}, // first state
 {1, 0, 0, 1},
 (1, 9, 0, 1)
 {1, 0, 4, 1},
 {1, 1, 1, 1}; Where the walls are represented by 1, the paths free by 0, 4 as the end, and the mines by number 9.

The algorithm will mark the valid path with 3, mines found by 7, and the end by 8.

At the end, all valid states (paths found) are stored in a list of states in the Search class. If you need to debug, enable the enable_debug attribute using the commented //first.enableDebug () method;

The FindBest class is just to find the best path.

The final output result is something like this:
 Run:
