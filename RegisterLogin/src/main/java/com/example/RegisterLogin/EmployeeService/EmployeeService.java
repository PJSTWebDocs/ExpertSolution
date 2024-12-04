package com.example.RegisterLogin.EmployeeService;


import com.example.RegisterLogin.EmployeeDto.EmployeeDto;
import com.example.RegisterLogin.EmployeeDto.LoginDto;
import com.example.RegisterLogin.response.LoginResponse;


public interface EmployeeService {
    String addEmployee(EmployeeDto employeeDTO);

    LoginResponse loginEmployee(LoginDto loginDTO);

}
