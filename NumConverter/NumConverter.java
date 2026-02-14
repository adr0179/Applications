package NumConverter;
import java.util.ArrayList;

// work in progress

public class NumConverter {
    private static String toString(ArrayList<String> arr) {
        String str = "";

        for (int i = arr.size() - 1; i >= 0; i--) {
            str += arr.get(i);
        }

        return str;
    }

    public static String toBinary(Number num) {
        ArrayList<String> res = new ArrayList<>();

        if (num.intValue() == 0) {
            return "00000000";
        }

        while (num.intValue() >= 1) {
            if (num.intValue() % 2 == 1) {
                res.add("1");
                num = Math.round(num.intValue() / 2);
            } else {
                res.add("0");
                num = Math.round(num.intValue() / 2);
            }
        }

        return toString(res);
    }

    public static String toHex(Number num) {
        ArrayList<String> res = new ArrayList<>();

        if (num.intValue() <= 9) {
            return Integer.toString(num.intValue());
        } 

        while(num.intValue() >= 1) {
            if (num.intValue() % 16 == 10) {
                res.add("A");
                num = Math.round(num.intValue() / 16);
            } else if (num.intValue() % 16 == 11) {
                res.add("B");
                num = Math.round(num.intValue() / 16);
            } else if (num.intValue() % 16 == 12) {
                res.add("C");
                num = Math.round(num.intValue() / 16);
            } else if (num.intValue() % 16 == 13) {
                res.add("D");
                num = Math.round(num.intValue() / 16);
            } else if (num.intValue() % 16 == 14) {
                res.add("E");
                num = Math.round(num.intValue() / 16);
            } else if (num.intValue() % 16 == 15) {
                res.add("F");
                num = Math.round(num.intValue() / 16);
            } else {
                res.add(Integer.toString(num.intValue() % 16));
                num = Math.round(num.intValue() / 16);
            }
        }

        return toString(res);
    }
}