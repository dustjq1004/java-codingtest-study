package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class RobotMovingMachine {

    public void moveRobotOnBelt(Deque<Belt> top) {
        LinkedList<Belt> castedTop = (LinkedList<Belt>) top;
        int beltNumber = top.size() - 1;

        while (beltNumber > 0 ) {
            Belt nextBelt = castedTop.get(beltNumber);
            Belt currentBelt = castedTop.get(beltNumber - 1);
            moveNextRobot(nextBelt, currentBelt);
            beltNumber--;
        }
        castedTop.get(top.size() - 1).removeRobot();
    }

    private boolean moveNextRobot(Belt nextBelt, Belt currentBelt) {
        if (!nextBelt.canMove() || !currentBelt.hasRobot()) {
            return false;
        }
        currentBelt.removeRobot();
        nextBelt.putRobot();
        return true;
    }
}

class Belt {
    private int durability;
    private boolean hasRobot;

    public Belt(int durability) {
        this.durability = durability;
        this.hasRobot = false;
    }

    public void putRobot() {
        hasRobot = true;
        durability--;
    }

    public void removeRobot() {
        hasRobot = false;
    }

    public boolean canMove() {
        return !hasRobot && durability > 0;
    }

    public int getDurability() {
        return durability;
    }

    public boolean hasRobot() {
        return hasRobot;
    }

    @Override
    public String toString() {
        return durability + ", " + hasRobot;
    }
}
class ConveyorBelt {

    private Deque<Belt> top = new LinkedList<>();
    private Deque<Belt> bottom = new LinkedList<>();
    private RobotMovingMachine movingMachine;

    public ConveyorBelt(Deque<Belt> top, Deque<Belt> bottom, RobotMovingMachine movingMachine) {
        this.top = top;
        this.bottom = bottom;
        this.movingMachine = movingMachine;
    }

    public void work() {
        bottom.offerLast(top.pollLast());
        top.offerFirst(bottom.pollFirst());

        top.getLast().removeRobot();

        movingMachine.moveRobotOnBelt(top);

        Belt firstBelt = top.getFirst();
        if (firstBelt.canMove()) {
            firstBelt.putRobot();
        }

//        System.out.println("top --------  " + top.toString());
//        System.out.println("bottom --------  " + bottom.toString());
//        System.out.println("##############################################################################################");
//        System.out.println();
    }

    public boolean isDurabilityCountK(int k) {
        LinkedList<Belt> castedTop = (LinkedList<Belt>) top;
        LinkedList<Belt> castedBottom = (LinkedList<Belt>) bottom;
        int index = 0;
        int kCount = 0;
        while (index < top.size()) {
            Belt topBelt = castedTop.get(index);
            Belt bottomBelt = castedBottom.get(index);

            if (topBelt.getDurability() <= 0) {
                kCount++;
            }

            if (bottomBelt.getDurability() <= 0) {
                kCount++;
            }
            index++;
        }
//        System.out.println("kCount = " + kCount);
        if (kCount >= k) {
            return true;
        }

        return false;
    }
}

public class Boj_20055 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] line = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = line[1];

        int index = 1;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Deque<Belt> top = new LinkedList<>();
        Deque<Belt> bottom = new LinkedList<>();
        while (st.hasMoreTokens()) {
            int beltDurability = Integer.parseInt(st.nextToken());

            if (index <= line[0]) {
                top.add(new Belt(beltDurability));
            } else {
                bottom.offerFirst(new Belt(beltDurability));
            }
            index++;
        }

        ConveyorBelt conveyorBelt = new ConveyorBelt(top, bottom, new RobotMovingMachine());

        int count = 0;
        while (!conveyorBelt.isDurabilityCountK(k)) {
            conveyorBelt.work();
            count++;
        }

        System.out.println(count);
        bf.close();
    }
}
