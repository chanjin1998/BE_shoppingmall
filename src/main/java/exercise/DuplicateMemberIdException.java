package exercise;

public class DuplicateMemberIdException extends RuntimeException{
    public String message;

    public DuplicateMemberIdException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
