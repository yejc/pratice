package extra.file_search;

import java.io.File;

/**
 * @author yejc001
 * @date 2019-11-04
 */
public interface Condition {
    boolean judge(File file);
}
