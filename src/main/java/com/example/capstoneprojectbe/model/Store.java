package com.example.capstoneprojectbe.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter// lombook
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_store")
public class Store {
    @Id
    private String storeID;

    private String storeName;

    private String address;

    // relationship Store - workhistory: 1 - N
    @OneToMany(mappedBy = "store")
    @JsonIgnore
    private Set<WorkHistory> workHistories = new HashSet<>();
}
