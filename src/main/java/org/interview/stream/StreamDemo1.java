package org.interview.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamDemo1 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple", "Banana", "Banana", "Orange", "Grapes", "Avocado", "Strawberry", "Pineapple");

        // 1. collect: 將 Stream 中的元素收集到一個 List 中
        List<String> collectedList = list.stream().collect(Collectors.toList());
        System.out.println("Collected List: " + collectedList);

        // 2. filter: 長度超過 5 的保留
        List<String> filteredList = list.stream().filter(s -> s.length() > 5).collect(Collectors.toList());
        System.out.println("Filtered List: " + filteredList);

        // 3. map: 使用裡面的函數做轉換。在這裡是用 String::length 的方法做轉換，把原本 list 內的元素都轉換成長度
        List<Integer> lengths = list.stream().map(String::length).collect(Collectors.toList());
        System.out.println("Lengths: " + lengths);

        // 4. forEach
        System.out.print("ForEach:");
        list.stream().forEach(System.out::print);
        System.out.println();

        // 5. reduce: 累加，目的是把所有元素都加起來
        // 使用 Optional 避免出現空空集合
        // 如果 ifPresent 有值，就做後續的動作
        Optional<String> concatenated = list.stream().reduce((s1, s2) -> s1 + s2);
        concatenated.ifPresent(result -> System.out.println("Concatenated String: " + result));

        // 6. distinct: 移除重複
        List<String> distinctList = list.stream().distinct().collect(Collectors.toList());
        System.out.println("Distinct List: " + distinctList);

        // 7. sorted: 排序
        List<String> sortedList = list.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted List: " + sortedList);

        // 8. limit: 限制撈取五筆
        //    skip: 略過前五筆
        List<String> limitedList = list.stream().limit(5).collect(Collectors.toList());
        List<String> skippedList = list.stream().skip(5).collect(Collectors.toList());
        System.out.println("Limited List: " + limitedList);
        System.out.println("Skipped List: " + skippedList);

        // 9. anyMatch: 只要任一元素，找到開頭是 A 的，就返回 true
        //    allMatch: 全部元素，都符合長度 3，就返回 true
        //    noneMatch: 全部元素，都不滿足空的條件，就返回 true
        boolean anyMatch = list.stream().anyMatch(s -> s.startsWith("A"));
        boolean allMatch = list.stream().allMatch(s -> s.length() > 3);
        boolean noneMatch = list.stream().noneMatch(s -> s.isEmpty());
        System.out.println("Any Match: " + anyMatch);
        System.out.println("All Match: " + allMatch);
        System.out.println("None Match: " + noneMatch);

        // 10. findFirst: 尋找第一個元素
        //     findAny: 尋找任一個元素
        // 若處於 Parallel 中，findFirst 需要等到處理完畢才會去取資料，所以效能比較好
        // 但如果還是抓第一筆資料，仍要使用 findFirst
        Optional<String> first = list.stream().findFirst();
        Optional<String> any = list.stream().findAny();
        first.ifPresent(result -> System.out.println("First: " + result));
        any.ifPresent(result -> System.out.println("Any: " + result));
    }
}
