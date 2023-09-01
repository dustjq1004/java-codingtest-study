package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Meeting {

    long start;
    long end;

    public Meeting(long start, long end) {
        this.start = start;
        this.end = end;
    }
}


public class Boj_1931 {



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Meeting> list = new ArrayList<>();
        int number = Integer.parseInt(bf.readLine());
        long last = 0;
        int cnt = 0;

        for (int i = 0; i < number; i++) {
            String[] time = bf.readLine().split(" ");
            list.add(new Meeting(Long.parseLong(time[0]), Long.parseLong(time[1])));
        }

        list.sort((o1, o2) -> {
            if(o1.end <= o2.end) {
                if(o1.start < o2.start) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return 1;
        });

        for (int i = 0; i < list.size(); i++) {
            if (last <= list.get(i).start) {
                last = list.get(i).end;
                cnt++;
            }
        }

        System.out.println(cnt);

        bf.close();
    }
}

/*
11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14
 */