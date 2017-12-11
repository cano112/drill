package pl.agh.edu.wiet.to2.kevin.model.parser;

public class AnswerDTO {
    private String answer;
    private boolean correct;

    public AnswerDTO() {
    }

    public AnswerDTO(String answer, boolean isCorrect) {
        this.answer = answer;
        this.correct = isCorrect;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isCorrect() {
        return correct;
    }
}
