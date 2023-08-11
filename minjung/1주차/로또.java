package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 로또 {

    static int[] list;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.countTokens() != 1) {
            list = new int[Integer.parseInt(st.nextToken())];
            for (int i = 0; i < list.length; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(list);

            visited = new boolean[list.length];
            visit(0, 0, new ArrayList<>());

            st = new StringTokenizer(br.readLine());
            System.out.println();
        }
    }


    public static void visit(int count, int idx, ArrayList<Integer> res) {
        // 6개 뽑아서 출력
        if(count==6) {
            for(int i=0; i<6; i++) System.out.print(res.get(i) + " ");
            System.out.println();
            return;
        }

        for (int i = idx; i < list.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                res.add(list[i]);
                visit(count + 1, i, res);
                visited[i] = false;
                res.remove(res.size()-1);
            }
        }
    }
}
