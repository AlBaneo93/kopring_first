package edu.kotlin.basic_crud.Doamin.models.Group

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface GroupRepository : JpaRepository<Group, Long> {
}