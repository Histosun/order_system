package com.zhaoyang.restaurant.service;

import com.zhaoyang.restaurant.dao.UserDAO;
import com.zhaoyang.restaurant.domain.User;

/**
 * This class operates on the User table by UserDAO
 * @author Shi Zhaoyang
 *
 */
public class UserService {
	private UserDAO userDAO=new UserDAO();
	
	public User getUserByIdAndPwd(String id, String pwd) {
		return userDAO.querySingle(User.class, "SELECT * FROM user_table where accountNum = ? and pwd = md5(?)", id, pwd);
	}
}
