package org.datastructuresandalgorithms.hiskio.commonlyused;

import java.util.ArrayList;
import java.util.List;

/**
 * https://hiskio.com/courses/465/lectures/23108
 * <p>
 * 找出飛機航班的合格解以及最佳解
 * <p>
 * 回溯法 = 在枚舉法每一次計算前，去看是否已經超過上一次的最佳解
 */
public class BackTracking {
    Integer[][] hours;

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

    /**
     * enumeration
     **/
    List<String> route = new ArrayList<>();

    public void enumeration(Integer hour_constraint) {
        // 設定初始由 NP 開始出發
        String start_country = "NP";
        route.add(start_country);
        countries[0] = null;

        enumeration_recursion(hour_constraint);
    }

    private void enumeration_recursion(Integer hourConstraint) {
        if (route.size() == 5) {
            int hour_total = get_hour_total();
            if (hour_total < hourConstraint) {
                System.out.print("    "); // 印出排版好比對
                printResult(hour_total, route);
            } else {
                System.out.print("[X]:");
                printResult(hour_total, route);
            }
            return;
        } else {
            // 回溯法的地方
            int hour_total = get_hour_total();
            if (hour_total > hourConstraint) {
                return;
            }
        }


        // 查找到所有地方的組合
        for (int i = 0; i < countries.length; i++) {
            if (countries[i] == null) continue; // 移除檢查是否為 Null，Null表示已經算過了
            String nextLocation = countries[i];
            route.add(nextLocation);
            countries[i] = null;

            enumeration_recursion(hourConstraint);

            // 上面移除後，下面還要計算所已把他們加回來
            route.remove(nextLocation);
            countries[i] = nextLocation;
        }
    }

    private void printResult(int hour_total, List<String> route) {
        for (int i = 0; i < route.size(); i++) {
            System.out.print(route.get(i));
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
        BackTracking tp = new BackTracking();
        tp.build_hour_table();
        Integer hour_constraint = 60; // 65 ~ 100
        tp.enumeration(hour_constraint);
    }
}
