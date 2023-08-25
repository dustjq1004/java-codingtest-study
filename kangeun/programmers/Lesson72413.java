//1h 2m
class Solution {
    int[][] map ;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        map = new int[n+1][n+1];

        for(int i=0; i<fares.length; i++){
            map[fares[i][0]][fares[i][1]] = fares[i][2];
            map[fares[i][1]][fares[i][0]] = fares[i][2];
        }    
        
        //배열 최단 거리로 변경
        changeMap();

        //s -> a -> b
        //s -> b -> a
        //s -> a + s->b
        //총 3가지 경우 비교
        answer = map[s][a] +map[s][b];
        for(int i=1; i<=n; i++){
            int se = map[s][i];
            int ea = map[a][i];
            int eb = map[b][i];
            if(se + ea + eb > 0){
                answer = Math.min(answer, se+ea+eb);            
            }
        }
        return answer;
    }
    
    void changeMap(){
        boolean check;
        int n= map.length;
        do{
            check = false;
            //arr[j][k] = arr[i][j] + arr[i][k]
            for(int i=1; i<n; i++){
                for(int j=1; j<n; j++){
                    //해당 거리가 비어있으면 skip
                    if(map[i][j]==0){
                        continue;
                    }
                    
                    for(int k=1; k<n; k++){
                        //해당 거리가 비어있으면 skip
                        if(map[i][k]==0||j==k){
                            continue;
                        }   
                        //최소 거리로 update
                        if(map[j][k]==0||map[j][k]>map[i][j]+map[i][k]){
                            check = true;
                            map[j][k]=map[i][j]+map[i][k];
                            map[k][j]=map[j][k];
                        }
                    }
                }
            }
            
        }while(check);

    }

}
