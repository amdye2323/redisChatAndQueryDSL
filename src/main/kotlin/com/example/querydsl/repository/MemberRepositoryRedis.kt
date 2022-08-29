package com.example.querydsl.repository

import com.example.querydsl.entity.Member
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MemeberRepositoryRedis: CrudRepository<Member, String>{}