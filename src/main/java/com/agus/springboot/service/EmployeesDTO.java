package com.agus.springboot.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.*;

public class EmployeesDTO {
    private Integer empno;
    @NotBlank(message = "The field: 'ename' can't be blank")
    @Size(max = 50, message = "Name size must be under 50 characters")
    private String name;
    @NotBlank (message = "The field 'job' can't be blank")
    private String job;
    @NotNull
    @Min(1)
    private Integer deptno;
    private String deptName;
    private String deptLocation;

    public EmployeesDTO(){

    }

    public EmployeesDTO(Integer empno, String name, String job,Integer deptno, String deptName, String deptLocation ){
        this.empno = empno;
        this.name = name;
        this.job = job;
        this.deptno = deptno;
        this.deptName = deptName;
        this.deptLocation = deptLocation;
    }

    public Integer getEmpno(){
        return empno;
    }
    public void setEmpno(int empno){
        this.empno = empno;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getJob() { return job; }
    public void setJob(String job){
        this.job = job;
    }
    public Integer getDeptno() {return deptno;}
    public void setDeptNo(int deptno){
        this.deptno = deptno;
    }
    public String getDeptName(){ return deptName;}
    public void setDeptName(String deptName){
        this.deptName = deptName;
    }
    public String getDeptLocation(){return deptLocation;}
    public void setDeptLocation(String deptLocation){
        this.deptLocation = deptLocation;
    }
}
