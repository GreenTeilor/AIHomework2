package by.inno.jsonplaceholder.repository.stub;

import by.inno.jsonplaceholder.entity.stub.user.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID> {
} 