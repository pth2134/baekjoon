import java.util.HashMap;

class Solution {
    public String solution(String[] id_pw, String[][] db) {
        HashMap<String,String> map = new HashMap<>();
        for (String[] i : db) {
            map.put(i[0],i[1]);
        }

        return map.containsKey(id_pw[0])? map.get(id_pw[0]).equals(id_pw[1])? "login":"wrong pw":"fail";
    }
}