package ToOffer;

import java.util.ArrayList;
import java.util.Stack;

class spiralOrder {
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length < 1){
            return new int[0];
        }
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        int[] result = new int[matrix.length * matrix[0].length];
        int index = 0;

        while(tR <= dR && tC <= dC){
            index = printEdge(matrix, tR, tC, dR, dC, result, index);
            tR++;
            tC++;
            dR--;
            dC--;
        }
        return result;
    }

    private static int printEdge(int[][] matrix, int tR, int tC, int dR, int dC, int[] result, int index) {
        if(tR == dR){
            for (int i = tC; i <= dC; i++) {
                System.out.println(matrix[tR][i]);
                result[index++] = matrix[tR][i];
            }
        } else if(tC == dC){
            for (int i = tR; i <= dR; i++) {
                System.out.println(matrix[i][tC]);
                result[index++] = matrix[i][tC];

            }
        } else {
            int curR = tR;
            int curC = tC;
            while(curC < dC){
                System.out.println(matrix[tR][curC]);
                result[index++] = matrix[tR][curC];

                curC++;
            }
            while (curR < dR){
                System.out.println(matrix[curR][dC]);
                result[index++] = matrix[curR][dC];

                curR++;
            }
            while (curC > tC){
                System.out.println(matrix[dR][curC]);
                result[index++] = matrix[dR][curC];

                curC--;
            }
            while (curR > tR){
                System.out.println(matrix[curR][tC]);
                result[index++] = matrix[curR][tC];

                curR--;
            }
        }
        return index;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int[][] matrix = {{1,2,3},{10,11,4},{9,12,5},{8,7,6}};
//        int[][] matrix = {{1,2,3}};
        spiralOrder(matrix);
        Long a = Long.valueOf(10000);
        System.out.println(a.intValue());

    }
}