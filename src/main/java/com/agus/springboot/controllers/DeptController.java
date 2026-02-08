package com.agus.springboot.controllers;

import com.agus.springboot.model.dao.IDeptDAO;
import com.agus.springboot.model.entities.DeptEntity;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

//import static sun.rmi.transport.TransportConstants.Return;

@RestController
@RequestMapping("api-rest/dept")
public class DeptController {
    @Autowired
    private IDeptDAO deptDAO;

    @GetMapping
    public List<DeptEntity> findAllDepts(){return (List<DeptEntity>) deptDAO.findAll();}

    @GetMapping("/{id}")
    public ResponseEntity<DeptEntity> findDeptById(@PathVariable(value = "id") int id){
        Optional<DeptEntity> dept = deptDAO.findById(id);

        if(dept.isPresent()){
            return ResponseEntity.ok().body(dept.get());
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> saveDept (@Validated @RequestBody DeptEntity dept){
//        if (employee.getEmpno() != null && employeeDAO.existsById(employee.getEmpno())) {
//            return ResponseEntity.badRequest().body("Employee already exists");
//        }
        if (dept.getDeptno() != null && deptDAO.existsById(dept.getDeptno())) {
            return ResponseEntity.badRequest().body("Employee already exists");
        }

        DeptEntity saved = deptDAO.save(dept);
        return ResponseEntity.ok(saved);
    }

//    public void deleteDept (@Validated @RequestBody DeptEntity dept){ deptDAO.delete(dept);}

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> deleteDept(@PathVariable(value = "id") int id){
        Optional<DeptEntity> dept = deptDAO.findById(id);

        if (dept.isPresent()){
            deptDAO.deleteById(id);
            return ResponseEntity.ok().body("Deleted");
        } else{
            return ResponseEntity.notFound().build();
        }

    }
}
