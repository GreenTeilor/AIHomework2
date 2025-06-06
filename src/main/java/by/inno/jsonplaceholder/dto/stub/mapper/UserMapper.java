package by.inno.jsonplaceholder.dto.stub.mapper;

import by.inno.jsonplaceholder.dto.stub.request.CreateUserRequest;
import by.inno.jsonplaceholder.dto.stub.request.UpdateUserRequest;
import by.inno.jsonplaceholder.dto.stub.response.UserResponse;
import by.inno.jsonplaceholder.entity.stub.user.User;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User map(CreateUserRequest createUserRequest, UUID ownerId);

    User map(UpdateUserRequest createUserRequest, UUID ownerId);

    UserResponse map(User user);

    List<UserResponse> map(List<User> users);
}
