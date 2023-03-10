package general.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(unique = true)
    private long number;

    @Column(length = 2)
    private long age;

    @OneToMany(mappedBy = "student", cascade ={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private Set<LectureStudent> lectureStudents;



}
