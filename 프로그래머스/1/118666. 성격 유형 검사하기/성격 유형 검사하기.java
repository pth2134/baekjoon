
class Solution {
    public String solution(String[] survey, int[] choices) {
        int rt = 0;
        int cf = 0;
        int jm = 0;
        int an = 0;
        
        for (int i = 0; i < survey.length; i++) {
            switch (survey[i]) {
                case "RT":
                    rt += choices[i] - 4;
                    break;
                case "TR":
                    rt -= choices[i] - 4;
                    break;
                case "CF":
                    cf += choices[i] - 4;
                    break;
                case "FC":
                    cf -= choices[i] - 4;
                    break;
                case "JM":
                    jm += choices[i] - 4;
                    break;
                case "MJ":
                    jm -= choices[i] - 4;
                    break;
                case "AN":
                    an += choices[i] - 4;
                    break;
                case "NA":
                    an -= choices[i] - 4;
                    break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        if(rt > 0) sb.append('T');
        else sb.append('R');
        if(cf > 0) sb.append('F');
        else sb.append('C');
        if(jm > 0) sb.append('M');
        else sb.append('J');
        if(an > 0) sb.append('N');
        else sb.append('A');
        
        return sb.toString();
    }
}