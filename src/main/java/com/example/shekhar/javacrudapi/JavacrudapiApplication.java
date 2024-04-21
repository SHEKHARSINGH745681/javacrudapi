
package com.example.shekhar.javacrudapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableAutoConfiguration
@SpringBootApplication
@RestController
public class JavacrudapiApplication {
	List<UserData> data = new ArrayList<>();
	int index = 0;

	public static void main(String[] args) {
		SpringApplication.run(JavacrudapiApplication.class, args);
	}

	@GetMapping(value = "/userDetail", produces = "application/json")
	public ResponseData userDetail() {
		ResponseData resData = new ResponseData(200, 1, "Successfull", data);
		return resData;
	}

	@GetMapping(value = "/userAdd", produces = "application/json")
	public String userAdd() {
		index = index + 1;
		data.add(new UserData(index, "Static Name", "staticemail@gmail.com"));

		return "User Added Successfully Static !!!!!!!!";
	}

	@GetMapping(value = "/userAdd2", produces = "application/json")
	public String userAdd2(@RequestParam String name, @RequestParam String email) {
		index = index + 1;
		data.add(new UserData(index, name, email));

		return "User Added Successfully Dynamic !!!!!!!!";
	}

	////////// POST METHOD

	@PostMapping(value = "/userAdd3", produces = "application/json")
	// TODO: 15042024
	public String userAdd3(@RequestBody requestuser requestuser) {
		index = index + 1;
		data.add(new UserData(index, requestuser.name, requestuser.email));

		return "User Added Successfully   !!  ";
	}



/////////// DELETE METHOD

//@DeleteMapping(value = "/delete/{id}")
//public String deleteuser(@PathVariable Integer id) {
	//data.add(new UserData(index, null));
//}

/////////// UPDATE METHOD
@PutMapping(value ="/update/{id}")
public String updateuser(@PathVariable updateuser updateuser) {
	data.add(new UserData(index, updateuser.name, updateuser.email));

	return "User Update Successfully   !!  ";
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

	public UserData(int index, requestuser requestuser) {
		// TODO Auto-generated constructor stub
	}
}

class ResponseData {
	public int code;
	public int status;
	public String message;
	public List<UserData> data;

	ResponseData(int code, int status, String message, List<UserData> data) {
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

class requestuser {
	public String name;
	public String email;

	requestuser(String name, String email) {
		this.name = name;
		this.email = email;
	}

}


class requestdeleteuser{
	public int id;
	
	requestdeleteuser(int id){
		this.id = id;
	}
}


/////upadteuserclass
 
class updateuser {
	public String name;
	public String email;

	updateuser(String name, String email) {
		this.name = name;
		this.email = email;
	}

}
