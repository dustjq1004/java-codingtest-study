package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Location {
    int x;
    int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Boj_17086 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        ArrayList<Location> sharks = new ArrayList();
        ArrayList<Location> safes = new ArrayList();

        int max = 0;

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 1; i <= n; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                String token = stringTokenizer.nextToken();
                if(token.equals("1")) sharks.add(new Location(i, j));
                else safes.add(new Location(i, j));
            }
        }

        for (int i = 0; i < safes.size(); i++) {
            Location safe = safes.get(i);
            int min = Integer.MAX_VALUE;

            for (Location shark : sharks) {
                int value = Math.max(Math.abs(safe.x - shark.x), Math.abs(safe.y - shark.y));
                min = Math.min(min, value);
            }

            max = Math.max(max, min);
        }

        System.out.println(max);
    }

}

/*
5 4
0 0 1 0
0 0 0 0
1 0 0 0
0 0 0 0
0 0 0 1


7 4
0 0 0 1
0 1 0 0
0 0 0 0
0 0 0 1
0 0 0 0
0 1 0 0
0 0 0 1
* */

