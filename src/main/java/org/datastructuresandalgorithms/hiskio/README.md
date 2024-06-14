# [hiskio-高效圖解演算法](src/main/java/org/datastructuresandalgorithms/hiskio)

> 這課程有完整的介紹流程，java 實作跟 leetcode，覺得滿划算就買了

## 入門篇

1. ### Array 實做
    - [Array_Impl.java](array/Array_Impl.java)
2. ### LinkedList 實做
    - [List_Impl.java](array/List_Impl.java)
3. ### Recursion
   > 了解遞迴的實作方式
    - [Fibonacci.java](Fibonacci.java)
4. ### Stack 實作[stack](stack)
    - Array 方式
    - List 方式
5. ### Queue 實作[queue](queue)
    - Array 方式
    - List 方式
    - 練習 [Priority_Queue.java](queue/Priority_Queue.java)

### 排序法(都從小到大做排序做解釋)

1. #### 冒泡排序法 - [bubble sort](sort/bubblesort)
   > 說明: 只要左邊比右邊大的就交換，且一路比到底
    - 時間: O(n) ~ O(n^2)。不管有無排序，每一次都要比較
    - 空間: 原地交換，沒有額外空間使用
    - 實現簡單好理解
    - 不適合用在大量的排序

2. #### 插入排序法 - [insertionsort](sort/insertionsort)
   > 說明: 往後找到比當前小的，找到就交換，如果沒有就跳脫。重點就是 break
    - 時間: O(n) ~ O(n^2)
    - 空間: 原地交換，沒有額外空間使用
    - 適合用在大致上有排序的數列，因為有 break 所以假設已經大致上有序，就可以少一些檢查
    - 不適合用在大量的排序

3. #### 選擇排序法 - [selectionsort](sort/selectionsort)
   > 說明: 往後找到比我當前最小的，就交換
    - 時間: O(n) ~ O(n^2)。不管有無排序，每一次都要找出最大的數字
    - 空間: 原地交換，沒有額外空間使用
    - 實現簡單好理解
    - 不適合用在大量的排序

### 常見演算法-[commonlyused](commonlyused)

1. #### 貪婪法-[Greedy.java](commonlyused/Greedy.java)
   > 使用當前最好的解(最短的路徑)，提供解方
    * 使用方法: PriorityQueue 儲存每一個 node 的最短路徑，然後取出最短的路徑去做組合
    * 應用條件: 需要滿足貪婪選擇性質(可以在每一次的選擇挑出最佳解)、最佳子結構問題(可以被細部拆分的行為)
    * 應用情境: 最小生成樹(如Prim算法和Kruskal算法)、最短路徑(如Dijkstra算法)
    * 簡單易實現，高效能計算因為不會全局去搜索，適合資源有限的情境查詢
    * `有可能算出來的是次優解，因為他只會提供當前最佳解`

2. #### 枚舉法-[Enumerative.java](commonlyused/Enumerative.java)
   > 把所有結果都跑一遍，列出所有可能，並依據合格標準去篩選
    * 使用方法: 可以用迴圈、recursion 找出所有組合
    * 簡單易實現，一定知道所有的答案
    * `時間複雜度會很高`

3. #### 回溯法-[BackTracking.java](commonlyused/BackTracking.java)
   > 針對枚舉法做的改善，
    * 使用方法: 紀錄上一次的合格解，若已經超過就停止往下計算
    * 通過"回溯"避免對不合適的解進行不必要的計算。
    * `時間複雜度會很高`

4. #### 分枝界限法-[BranchAndBound.java](commonlyused/BranchAndBound.java)
   > 挑選當下"看起來最好"、不可能更好就回頭，找到最佳解
    * 使用方法:
        * branch 方法: PriorityQueue 儲存每一個班機的最短路徑，然後取出最短的路徑去做組合
        * bound 方法: 紀錄上一次的最佳解，並拿去做比對，超過最佳就停止往下計算

5. #### 分治法-[DivideConquer_Hanoi.java](commonlyused/DivideConquer_Hanoi.java)
   > 將一個複雜問題分解為較小且相似的子問題，使用相同的方式解決這些子問題，最後將所有解合併以得到原問題的解
    * 使用方法：
        * 分解：將問題分解為若干個子問題
        * 解決：遞歸地解決每個子問題，直到子問題變得足夠簡單，可以直接解決
        * 合併：將子問題的解合併成原問題的解
    * 高效：對於許多問題，分治法可以顯著降低時間複雜度，例如快速排序（O(n log n)）和合併排序（O(n log n)）
    * 模塊化：每個子問題獨立解決，易於調試和理解
    * 遞歸開銷：遞歸調用的額外開銷
    * 如果子問題重疊，會出現重複計算的情況，例如計算斐波那契數列，這時動態規劃可能更優
    * 合併步驟可能比較複雜且耗時，例如在合併排序中

