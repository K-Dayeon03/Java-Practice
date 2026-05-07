package loop;

public class BreakExample {
    public static void main(String[] args) {

        for(int i =1; i<=10; i++){
            System.out.print(i + " ");
        }
        System.out.println("\n==================");

        for(int i = 0; i<=2; i++){
            for(int j =0; j<=i; j++){
                System.out.println(i +"-"+j);
            }
        }
    }
}
