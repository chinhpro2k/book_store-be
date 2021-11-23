package com.laptrinhweb.book_storebe.service.book;

import com.laptrinhweb.book_storebe.dtos.BookDTO;
import com.laptrinhweb.book_storebe.entity.book.BookItem;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
@Transactional
public class UtilsService {
    @Autowired
    private EntityManager entityManager;

    public List<BookDTO> getDataBook(){
        StringBuilder strQuery = new StringBuilder(" Select ");
        strQuery.append("   b.img as img, ");
        strQuery.append("   b.title as title, ");
        strQuery.append("   bi.amount as amount, ");
        strQuery.append("   bi.price as price ");
        strQuery.append("   from Book b ");
        strQuery.append("   join BookItem bi on b.id = bi.id ");

        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery(strQuery.toString())
                .setResultTransformer(Transformers.aliasToBean(BookDTO.class));
        return query.getResultList();
    }

    public List<BookDTO> getDataBookItem(Long bookItemId){
        StringBuilder strQuery = new StringBuilder(" Select ");
        strQuery.append("   bi.id as id, ");
        strQuery.append("   b.img as img, ");
        strQuery.append("   b.title as title, ");
        strQuery.append("   bi.amount as amount, ");
        strQuery.append("   bi.price as price ");
        strQuery.append("   from Book b ");
        strQuery.append("   join BookItem bi on b.id = bi.id and bi.book.id = "+bookItemId+"");

        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery(strQuery.toString())
                .setResultTransformer(Transformers.aliasToBean(BookDTO.class));
        return query.getResultList();
    }
}
