package pl.agh.edu.wiet.to2.kevin.service.parser.dto;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationDTO {
    private List<QuestionDTO> questions;

    public ConfigurationDTO() {
        this.questions = new ArrayList<>();
    }

    public ConfigurationDTO(List<QuestionDTO> questions) {
        this.questions = questions;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }
}
