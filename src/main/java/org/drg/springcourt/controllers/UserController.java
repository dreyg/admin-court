package org.drg.springcourt.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.drg.springcourt.dtos.requests.UserRequestDto;
import org.drg.springcourt.dtos.responses.UserResponseDto;
import org.drg.springcourt.security.Constants;
import org.drg.springcourt.services.JwtService;
import org.drg.springcourt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtService jwtService;

    @Operation(summary = "Get all users")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Found all users",
            content = {@Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = UserResponseDto.class)))})})
    @GetMapping("/")
    public Collection<UserResponseDto> getUsers() {
        return userService.findAll();
    }

    @PostMapping("/")
    ResponseEntity<String> addUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        userService.saveUser(userRequestDto);
        return ResponseEntity.ok("User is valid");
    }

    @Operation(summary = "Get a user by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid format id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content)})
    @GetMapping("/{userId}")
    public UserResponseDto getUser(@Parameter(description = "id of user to be searched")
                                   @PathVariable long userId) {
        return this.userService.findById(userId);
    }


    @Operation(summary = "Get the username of the token sent")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content)})
    @GetMapping("/me")
    public UserResponseDto whoami(@RequestHeader Map<String, String> headers) {
        return this.jwtService.getUser(headers.get(Constants.HEADER_AUTHORIZATION_KEY.toLowerCase()));
    }

}

