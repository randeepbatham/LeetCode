class Solution {
    public int totalNQueens(int n) {
        char [][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }

        List<List<String>> result = new ArrayList<>();
        backtrack(board, 0, result);
        return result.size();
    }

    private void backtrack(char[][] board, int col, List<List<String>> result){
        if (col == board.length){
            result.add(contruct(board));
            return;
        }

        for (int i = 0; i < board.length; i++){
            if (isValid(board, i, col)){
                board[i][col] = 'Q';
                backtrack(board, col + 1, result);
                board[i][col] = '.';
            }
        }
    }
    private boolean isValid(char[][] board, int row, int col){
        // Horizontal checking or cols
        for (int i = 0; i < board.length; i++){
            if (board[row][i] == 'Q'){
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if (board[i][j] == 'Q'){
                return false;
            }
        }

        for (int i = row, j = col; i < board.length && j >= 0; i++, j--){
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        return true;

    }
    private List<String> contruct(char[][] board){
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++){
            String row = new String(board[i]);
            result.add(row);
        }
        return result;
    }
}
