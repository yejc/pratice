package sundry;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yejc
 * @date 2020/2/17 18:35
 */
public class WordZip {
    /**
     * 单词的压缩编码
     *
     * @param words
     * @return
     */
    public int minimumLengthEncoding(String[] words) {
        Set<String> good = new HashSet(Arrays.asList(words));
        for (String word : words) {
            for (int k = 1; k < word.length(); ++k)
                good.remove(word.substring(k));
        }

        int ans = 0;
        for (String word : good)
            ans += word.length() + 1;
        return ans;
    }
}
