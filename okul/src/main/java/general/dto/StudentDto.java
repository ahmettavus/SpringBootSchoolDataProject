package general.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentDto {
    private long id;
    private String name;
    private long number;
    private long age;
    private Set<LectureStudentDto> lectureStudents;
}
