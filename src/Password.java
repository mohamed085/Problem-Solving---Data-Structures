// https://codeforces.com/problemset/problem/126/B

import java.util.ArrayList;
import java.util.Scanner;

public class Password {
    static ArrayList<Integer> longestPrefix;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.next();
        longestPrefix = new ArrayList();//new object 
        computePrefix(s);//Prefix function

        boolean found = false;
        int len;//the length of the answer

        len = longestPrefix.get(s.length() - 1);

        if(len!=0){
            for(int j=0;j<2;j++) {
                for (int i = 1; i < s.length() - 1; i++) {
                    if (len == longestPrefix.get(i)) {
                        found = true;
                        break;
                    }

                }
                if(!found){
                    len=longestPrefix.get(len-1);
                    if(len==0)
                        break;
                }
                else
                    break;
            }

        }
        if (!found || len == 0) {
            System.out.println("Just a legend");
        } else {
            System.out.println(s.substring(0, len));
        }

    }

    public static void computePrefix(String str) {
        longestPrefix.add(0);
        int m = str.length();
        for (int i = 1, k = 0; i < m; i++) {
            while (k > 0 && str.charAt(k) != str.charAt(i)) {
                k = longestPrefix.get(k - 1);
            }

            if (str.charAt(k) == str.charAt(i)) {
                longestPrefix.add(i, ++k);
            } else {
                longestPrefix.add(i, k);
            }
        }
    }

}