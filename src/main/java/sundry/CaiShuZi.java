package sundry;

import java.util.HashMap;
import java.util.Map;

/**
 * 299. 猜数字游戏
 *
 * @program: pratice
 * @description:
 * @author: yejc
 * @create: 2020-02-21 10:11
 **/
public class CaiShuZi {
    public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        Map<Character, Integer> map = new HashMap<>();
        int n = Math.min(secret.length(), guess.length());
        for (int i = 0; i < n; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
            } else {
                map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
                map.put(guess.charAt(i), map.getOrDefault(guess.charAt(i), 0) - 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                b += entry.getValue();
            }
        }
        b = secret.length() - a - b;
        return a + "A" + b + "B";
    }

    public static void main(String[] args) {
        CaiShuZi caiShuZi = new CaiShuZi();
        String hint = caiShuZi.getHint("1807", "7810");
        System.out.println(hint);
    }
}
