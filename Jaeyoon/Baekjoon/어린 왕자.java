/*
    백준 1004번: 어린 왕자
    알고리즘 분류: #수학 #기하학
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 진입, 이탈 횟수를 저장할 count
    static int cnt;
    // 출발 좌표
    static int x1, y1;
    // 도착 좌표
    static int x2, y2;
    // 행성의 중점과 반지름
    static int cx, cy, r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(br.readLine());

            for(int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                cx = Integer.parseInt(st.nextToken());
                cy = Integer.parseInt(st.nextToken());
                r = Integer.parseInt(st.nextToken());
                // 출발 지점이 행성 안에 포함되고
                if(dotInCircle(x1, y1)){
                    // 도착 지점이 행성 밖에 있다면 count를 증가
                    if(!dotInCircle(x2, y2)){
                        cnt++;
                    }
                }
                // 출발 지점이 행성 밖에 있고
                else{
                    // 도착 지점이 행성 안에 포함된다면 count를 증가
                    if(dotInCircle(x2, y2)){
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    public static boolean dotInCircle(int x, int y){
        // 피타고라스의 정리를 이용해 해당 좌표가 원의 범위 안에 포함되는지 확인
        if (Math.pow(r, 2) > (Math.pow(cx - x, 2) + Math.pow(cy - y, 2))) {
            return true;
        }
        else{
            return false;
        }
    }
}