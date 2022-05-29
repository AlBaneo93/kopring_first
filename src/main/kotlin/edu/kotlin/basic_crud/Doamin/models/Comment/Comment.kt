package edu.kotlin.basic_crud.Doamin.models.Comment

import edu.kotlin.basic_crud.Doamin.models.Post.Post
import edu.kotlin.basic_crud.Doamin.models.User.User
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import java.util.LongSummaryStatistics
import javax.persistence.*

@Entity
data class Comment(
  @Id @GeneratedValue private val seq: Long,
  private val content: String,
  @CreationTimestamp private val createdAt: LocalDateTime,
  @UpdateTimestamp private val updatedAt: LocalDateTime,
  @OneToOne private val author: User,
  @ManyToOne private val post: Post,
  private val parentId: Long,
  private val bundleId: Long,
  private val depth: Int,
)
