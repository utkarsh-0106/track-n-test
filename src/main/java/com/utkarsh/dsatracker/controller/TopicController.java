package com.utkarsh.dsatracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class TopicController {

    @GetMapping("/topics")
    public String getTopics(Model model) {
        // Static topics list for now
        List<Map<String, String>> topics = List.of(
                Map.of("name", "Arrays", "url", "https://www.youtube.com/watch?v=CuXUoQNOmIY"),
                Map.of("name", "Strings", "url", "https://www.youtube.com/watch?v=HVRa3V5P4Gg"),
                Map.of("name", "Recursion", "url", "https://www.youtube.com/watch?v=ngCos392W4w"),
                Map.of("name", "Linked List", "url", "https://www.youtube.com/watch?v=unxAnJQ4B1U"),
                Map.of("name", "Stacks & Queues", "url", "https://www.youtube.com/watch?v=jDZQKzEtbYQ"),
                Map.of("name", "Graphs", "url", "https://www.youtube.com/watch?v=Eaq3hAmXHS4")
        );

        model.addAttribute("topics", topics);
        return "topics"; // topics.html
    }
}
