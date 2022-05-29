package edu.kotlin.basic_crud.Port.In

interface PostInboundPort {

  fun createNewPost()

  fun deletePostById(id: Long)

  fun updatePostById(id: Long)

  fun getPostById(id: Long)

  fun getAllPosts()
}