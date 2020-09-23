package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class trulyMostPopular {
    HashMap<String, String> map = new HashMap<>();
    HashMap<String, Integer> scores = new HashMap<>();
    public String[] trulyMostPopular(String[] names, String[] synonyms) {

        for (String name : names) {
            int i = name.indexOf('(');
            int j = name.indexOf(')');
            Integer score = Integer.parseInt(name.substring(i + 1, j));
            String name1 = name.substring(0, i);
            scores.put(name1, score);
            map.put(name1, name1);
        }
        for (String synonym : synonyms) {
            String substring = synonym.substring(1, synonym.length() - 1);
            String[] strings = substring.split(",");
            merge(strings[0], strings[1]);
        }
        Set<String> keys = scores.keySet();
        Set<String> resKeys = new HashSet<>();

        for (String key : keys) {
            String root = find(key);
            resKeys.add(root);
            if (!key.equals(root)){
                scores.put(root, scores.get(root) + scores.get(key));
            }
        }

        String[] res = new String[resKeys.size()];
        int i = 0;
        for (String resKey : resKeys) {
            StringBuilder sb = new StringBuilder();
            sb.append(resKey).append('(').append(scores.get(resKey)).append(")");
            res[i++] = sb.toString();
        }
        return res;


    }

    private void merge(String i, String j) {
        String x = find(i);
        String y = find(j);
        if (x.equals(y)) return;
        if (x.compareTo(y) < 0){
            map.put(y, x);
        } else {
            map.put(x, y);
        }
    }

    private String find(String x) {
        map.putIfAbsent(x, x);
        if (x.equals(map.get(x))){
            return x;
        } else {
            map.put(x, find(map.get(x)));
            return map.get(x);
        }

    }


    public static void main(String[] args) {
        String[] names = new String[]{"John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"};
        String[] synonyms = new String[]{"(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"};
        trulyMostPopular t = new trulyMostPopular();
        String[] strings = t.trulyMostPopular(names, synonyms);
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + " ");
        }


    }
}