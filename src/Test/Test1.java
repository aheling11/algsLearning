package Test;
public class Test1 {



    public static void main(String[] args) {
        String s1 = "abcs";
        String s2 = "abcs";
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        int[] arr1 = new int[2];
        int[] arr2 = new int[2];
        System.out.println(arr1.hashCode());
        System.out.println(arr2.hashCode());


    }
}
