package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Applicant {
    private int document;
    private int interview;

    public Applicant(int document, int interview) {
        this.document = document;
        this.interview = interview;
    }

    public boolean isInvBetter(int interview) {
        if(interview < this.interview) return true;
        return false;
    }

    public int getInterview() {
        return interview;
    }

    public int getDocument() {
        return document;
    }
}

public class Boj_1946 {

    public int getMaxNumNewEmployees(List<Applicant> applicants) {
        int cnt = 1;
        int min = applicants.get(0).getInterview();
        for (int i = 1; i < applicants.size(); i++) {
            int interview = applicants.get(i).getInterview();
            if(interview < min) {
                cnt++;
                min = interview;
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Boj_1946 boj1946 = new Boj_1946();
        int testCnt = Integer.parseInt(br.readLine());


        while (testCnt > 0) {
            List<Applicant> list = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                String[] app = br.readLine().split(" ");
                list.add(new Applicant(Integer.parseInt(app[0]), Integer.parseInt(app[1])));
            }

            list.sort(new Comparator<Applicant>() {
                @Override
                public int compare(Applicant o1, Applicant o2) {
                    if(o1.getDocument() > o2.getDocument()) {
                        return 1;
                    }
                    return -1;
                }
            });

            int cnt = boj1946.getMaxNumNewEmployees(list);

            System.out.println(cnt);

            testCnt--;
        }

    }
}
