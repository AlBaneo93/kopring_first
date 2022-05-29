package edu.kotlin.basic_crud.Adapter.Out

import edu.kotlin.basic_crud.Doamin.models.Group.Group
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface GroupRepositoryAdapter : JpaRepository<Group, Long> {
}