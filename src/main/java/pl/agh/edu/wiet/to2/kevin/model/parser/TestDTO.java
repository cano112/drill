package pl.agh.edu.wiet.to2.kevin.model.parser;

import pl.agh.edu.wiet.to2.kevin.model.parser.QuestionDTO;

import java.util.ArrayList;
import java.util.List;

public class TestDTO {
    private List<QuestionDTO> questions;

    public TestDTO() {
        this.questions = new ArrayList<>();
    }

    public TestDTO(List<QuestionDTO> questions) {
        this.questions = questions;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }
}