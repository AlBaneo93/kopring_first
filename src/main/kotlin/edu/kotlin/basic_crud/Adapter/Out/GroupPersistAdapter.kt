package edu.kotlin.basic_crud.Adapter.Out

import edu.kotlin.basic_crud.Doamin.models.Group.Group
import edu.kotlin.basic_crud.Port.Out.GroupRepositoryPort
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Component
import java.util.*

@Slf4j
@Component
class GroupPersistAdapter(
  private val groupRepositoryAdapter: GroupRepositoryAdapter
) : GroupRepositoryPort {

  override fun saveGroupInfo(group: Group): Group = groupRepositoryAdapter.save(group)

  override fun updateGroupInfo(group: Group): Group = groupRepositoryAdapter.saveAndFlush(group)

  override fun getAllGroups(): MutableList<Group> = groupRepositoryAdapter.findAll()

  override fun getGroupById(id: Long): Optional<Group> = groupRepositoryAdapter.findById(id)

  override fun deleteGroupById(group: Group): Boolean {
    groupRepositoryAdapter.delete(group)
    return true
  }


}