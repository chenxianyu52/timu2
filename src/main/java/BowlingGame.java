import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
        Map<Character,Integer> mp = new HashMap<Character,Integer>();
        mp.put('-',0);
        mp.put('1',1);
        mp.put('2',2);
        mp.put('3',3);
        mp.put('4',4);
        mp.put('5',5);
        mp.put('6',6);
        mp.put('7',7);
        mp.put('8',8);
        mp.put('9',9);
        mp.put('X',10);
        int sum=0;
        String p[]=bowlingCode.split("\\|");
        int len = p.length;
        if(p.length>10){
            p[10]=p[11];
            len--;
        }
        for(int i=0;i<10;i++){
            if(p[i].charAt(0)=='X'){
                sum+=10;
                if(p[i+1].length()==2){
                    if(p[i+1].charAt(1)=='/'){
                        sum+=10;
                    }else{
                        sum=sum+mp.get(p[i+1].charAt(0))+mp.get(p[i+1].charAt(1));
                    }
                }else{
                    sum+=10;
                    sum+=mp.get(p[i+2].charAt(0));
                }
            }else{
                if(p[i].charAt(1)=='/'){
                    sum=sum+mp.get(p[i+1].charAt(0))+10;
                }else{
                    sum=sum+mp.get(p[i].charAt(0))+mp.get(p[i].charAt(1));
                }
            }

        }
        System.out.println(sum);
        return sum;
    }
}
