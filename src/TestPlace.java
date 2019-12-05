public class TestPlace {
    public static < A > void printArray( A[] inputArray )
    {
        // 输出数组元素
        for ( A element : inputArray ){
            System.out.printf( "%s ", element );
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        TestPlace t = new TestPlace();
        System.out.println(t.getClass());
    }
}
