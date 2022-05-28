package edu.kotlin.basic_crud.Adapter.In

import edu.kotlin.basic_crud.Doamin.models.Group.Group
import edu.kotlin.basic_crud.Port.In.GroupInboundPort
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/group")
class GroupController(private val groupPort: GroupInboundPort) {

  @GetMapping("/{id}")
  fun getGroupBySeq(@PathVariable("id") id: Long): Group? {
    return groupPort.getGroupById(id)
  }

  @PostMapping
  fun addGroup(@RequestBody group: Group): Group {
    // TODO 2022-05-28, 토, 13:51 : Group으로 받지 않고 다른 방법으로 받아야 한다
    return groupPort.createGroup()
  }

  @PutMapping
  fun updateGroup(@RequestBody group: Group): Group {
    return groupPort.updateGroup()
  }

  @DeleteMapping
  fun deleteGroup(@RequestBody group: Group): Boolean {
    try {
      groupPort.deleteGroup()
      return true
    } catch (e: Exception) {
      throw Exception(e.cause)
    }
  }

  @DeleteMapping("/{id}")
  fun deleteGroup(@PathVariable("id") seq: Long): Boolean {
    try {
      groupPort.deleteGroup()
      return true
    } catch (e: Exception) {
      throw Exception(e.cause)
    }
  }
}