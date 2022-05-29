package edu.kotlin.basic_crud.Adapter.Out

import edu.kotlin.basic_crud.Doamin.models.Post.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepositoryAdaptor : JpaRepository<Post, Long> {


}