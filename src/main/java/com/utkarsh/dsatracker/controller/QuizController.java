package com.utkarsh.dsatracker.controller;

import com.utkarsh.dsatracker.model.QuizQuestion;
import com.utkarsh.dsatracker.repository.QuizQuestionRepository;
import com.utkarsh.dsatracker.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;

    @Autowired
    private QuizQuestionRepository quizQuestionRepository;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/{topic}")
    public String showQuiz(@PathVariable String topic, Model model) {
        List<QuizQuestion> questions = quizQuestionRepository.findByTopicIgnoreCase(topic);
        model.addAttribute("questions", questions);
        model.addAttribute("topic", topic);
        return "quiz_page";
    }


    @PostMapping("/submit")
    public String submitQuiz(@RequestParam Map<String, String> allParams, Model model) {
        int score = 0;
        int total = 0;
        String topic = null;

        for (String key : allParams.keySet()) {
            if (key.startsWith("answer_")) {
                total++;
                Long questionId = Long.parseLong(key.replace("answer_", ""));
                String selectedAnswer = allParams.get(key);

                QuizQuestion question = quizService.getQuestionById(questionId);
                if (question != null) {
                    topic = question.getTopic();
                    if (question.getCorrectAnswer().equalsIgnoreCase(selectedAnswer)) {
                        score++;
                    }
                }
            }
        }

        model.addAttribute("score", score);
        model.addAttribute("total", total);
        model.addAttribute("topic", topic);

        return "quiz_result";
    }
}
