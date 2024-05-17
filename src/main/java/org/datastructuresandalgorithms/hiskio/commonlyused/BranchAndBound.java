package org.datastructuresandalgorithms.hiskio.commonlyused;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://hiskio.com/courses/465/lectures/23109
 * <p>
 * 找出飛機航班的最佳解
 * <p>
 * 分支界限法 = 基於回溯法去優化，找出最佳解
 */
public class BranchAndBound {
    Integer[][] hours;
    Integer hour_best = null;
    String[] countries = new String[]{"NP", "IS", "CA", "UK", "US"};

    private void build_hour_table() {
        // NP: 0 (North Pole)
        // IS: 1
        // CA: 2
        // UK: 3
        // US: 4

        this.hours = new Integer[5][5];

        hours[0][0] = 0;     // NP -> NP
        hours[0][1] = 14;    // NP -> IS
        hours[0][2] = 15;    // NP -> CA
        hours[0][3] = 17;    // NP -> UK
        hours[0][4] = 16;    // NP -> US

        hours[1][0] = 14;    // IS -> NP
        hours[1][1] = 0;     // IS -> IS
        hours[1][2] = 24;    // IS -> CA
        hours[1][3] = 8;     // IS -> UK
        hours[1][4] = 36;    // IS -> US

        hours[2][0] = 15;    // CA -> NP
        hours[2][1] = 24;    // CA -> IS
        hours[2][2] = 0;     // CA -> CA
        hours[2][3] = 34;    // CA -> UK
        hours[2][4] = 4;     // CA -> US

        hours[3][0] = 17;    // UK -> NP
        hours[3][1] = 8;     // UK -> IS
        hours[3][2] = 34;    // UK -> CA
        hours[3][3] = 0;     // UK -> UK
        hours[3][4] = 30;    // UK -> US

        hours[4][0] = 16;    // US -> NP
        hours[4][1] = 36;    // US -> IS
        hours[4][2] = 4;     // US -> CA
        hours[4][3] = 30;    // US -> UK
        hours[4][4] = 0;     // US -> US

    }

    public Integer get_hour(String start, String end) {
        Integer x = get_index(start);
        Integer y = get_index(end);
        return this.hours[x][y];
    }

    private Integer get_index(String str) {
        if (str.equals("NP")) return 0;
        if (str.equals("IS")) return 1;
        if (str.equals("CA")) return 2;
        if (str.equals("UK")) return 3;
        if (str.equals("US")) return 4;

        return null;
    }

    static class Country {
        String countryName;
        Integer index;
        Integer hour_to_take;

        public Country(String countryName, Integer index, Integer hour_to_take) {
            this.countryName = countryName;
            this.index = index;
            this.hour_to_take = hour_to_take;
        }
    }

    static class MyComp implements Comparator<Country> {
        @Override
        public int compare(Country country1, Country country2) {
            return country1.hour_to_take.compareTo(country2.hour_to_take);
        }
    }


    /**
     * branchandbound
     **/
    List<String> route = new ArrayList<>();

    public void branchAndBound(Integer hour_constraint) {
        // 設定初始由 NP 開始出發
        String start_country = "NP";
        route.add(start_country);
        countries[0] = null;

        branchAndBound_recursion(hour_constraint);
    }

    private void branchAndBound_recursion(Integer hourConstraint) {
        if (route.size() == 5) {
            int hour_total = get_hour_total();
            if (hour_best == null || hour_total < hour_best) {
                hour_best = hour_total;
                System.out.print("    "); // 印出排版好比對
                printResult(hour_total, route);
            } else {
                System.out.print("[X]:");
                printResult(hour_total, route);
            }
        } else {
            // 回溯法的地方
            int hour_total = get_hour_total();
            if (hour_best != null && hour_total > hour_best) {
                return;
            }
        }


//        // 查找到所有地方的組合 - 在 backtracking 或 enumeration 內都是單純 for 往下跑，我們要做有智慧的選擇
//        for (int i = 0; i < countries.length; i++) {
//            if (countries[i] == null) continue; // 移除檢查是否為 Null，Null表示已經算過了
//            String nextLocation = countries[i];
//            route.add(nextLocation);
//            countries[i] = null;
//
//            branchAndBound_recursion(hourConstraint);
//
//            // 上面移除後，下面還要計算所已把他們加回來
//            route.remove(nextLocation);
//            countries[i] = nextLocation;
//        }

        PriorityQueue<Country> pq = new PriorityQueue<>(countries.length, new MyComp());

        // step 01. sort child node by hours
        String c_start = route.get(route.size() - 1);
        for (int i = 0; i < countries.length; i++) {
            if (countries[i] == null) continue; // 代表這國家被用掉了，可以略過
            String c_end = countries[i];
            Integer hour = get_hour(c_start, c_end);
            Country c = new Country(c_end, i, hour);
            pq.add(c);
        }

        // step 02. pick the shortest path to calculate
        while (true) {
            if (pq.size() == 0) break;
            Country c = pq.poll();

            route.add(c.countryName);
            countries[c.index] = null;

            branchAndBound_recursion(hourConstraint);

            // 上面移除後，下面還要計算所已把他們加回來
            route.remove(c.countryName);
            countries[c.index] = c.countryName;
        }
    }

    private void printResult(int hour_total, List<String> route) {
        String countryOrigin = "NP";
        String countryTmp = "NP";
        int nowHour = 0;
        for (int i = 0; i < route.size(); i++) {

            countryOrigin = new String(countryTmp);
            countryTmp = route.get(i);
            nowHour = get_hour(countryOrigin, countryTmp);

            System.out.print(route.get(i));
            System.out.print("(" + nowHour + ")");
            if (i + 1 == route.size()) break;
            System.out.print("->");
        }

        System.out.println(" : " + hour_total);
    }

    private int get_hour_total() {
        if (route.size() == 0) return 0;

        int hour_total = 0;
        for (int i = 1; i < route.size(); i++) {
            hour_total += get_hour(route.get(i - 1), route.get(i));
        }
        return hour_total;
    }

    public static void main(String[] args) {
        BranchAndBound tp = new BranchAndBound();
        tp.build_hour_table();
        Integer hour_constraint = 60; // 65 ~ 100
        tp.branchAndBound(hour_constraint);

        // 在看結論的時候，會發現雖然已經找到第一個最佳解 56，但再找到 52 之前，還是有很多走到底
        // 原因是因為這些再走到第四座城市的時候都還 < 56，所以都還是會走到底
    }
}
