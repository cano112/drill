package pl.agh.edu.wiet.to2.kevin.model.parser;

import java.util.List;

public final class QuestionDTO {
    private String question;
    private List<AnswerDTO> answers;

    public QuestionDTO() {
    }

    public QuestionDTO(String question, List<AnswerDTO> answers) {
        this.question = question;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public List<AnswerDTO> getAnswers() {
        return answers;
    }
}
