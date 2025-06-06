package by.inno.jsonplaceholder.controller;

import by.inno.jsonplaceholder.dto.stub.request.CreateUserRequest;
import by.inno.jsonplaceholder.dto.stub.response.UserResponse;
import by.inno.jsonplaceholder.service.stub.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponse create(
            @RequestBody CreateUserRequest createUserRequest
    ) {
        return userService.create(createUserRequest);
    }

    @GetMapping
    public List<UserResponse> read() {
        return userService.findAll();
    }
} 