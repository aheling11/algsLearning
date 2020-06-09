package ToOffer;

class reverseWords {
    public static String reverseWords(String s) {
        s = s.trim();
        s = s.replaceAll(" +", " ");
        String[] strlist = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = strlist.length - 1; i >= 0; i--){
            sb.append(strlist[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "the sky   is blue";
//        s = "  hello world!  ";
        char a = 'a';
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
    }
}