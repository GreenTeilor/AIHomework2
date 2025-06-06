package by.inno.jsonplaceholder.service.stub;

import by.inno.jsonplaceholder.dto.stub.request.CreateUserRequest;
import by.inno.jsonplaceholder.dto.stub.response.CreateUserResponse;
import by.inno.jsonplaceholder.repository.stub.UserRepository;
import by.inno.jsonplaceholder.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final AuthenticationService authenticationService;

    public CreateUserResponse create(CreateUserRequest createUserRequest) {
        UUID selfId = authenticationService.getSelf().getId();
        return null;
    }
}
