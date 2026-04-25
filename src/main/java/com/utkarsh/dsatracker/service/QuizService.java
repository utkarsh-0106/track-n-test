package com.utkarsh.dsatracker.service;

import com.utkarsh.dsatracker.model.QuizQuestion;
import com.utkarsh.dsatracker.repository.QuizQuestionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuizService {
    private final QuizQuestionRepository repository;

    public QuizService(QuizQuestionRepository repository) {
        this.repository = repository;
    }

    public List<QuizQuestion> getQuestionsByTopic(String topic) {
        return repository.findByTopicIgnoreCase(topic);
    }

    public void saveQuestion(QuizQuestion question) {
        repository.save(question);
    }

    public QuizQuestion getQuestionById(Long id) {
        return repository.findById(id).orElse(null);
    }

}
