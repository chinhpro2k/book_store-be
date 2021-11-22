package com.laptrinhweb.book_storebe.service.order;

import com.laptrinhweb.book_storebe.dtos.CartDto;
import com.laptrinhweb.book_storebe.entity.customer.CustomerNew;
import com.laptrinhweb.book_storebe.entity.order.Cart;
import com.laptrinhweb.book_storebe.payload.ApiResponse;
import com.laptrinhweb.book_storebe.repository.customer.CustomerNewRepository;
import com.laptrinhweb.book_storebe.repository.order.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CustomerNewRepository customerNewRepository;

    public ApiResponse update(CartDto cartDto){
        List<Cart> cart = cartRepository.findByUserId(cartDto.getUserId());
        CustomerNew customer = customerNewRepository.findByUserId(cartDto.getUserId());

        Cart cartChange = checkExist(cart,cartDto.getBookItemId());

        if(cartChange == null){
            Cart cartNew =new Cart();
            cartNew.setQuantity(cartDto.getQuantity());
            cartNew.setTotalPrice(cartDto.getTotalPrice());
            cartNew.setBookItemId(cartDto.getBookItemId());
            cartNew.setCustomer(customer);
            cartRepository.save(cartNew);
        }
        else{
            if(cartDto.getStatus() == 0){
                cartRepository.deleteById(cartChange.getId());
            }
            else{
                cartChange.setQuantity(cartDto.getQuantity());
                cartChange.setTotalPrice(cartDto.getTotalPrice());

                cartRepository.save(cartChange);
            }

        }
        return new ApiResponse(0);
    }

    private Cart checkExist(List<Cart> books, int bookId){
        for(int i=0;i<books.size();i++){
            if(books.get(i).getBookItemId() == bookId){
                return books.get(i);
            }
        }
        return null;
    }

}
