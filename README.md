# 這邊專門放一些平常練習用的，怕日後忘記可以來複習

1. nativePractive(這裡是之前研究 java native 可以做到什麼樣的程度)
    * [nativepractice](src/main/java/org/nativepractice)
2. 深拷貝(deepcopy)與淺拷貝(shallowcopy)範例
    * [deepcopy](src/main/java/org/interview/deepcopy)
    * [shallowcopy](src/main/java/org/interview/shallowcopy)
3. 傳值
    * [passbyvalue](src/main/java/org/interview/passbyvalue)
4. 構造器重寫
    * [ConstructorOverride.java](src/main/java/org/interview/override/ConstructorOverride.java)
5. 靜態方法呼叫非靜態方法
    * [StaticTest.java](src/main/java/org/interview/statictest/StaticTest.java)
6. 初始化題目
    * [靜態代碼與構造器的執行順序](src/main/java/org/interview/initialtest[InitialTest.java](src/main/java/org/interview/initialtest/InitialTest.java))
7. 抽象與接口
    * [方法與變數的使用](src/main/java/org/interview/abstractandinterface)
8. trycatchfinally處理
    * [trycatchfinallyquestion](src/main/java/org/interview/trycatchfinallyquestion)
9. Lambda 使用
    * [LambdaDemo1.java](src/main/java/org/interview/lambda/LambdaDemo1.java) - 展示Lambda的改寫方式
    * [LambdaDemo2.java](src/main/java/org/interview/lambda/LambdaDemo2.java) - 自定義函數式接口
    * [LambdaDemo3.java](src/main/java/org/interview/lambda/LambdaDemo3.java) - 自定義函數並且客製化包裝
    * [LambdaDemo4.java](src/main/java/org/interview/lambda/LambdaDemo4.java) - 泛型的搭配
10. Stream API
    * [StreamDemo1.java](src/main/java/org/interview/stream/StreamDemo1.java)
11. Method Reference
    * [MethodReferenceDemo1.java](src/main/java/org/interview/methodreference/MethodReferenceDemo1.java)
## 還找不到範例先建立資料夾

* [parallelism](src/main/java/org/interview/parallelism)

---

## [hiskio-高效圖解演算法](src%2Fmain%2Fjava%2Forg%2Fdatastructuresandalgorithms%2Fhiskio)
這課程有完整的介紹流程，java 實作跟 leetcode，覺得滿划算就買了

## 入門篇
### Array
[Array_Impl3.java](src%2Fmain%2Fjava%2Forg%2Fdatastructuresandalgorithms%2Fhiskio%2FArray_Impl3.java)

### Recursion
了解遞迴的實作方式
[Fibonacci.java](src%2Fmain%2Fjava%2Forg%2Fdatastructuresandalgorithms%2Fhiskio%2FFibonacci.java)

### 排序法
1. #### [冒泡排序法 bubble sort]([bubblesort](src%2Fmain%2Fjava%2Forg%2Fdatastructuresandalgorithms%2Fhiskio%2Fsort%2Fbubblesort))
- 時間: O(n) ~ O(n^2)
- 空間: 原地交換，沒有額外空間使用
- 實現簡單好理解
- 不適合用在大量的排序

2. #### [插入排序法 insertion sort]([insertionsort](src%2Fmain%2Fjava%2Forg%2Fdatastructuresandalgorithms%2Fhiskio%2Fsort%2Finsertionsort))
- 時間: O(n) ~ O(n^2)
- 空間: 原地交換，沒有額外空間使用
- 適合用在大致上有排序的數列
- 不適合用在大量的排序

---