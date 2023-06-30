package com.hendisantika.repository;

import com.hendisantika.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mysql-docker-compose
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/30/23
 * Time: 10:02
 * To change this template use File | Settings | File Templates.
 */
public interface BookRepository extends JpaRepository<Book, Serializable> {
}
