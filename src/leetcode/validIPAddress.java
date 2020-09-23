package leetcode;

class validIPAddress {
    public static String validIPAddress(String IP) {
        String res = "Neither";

        int type = 0;
        String[] ip4 = IP.split("\\.");
        String[] ip6 = IP.split(":");
        if (ip4.length == 4) type = 1;
        else if (ip6.length == 8) type = 2;
        if (type == 1) {
            if (IP.charAt(IP.length() - 1) == '.' || IP.charAt(0) == '.') {
                return res;
            }
            for (String tip : ip4) {
                try {
                    int tInt = Integer.parseInt(tip);
                    if (tInt > 255 || tInt < 0){
                        return res;
                    }
                } catch (Exception e){
                    return res;
                }
                if (tip.equals("")) {
                    return res;
                }
                if (tip.length() > 1 && tip.charAt(0) == '0') {
                    return res;
                }
            }
            return "IPv4";
        } else if (type == 2) {
            if (IP.charAt(IP.length() - 1) == ':' || IP.charAt(0) == ':') {
                return res;
            }
            for (String tip : ip6) {
                if (tip == null || tip.equals("")) {
                    return res;
                }
                if (tip.length() > 4) {
                    return res;
                }

            }
            return "IPv6";
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "20EE:FGb8:85a3:0:0:8A2E:0370:7334";
        String s1 = validIPAddress(s);
        System.out.println(s1);
    }
}