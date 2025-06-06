package by.inno.jsonplaceholder.service.stub;

import by.inno.jsonplaceholder.entity.stub.user.Company;
import by.inno.jsonplaceholder.repository.stub.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public Company getCompanyByIdOrThrow(UUID id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + id));
    }

}
