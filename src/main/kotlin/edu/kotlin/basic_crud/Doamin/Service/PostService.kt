package edu.kotlin.basic_crud.Doamin.Service

import edu.kotlin.basic_crud.Port.In.PostInboundPort
import edu.kotlin.basic_crud.Port.Out.PostRepositoryPort
import org.springframework.stereotype.Service

// Service는 Domain에 의존성이 있어야 한다.
// inbound Port를 구현하고,
// outbound port에 의존성이 있어야 한다
// PostService가 구현(implements)하는 PostIboundPort를 InboundAdapter에서 의존성을 가지면,
// InboundPort를 구현하는 객체를 InboundAdapter에서 사용할 수 있도록 한다
@Service
class PostService(
  private val postRepositoryPort: PostRepositoryPort
) : PostInboundPort {

  override fun createNewPost() {
    TODO("Not yet implemented")
  }

  override fun deletePostById(id: Long) {
    TODO("Not yet implemented")
  }

  override fun updatePostById(id: Long) {
    TODO("Not yet implemented")
  }

  override fun getPostById(id: Long) {
    TODO("Not yet implemented")
  }

  override fun getAllPosts() {
    TODO("Not yet implemented")
  }
}