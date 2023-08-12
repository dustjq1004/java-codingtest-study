package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 어린왕자 {
    static int[][] list;
    static int[] spot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            spot = new int[]{Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())};

            int n = Integer.parseInt(br.readLine());

            list = new int[n][3];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 3; k++) {
                    list[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            // 입력 다 받음

            int count = 0;
            for (int j = 0; j < n; j++) {
                int key = check(spot, list[j]);
                if (key == 1) {
                    // 시작점과 도착점 둘 중 하나만 원 안에 있을 때
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static int check(int[] spot, int[] circle) {
        // 원 안에 점이 있는지 확인함
        int startX = spot[0];
        int startY = spot[1];
        int destX = spot[2];
        int destY = spot[3];
        int key = 0;

        if (
                (((startX - circle[0]) * (startX - circle[0])) + ((startY - circle[1]) * (startY - circle[1]))
                        < (circle[2] * circle[2]))
        ) {
            // 시작점이 원 안에 있을 때
            key++;
        }
        if (
                (((destX - circle[0]) * (destX - circle[0])) + ((destY - circle[1]) * (destY - circle[1]))
                        < (circle[2] * circle[2]))
        ){
                // 도착점이 원 안에 있을 때
                key++;
            }
            return key;
        }
}

