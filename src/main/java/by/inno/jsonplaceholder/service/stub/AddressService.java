package by.inno.jsonplaceholder.service.stub;

import by.inno.jsonplaceholder.entity.stub.user.Address;
import by.inno.jsonplaceholder.repository.stub.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public Address getAddressByIdOrThrow(UUID id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + id));
    }

}
