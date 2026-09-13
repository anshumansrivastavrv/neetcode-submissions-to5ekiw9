class Solution {
    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;

        int res=0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid,int n,int m){
        int r=grid.length;
        int c=grid[0].length;

        if(n<0 || m<0 || n>=r ||m>=c || grid[n][m]=='0')return ;

        grid[n][m]='0';
        
        dfs(grid,n-1,m);
        dfs(grid,n,m-1);
        dfs(grid,n+1,m);
        dfs(grid,n,m+1);
    }
}
