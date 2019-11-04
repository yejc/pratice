package file_search;

import lombok.Data;

import java.io.File;

/**
 * @author yejc001
 * @date 2019-11-04
 */
@Data
public class AndDecorator implements Condition
{
    private Condition condition1;
    private Condition condition2;

    @Override
    public boolean judge(File file)
    {
        return condition1.judge(file) && condition2.judge(file);
    }
}
