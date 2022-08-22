

- [图的一些基本概念](#图的一些基本概念)
  - [出度 outdegree 入度 indegree](#出度-outdegree-入度-indegree)
  - [连通性](#连通性)
    - [Reference](#reference)
  - [二分图](#二分图)
    - [Hint to Use](#hint-to-use)
    - [题目](#题目)
    - [Reference](#reference-1)
  - [生成树](#生成树)
    - [最小生成树 (Minimum Spanning Tree)](#最小生成树-minimum-spanning-tree)
    - [Reference](#reference-2)
- [图的算法](#图的算法)
  - [环检测和拓扑排序(Topological Sort)](#环检测和拓扑排序topological-sort)
  - [并查集(Union Find)](#并查集union-find)
    - [Reference](#reference-3)
  - [Kruskal 算法](#kruskal-算法)
  - [Prim 算法](#prim-算法)
  - [Dijkstra算法](#dijkstra算法)

## 图的一些基本概念

### 出度 outdegree 入度 indegree
属于「有向图」中的概念。   
「出度」：如果一个节点 x 有 a 条边指向别的节点，则称节点 x 的出度为 a。   
「入度」：如果一个节点 x 被 b 条边所指，则称节点 x 的入度为 b。

### 连通性
性质: 自反性(自己和自己), 对称性, 传递性;

#### Reference



### 二分图
设G=(V,E)是一个无向图，如果顶点V可分割为两个互不相交的子集(A,B)，并且图中的每条边（i，j）所关联的两个顶点 i 和 j 分别属于这两个不同的顶点集(i in A, j in B)，则称图G为一个二分图。(有的node可能不和任何人相连, 只要不同颜色的在两个集合即可。)  

<img src="../images/Graph/二分图.png" height="400" width="400">


#### Hint to Use
- 经典的着色问题; 
- 分成两个阵营;


#### 题目
- [785. Is Graph Bipartite?](https://leetcode.com/problems/is-graph-bipartite/)
- [886. Possible Bipartition](https://leetcode.com/problems/possible-bipartition/)


#### Reference
[labuladong](https://labuladong.github.io/algo/2/22/52/)

### 生成树
生成树是含有图中所有顶点的「无环连通子图」


#### 最小生成树 (Minimum Spanning Tree)

<img src="../images/Graph/最小生成树.png" >

对于加权图，每条边都有权重，所以每棵生成树都有一个权重和。比如上图，右侧生成树的权重和显然比左侧生成树的权重和要小。
最小生成树，是所有可能的生成树中，权重和最小的那棵生成树就叫「最小生成树」。

#### Reference
[labuladong](https://labuladong.github.io/algo/2/22/54/)



## 图的算法

### [环检测和拓扑排序(Topological Sort)](../NotesBasedOnTags/Topological%20Sort.md)



### 并查集(Union Find)

#### Reference
[labuladong](https://labuladong.github.io/algo/2/22/53/)   
[力扣加加](https://mp.weixin.qq.com/s/aHdMcSAu2cpHgRq46yW3dw)    
https://github.com/lilyzhaoyilu/LeetCode-Notes/blob/master/NotesBasedOnCategories/Union%20Find.md

### Kruskal 算法


### Prim 算法


### Dijkstra算法

