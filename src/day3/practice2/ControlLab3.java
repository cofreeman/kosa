package day3.practice2;

public class ControlLab3 {
    public static void main(String[] args) {
        String s = "";
        while(true){
            int randNum = (int) (Math.random() * 120) + 1;
            if (randNum < 50){
                s = "%d : 50이하\n";
                if(randNum % 10 == 3){
                    s +="%d : *듀크팀*\n";
                }
            }else if(randNum >=50 && randNum<=80){
                s = "%d : 50이상 80 이하\n";
                if(randNum/10 == 7){
                    s += "%d : *턱시팀*\n";
                }
            }else if(randNum>=81 && randNum <= 100){
                continue;
            }else {
                break;
            }
            System.out.printf(s,randNum,randNum);
            s = "";

        }
    }
}
