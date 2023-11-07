class Solution {
    public static String solution(String polynomial) {
        String[] ss = polynomial.split(" \\+ ");
        int n = 0;
        int x = 0;
        for (int i = 0; i < ss.length; i++) {
            if(ss[i].contains("x")) {
                String s = ss[i].replace("x","");
                if(s.length()==0) {
                    x+=1;
                    continue;
                }
                x+= Integer.parseInt(s);
            } else{
                n+= Integer.parseInt(ss[i]);
            }
        }
        String answer = (x==0? "":x==1? "x":x+"x") +((x==0||n==0)? "":" + ")+ (n==0? "":n);
        return answer;
    }
}