package exercise;

public class ArithmeticEx {

    public static void main(String[] args) {
        int result = divide(10,0);
        System.out.println(result);

    }

//    try{
//        result = 10 / 0;
//    } catch (ArithmeticException e){
//        System.out.println("0으로는 나누기할 수 없습니다.");
//    }
    public static int divide(int x, int y){
        try{
            return x/y;
        } catch(ArithmeticException e){
            return 0;
        }
    }
}
