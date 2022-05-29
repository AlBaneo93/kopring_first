package edu.kotlin.basic_crud.Port.Out

import edu.kotlin.basic_crud.Doamin.models.Post.Post

// Post Outbound Port
interface PostRepositoryPort {

  fun createdPost(post: Post): Post

  fun updatePost(post: Post): Post
  fun deletePost(post: Post): Boolean
  fun getPost(id: Long): Post
  fun getAllPosts(): MutableList<Post>

}