package edu.kotlin.basic_crud.Adapter.Out

import edu.kotlin.basic_crud.Doamin.models.Group.Group
import edu.kotlin.basic_crud.Doamin.models.Group.GroupRepository
import edu.kotlin.basic_crud.Port.Out.GroupRepositoryPort
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Component
import java.util.*

@Slf4j
@Component
class GroupPersistAdapter(
  private val groupRepository: GroupRepository
) : GroupRepositoryPort {

  override fun saveGroupInfo(group: Group): Group = groupRepository.save(group)

  override fun updateGroupInfo(group: Group): Group = groupRepository.saveAndFlush(group)

  override fun getAllGroups(): MutableList<Group> = groupRepository.findAll()

  override fun getGroupById(id: Long): Optional<Group> = groupRepository.findById(id)

  override fun deleteGroupById(group: Group): Boolean {
    groupRepository.delete(group)
    return true
  }


}