package com.example.RegisterLogin.EmployeeService.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.RegisterLogin.EmployeeDto.EmployeeDto;
import com.example.RegisterLogin.EmployeeDto.LoginDto;
import com.example.RegisterLogin.EmployeeService.EmployeeService;
import com.example.RegisterLogin.Entity.Employee;
import com.example.RegisterLogin.Repo.EmployeeRepo;
import com.example.RegisterLogin.response.LoginResponse;

@Service
public class EmployeeIMPL implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addEmployee(EmployeeDto employeeDTO) {
        Employee employee = new Employee(
                employeeDTO.getEmployeeid(),
                employeeDTO.getEmployeename(),
                employeeDTO.getEmail(),
               this.passwordEncoder.encode(employeeDTO.getPassword())
        );
        employeeRepo.save(employee);
        return employee.getEmployeename();
    }
    EmployeeDto employeeDTO;
    @Override
    public LoginResponse  loginEmployee(LoginDto loginDTO) {
//        String message = "";
        Employee employee1 = employeeRepo.findByEmail(loginDTO.getEmail());
        if (employee1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Employee> employee = employeeRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("Incorrect Email and Password not match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }
    }
}
