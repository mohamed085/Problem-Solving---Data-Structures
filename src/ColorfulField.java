// https://codeforces.com/problemset/problem/79/B
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;
import static java.lang.String.*;

public class ColorfulField {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        StringTokenizer tk;

        tk = new StringTokenizer(in.readLine());
        int n = parseInt(tk.nextToken()),m = parseInt(tk.nextToken()),k = parseInt(tk.nextToken()),t = parseInt(tk.nextToken());

        TreeSet<pair> s = new TreeSet<>();
        for(int i=0,r,c; i<k; i++) {
            tk = new StringTokenizer(in.readLine());
            r = parseInt(tk.nextToken());
            c = parseInt(tk.nextToken());

            s.add(new pair(r,c));
        }

        int cnt=1;
        for(pair p : s)
            p.order = cnt++;

        while(t-- > 0) {
            tk = new StringTokenizer(in.readLine());
            int r = parseInt(tk.nextToken()),c = parseInt(tk.nextToken());

            pair p = s.ceiling(new pair(r,c));

            if(p==null) {
                int res = (r-1)*m+c-(k);

                if(res%3==0) out.append("Grapes\n");
                else if(res%3==1) out.append("Carrots\n");
                else out.append("Kiwis\n");
            } else {
                if(p.r==r && p.c==c) {
                    out.append("Waste\n");
                } else {
                    int res = (r-1)*m+c-(p.order-1);

                    if(res%3==0) out.append("Grapes\n");
                    else if(res%3==1) out.append("Carrots\n");
                    else out.append("Kiwis\n");
                }
            }
        }

        System.out.print(out);
    }

}

class pair implements Comparable<pair> {
    int r,c,order;

    public pair(int r,int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public int compareTo(pair o) {
        if(r!=o.r)
            return r-o.r;
        return c-o.c;
    }
}