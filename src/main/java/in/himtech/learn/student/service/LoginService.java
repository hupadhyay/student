package in.himtech.learn.student.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public Boolean authenticateLogin(String userName, String password) {
		return userName.equals("himanshu") && password.equals("himpc");
	}

}
