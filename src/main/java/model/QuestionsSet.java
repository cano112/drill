package model;

import java.util.List;

public class QuestionsSet {
    private List<Question> questions;

    public QuestionsSet() {
    }

    public QuestionsSet(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
