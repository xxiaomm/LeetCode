 ## 目录
- [目录](#目录)
  - [DFS](#dfs)
    - [Approaches](#approaches)
    - [Scenarios](#scenarios)
  - [BFS](#bfs)
    - [Approaches](#approaches-1)
    - [Scenarios](#scenarios-1)
    - [Complexity](#complexity)

### DFS

#### Approaches
- preorder;
- inorder;
- postorder;  
All of them includes recursive, iterative and Morris traversal.

#### Scenarios



### BFS

#### Approaches
Iterative with queue. (level traversal)

#### Scenarios


#### Complexity
Time: 
- Both of them are O(N), since one has to visit all nodes.  
     
Space:   
- DFS: O(H), H is a tree height, worst-case scenarios: O(N) ***skewed tree***, height = n.   
- BFS: O(D), D is a tree diameter; worst-case scenarios: O(N) ***complete tree***, diameter = n/2(leaf).
