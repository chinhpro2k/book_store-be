package com.laptrinhweb.book_storebe.repository.Information;

import com.laptrinhweb.book_storebe.entity.information.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface AddressRepository extends JpaRepository<Address,Long> {
    @Query("select a from Address a where a.user_id = ?1" )
    ArrayList<Address> getAddress(Long id);
    @Transactional
    @Modifying
    @Query("update Address a set a.phone = ?1 where a.id = ?2")
    void updateAddress(Long phone,Long id);
    @Transactional
    @Modifying
    @Query("delete from Address a where a.id = ?1")
    void deleteAddress(Long id);
}
