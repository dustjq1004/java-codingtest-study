/*
    프로그래머스 Lv2
    Title: 조이스틱
 */
class Solution {
    public int solution(String name) {
        int upDownCnt = 0;
        // 상하 조작 count
        for(int i = 0; i < name.length(); i++) {
            upDownCnt += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A'));
        }

        int A_cnt = 0;  // 'A'의 개수 count
        int maxLength = 0; // 가장 긴 'A' 문자 집합의 길이
        int maxIdx = -1; // 가장 긴 'A' 문자 집합이 끝나는 위치의 index
        int lastChar_Idx = -1; // 'A'가 아닌 마지막 문자의 index

        // 가장 긴 'A' 문자 집합과 'A'가 아닌 마지막 문자의 위치를 찾음
        for(int i = 0; i < name.length(); i++) {
            if(name.charAt(i) == 'A') {
                A_cnt++;
            }
            else {
                if(A_cnt > maxLength) {
                    maxLength = A_cnt;
                    maxIdx = i - 1;
                }
                A_cnt = 0;
                lastChar_Idx = i;
            }
        }
        // 좌우 조작 횟수 count
        int rightLeft_Cnt = 0;
        // 시작 위치에서 오른쪽으로만 이동한 경우와 가장 긴 'A' 문자집합 앞에서 왼쪽으로 턴하는 경우 중 더 작은 값을 저장
        rightLeft_Cnt = Math.min(lastChar_Idx, (maxIdx - maxLength) * 2 + name.length() - maxIdx - 1);
        // 첫 위치에서 왼쪽으로 이동하다가 가장 긴 'A' 문자집합 뒤에서 오른쪽으로 턴하는 경우와 위의 결과값 중 더 작은 값을 저장
        rightLeft_Cnt = Math.min(rightLeft_Cnt, (name.length() - maxIdx - 1) * 2 +  maxIdx - maxLength);

        // 문자열에 'A'가 존재하지 않는 경우 좌우 이동 횟수는 문자열의 길이 - 1
        if(maxIdx == -1) {
            rightLeft_Cnt = name.length() - 1;
        }
        // 문자열이 모두 'A' 문자로만 이루어진 경우 좌우 이동 횟수는 0
        if(lastChar_Idx == -1) {
            rightLeft_Cnt = 0;
        }
        // 상하 이동 횟수 + 좌우 이동 횟수 = 총 조작 횟수
        return upDownCnt + rightLeft_Cnt;
    }
}