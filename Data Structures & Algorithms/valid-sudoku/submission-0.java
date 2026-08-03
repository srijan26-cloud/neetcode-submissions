class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                char num = board[r][c];
                if(num != '.'){
                    String rowKey = num+"r"+r;
                    String colKey = num+"c"+c;
                    String squareKey = num+"b"+(r/3)+"|"+(c/3);
                    if(!seen.add(rowKey) || !seen.add(colKey) || !seen.add(squareKey))
                        return false;
                }
            }
        }
        return true;
    }
}
