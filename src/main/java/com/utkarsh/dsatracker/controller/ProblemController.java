package com.utkarsh.dsatracker.controller;

import com.utkarsh.dsatracker.model.Problem;
import com.utkarsh.dsatracker.repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProblemController {

    @Autowired
    private ProblemRepository problemRepository;

    @GetMapping("/problems")
    public String getAllProblems(Model model) {
        List<Problem> problems = problemRepository.findAll();
        model.addAttribute("problems", problems);
        return "problems"; 
    }

    @GetMapping("/problems/add")
    public String showAddProblemForm(Model model) {
        model.addAttribute("problem", new Problem());
        return "add_problem"; 
    }

    @PostMapping("/problems/add")
    public String addProblem(@ModelAttribute Problem problem) {
        problemRepository.save(problem);
        return "redirect:/problems";
    }
}
