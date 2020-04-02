package ToOffer;

import java.util.Stack;

class validateStackSequences {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < popped.length; i++) {
            int cur = popped[i];
            while ((stack.isEmpty() || stack.peek() != cur) && index < pushed.length){
                stack.push(pushed[index++]);
            }
            if (index == pushed.length && stack.peek() != cur){
                return false;
            }
            stack.pop();
        }
        return true;
    }

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5,5};
        int[] popped = {4,5,5,3,2,1};
        boolean b = validateStackSequences(pushed, popped);
        System.out.println(b);

    }
}