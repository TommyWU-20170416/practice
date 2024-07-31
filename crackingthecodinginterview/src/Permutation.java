public class Permutation {
    public static void main(String[] args) {
        Permutation p = new Permutation();
        p.permutation("AB");
    }

    void permutation(String str) {
        permutation(str, "");
    }

    void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
//                System.out.println("第" + i + "次:" + rem + ", prefix:" + str.charAt(i));
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }

    /**
     * prefix 會印出
     * ABCD  BACD  CABD  DABC
     * ABDC  BADC  CADB  DACB
     * ACBD  BCAD  CBAD  DBAC
     * ACDB  BCDA  CBDA  DBCA
     * ADBC  BDAC  CDAB  DCAB
     * ADCB  BDCA  CDBA  DCBA
     *
     * 以 A 來看
     * 想像成有個指標從 A 開始挑出來，然後最後 prefix + str.charAt(i)
     * A >  AB > ABC > ABCD
     * ----------ACD > ABDC
     * ---- AC > ACB > ACBD
     * --------- ACD > ACDB
     * ---- AD > ADB > ADBC
     * ---- AD > ADC > ADCB
     */
}
