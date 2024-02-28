package com.example.RegisterLogin.Service;

import org.springframework.stereotype.Service;

import com.example.RegisterLogin.DTO.LoginDTO;
import com.example.RegisterLogin.DTO.RegisterDTO;
import com.example.RegisterLogin.response.LoginResponse;

@Service
public interface EmployeeService {

	String addEmployee(RegisterDTO employeeDTO);

	LoginResponse loginEmployee(LoginDTO loginDTO);
}
