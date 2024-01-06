package DSA;

import java.util.Arrays;
import java.util.HashMap;

public class MinimumWindowSubString {

    public static boolean containAllChars(String s, String t) {

        HashMap<Character, Integer> temp = new HashMap<>();

        for (int i=0; i<t.length(); i++){
            if (temp.containsKey(t.charAt(i))){
                temp.put(t.charAt(i), temp.get(t.charAt(i))+1);
            }else {
                temp.put(t.charAt(i), 1);
            }
        }

        for (int i=0; i<s.length(); i++){
            if (temp.containsKey(s.charAt(i))){
                if (temp.get(s.charAt(i)) == 0){
                    continue;
                }else {
                    temp.put(s.charAt(i), temp.get(s.charAt(i))-1);
                }
            }
        }

        for (int value : temp.values()){
            if (value>0){
                return false;
            }
        }

        return true;
    }

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        if (s.equals(t)) return s;
        String out = "";

        int i = 0;
        int j = 0;

        while (i<s.length() && j<s.length()){

            String temp = s.substring(i,j+1);
            if (containAllChars(temp,t)){
                if (out.length()==0){
                    out = temp;
                }
                if (temp.length() < out.length()){
                    out = temp;
                }

                i++;
                j = i;

            }else {
                j++;
            }

            if (j==s.length()){
                i++;
                j = i;
            }
        }

        return out;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
}
