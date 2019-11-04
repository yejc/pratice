package alibaba;

import java.io.File;
import java.util.List;

/**
 * @author yejc001
 * @date 2019-11-01
 */
public class FileManagerTest
{
    public static void main(String[] args)
    {
        ConcreteCondition nameCondition = new ConcreteCondition();
        nameCondition.setPredicate(file -> file.getName().contains("Java"));
        ConcreteCondition nonHiddenCondition = new ConcreteCondition();
        nonHiddenCondition.setPredicate(file -> file.isHidden());

        ConcreteCondition dirCondition = new ConcreteCondition();
        dirCondition.setPredicate(File::isDirectory);

        OrDecorator orDecorator = new OrDecorator();
        orDecorator.setCondition1(nameCondition);
        orDecorator.setCondition2(nonHiddenCondition);
        AndDecorator andDecorator = new AndDecorator();
        andDecorator.setCondition1(orDecorator);
        andDecorator.setCondition2(dirCondition);

        FileManager manager = new FileManager();
        manager.setCondition(andDecorator);
        List<File> files = manager.findFile("C:/books");
        System.out.println(files);
    }
}
