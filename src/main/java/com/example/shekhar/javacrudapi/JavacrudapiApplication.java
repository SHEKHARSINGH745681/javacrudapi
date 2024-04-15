
package com.example.shekhar.javacrudapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
public class JavacrudapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavacrudapiApplication.class, args);
	}

	@GetMapping(value = "/userDetail", produces = "application/json")
	public ResponseData userDetail() {
		UserData[] data = new UserData[3];

		data[0] = new UserData(1, "Shekhar singh", "Shekharsingh@gmail.com");
		data[1] = new UserData(2, "shekharsingh", "Shekharsingh@gmail.com");
		data[2] = new UserData(3, "Sandeep bhaiya", "Sandeepbhaiya@gmail.com");
		ResponseData resData = new ResponseData(200, 1, "Successfull", data);
		return resData;
	}

	@PostMapping(value = "/saveUser")
	public String saveUser(@RequestBody String reqBody) {
		System.out.println("-----------------------------");
		System.out.println(reqBody);
		return "User Saved Sucessfully";

	}
}

//Model Class Writing Here 
class UserData {
	public int id;
	public String name;
	public String email;

//	Constructor Function 
	UserData(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;

	}
}

class ResponseData {
	public int code;
	public int status;
	public String message;
	public UserData[] data;

	ResponseData(int code, int status, String message, UserData[] data) {
		this.code = code;
		this.status = status;
		this.message = message;
		this.data = data;
	}
}

class RequestSaveUser {
	public String name;
	public String email;

	RequestSaveUser(String name, String email) {
		this.name = name;
		this.email = email;
	}

}
