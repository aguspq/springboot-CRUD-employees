package com.agus.springboot.service;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DepartmentDTO {
    private Integer deptNo;
//    check @Valid (in controller) to use annotations
    @NotBlank(message = "The field 'name' is mandatory")
    @Size(max = 50, message = "Name size must be under 50 characters")
    private String name;
    @NotBlank(message = "The field 'location' is mandatory")
    private String location;

    public DepartmentDTO(){

    }
    public DepartmentDTO(Integer deptNo, String name, String location){
        this.deptNo = deptNo;
        this.name = name;
        this.location = location;
    }

    public Integer getDeptNo() {
        return deptNo;
    }
    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}
