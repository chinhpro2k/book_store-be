package com.laptrinhweb.book_storebe.repository.customer;


import com.laptrinhweb.book_storebe.entity.customer.CustomerMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMemberRepository extends JpaRepository<CustomerMember, Long> {
    @Query("select u from CustomerMember u where u.username = ?1")
    CustomerMember getByUserName(String userName);
}
