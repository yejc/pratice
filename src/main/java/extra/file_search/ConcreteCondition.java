package extra.file_search;

import lombok.Data;

import java.io.File;
import java.util.function.Predicate;

/**
 * @author yejc001
 * @date 2019-11-04
 */
@Data
public class ConcreteCondition implements Condition
{

    private Predicate<File> predicate;

    @Override
    public boolean judge(File file)
    {
        return predicate.test(file);
    }
}
