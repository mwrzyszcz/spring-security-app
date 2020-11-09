package pl.security.springsecurityapp.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "role")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  private RoleName name;

  @Column(length = 100)
  private String description;
}
