package alibaba;

import lombok.Data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yejc001
 * @date 2019-11-01
 */
@Data
public class FileManager
{
    private Condition condition;

    private void findFile(File file, List<File> result)
    {
        if (condition.judge(file))
        {
            result.add(file);
        }
        if (file.isDirectory())
        {
            File[] subFiles = file.listFiles();
            if (subFiles != null && subFiles.length > 0)
            {
                for (File subFile : subFiles)
                {
                    findFile(subFile, result);
                }
            }
        }
    }

    public List<File> findFile(String path)
    {
        List<File> result = new ArrayList<>();
        findFile(new File(path), result);
        return result;
    }
}
