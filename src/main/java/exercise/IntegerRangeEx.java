package exercise;
//사용자 정의 클래스
public class IntegerRangeEx extends Exception{
    private String message;

    public IntegerRangeEx(String message){
        this.message = message;
    }
    @Override
    public String getMessage() {
        return this.message;
    }
}
