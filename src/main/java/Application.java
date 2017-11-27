import model.QuestionsSet;

public class Application {
    public static void main(String[] args) {
        QuestionsSet questions = new YamlParser("C:\\Users\\matr\\kevin\\wt-935-kevin\\src\\main\\java\\test.yml").parse();
        System.out.println(questions);
    }
}
