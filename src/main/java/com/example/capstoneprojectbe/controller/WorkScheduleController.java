package com.example.capstoneprojectbe.controller;

import com.example.capstoneprojectbe.dto.WorkScheduleDto;
import com.example.capstoneprojectbe.model.WorkSchedule;
import com.example.capstoneprojectbe.service.WorkScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workschedule")
public class WorkScheduleController {
    private final WorkScheduleService workScheduleService;

    public WorkScheduleController(WorkScheduleService workScheduleService) {
        this.workScheduleService = workScheduleService;
    }


    @PostMapping("/create")
    public ResponseEntity createWorkSchedule(@RequestBody WorkScheduleDto dto) {// lấy dữ liệu tryền vào dto
        if(workScheduleService.isExisted(dto.getWorkScheduleID())){
            return ResponseEntity.badRequest().body("Id is duplicated");
        }
//        if(planService.isExistedUserIDAndDateAndShift(dto.getUserID(), dto.getDate(), dto.getShift())){
//            return ResponseEntity.badRequest().body("UserID & Date & Shift is duplicated");
//        }
        // tạo annoation//?
        workScheduleService.createWorkSchedule(dto);
        return ResponseEntity.ok().body("Successful");
    }
    @GetMapping
    private ResponseEntity getAll() {
        List<WorkSchedule> workSchedulesList = workScheduleService.getAll();
        return ResponseEntity.ok().body(workSchedulesList);
    }

    @PutMapping
    private ResponseEntity update(@RequestBody WorkScheduleDto dto) {
        workScheduleService.update(dto);
        return ResponseEntity.ok().body("Successful");
    }

    @DeleteMapping()
    private ResponseEntity delete(@RequestParam String id) {
        workScheduleService.delete(id);
        return ResponseEntity.ok().body("Successful");
    }

    @GetMapping("/get-by-user-id")
    private ResponseEntity getByUserId(@RequestParam String id) {
        List<WorkSchedule> workScheduleList = workScheduleService.getByUserId(id);
        return ResponseEntity.ok().body(workScheduleList);
    }
}
