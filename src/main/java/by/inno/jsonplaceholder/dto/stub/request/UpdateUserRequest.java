package by.inno.jsonplaceholder.dto.stub.request;

import java.util.UUID;

public record UpdateUserRequest(
    UUID id,
    String name,
    String username,
    String email,
    UUID addressId,
    String phone,
    String website,
    UUID companyId
) {
}
