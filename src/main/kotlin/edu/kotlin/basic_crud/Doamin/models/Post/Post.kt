package edu.kotlin.basic_crud.Doamin.models.Post

import edu.kotlin.basic_crud.Doamin.models.Comment.Comment
import edu.kotlin.basic_crud.Doamin.models.User.User
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import java.util.PrimitiveIterator
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
data class Post(
  @Id @GeneratedValue private val seq: Long,
  private val title: String,
  private val content: String?,
  @CreationTimestamp private val createdAt: LocalDateTime,
  @UpdateTimestamp private val updatedAt: LocalDateTime,
  @ManyToOne private val author: User,
  @OneToMany(mappedBy = "author") private val comments: MutableSet<Comment>
)
