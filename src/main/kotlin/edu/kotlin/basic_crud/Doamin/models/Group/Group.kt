package edu.kotlin.basic_crud.Doamin.models.Group

import edu.kotlin.basic_crud.Doamin.models.User.User
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "groups")
data class Group(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private val seq: Long,
  private val name: String,
  @CreationTimestamp private val createdAt: LocalDateTime,
  @UpdateTimestamp private val lastUpdate: LocalDateTime,
  private val endedAt: LocalDateTime,
//  @OneToOne
//  private val creator: User,
  @OneToMany(mappedBy = "group") private val members: MutableSet<GroupUser>
)

@Entity
@Table(name = "group_user")
data class GroupUser(
  @EmbeddedId val seq: CompositeUserGroupKey,
  @ManyToOne @MapsId("user_seq") @JoinColumn(name = "user_seq") private val user: User,
  @ManyToOne @MapsId("group_seq") @JoinColumn(name = "group_seq") private val group: Group
)

// composite key (복합키)를 jpa로 정의하기
@Embeddable
@Table(name = "group_user")
class CompositeUserGroupKey(
  @Column(name = "user_seq") private val userSeq: Long, @Column(name = "group_seq") private val groupSeq: Long
) : java.io.Serializable