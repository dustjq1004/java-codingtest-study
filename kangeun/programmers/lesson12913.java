class Solution {
    private int col = 4;
    int solution(int[][] land) {
        int row = land.length;
        
        //DP?       
        for(int i=0; i<row-1; i++){
            int[] rowMax = returnMax(land[i]);
            
            for(int j=0; j<col; j++){
                  land[i+1][j] += (rowMax[0]!=j)?land[i][rowMax[0]]:land[i][rowMax[1]];
            }
        }
        int[] answer = returnMax(land[row-1]);
        return land[row-1][answer[0]];
    }
    
    int[] returnMax(int[] arr){
        int[] maxs = new int[2];
        for(int j=1; j<col; j++){
            if(arr[maxs[0]]<arr[j]){
                maxs[1]=maxs[0];
                maxs[0]=j;
            }else if(arr[maxs[1]]<arr[j]||maxs[0]==maxs[1]){
                maxs[1]=j;
            }
        }
        return maxs;
            
    }
    
    void print(int[][]arr, int row, int col){
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                System.out.print(arr[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
