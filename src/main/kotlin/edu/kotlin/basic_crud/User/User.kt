package edu.kotlin.basic_crud.User

import edu.kotlin.basic_crud.Group.Group
import edu.kotlin.basic_crud.Group.GroupUser
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "job_user")
data class User(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private val seq: Long,
  private val id: String,
  private val password: String,
  private val name: String,
  private val isAdmin: Boolean,

  @Enumerated(EnumType.STRING)
  @ElementCollection

  private val authorities: Set<UserRole>,

  @CreationTimestamp
  private val createdAt: LocalDateTime,

  @UpdateTimestamp
  private val updatedAt: LocalDateTime,

  @OneToMany(mappedBy = "user") private val joinGroups: MutableSet<GroupUser>
) : UserDetails {

  override fun getAuthorities(): MutableCollection<out GrantedAuthority> = authorities.map {
    SimpleGrantedAuthority(it.name)
  }.toMutableSet()


  override fun getPassword(): String = this.password

  override fun getUsername(): String = this.id

  override fun isAccountNonExpired(): Boolean = true

  override fun isAccountNonLocked(): Boolean = true

  override fun isCredentialsNonExpired(): Boolean = true

  override fun isEnabled(): Boolean = true
}


enum class UserRole(val code: Int, val type: String) {
  USER(0, "user"),
  DEVELOPER(1, "developer"),
  STAFF(2, "staff"),
  ADMIN(3, "admin");
}