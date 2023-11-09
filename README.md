# java-codingtest-study
자바 코딩 테스트 스터디 그룹입니다.😆


## 자바 코딩 테스트 스터디
1. 1주일에 4개의 문제를 푼다. (문제는 백준 or 프로그래머스에서 각자 풀고 싶은 문제 하나를 선택한다.)
   - 백준 : 실버3 ~ 골드 3,4
   - 프로그래머스 : level2,3
2. 매 주 토요일 낮에 오프라인으로 모여서 코드리뷰를 하고 시간을 정해 문제 하나를 푼다.
## 오프라인
```
🗺️ 장소 : 사당역 스터디룸  
⏰ 시간 : 토요일 오후 2시까지
```
- 리뷰할 문제는 랜덤으로 정한다. 인당 1문제  
```문제 풀지 못한 사람이 걸릴 경우 의논 필요 <<<< ```
- 코드 리뷰 후 질문 또는 피드백 (개선점)
- 그리고 오프라인 당일 문제 하나를 선택해 시간을 정해두고 풀기.
## commit 규칙
- commit 메세지: [문제 출처(플랫폼)] 문제이름 / 난이도 / 걸린시간 
- description: 문제 주소 (option)
- 터미널에서 작성법: 
```
git commit -m "[BOJ] Hello World / 브론즈5 / 1분" -m "https://www.acmicpc.net/problem/2557"
```
- 플랫폼 작성법 통일: 
  * [BOJ] - 백준 
  * [PGS] - 프로그래머스
  * [LTC] - 리트코드
  * [CFS] - 코드포스
  * [SEA] - 삼성SW Expert Academy
  * [ETC] - 그외

## PR 규칙
- PR 제목: 이름 / 주차 / 몇 문제  
``` yeonsup / 8월 1주차 / 4문제 ```
- 내용 : 시간복잡도 / 공간복잡도
- PR은 모든 문제 풀고 한 번에 PR을 하셔도 되고, 아니면 1문제 1PR도 괜찮습니다. ```(PR 내용을 작성하려면 1문제 1PR이 좋다고 생각)```
- 내용 작성은 자유로우나 자신이 푼 문제에 대해서 풀기 전에 어떻게 접근하고 설계해서 풀었는지 작성하는 것도 좋은 방식이라고 생각합니다.
- 일종의 간단한 리뷰? 어디부분에서 해맸다. 풀긴 풀었는데 효율적이지 못한 것 같아서 다른 방식으로 바꿨다. etc...
- 문제마다 시간복잡도와 공간복잡도는 적는게 좋을 것 같습니다!

## 폴더
- 각자 개인 폴더를 생성하고, 그 안에서 만 작성한다.
- 그 다음은 자유롭게 구조를 잡는다.

> 예시 : yeonsup > [문제유형별] or [주차별] or [사이트별] ...
## 제출 방식
1. 해당 레포를 fork 한다.
2. fork한 자신의 레포를 clone을 한다.
3. 문제를 푼다.
4. commit 후 push를 하고, github에 접속해 PR을 작성하고 기존 레포에 자신의 커밋들을 Merge한다.
5. ❗️자신이 푼 java 파일만 push 한다. 이외에 것들은 올리지 말아주세요. ex) classpath 등 각종 설정파일
 - 최상위 폴더에서 ```git add .``` 금지

## 문제

<details>
<summary>1주차</summary>

