package edu.kotlin.basic_crud.Group

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.stereotype.Repository


@Repository
interface GroupRepository : JpaRepository<Group, Long> {
}