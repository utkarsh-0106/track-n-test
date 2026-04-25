package com.utkarsh.dsatracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        // --- DSA Topics (YouTube links) ---
        Map<String, String> dsaTopics = new LinkedHashMap<>();
        dsaTopics.put("Arrays", "https://www.youtube.com/watch?v=9oWd4VJOwr0");
        dsaTopics.put("Strings", "https://www.youtube.com/watch?v=qB0zZpBJlh8");
        dsaTopics.put("Linked List", "https://www.youtube.com/watch?v=Hlz0D5U6cYY");
        dsaTopics.put("Binary Trees", "https://www.youtube.com/watch?v=fmflMqVOC7k");
        dsaTopics.put("Graphs", "https://www.youtube.com/watch?v=udDe9t3sL08");

        // --- DSA Quiz Links (Internal app routes) ---
        Map<String, String> dsaQuizzes = new LinkedHashMap<>();
        dsaQuizzes.put("Arrays", "/quiz/array");
        dsaQuizzes.put("Strings", "/quiz/strings");
        dsaQuizzes.put("Linked List", "/quiz/linkedlist");
        dsaQuizzes.put("Binary Trees", "/quiz/trees");
        dsaQuizzes.put("Graphs", "/quiz/graphs");

        // --- System Design Topics ---
        Map<String, String> systemDesignTopics = new LinkedHashMap<>();
        systemDesignTopics.put("Scalability Basics", "https://www.youtube.com/watch?v=xpDnVSmNFX0");
        systemDesignTopics.put("Load Balancing", "https://www.youtube.com/watch?v=3ZBW3gFbK2s");
        systemDesignTopics.put("Caching", "https://www.youtube.com/watch?v=R6Vt9Z6l5KQ");
        systemDesignTopics.put("Database Sharding", "https://www.youtube.com/watch?v=SaDkGEb12PM");

        // --- AI/ML Topics ---
        Map<String, String> aiMlTopics = new LinkedHashMap<>();
        aiMlTopics.put("Introduction to AI", "https://www.youtube.com/watch?v=JMUxmLyrhSk");
        aiMlTopics.put("Supervised vs Unsupervised Learning", "https://www.youtube.com/watch?v=KXJSjte_OAI");
        aiMlTopics.put("Neural Networks Basics", "https://www.youtube.com/watch?v=aircAruvnKk");
        aiMlTopics.put("Deep Learning Overview", "https://www.youtube.com/watch?v=VyWAvY2CF9c");

        // Add all to model
        model.addAttribute("dsaTopics", dsaTopics);
        model.addAttribute("dsaQuizzes", dsaQuizzes);
        model.addAttribute("systemDesignTopics", systemDesignTopics);
        model.addAttribute("aiMlTopics", aiMlTopics);

        return "dashboard";
    }
}
