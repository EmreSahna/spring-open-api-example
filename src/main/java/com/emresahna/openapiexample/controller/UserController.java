package com.emresahna.openapiexample.controller;

import com.emresahna.openapiexample.dto.CreateUserRequest;
import com.emresahna.openapiexample.dto.UserResponse;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/create")
    @Operation(
            tags = {"UserController"},
            summary = "Create a user summary",
            operationId = "createUser",
            description = "Create a user description",
            requestBody = @RequestBody(
                    description = "User object that needs to be created",
                    content = @Content(
                            schema = @Schema(
                                    implementation = CreateUserRequest.class
                            )
                    )
            ),
            parameters = {
                    @Parameter(name = "username", description = "Username", required = true, example = "userexample"),
                    @Parameter(name = "password", description = "Password", required = true, example = "passwordexample")
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "User created successfully",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = UserResponse.class
                                    ),
                                    mediaType = "application/json",
                                    examples = {
                                            @ExampleObject(
                                                    name = "User created successfully",
                                                    value = "{\n" +
                                                            "  \"id\": 1,\n" +
                                                            "  \"username\": \"userexample\",\n" +
                                                            "  \"password\": \"passwordexample\"\n" +
                                                            "}"
                                            )
                                    }
                            )
                    )
            },
            externalDocs = @ExternalDocumentation(
                    description = "User Create Wiki Documentation",
                    url = "usercreate.wiki.com"
            )
    )
    public UserResponse createPost(@RequestBody CreateUserRequest createUserRequest){
        return new UserResponse(1L, createUserRequest.getUsername(), createUserRequest.getPassword());
    }
}
