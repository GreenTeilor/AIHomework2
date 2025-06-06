package by.inno.jsonplaceholder.service.stub;

import by.inno.jsonplaceholder.dto.stub.mapper.UserMapper;
import by.inno.jsonplaceholder.dto.stub.request.CreateUserRequest;
import by.inno.jsonplaceholder.dto.stub.response.UserResponse;
import by.inno.jsonplaceholder.entity.stub.user.User;
import by.inno.jsonplaceholder.repository.stub.UserRepository;
import by.inno.jsonplaceholder.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final AuthenticationService authenticationService;
    private final AddressService addressService;
    private final CompanyService companyService;

    private final UserMapper userMapper;

    public UserResponse create(CreateUserRequest createUserRequest) {
        UUID selfId = authenticationService.getSelf().getId();
        User user = userMapper.map(createUserRequest, selfId);
        user.setAddress(addressService.getAddressByIdOrThrow(user.getAddressId()));
        user.setCompany(companyService.getCompanyByIdOrThrow(user.getCompanyId()));
        user.setId(UUID.randomUUID());
        userRepository.save(user);
        return userMapper.map(user);
    }

    public List<UserResponse> findAll() {
        return userMapper.map(userRepository.findAllWithAddressAndCompany());
    }
}
