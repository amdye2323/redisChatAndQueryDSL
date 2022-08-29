package com.example.querydsl

import com.example.querydsl.controller.entity.Hello
import com.example.querydsl.controller.entity.QHello
import com.querydsl.jpa.impl.JPAQueryFactory
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@SpringBootTest
@Transactional
class QueryDslApplicationTests {

    @PersistenceContext
    lateinit var em:EntityManager

    @Test
    fun contextLoads() {
        var hello:Hello = Hello()
        em.persist(hello)

        var qhello:QHello = QHello("h")

        val query:JPAQueryFactory = JPAQueryFactory(em)

        val result = query.selectFrom(qhello).fetchOne()

        assertThat(result).isEqualTo(hello)
    }

}
