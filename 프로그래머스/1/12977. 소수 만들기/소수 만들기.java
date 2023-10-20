import java.util.Arrays;
import java.util.HashSet;

class Solution {
	public static int solution(int[] nums) {
		int l = nums.length;
		HashSet<Integer> set = new HashSet<>();
		for (int i = 7; i <= 2997 ; i++) {
			boolean p = true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if(i%j==0) {
					p = false;
					break;
				}
			}
			if(p) set.add(i);
		}
		int answer = 0;
		for (int i = 0; i <l-2 ; i++) {
			int a = nums[i];
			for (int j = i+1; j < l-1; j++) {
				int b = nums[j];
				for (int k = j + 1; k < l; k++) {
					int sum = a + b + nums[k];
					if (set.contains(sum)) {
							answer++;
						}
					}

				}
			}
		
		String str = Arrays.toString(nums).replaceAll(" ","");
		System.out.println(str+"를 이용해서 "+answer+"을 만들 수 있습니다.");
        return answer;
	}
}