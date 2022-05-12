package edu.kotlin.basic_crud.Group

import org.springframework.data.jpa.repository.JpaRepository


interface GroupRepository : JpaRepository<Group, Long> {
}