package loop;

public class LoopNesting {
    public static void main(String[] args) {
        //30~100 사이의 소수가 몇개 있는 세봐
        //이 문제 공부하기
        int total = 0;
        for (int i = 30; i<=100; i++){
            int count = 0;
            for(int j = 1; j<=i; j++){
                if(i % j == 0) {
                    count++;
                }
            }
            if(count == 2){
                total++;
            }
        }
        System.out.println("소수의 개수: "+total +"개");
    }
}
