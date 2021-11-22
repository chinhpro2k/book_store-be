package com.laptrinhweb.book_storebe.repository.customer;

import com.laptrinhweb.book_storebe.entity.customer.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("select u from Address u where u.customerNew.id = ?1")
    public List<Address> getListAddress(Long id);
}
