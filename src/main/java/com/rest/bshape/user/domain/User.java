package com.rest.bshape.user.domain;

import com.rest.bshape.bodytype.BodyType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 3)
    private String firstName;

    @NotEmpty
    @Size(min = 2)
    private String lastName;

    @NotNull
    private Integer age;

    @NotNull
    private Double weight;

    @NotNull
    private Double height;

    @NotNull
    private Integer sex;

    @NotNull
    @Size(min = 6)
    private String password;

    @Email
    @NotNull
    @Size(min = 5, max = 30)
    private String email;

    @OneToOne(fetch = FetchType.EAGER)
    private BodyType bodyType;

    @ManyToMany/*(fetch = FetchType.EAGER)*/
    private Set<Role> roles;

}
