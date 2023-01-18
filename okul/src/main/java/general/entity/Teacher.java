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
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    private boolean gicik;

    @OneToMany(mappedBy = "teacher", cascade = { CascadeType.REMOVE, CascadeType.PERSIST,CascadeType.MERGE})
    private Set<Lecture> lectures;

}
