package com.example.RegisterLogin.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.RegisterLogin.DTO.LoginDTO;
import com.example.RegisterLogin.DTO.RegisterDTO;
import com.example.RegisterLogin.Entity.RegisterUser;
import com.example.RegisterLogin.Repo.EmployeeRepo;
import com.example.RegisterLogin.response.LoginResponse;

@Service
public class EmployeeServiceIMPL implements EmployeeService {

	@Autowired
    private  EmployeeRepo employeeRepo;
	
	 private PasswordEncoder passwordEncoder;

	    @Autowired
	    public EmployeeServiceIMPL(PasswordEncoder passwordEncoder) {
	        this.passwordEncoder = passwordEncoder;
	    }

    

    @Override
    public String addEmployee(RegisterDTO employeeDTO) {
        
    	RegisterUser employee = new RegisterUser(
                employeeDTO.getEmployeeId(),
                employeeDTO.getEmployeeName(),
                employeeDTO.getEmail(),
                
                this.passwordEncoder.encode(employeeDTO.getPassword())
                
                
        );
        employeeRepo.save(employee);

        // Return the employee name as confirmation
        return employee.getEmployeeName();
    }



	@Override
	public LoginResponse loginEmployee(LoginDTO loginDTO) {
		String msg="";
		RegisterUser employee1=employeeRepo.findByEmail(loginDTO.getEmail());
		if(employee1!=null) {
			String password=loginDTO.getPassword();
			String encodedPassword=employee1.getPassword();
			Boolean isPwdRight=passwordEncoder.matches(password, encodedPassword);
			if(isPwdRight) {
				Optional<RegisterUser> employee=employeeRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
				if(employee.isPresent()) {
					return new LoginResponse("Login Success", true);
				}else {
					return new LoginResponse("Login Failed",false);
				}
			}else {
				return new LoginResponse("Password Not Match",false);
			}
		}else {
			return new LoginResponse("Email Not Exists",false);
		}
	}



	
}
