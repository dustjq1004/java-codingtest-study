package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Shark extends Fish{
    int fish = 0;

    public Shark(int x, int y) {
        super(x, y, 2);
    }


    private void grow() {
        size++;
        fish = 0;
    }

    public void getFish(Fish target) {
        this.x = target.x;
        this.y = target.y;
        fish++;

        if(fish == this.size) grow();
    }
}
class Fish {
    int x, y;
    int size;
    public Fish(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }
}

public class Boj_16236 {

    static int[][] board;
    static int[][] visited;
    static List<Fish> list = new ArrayList<>();
    static Shark shark;

    static int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    // 목적지까지 거리를 계산하는 bfs
    public static int bfs(Fish target, int x, int y) {
        Deque<Fish> queue = new ArrayDeque<>();
        queue.offerLast(new Fish(x, y, 0));
        visited[x][y] = 1;

        while (queue.size() > 0) {
            Fish fish = queue.poll();
            int time = visited[fish.x][fish.y];
            if (fish.x == target.x && fish.y == target.y) {
                return time - 1;
            }

            for (int i = 0; i < directions.length; i++) {
                int newX = fish.x + directions[i][0];
                int newY = fish.y + directions[i][1];

                if (newX >= 0 && newX < board.length
                        && newY >= 0 && newY < board.length
                        && board[newX][newY] <= shark.size
                        && visited[newX][newY] == 0) {

                        queue.offerLast(new Fish(newX, newY, 0));
                        visited[newX][newY] = time + 1;
                    }
                }
            }

        return -1;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int time = 0;
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int size = board[i][j];
                if(size >= 1 && size < 9) {
                    list.add(new Fish(i, j, size));
                } else if (size >= 9) {
                    shark = new Shark(i, j);
                    board[i][j] = 0;
                }
            }
        }

        List<Fish> searchList = list.stream().filter(fish -> fish.size < shark.size).collect(Collectors.toList());

        while (searchList.size() > 0) {
            int min = Integer.MAX_VALUE;
            Fish destFish = null;

            for (int i = 0; i < searchList.size(); i++) {
                visited = new int[n][n];
                Fish searchFish = searchList.get(i);
                int result = bfs(searchFish, shark.x, shark.y);
                if (result > -1 && result < min) {
                    destFish = searchFish;
                    min = result;
                }
            }

            if (destFish == null) break;

            shark.getFish(destFish);
            time += min;
            list.remove(destFish);
            searchList = list.stream().filter(fish -> fish.size < shark.size).collect(Collectors.toList());
        }


        System.out.println(time);
    }
}
