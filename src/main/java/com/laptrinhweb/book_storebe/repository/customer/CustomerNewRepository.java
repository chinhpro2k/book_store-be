package com.laptrinhweb.book_storebe.repository.customer;


import com.laptrinhweb.book_storebe.entity.customer.CustomerNew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerNewRepository extends JpaRepository<CustomerNew, Long> {
    @Query("select u from CustomerNew u where u.username = ?1")
    CustomerNew getByUserName(String userName);

    @Query(value = "select c from CustomerNew c where c.id = :userId")
    CustomerNew findByUserId(@Param("userId") Long userId);
}
