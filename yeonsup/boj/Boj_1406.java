package boj;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class Boj_1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String value = br.readLine();
        Editor editor = new Editor(value);
        int count = Integer.parseInt(br.readLine());
        while (count-- > 0) {
            String[] inputValues = br.readLine().split(" ");
            if (inputValues.length > 1) {
                editor.input(inputValues[0], inputValues[1]);
            } else {
                editor.input(inputValues[0], null);
            }
        }

        bw.write(editor.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    private static class Editor {
        private final Deque<String> data;
        private final Deque<String> sub;

        public Editor(String value) {
            this.data = new ArrayDeque<>();
            for (char c : value.toCharArray()) {
                data.push(String.valueOf(c));
            }
            this.sub = new ArrayDeque<>();
        }

        public void input(String command, String value) {
            try {
                switch (command) {
                    case "L" :
                        sub.push(data.pop());
                        break;
                    case "D" :
                        data.push(sub.pop());
                        break;
                    case "B" :
                        data.pop();
                        break;
                    case "P" :
                        data.push(value);
                        break;
                }
            } catch (NoSuchElementException e) {}

        }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer();
            for (String value : data) {
                sb.append(value);
            }
            sb.reverse();
            for (String value : sub) {
                sb.append(value);
            }
            return sb.toString();
        }
    }
}
