package com.example.capstoneprojectbe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter// lombook
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_workschedule")
public class WorkSchedule {

    @Id
    private String workScheduleID;

//    private String userID;

    private String date;

    private boolean shift1;

    private boolean shift2;

    private boolean shift3;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID")
    private User user;
}
