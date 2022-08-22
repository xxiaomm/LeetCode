
## Union Find 并查集
- [Union Find 并查集](#union-find-并查集)
  - [Intro](#intro)
  - [Hints to Use](#hints-to-use)
  - [Reference](#reference)

### Intro

并查集使用的是一种「树型」的数据结构，用于处理一些不交集（Disjoint Sets）的合并及查询问题。  

并查集（Union-find Algorithm）定义了两个用于此数据结构的操作：
- Find: 确定元素属于哪一个子集。它可以被用来确定两个元素是否属于同一子集。通常是返回集合内的一个「代表元素」。
- Union: 将两个子集合并成同一个集合。
- isConneted: 



### Hints to Use

- 需要查询图的联通状况
- 需要支持快速合并两个合集
- 检测是否有环 - 将边合并，如果在合并之前就同元，那么就有环
- 确定无向图的连通分量
- 亲戚问题，是否同个祖先



### Reference
https://algo.itcharge.cn/07.Tree/05.Union-Find/01.Union-Find/    
https://mp.weixin.qq.com/s/aHdMcSAu2cpHgRq46yW3dw     
https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247489706&idx=1&sn=771cd807f39d1ca545640c0ef7e5baec