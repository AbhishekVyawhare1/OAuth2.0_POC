package com.example.RegisterLogin.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "employee")
public class RegisterUser {

    @Id
    private String id;

    @Indexed(unique = true) // Example of indexing for uniqueness
    private String employeeName;

    @Indexed(unique = true) // Example of indexing for uniqueness
    private String email;

    private String password;

	public RegisterUser orElse(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
}
