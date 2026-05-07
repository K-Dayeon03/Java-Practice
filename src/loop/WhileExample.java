package loop;

public class WhileExample {
    public static void main(String[] args) {
        int i = 1; //begin
        while(i <= 10) //end
        {
            System.out.println("안녕하세요! " + i +"번 고객님! while");
            i++; //step
        }

        //for
        for(int j= 1; j<= 10; j++){
            System.out.println("안녕하세요! "+j+"번 고객님!");
        }

        System.out.println("========================");
        int n = 1;
        int total = 0;
        while(n<=100){
            total+=n;
            n++;
        }
        System.out.println("while 1~100 누적 합계 :" + total);

        int sum=0;
        for (int k = 0; k<=100; k++){
            sum+=k;
        }
        System.out.println("for문 1~100 누적 합계 : " + sum);

        System.out.println("=========================");
        //특정 값이 소수인지 소수가 아닌지 판별하는 문제
        int num =97;
        int m =1;
        int count = 0;
        while(m<=num){
            if(num % m == 0){
                count++;
            }
            m++;
        }

        if(count == 2){
            System.out.println(num + "은(는) 소수입니다.");
        } else {
            System.out.println(num + "은(는) 소수가 아닙니다.");
        }
        System.out.println("==================");

        int s = 2;
        while(num % s != 0){
            s++;
        }
        if(num == s){
            System.out.println(num + "은(는) 소수입니다.");
        } else {
            System.out.println(num + "은(는) 소수가 아닙니다.");
        }
    }
}
