package edu.kotlin.basic_crud.Group

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/group")
class GroupController(private val groupService: GroupService) {

    @GetMapping("/{id}")
    fun getGroupBySeq(@PathVariable("id") id: Long): Group? {
        return groupService.getGroupBySeq(id)
    }

    @PostMapping
    fun addGroup(@RequestBody group: Group): Group {
        return groupService.addGroup(group)
    }

    @PutMapping
    fun updateGroup(@RequestBody group: Group): Group {
        return groupService.updateGroup(group)
    }

    @DeleteMapping
    fun deleteGroup(@RequestBody group: Group): Boolean {
        try {
            groupService.deleteGroup(group)
            return true
        } catch (e: Exception) {
            throw Exception(e.cause)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteGroup(@PathVariable("id") seq: Long): Boolean {
        try {
            groupService.deleteGroup(seq)
            return true
        } catch (e: Exception) {
            throw Exception(e.cause)
        }
    }
}