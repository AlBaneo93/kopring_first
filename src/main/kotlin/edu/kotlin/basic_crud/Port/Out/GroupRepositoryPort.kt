package edu.kotlin.basic_crud.Port.Out

import edu.kotlin.basic_crud.Doamin.models.Group.Group
import java.util.*

interface GroupRepositoryPort {

  fun saveGroupInfo(group: Group): Group

  fun updateGroupInfo(group: Group): Group

  fun getAllGroups(): MutableList<Group>

  fun getGroupById(id: Long): Optional<Group>

  fun deleteGroupById(group: Group): Boolean
}