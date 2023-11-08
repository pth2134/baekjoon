class Solution {
    public int solution(int[][] board) {
        int height = board.length;
        int width = board[0].length;

        boolean[][] danger = new boolean[height][width];
        int safeArea = height*width;
        int[] x_move = {0,0,0,-1,1,1,1,-1,-1};
        int[] y_move = {0,1,-1,0,0,1,-1,-1,1};



        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(board[i][j]==1){
                    for (int k = 0; k < 9; k++) {
                        int x = j+x_move[k];
                        int y = i+y_move[k];
                        if(x<width&&x>=0&&y<height&&y>=0){
                            if(!danger[y][x]) {
                                danger[y][x] = true;
                                safeArea--;
                            }
                        }
                    }
                }
            }
        }
        return safeArea;
    }
}