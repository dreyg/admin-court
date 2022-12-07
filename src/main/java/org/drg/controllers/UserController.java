package org.drg.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.drg.dtos.requests.UserRequestDto;
import org.drg.dtos.responses.UserResponseDto;
import org.drg.models.UserEntity;
import org.drg.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

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

    @Operation(summary = "Get only users by street")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Give all users from same street",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = UserResponseDto.class)))})})
    @GetMapping("/street")
    public Collection<UserResponseDto> getUsersSameStreet(@RequestBody UserRequestDto userRequestStreetDto) {
        return userService.findAllUsersSameStreet(userRequestStreetDto);
    }



}

