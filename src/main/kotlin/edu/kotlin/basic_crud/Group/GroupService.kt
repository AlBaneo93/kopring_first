package edu.kotlin.basic_crud.Group

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

interface GroupService {
    fun getAllGroups(): MutableList<Group>

    fun getGroupBySeq(seq: Long): Group?

    fun addGroup(group: Group): Group

    fun deleteGroup(group: Group)

    fun deleteGroup(seq: Long)

    fun updateGroup(group: Group): Group
}

@Service
class GroupServiceImpl(private val groupRepository: GroupRepository) : GroupService {
    override fun getAllGroups(): MutableList<Group> {
        return groupRepository.findAll()
    }

    override fun getGroupBySeq(seq: Long): Group? {
        return groupRepository.findByIdOrNull(seq)
    }

    override fun addGroup(group: Group): Group {
        return groupRepository.save(group)
    }

    override fun deleteGroup(group: Group) {
        groupRepository.delete(group)
    }

    override fun deleteGroup(seq: Long) {
        groupRepository.deleteById(seq)
    }

    override fun updateGroup(group: Group): Group {
        return groupRepository.saveAndFlush(group)
    }

}