## Graph

### 第一章 Graph 資料結構表現法

#### Adj_Matrix

* 使用 boolean 表示節點與節點之間的關聯
    * [Graph_Adj_Matrix_Impl_boolean.java](graph/matrix/Graph_Adj_Matrix_impl_boolean.java)
* 使用 weight 表示節點與節點之間的距離
    * [Graph_Adj_Matrix_Impl_Integer.java](graph/matrix/Graph_Adj_Matrix_impl_Integer.java)
* 為了讓印出的時候可以更好的識別，新增 print_edge 的 src 以及 dst，來源跟目的都變成 ABCDE
    * [Graph_Adj_Matrix_impl_Vertex.java](graph/matrix/Graph_Adj_Matrix_impl_Vertex.java)

```java
//  A B C D E 
//A 0 1 3 ∞ ∞ 
//B ∞ 0 ∞ ∞ 7 
//C ∞ ∞ 0 2 2 
//D ∞ ∞ ∞ 0 9 
//E ∞ ∞ ∞ 9 0 
```

#### Adj_List

* 使用 list 取代 array 紀錄 節點與節點之間的關聯，此時還沒有距離的概念
  [Graph_Adj_List_Impl_Integer.java](graph/list/Graph_Adj_List_Impl.java)

```java
//[0] -> 1 -> 2
//[1] -> 4
//[2] -> 3 -> 4
//[3] -> 4
//[4] -> 3 
```

* 使用 EdgeState 新增距離的概念
  [Graph_Adj_List_Impl_EdgeState.java](graph/list/Graph_Adj_List_Impl_EdgeState.java)

```java
//[0] -> [1 1] -> [2 3] 
//[1] -> [4 7] 
//[2] -> [3 2] -> [4 2] 
//[3] -> [4 9] 
//[4] -> [3 9] 
```

* 把原本的 0 1 2 3 4 取代成 A B C D E
  [Graph_Adj_List_Impl_EdgeState_Vertex.java](graph/list/Graph_Adj_List_Impl_EdgeState_Vertex.java)

```java
//[A] -> [B 1] -> [C 3] 
//[B] -> [E 7] 
//[C] -> [D 2] -> [E 2] 
//[D] -> [E 9] 
//[E] -> [D 9] 
```

### 第二章 Graph 的遍歷

* BFS
    * Matrix
        * [Graph_Adj_Matrix_Impl_Weight_Plus_Vertext_State_bfs.java](graph/bfs/Graph_Adj_Matrix_Impl_Weight_Plus_Vertext_State_bfs.java)
        * 使用 QUEUE 去紀錄，當節點去遍歷的時候發現往下還有，就新增到 queue 內
          ```java
          //bfs: A B C E D
          // |     | 想像這是 queue，右進左出
          //第一步: A 放進去 => |A |
          //第二步: 取出A，發現 BC 有關聯，放進 BC => |BC |
          //第三步: 取出B，發現 E 有關聯，放進 E => |CE |
          //第四步: 取出C，發現 D 有關聯，放進 D => |ED |
          //第五步: 取出E，發現 D 有關聯，可是D放過就不放 => |D |
          //第六步: 取出D，發現 E 有關聯，可是E放過就不放 => | |
          ```
    * List
        * 做法跟 Matrix 一樣，只是從 array 改成 list 抓資料

* DFS
    * Matrix
        * [Graph_Adj_Matrix_Impl_Weight_Plus_Vertext_State_dfs.java](graph/dfs/Graph_Adj_Matrix_Impl_Weight_Plus_Vertext_State_dfs.java)
        * 使用 recusion + for 按照順序 一層層訪問下去
        * 在這邊也是有 preorder 以及 postorder 可以使用

        ```java
        //bfs: A B C E D 
        //第一步: 訪問 A，A 的第一順位是 B(若有被 set 記錄過，且 內容為MIN 就跳過)
        //第二步: 訪問 B，B 的第一順位是 E
        //第三步: 訪問 E，E 的第一順位是 D
        //第四步: 訪問 D，D 的第一順位是 E，可是被記錄過，所以開始返回
        //第五步: 返回到 E 這層，沒有其他節點
        //第六步: 返回到 B 這層，沒有其他節點
        //第七步: 返回到 A 這層，A 的第二順位是 C
        //第八步: 訪問 C，C 的第一順位是 D，被訪問過；第二順位是E，被訪問過，所以開始返回
        //第九步: A 沒有其他順位，結束。
        ```
    * List
        * 做法跟 Matrix 一樣，只是從 array 改成 list 抓資料