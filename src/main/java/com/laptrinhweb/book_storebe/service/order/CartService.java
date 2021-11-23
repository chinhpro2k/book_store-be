package com.laptrinhweb.book_storebe.service.order;

import com.laptrinhweb.book_storebe.dtos.CartDetailDto;
import com.laptrinhweb.book_storebe.dtos.CartDto;
import com.laptrinhweb.book_storebe.dtos.GetCartDto;
import com.laptrinhweb.book_storebe.entity.book.BookItem;
import com.laptrinhweb.book_storebe.entity.customer.CustomerNew;
import com.laptrinhweb.book_storebe.entity.order.Cart;
import com.laptrinhweb.book_storebe.payload.ApiResponse;
import com.laptrinhweb.book_storebe.repository.book.BookItemRepository;
import com.laptrinhweb.book_storebe.repository.customer.CustomerNewRepository;
import com.laptrinhweb.book_storebe.repository.order.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CustomerNewRepository customerNewRepository;
    @Autowired
    private BookItemRepository bookItemRepository;

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

    private Cart checkExist(List<Cart> books, Long bookId){
        for(int i=0;i<books.size();i++){
            if(books.get(i).getBookItemId() == bookId){
                return books.get(i);
            }
        }
        return null;
    }


    public List<CartDetailDto> getCart(GetCartDto getCartDto){
        List<CartDetailDto> response = new ArrayList<>();

        List<Cart> cart = cartRepository.findByUserId(getCartDto.getCustomerId());

        cart.forEach(s->{
            List<BookItem> bookItem = bookItemRepository.searchById(s.getBookItemId());
            CartDetailDto itemRes = new CartDetailDto();
            /*itemRes.setBookItemId(s.getBookItemId());
            itemRes.setQuantity(s.getQuantity());
            itemRes.setPrice(bookItem.getPrice());
            itemRes.setTitle(bookItem.getBook().getTitle());
            itemRes.setSummary(bookItem.getBook().getSummary());
            itemRes.setImg(bookItem.getBook().getImg());

            response.add(itemRes);*/
        });

        return response;
    }

}
