package com.example.capstoneprojectbe.repository;

import com.example.capstoneprojectbe.model.RegistrationSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationScheduleRepository extends JpaRepository<RegistrationSchedule, String>  {
    @Query("select rs from RegistrationSchedule rs where rs.user.userID = ?1")
    List<RegistrationSchedule> getRegistrationScheduleByUserID(String userID);
}
