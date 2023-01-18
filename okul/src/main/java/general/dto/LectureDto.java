package general.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LectureDto {
    private long id;
    private String lectureName;
    private Set<ContentDto> contents;
    private Set<LectureStudentDto> lectureStudents;
}
