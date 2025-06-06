package by.inno.jsonplaceholder.controller;

import by.inno.jsonplaceholder.dto.stub.request.CreateUserRequest;
import by.inno.jsonplaceholder.dto.stub.request.UpdateUserRequest;
import by.inno.jsonplaceholder.dto.stub.response.UserResponse;
import by.inno.jsonplaceholder.service.stub.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

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

    @PutMapping
    public UserResponse update(
            @RequestBody UpdateUserRequest updateUserRequest
    ) {
        return userService.update(updateUserRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable UUID id
    ) {
        userService.delete(id);
    }
} 