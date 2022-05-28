package edu.kotlin.basic_crud.Doamin.Service

import edu.kotlin.basic_crud.Doamin.models.Group.Group
import edu.kotlin.basic_crud.Infrastructures.exceptions.UserNotFoundException
import edu.kotlin.basic_crud.Port.In.GroupInboundPort
import edu.kotlin.basic_crud.Port.Out.GroupRepositoryPort
import org.springframework.stereotype.Service

// 영속성 모듈을 호출하는 포트(Outbound Port)를 의존성으로 받음
@Service
class GroupService(private val groupRepoPort: GroupRepositoryPort) : GroupInboundPort {

  override fun createGroup(): Group {
    val group = null
    groupRepoPort.saveGroupInfo(group!!)
  }

  override fun deleteGroup(): Boolean {
    val group = null
    groupRepoPort.deleteGroupById(group!!)
  }

  override fun updateGroup(): Group {
    val group = null
    return groupRepoPort.updateGroupInfo(group = group!!)
  }

  override fun getAllGroups(): MutableList<Group> = groupRepoPort.getAllGroups()

  override fun getGroupById(groupId: Long): Group = groupRepoPort.getGroupById(groupId).orElseThrow { UserNotFoundException("id not in here") }

}

//interface GroupService {
//
//  fun getAllGroups(): MutableList<Group>
//
//  fun getGroupBySeq(seq: Long): Group?
//
//  fun addGroup(group: Group): Group
//
//  fun deleteGroup(group: Group)
//
//  fun deleteGroup(seq: Long)
//
//  fun updateGroup(group: Group): Group
//}
//
//@Service
//open class GroupServiceImpl(private val groupRepository: GroupRepository) : GroupService {
//
//  override fun getAllGroups(): MutableList<Group> {
//    return groupRepository.findAll()
//  }
//
//  override fun getGroupBySeq(seq: Long): Group? {
//    return groupRepository.findByIdOrNull(seq)
//  }
//
//  override fun addGroup(group: Group): Group {
//    return groupRepository.save(group)
//  }
//
//  override fun deleteGroup(group: Group) {
//    groupRepository.delete(group)
//  }
//
//  override fun deleteGroup(seq: Long) {
//    groupRepository.deleteById(seq)
//  }
//
//  override fun updateGroup(group: Group): Group {
//    return groupRepository.saveAndFlush(group)
//  }
//
//}
