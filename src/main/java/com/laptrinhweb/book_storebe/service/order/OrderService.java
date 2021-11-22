package com.laptrinhweb.book_storebe.service.order;

import com.laptrinhweb.book_storebe.dtos.CartDto;
import com.laptrinhweb.book_storebe.dtos.OrderDto;
import com.laptrinhweb.book_storebe.entity.customer.CustomerNew;
import com.laptrinhweb.book_storebe.entity.order.Cart;
import com.laptrinhweb.book_storebe.entity.order.Order;
import com.laptrinhweb.book_storebe.entity.order.OrderLine;
import com.laptrinhweb.book_storebe.payload.ApiResponse;
import com.laptrinhweb.book_storebe.repository.customer.CustomerNewRepository;
import com.laptrinhweb.book_storebe.repository.order.CartRepository;
import com.laptrinhweb.book_storebe.repository.order.OrderLineRepository;
import com.laptrinhweb.book_storebe.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CustomerNewRepository customerNewRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderLineRepository orderLineRepository;

    public ApiResponse createOrder(OrderDto orderDto) {
        List<Cart> cartList = cartRepository.findByUserId(orderDto.getCustomerId());
        CustomerNew customer = customerNewRepository.findByUserId(orderDto.getCustomerId());

        Order orderNew = new Order();
        orderNew.setStatus("new");
        orderNew.setCustomer(customer);
        orderNew.setDate(new Date());

        orderRepository.save(orderNew);

        List<OrderLine> orderLines = new ArrayList<>();
        cartList.forEach(s->{
            OrderLine orderLineNew = new OrderLine();
            orderLineNew.setOrderId(orderNew.getId());
            orderLineNew.setBookItemId(s.getBookItemId());
            orderLineNew.setQuantity(s.getQuantity());
            orderLines.add(orderLineNew);
        });
        orderLineRepository.saveAll(orderLines);

        return new ApiResponse(0);
    }
}
