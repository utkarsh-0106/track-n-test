package com.utkarsh.dsatracker.repository;

import com.utkarsh.dsatracker.model.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {
    Problem findByProblemName(String problemName);
}
