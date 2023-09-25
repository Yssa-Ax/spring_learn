package od;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Administrator
 * @description
 * @since 2023/8/17 11:16
 **/
public class MaxProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int max = 0;

        for (String strA : strs) {
            for (String strB : strs) {
                boolean b = hasSameCharacters(strA, strB);
                if(!b) {
                    int i = strA.length() * strB.length();
                    if(i > max) {
                        max = i;
                    }
                }
            }
        }
        System.out.println(max);
    }


    public static boolean hasSameCharacters (String str1, String str2) {
        HashSet<Character> charSet1  = new HashSet<>();
        HashSet<Character> charSet2  = new HashSet<>();

        for (char c : str1.toCharArray()) {
            charSet1.add(c);
        }

        for (char c : str2.toCharArray()) {
            charSet2.add(c);
        }

        // 并通过retainAll()方法求取两个集合的交集
        charSet1.retainAll(charSet2);

        return !charSet1.isEmpty();

    }
}
