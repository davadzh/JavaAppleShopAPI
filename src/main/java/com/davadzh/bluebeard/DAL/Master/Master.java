package com.davadzh.bluebeard.DAL.Master;

import com.davadzh.bluebeard.DAL.MasterWorkType.MasterWorkType;
import com.davadzh.bluebeard.DAL.Record.Record;
import com.davadzh.bluebeard.DTO.MasterDtos.AddMasterDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "master")
public class Master implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String fullName;

    @Column(nullable = false)
    int age;

    @Column(nullable = false)
    String position;

    @OneToMany(mappedBy = "master", cascade = CascadeType.ALL, orphanRemoval = true)
    List<MasterWorkType> masterWorkTypes;

    @OneToMany(mappedBy = "master", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Record> records;

    public Master() { }

    public Master(AddMasterDto addMasterDto) {
        fullName = addMasterDto.fullName;
        age = addMasterDto.age;
        position = addMasterDto.position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}