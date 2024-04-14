# 工廠模式

---

## 情境

- Fake 想要開一家 Pizza 店，他想要寫一個共用類，當有新的 Pizza 品項出來的時候，他就添加新口味到共用類裡面，Wally認為這樣的做法比較簡單。[程式碼-WallyPizza.java](practice1%2FWallyPizza.java)

## 步驟

1. 定義共用類 Pizza，後面新的口味就來繼承這個物件
2. 在共用類的 order 時候，根據 type 在執行期的時候決定要創建什麼 pizza

## 想想看

1. 這樣做有什麼缺點
    * 分析看看
        * 若有新增、移除口味的時候就要新增 if else
        * 若之後要開給其他 Pizza 公司共用，有辦法嗎?現在只能給新口味 extends
2. 可以怎麼改善
    * 這樣看下來要把 __會變動的__ 移出去，拒絕修改程式

---

## 開始改造

## 目的是要創建一個方法，輸入口味回傳 Pizza 物件

- 創建一個 [SimplePizzaFactory.java](practice2%2FSimplePizzaFactory.java)
- 創建 [WallyPizza2.java](practice2%2FWallyPizza2.java) 第二代，讓原本的 if else ，改成呼叫工廠，請工廠根據 type 輸出 pizza

## 想想看
若未來新增口味，不用修改 WallyPizza，只要修改 SimplePizzaFactory，

---

# 代辦
[WallyPizza2.java](practice2%2FWallyPizza2.java) 內呼叫的 factory 與書上的差異。