class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        
        for(int i = 0; i < 4; i++){   // 0°, 90°, 180°, 270°
            
            if(isEqual(mat, target)){
                return true;
            }
            
            mat = rotate(mat);   // rotate 90° clockwise
        }
        
        return false;
    }
    
    // check if two matrices are equal
    public boolean isEqual(int[][] a, int[][] b){
        int n = a.length;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(a[i][j] != b[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    
    // rotate matrix 90° clockwise
    public int[][] rotate(int[][] mat){
        int n = mat.length;
        int[][] rotated = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                rotated[j][n - 1 - i] = mat[i][j];
            }
        }
        
        return rotated;
    }
}