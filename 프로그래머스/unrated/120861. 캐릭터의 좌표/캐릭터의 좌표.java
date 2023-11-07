class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int x_max = board[0]/2;
        int y_max = board[1]/2;
        int x = 0;
        int y = 0;
        for (int i = 0; i < keyinput.length; i++) {
            switch (keyinput[i]){
                case "up" :
                    if(y<y_max) y++;
                    break;
                case "down" :
                    if(y>-y_max) y--;
                    break;
                case "right" :
                    if(x<x_max) x++;
                    break;
                case "left" :
                    if(x>-x_max) x--;
                    break;
            }
        }
        return new int[]{x,y};
    }
}