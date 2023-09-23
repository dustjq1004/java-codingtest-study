/*
    프로그래머스 Lv2
    Title: 전화번호 목록
 */
import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();

        // 해시맵에 모든 전화번호를 등록
        for(String phone_number : phone_book) {
            map.put(phone_number, 1);
        }
        // 해시맵 순회
        for(String phone_number : phone_book) {
            // 각 전화번호의 접두사에 해시맵에 존재하는지 확인 (substring(0, 1) ~ substring(0, length - 1))
            for(int i = 1; i < phone_number.length(); i++) {
                String s = phone_number.substring(0, i);
                // 존재하면 false 반환
                if(map.containsKey(s)) {
                    return false;
                }
            }
        }
        // 반복문이 종료되면 한 번호가 다른 번호의 접두사인 경우가 없는 것으므로, true 반환
        return true;
    }
}