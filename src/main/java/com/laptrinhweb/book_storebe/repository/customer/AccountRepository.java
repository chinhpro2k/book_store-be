package com.laptrinhweb.book_storebe.repository.customer;

import com.laptrinhweb.book_storebe.entity.book.Book;
import com.laptrinhweb.book_storebe.entity.customer.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
