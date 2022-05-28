package edu.kotlin.basic_crud.Group

import edu.kotlin.basic_crud.Adapter.In.GroupController
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@WebMvcTest(controllers = [GroupController::class])
@SpringBootTest
internal class GroupControllerTest(private val mock: MockMvc) {

  @Test
  @DisplayName("그룹 시퀀스로 조회")
  fun getGroupBySeq() {
    val seq = 1

    mock.perform(get("/api/grou/$seq"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print())
  }

  @Test
  @DisplayName("잘못된 시퀀스로 그룹 조회")
  fun getGroupBy_abnormalSeq() {

  }

  @Test
  @DisplayName("그룹을 추가한다")
  fun addGroup() {
  }

  @Test
  @DisplayName("그룹추가_필수데이터_없음")
  fun addGroup_without_required_data() {

  }

  @Test
  @DisplayName("그룹추가_데이터_검증_실패")
  fun addGroup_with_invalid_data() {

  }


  @Test
  fun updateGroup() {
  }

  @Test
  fun deleteGroup() {
  }

  @Test
  fun testDeleteGroup() {
  }

}