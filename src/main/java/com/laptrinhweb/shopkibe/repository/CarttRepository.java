//package com.laptrinhweb.shopkibe.repository;
//
//
//
//import com.laptrinhweb.shopkibe.entity.Cartt;
//import com.laptrinhweb.shopkibe.entity.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import javax.transaction.Transactional;
//import java.util.ArrayList;
//import java.util.Optional;
//
//@Repository
//public interface CarttRepository extends JpaRepository<Cartt, Long> {
//
//    @Query("select c from Cart c where c.user_id = ?1" )
//    ArrayList<Cartt> getCartById(Long id);
//    @Transactional
//    @Modifying
//    @Query("update Cartt  c set c.quantity = ?1 where c.id = ?2")
//    void updateCartQuantity(Long quantity,Long id);
//    @Transactional
//    @Modifying
//    @Query("delete from Cartt  c where c.id = ?1")
//    void deleteCart(Long id);
//
//}
