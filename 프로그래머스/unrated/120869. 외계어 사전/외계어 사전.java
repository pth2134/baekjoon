class Solution {

    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        for (int i = 0; i < dic.length; i++) {
            if(dic[i].length()!= spell.length) continue;
            String dic1 = dic[i];
            for (int j = 0; j < spell.length; j++) {
                dic1 = dic1.replaceFirst(spell[j],"");
            }
            if(dic1.length()==0) {
                answer=1;
                break;
            }
        }
        return answer;
    }
}