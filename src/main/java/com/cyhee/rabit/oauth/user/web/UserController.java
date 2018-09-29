package com.cyhee.rabit.oauth.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyhee.rabit.oauth.user.model.User;
import com.cyhee.rabit.oauth.user.service.UserService;
import com.cyhee.rabit.oauth.user.validation.SetPasswordGroup;

@RestController
@RequestMapping("v1/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<Void> addUser(@RequestBody @Validated({SetPasswordGroup.class}) User user, BindingResult bindingResult) {
		// TODO Handle Exception
		if (bindingResult.hasErrors())
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	
		userService.addUser(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}