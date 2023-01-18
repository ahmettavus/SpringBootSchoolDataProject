package general.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LectureStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int absence;
    private int note;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "Student_FK"))
    private Student student;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "Lecture_FK"))
    private Lecture lecture;
}
