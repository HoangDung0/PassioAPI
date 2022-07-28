package com.example.capstoneprojectbe.service;

import com.example.capstoneprojectbe.dto.RegistrationScheduleDto;
import com.example.capstoneprojectbe.model.RegistrationSchedule;
import com.example.capstoneprojectbe.repository.RegistrationScheduleRepository;
import com.example.capstoneprojectbe.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationScheduleService {
    private final RegistrationScheduleRepository registrationScheduleRepository;

    private final UserRepository userRepository;

    public RegistrationScheduleService(RegistrationScheduleRepository registrationScheduleRepository, UserRepository userRepository) {
        this.registrationScheduleRepository = registrationScheduleRepository;
        this.userRepository = userRepository;
    }


    public boolean isExisted(String id) {
        return registrationScheduleRepository.existsById(id);
    }

//    public boolean isExistedUserIDAndDateAndShift(String userID, String date, String shift) {
//        boolean check = false;
//        List<WorkingHour> listWorkHour = workingHourRepository.findAll();
//        for (int i = 1; i < listWorkHour.size(); i++) {
//            WorkingHour dtoCheck = listWorkHour.get(i);
//            if(userID.equals(dtoCheck.getUser().getUserID()) && date.equals(dtoCheck.getDate()) && shift.equals(dtoCheck.getShift())) {
//                check = true;
//                break;
//            }
//        }
//        return check;
//    }

    public void createRegistrationSchedule(RegistrationScheduleDto dto) {
        RegistrationSchedule registrationSchedule = new RegistrationSchedule();
        registrationSchedule.setRegistrationScheduleID(dto.getRegistrationScheduleID());
        registrationSchedule.setUser(userRepository.getById(dto.getUserID()));
        registrationSchedule.setDate(dto.getDate());
        registrationSchedule.setShift1(dto.isShift1());
        registrationSchedule.setShift2(dto.isShift2());
        registrationSchedule.setShift3(dto.isShift3());
        registrationSchedule.setAllday(dto.isAllday());
        registrationScheduleRepository.save(registrationSchedule);
    }


    public List<RegistrationSchedule> getAll() {
        return registrationScheduleRepository.findAll();
    }

    public void update(RegistrationScheduleDto dto) {
        RegistrationSchedule registrationSchedule = new RegistrationSchedule();
        registrationSchedule.setRegistrationScheduleID(dto.getRegistrationScheduleID());
        registrationSchedule.setUser(userRepository.getById(dto.getUserID()));
        registrationSchedule.setDate(dto.getDate());
        registrationSchedule.setShift1(dto.isShift1());
        registrationSchedule.setShift2(dto.isShift2());
        registrationSchedule.setShift3(dto.isShift3());
        registrationSchedule.setAllday(dto.isAllday());
        registrationScheduleRepository.save(registrationSchedule);
    }

    public void delete(String id) {
        registrationScheduleRepository.deleteById(id);
    }

    public List<RegistrationSchedule> getByUserId(String id) {
        return registrationScheduleRepository.getRegistrationScheduleByUserID(id);
    }

}
