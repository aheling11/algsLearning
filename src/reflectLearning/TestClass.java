package reflectLearning;

public class TestClass {

    private String MSG = "Original";

    private void privateMethod(String head , int tail){
        System.out.print(head + tail);
    }

    public String getMsg(){
        return MSG;
    }

    public static void main(String[] args) {
        ClassLoader c1 = Object.class.getClassLoader();
        System.out.println(c1);
        ClassLoader c2 = TestClass.class.getClassLoader();
        System.out.println(c2);
    }
}
