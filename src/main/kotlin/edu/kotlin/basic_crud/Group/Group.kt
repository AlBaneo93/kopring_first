package edu.kotlin.basic_crud.Group

import edu.kotlin.basic_crud.User.User
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
data class Group(
  @Id @GeneratedValue private val seq: Long,
  private val name: String,
  @CreationTimestamp private val createdAt: LocalDateTime,
  private val endedAt: LocalDateTime,
  @UpdateTimestamp private val lastUpdate: LocalDateTime,
  @OneToOne private val creator: User,
  @OneToMany(mappedBy = "group") private val member: MutableSet<GroupUser>
)

@Entity
data class GroupUser(
  @EmbeddedId val id: CompositeUserGroupKey,
  @ManyToOne @MapsId("user_id") @JoinColumn(name = "user_id") private val user: User,
  @ManyToOne @MapsId("group_id") @JoinColumn(name = "group_id") private val group: Group
)

// composite key (복합키)를 jpa로 정의하기
@Embeddable
class CompositeUserGroupKey(
  @Column(name = "user_id") private val userId: Long,
  @Column(name = "group_id") private val groupId: Long
) : java.io.Serializable