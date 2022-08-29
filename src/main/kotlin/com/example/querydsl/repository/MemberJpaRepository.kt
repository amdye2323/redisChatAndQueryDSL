package com.example.querydsl.repository

import com.example.querydsl.entity.Member
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class MemberJpaRepository {

    @PersistenceContext
    private lateinit var em:EntityManager

    fun save(member: Member):Member{
        em.persist(member)
        return member
    }

    fun find(id: Long):Member{
        return em.find(Member::class.java, id)
    }
}