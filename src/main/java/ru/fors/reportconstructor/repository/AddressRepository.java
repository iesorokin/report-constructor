package ru.fors.reportconstructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fors.reportconstructor.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}