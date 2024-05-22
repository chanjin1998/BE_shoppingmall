package exercise;

public class NullPointerExceptionEx {
    public static void main(String[] args) {
        String str = null;
        String[] strings = null;
        //Exception 종류
        try {
            System.out.println(str.charAt(0));
        } catch(Exception e){ //NullpointerException
            System.out.println("성공");
            System.out.println(e.getMessage());
//            System.out.println(e.);
        }
    }
}