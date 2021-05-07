/** https://codeforces.com/problemset/problem/567/D */

import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;

public class OneDimensionalBattleShips {

    static int n,k,a;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        StringTokenizer tk;

        tk = new StringTokenizer(in.readLine());
        n = parseInt(tk.nextToken());
        k = parseInt(tk.nextToken());
        a = parseInt(tk.nextToken());

        TreeSet<segment> set = new TreeSet<>();
        set.add(new segment(1,n));
        int ship = length(1,n);

        int q = parseInt(in.readLine());
        tk = new StringTokenizer(in.readLine());

        for(int i=1,x; i<=q; i++) {
            x = parseInt(tk.nextToken());

            segment s = set.ceiling(new segment(x,x));

            ship -= length(s.l,s.r);

            ship += length(s.l,x-1);
            set.add(new segment(s.l,x-1));

            ship += length(x+1,s.r);
            set.add(new segment(x+1,s.r));

            if(ship < k) {
                System.out.println(i);
                return;
            }
        }

        System.out.println("-1");
    }

    static int length(int l,int r) {
        return (r-l+2)/(a+1);
    }
}

class segment implements Comparable<segment> {
    int l,r;

    public segment(int l,int r){
        this.l = l;
        this.r = r;
    }

    @Override
    public int compareTo(segment o) {
        if(l!=o.l)
            return o.l-l;
        return r-o.r;
    }
}