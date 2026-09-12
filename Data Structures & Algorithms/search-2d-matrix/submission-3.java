class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0;
        int r=matrix[0].length*matrix.length-1;
        int col=matrix[0].length;

        while(l<=r){
            int mid=(l+r)/2;
            int corx=mid/col;
            int cory=mid%col;

            if(matrix[corx][cory]==target)return true;
            else if(matrix[corx][cory]<target)l=mid+1;
            else r=mid-1;
        }

        return false;
    }
}
