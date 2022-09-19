package main.java.striversSdeSheet.String.part1;

import java.util.HashMap;
import java.util.Map;

public class RomanNumberToInteger {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
                //2 * because we added wrong number then to correct it we have to remove it,
                //also we have to subtract that number
                //for eg: For 90, XC -> 10 added, then we identified C 100 added became 110,
                //But 100 > 10 so, we should have subtracted. Hence, 2 * 10 will get subtracted to correct it.
                result += map.get(s.charAt(i)) - (2 * map.get(s.charAt(i - 1)));
            } else {
                result += map.get(s.charAt(i));
            }
        }
        return result;
    }

    public String intToRoman(int num) {

        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return thousands[num / 1000] +
                hundreds[(num % 1000) / 100] +
                tens[(num % 100) / 10] +
                units[num % 10];
    }

    public static void main(String[] args) {
    }
}
