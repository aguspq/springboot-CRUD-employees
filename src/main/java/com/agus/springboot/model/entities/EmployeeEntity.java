package com.agus.springboot.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "employee", schema = "public", catalog = "employeeAPC2425")
public class EmployeeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "empno")
    private Integer empno;
    @Basic
    @Column(name = "ename")
    private String ename;
    @Basic
    @Column(name = "job")
    private String job;
//    @Basic
//    @Column(name = "deptno")
//    private Integer deptno;

    @ManyToOne
    @JoinColumn(name = "deptno", referencedColumnName = "deptno")
    private DeptEntity dept;


    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public DeptEntity getDept() {
        return dept;
    }

    public void setDept(DeptEntity dept) {
        this.dept = dept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return empno == that.empno && Objects.equals(ename, that.ename) && Objects.equals(job, that.job) && Objects.equals(dept, that.dept);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empno, ename, job, dept);
    }
}
