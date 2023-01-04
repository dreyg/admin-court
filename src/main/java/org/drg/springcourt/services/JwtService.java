package org.drg.springcourt.services;

import org.drg.springcourt.dtos.requests.UserRequestDto;
import org.drg.springcourt.dtos.responses.UserResponseDto;

public interface JwtService {

	UserResponseDto getUser(String authHeader);
	boolean isValid(String authHeader);
	String generateToken(UserRequestDto userRequestDto);
	String login(UserRequestDto userRequestDto);
}
