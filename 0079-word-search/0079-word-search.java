class Solution {
    private boolean wordSearching(char[][] board, String word, int i, int j, int index) {
        // 모든 문자를 찾은 경우
        if (index == word.length()) {
            return true;
        }
        // i: 수직방향, j: 수평방향
        if (i < 0 || i >= board.length || j < 0 || j  >= board[i].length) {
            return false;
        }
        if (word.charAt(index) != board[i][j]) {
            return false;
        }
        // 주변 셀 탐색
        // 문자를 찾은경우
        char tmep = board[i][j];
        board[i][j] = '*';
        boolean found = wordSearching(board, word, i - 1, j, index + 1) ||
                wordSearching(board, word, i + 1, j, index + 1) ||
                wordSearching(board, word, i, j - 1, index + 1) ||
                wordSearching(board, word, i, j + 1, index + 1);

       board[i][j] = tmep;
        return found;
    }

    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (wordSearching(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

}