package swe642.hw3.SpringBoot.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import swe642.hw3.SpringBoot.model.StudentSurvey;


public interface StudentSurveyRepository extends JpaRepository<StudentSurvey, Integer> {
}
