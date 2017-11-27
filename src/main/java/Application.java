import exception.ParseException;
import model.QuestionsSet;

public class Application {
    public static void main(String[] args) {
        QuestionsSet questions = null;
        try {
            questions = new YamlParser("C:\\Users\\matr\\kevin\\wt-935-kevin\\src\\main\\java\\test.yml").parse();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(questions);
    }
}
