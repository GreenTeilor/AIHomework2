package by.inno.jsonplaceholder.controller;

import by.inno.jsonplaceholder.dto.stub.request.CreateUserRequest;
import by.inno.jsonplaceholder.dto.stub.response.CreateUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    @PostMapping
    public CreateUserResponse create(
            @RequestBody CreateUserRequest createUserRequest
    ) {

        return new CreateUserResponse();
    }
} 