- [백준 [실버2] : 로또](https://www.acmicpc.net/problem/6603)
- [백준 [실버3] : 소수 최소 공배수](https://www.acmicpc.net/problem/21919)
- [백준 [실버3] : 어린왕자](https://www.acmicpc.net/problem/1004)
- [프로그래머스 [레벨2] : 땅따먹기](https://school.programmers.co.kr/learn/courses/30/lessons/12913)
</details>
<details>
<summary>2주차</summary>

- [백준 [실버2] : 병사 배치하기](https://www.acmicpc.net/problem/18353)
- [백준 [실버1] : 포도주 시식하기](https://www.acmicpc.net/problem/2156)
- [백준 [골드5] : 진우의 달 여행](https://www.acmicpc.net/problem/17485)
- [프로그래머스 [레벨2] : 다리를 지나는 트럭](https://school.programmers.co.kr/learn/courses/30/lessons/42583)
</details>
<details>
<summary>3주차</summary>

- [백준 [실버1] : 돌다리](https://www.acmicpc.net/problem/12761)
- [백준 [골드5] : 적록색약](https://www.acmicpc.net/problem/10026)
- [백준 [골드4] : 일루미네이션](https://www.acmicpc.net/problem/5547)
- [프로그래머스 [레벨3] : 합승 택시 요금](https://school.programmers.co.kr/learn/courses/30/lessons/72413)
</details>
<details>
<summary>4주차</summary>

- [백준 [골드4] : 카드 정렬하기](https://www.acmicpc.net/problem/1715)
- [백준 [실버1] : 신입사원](https://www.acmicpc.net/problem/1946)
- [백준 [실버1] : 회의실배정](https://www.acmicpc.net/problem/1931)
- [프로그래머스 [레벨3] : 등산코드 정하기](https://school.programmers.co.kr/learn/courses/30/lessons/4)
- [프로그래머스 [레벨2] : 조이스틱](https://school.programmers.co.kr/learn/courses/30/lessons/42860)
</details>

<details>
<summary>5주차</summary>

- [백준 [골드4] : 최단경로](https://www.acmicpc.net/problem/1753)
- [백준 [골드4] : 플로이드](https://www.acmicpc.net/problem/11404)
- [백준 [골드4] : 공유기 설치](https://www.acmicpc.net/problem/2110)
- [프로그래머스 [레벨3] : 입국심사](https://school.programmers.co.kr/learn/courses/30/lessons/43238)
</details>



<details>
<summary>6주차</summary>

- [백준 [골드5] : 1학년](https://www.acmicpc.net/problem/5557)
- [백준 [골드5] : 동전](https://www.acmicpc.net/problem/2294)
- [백준 [실버1] : RGB거리](https://www.acmicpc.net/problem/1149)
- [프로그래머스 [레벨3] : 등굣길](https://school.programmers.co.kr/learn/courses/30/lessons/42898)
</details>

<details>
<summary>7주차</summary>

- [백준 [실버2] : 과자 나눠주기](https://www.acmicpc.net/problem/16401)
- [백준 [골드5] : 치킨 배달](https://www.acmicpc.net/problem/15686)
- [백준 [골드4] : 좋다](https://www.acmicpc.net/problem/1253)
- [프로그래머스 [레벨2] : 전화번호 목록](https://school.programmers.co.kr/learn/courses/30/lessons/42577)
</details>

<details>
<summary>8주차</summary>

- [백준 [실버3] : 꿀 아르바이트](https://www.acmicpc.net/problem/12847)
- [백준 [실버2] : 마인크래프트](https://www.acmicpc.net/problem/18111)
- [백준 [골드3] : 아기상어](https://www.acmicpc.net/problem/16236)
- [프로그래머스 [레벨2] : 택배 배달과 수거하기](https://school.programmers.co.kr/learn/courses/30/lessons/150369)
</details>

<details>
<summary>9주차</summary>
   
- [백준 [골드4] : 테트로미노](https://www.acmicpc.net/problem/14500)
- [백준 [골드4] : 미세먼지 안녕!](https://www.acmicpc.net/problem/17144)
- [프로그래머스 [레벨2] : 숫자 카드 나누기](https://school.programmers.co.kr/learn/courses/30/lessons/135807)
- [프로그래머스 [레벨2] : 주차 요금 계산](https://school.programmers.co.kr/learn/courses/30/lessons/92341)
</details>


<details>
<summary>10주차</summary>
   
- [백준 [골드4] : 뱀](https://www.acmicpc.net/problem/3190)
- [백준 [골드3] : 최소비용 구하기 2](https://www.acmicpc.net/problem/11779)
- [프로그래머스 [레벨2] : 시소 짝꿍](https://school.programmers.co.kr/learn/courses/30/lessons/152996)
- [프로그래머스 [레벨2] : 이모티콘 할인행사](https://school.programmers.co.kr/learn/courses/30/lessons/150368)
</details>


<details>
<summary>11주차</summary>
   
- [백준 [실버2] : 연결 요소의 개수](https://www.acmicpc.net/problem/11724)
- [백준 [골드5] : 컨베이어 벨트 위의 로봇](https://www.acmicpc.net/problem/20055)
- [백준 [골드5] : 숨바꼭질 3](https://www.acmicpc.net/problem/13549)
- [프로그래머스 [레벨2] : 두 큐합 같게 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/118667)
- [프로그래머스 [레벨3] : 미로 탈출 명령어](https://school.programmers.co.kr/learn/courses/30/lessons/150365)
</details>

<details>
<summary>12주차</summary>
   
- [백준 [실버4] : 좋은 단어](https://www.acmicpc.net/problem/3986)
- [백준 [골드5] : 회문](https://www.acmicpc.net/problem/17609)
- [프로그래머스 [레벨2] : 운영체제](https://school.programmers.co.kr/learn/courses/30/lessons/121686)
- [프로그래머스 [레벨2] : 가장 먼 노드](https://school.programmers.co.kr/learn/courses/30/lessons/49189)
</details>



### 문제 참고
- https://github.com/tony9402/baekjoon/tree/main/math
- https://dev-dain.tistory.com/155
- https://solved.ac/problems/tags/math
- https://school.programmers.co.kr/

### 참고 레포
- https://github.com/ellynhan/challenge100-codingtest-study
