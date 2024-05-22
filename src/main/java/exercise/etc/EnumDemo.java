package exercise.etc;

public enum EnumDemo {

    AMERICANO(0, "아메리카노"),
    LATTE(1,"라뗴"),
    STRAWBERRY_ADE(2,"딸기라떼"),
    ESPRESSO(3,"에스프레소");

    private final int menuNum;
    private final String menuName;
    EnumDemo(int menuNum, String menuName){
        this.menuNum = menuNum;
        this.menuName = menuName;
    }

    public void selectMenu(){
        System.out.println(menuName);
    }

    @Override
    public String toString() {
        return "EnumDemo{" +
                "menuNum=" + menuNum +
                ", menuName='" + menuName + '\'' +
                '}';
    }
}
