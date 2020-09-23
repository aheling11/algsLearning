package Bishi.Alibaba.网易0911;

public class First {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 使用题目中描述的方法，将 raw_str 压缩后返回
     *
     * @param raw_str string字符串 未压缩的原始字符串
     * @return string字符串
     */
    public static String compress(String raw_str) {
        char[] chars = raw_str.toCharArray();
        char[] map = new char[60];
        int index = 0;
        for (int i = 4; i < 30; i++) {
            map[i] = (char) ('a' + index);
            index++;
        }
        index = 0;
        for (int i = 30; i <= 55; i++) {
            map[i] = (char) ('A' + index);
            index++;
        }
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (i > 0) {
                if (chars[i - 1] == chars[i]) {
                    cnt++;
                } else {
                    if (cnt == 1) {
                        sb.append(chars[i - 1]);
                    } else if (cnt > 1 && cnt < 4) {
                        for (int j = 0; j < cnt; j++) {
                            sb.append(chars[i - 1]);
                        }
                    } else {
                        if (cnt <= 55) {
                            sb.append('0');
                            sb.append(map[cnt]);
                            sb.append(chars[i - 1]);
                        } else if (cnt > 55) {
                            int t = cnt % 55;
                            for (int j = 0; j < cnt / 55; j++) {
                                sb.append("0Z");
                                sb.append(chars[i - 1]);
                            }
                            if (t < 4) {
                                for (int j = 0; j < t; j++) {
                                    sb.append(chars[i - 1]);
                                }
                            } else {
                                sb.append('0').append(map[t]).append(chars[i - 1]);

                            }
                        }
                    }
                    cnt = 1;
                }
            }
        }
        if (cnt == 1) {
            sb.append(chars[chars.length - 1]);
        } else if (cnt > 1 && cnt < 4) {
            for (int j = 0; j < cnt; j++) {
                sb.append(chars[chars.length - 1]);
            }
        } else {
            if (cnt <= 55) {
                sb.append('0');
                sb.append(map[cnt]);
                sb.append(chars[chars.length - 1]);
            } else if (cnt > 55) {
                int t = cnt % 55;
                for (int j = 0; j < cnt / 55; j++) {
                    sb.append("0Z");
                    sb.append(chars[chars.length - 1]);
                }
                if (t < 4) {
                    for (int j = 0; j < t; j++) {
                        sb.append(chars[chars.length - 1]);
                    }
                } else {
                    sb.append('0').append(map[t]).append(chars[chars.length - 1]);

                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 57; i++) {
            s.append('a');
        }
        String compress = compress(s.toString());
        System.out.println(compress);
    }
}
