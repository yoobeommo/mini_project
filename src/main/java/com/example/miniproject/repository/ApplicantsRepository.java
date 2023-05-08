package com.example.miniproject.repository;

import com.example.miniproject.entity.Applicants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantsRepository extends JpaRepository<Applicants, Long> {
}
