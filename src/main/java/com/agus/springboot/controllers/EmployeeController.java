package com.agus.springboot.controllers;

import com.agus.springboot.model.dao.IDeptDAO;
import com.agus.springboot.model.dao.IEmployeeDAO;
import com.agus.springboot.model.entities.DeptEntity;
import com.agus.springboot.model.entities.EmployeeEntity;
import com.agus.springboot.service.EmployeeService;
import com.agus.springboot.service.EmployeesDTO;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("api-rest/employees")
public class EmployeeController {
    @Autowired
    private IEmployeeDAO employeeDAO;
    @Autowired
    private EmployeeService emplService;

    @GetMapping
    public ResponseEntity<List<EmployeesDTO>> findAllEmployees(){
        List<EmployeesDTO> employeesDTOList = emplService.findAllEmployees();
        return ResponseEntity.ok(employeesDTOList);
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<EmployeesDTO> findEmployeeByIdDTO (@PathVariable(value = "id") int id){

        return ResponseEntity.ok(emplService.findEmployeeByIdDTO(id));
    }


    @PostMapping
    public ResponseEntity<EmployeesDTO> saveEmployee(@Valid @RequestBody EmployeesDTO employee){ // new employee

        return ResponseEntity.ok(emplService.saveEmployee(employee));

    }
    // ------------------------------
    @PutMapping("/{id}")
    public ResponseEntity<EmployeesDTO> updateEmployee(@RequestBody EmployeesDTO newEmpl,
                                            @PathVariable(value = "id") int id){

        return ResponseEntity.ok(emplService.updateEmployee(id, newEmpl));
    }


    // ------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "id") int id){

        emplService.deleteUser(id);

        return ResponseEntity.noContent().build(); // 204 is a standard code to deleted successfully
//                                                  same but without response. More "pro"


    }

}
