package com.neq.carrental.user;

import org.springframework.security.core.Authentication;

public interface IUserAuthentication {

	public Authentication getAuthentication();
}
