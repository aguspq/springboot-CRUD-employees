package com.agus.springboot.model.entities;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "dept", schema = "public", catalog = "employeeAPC2425")
public class DeptEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "deptno")
    private Integer deptno;
    @Basic
    @Column(name = "dname")
    private String dname;
    @Basic
    @Column(name = "loc")
    private String loc;

    @OneToMany(mappedBy = "dept")
    private Set<EmployeeEntity> employees;


    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeptEntity that = (DeptEntity) o;
        return deptno == that.deptno && Objects.equals(dname, that.dname) && Objects.equals(loc, that.loc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptno, dname, loc);
    }
}
