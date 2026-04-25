package com.utkarsh.dsatracker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "problems")
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String problemName;
    private String platform;
    private String difficulty;
    private String yourFeeling;

    public Problem() {}

    public Problem(String problemName, String platform, String difficulty, String yourFeeling) {
        this.problemName = problemName;
        this.platform = platform;
        this.difficulty = difficulty;
        this.yourFeeling = yourFeeling;
    }

    public Long getId() { return id; }

    public String getProblemName() { return problemName; }
    public void setProblemName(String problemName) { this.problemName = problemName; }

    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }

    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }

    public String getYourFeeling() { return yourFeeling; }
    public void setYourFeeling(String yourFeeling) { this.yourFeeling = yourFeeling; }
}
