package extra.file_search;

import java.io.File;
import java.util.List;

/**
 * @author yejc001
 * @date 2019-11-01
 */
public class FileManagerTest {
    /**
     * 题干：已知一个文件夹，编写一个程序快速找到该文件夹下的所有名称中带“abc”字符的文件或文件夹。
     * 要求：
     * 如果文件夹很大很深，需要注意堆栈溢出
     * 程序具备可扩展性，可插件化地实现模糊匹配，例如匹配名称、匹配文件内容、匹配作者、匹配专辑（Mp3、Mp4）等等，支持快速开发自定义插件满足需求。
     * 插件之间的逻辑关系可配置化，例如 “匹配名称&匹配文件内容 || 匹配作者”
     * 考虑英文匹配的大小写问题。
     * 考核点：递归算法、设计模式、文本字符处理
     * 考核标准：可运行并且满足所有题干要求
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 查找C:/books下【名称包含Java或文件是隐藏的文件夹】
         */
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
