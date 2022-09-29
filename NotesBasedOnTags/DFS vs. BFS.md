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
 
对 找出 从某类型的格子 到另一种类型的格子的 最短距离综合, 例如从land 到所有building:   
有一种优化技巧 -> 不计算从所有 land 到 building, 反向思维, 计算从所有 building 到 land


#### Approaches
Iterative with queue. (level traversal)

#### Scenarios


#### Complexity
Time: 
- Both of them are O(N), since one has to visit all nodes.  
     
Space:   
- DFS: O(H), H is a tree height, worst-case scenarios: O(N) ***skewed tree***, height = n.   
- BFS: O(D), D is a tree diameter; worst-case scenarios: O(N) ***complete tree***, diameter = n/2(leaf).
