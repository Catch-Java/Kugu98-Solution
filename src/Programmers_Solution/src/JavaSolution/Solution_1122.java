package Programmers_Solution;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_1122 {
    public int[] solution(int[] numbers){
        ArrayList<Integer> list = new ArrayList<>();
        int sum=0;
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                sum=numbers[i]+numbers[j];
                if(!list.contains(sum)){
                    list.add(sum);
                }
            }
        }
        int [] answer=new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]= (int) list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }

}
