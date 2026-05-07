package basic.constate;

public class SwitchExample {
    public static void main(String[] args) {
        String gender = "ㄴ";
        //swtich-case는 문자열, 정수만 가능
        switch (gender){
            /*세로로 너무 길면 가로로 설정도 가능
            *
            * case "m" : case "M": ase "남" : case "ㅡ":
            * 또는 14버전 이후
            * case "F", "f", "여", "ㄹ":
            * */
            case "m":
            case "M" :
                System.out.println("남성입니다.");
                break;
            case "f":
            case "F" :
                System.out.println("여성입니다.");
                break;
            default:
                System.out.println("잘못된 성별입니다.");
        }
    }
}
