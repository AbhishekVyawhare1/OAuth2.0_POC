package com.example.RegisterLogin.EmployeeController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class home {
	
	@GetMapping("/home")
	public String getdata()
	{
		return "Jai Shri Ram";
	}

}