package by.inno.jsonplaceholder.dto.stub.request;

import java.util.UUID;

public record CreateUserRequest(
    String name,
    String username,
    String email,
    UUID addressId,
    String phone,
    String website,
    UUID companyId
) {
}
