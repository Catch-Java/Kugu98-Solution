package Programmers_Solution;

public class Solution_1115 {
    public String solution(String new_id){
        String ansewr;
        ansewr=new_id;
        ansewr=ansewr.replaceAll("[^a-z0-9-_.]","");
        ansewr=ansewr.replaceAll("[.]{2,}",".");
        ansewr=ansewr.replaceAll("^[.]|[.]$","");
        if(ansewr.equals("")){
            ansewr=ansewr+"a";
        }
        if(ansewr.length()>=16){
            ansewr=ansewr.substring(0,15);
            ansewr=ansewr.replaceAll("[.]$","");
        }
        if(ansewr.length()<=2){
            while(ansewr.length()<3){
                ansewr=ansewr+ansewr.charAt(ansewr.length()-1);
            }
        }
        return ansewr;
    }

}
