package com.example.capstoneprojectbe.repository;

import com.example.capstoneprojectbe.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRepository extends JpaRepository<Plan, String> {
    @Query("select plan from Plan plan where plan.user.userID = ?1")
    List<Plan> getPlanByUserID(String userID);
}
