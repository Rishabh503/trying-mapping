package com.example.codingshuttle.demomapping.demomappingnew.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
//@Data yaaha se bhi hatao
@Getter @Setter

@Table(name="departments")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @OneToOne
    @JoinColumn(name="departments_manager")
    private EmployeeEntity manager;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DepartmentEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getTitle(), that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle());
    }

    @OneToMany(mappedBy = "workerDepartment",fetch = FetchType.EAGER)
//    @JsonIgnore
    private Set<EmployeeEntity> workers;


    @ManyToMany(mappedBy = "freelanceDepartments")
    private Set<EmployeeEntity> freelancers;
}
