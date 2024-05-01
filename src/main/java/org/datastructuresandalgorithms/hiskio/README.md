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

3. #### 回溯法
4. #### 分枝界線法
5. #### 分治法
