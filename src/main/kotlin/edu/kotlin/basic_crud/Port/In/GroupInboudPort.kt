package edu.kotlin.basic_crud.Port.In

import edu.kotlin.basic_crud.Doamin.models.Group.Group

interface GroupInboundPort {

  fun createGroup(): Group

  fun deleteGroup(): Boolean

  fun updateGroup(): Group

  fun getAllGroups(): MutableList<Group>

  fun getGroupById(groupId: Long): Group
}