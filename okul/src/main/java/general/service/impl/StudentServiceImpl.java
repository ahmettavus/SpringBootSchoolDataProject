package general.service.impl;

import general.dto.StudentDto;
import general.entity.Student;
import general.service.StudentService;
import org.springframework.stereotype.Service;
import general.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final LectureStudentServiceImpl lectureStudentService;

    public StudentServiceImpl(StudentRepository studentRepository, LectureStudentServiceImpl lectureStudentService) {
        this.studentRepository = studentRepository;
        this.lectureStudentService = lectureStudentService;
    }

    @Override
    public List<StudentDto> getAll() {
        List<StudentDto> studentDtoList = new ArrayList<>();
        List<StudentDto> finalstudentDtoList = studentDtoList;
        studentRepository.findAll().forEach(student -> {
            StudentDto studentDto = new StudentDto();
            entityToDto(student,studentDto);
            finalstudentDtoList.add(studentDto);
        });
        return studentDtoList;
    }

    @Override
    public Optional<StudentDto> getById(long id) {
        StudentDto studentDto = new StudentDto();
        entityToDto(studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Student could not be found!")), studentDto);
        return Optional.of(studentDto);
    }

    @Override
    public StudentDto update(StudentDto studentDto) {
        Optional<StudentDto> studentDtoOptional = Optional.of(getById(studentDto.getId()).orElseThrow());
        studentDto.setId(studentDtoOptional.get().getId());
        Student student = new Student();
        entityToDto(studentRepository.save(student),studentDto);
        return studentDto;
    }

    @Override
    public StudentDto add(StudentDto studentDto) {
        Student student = new Student();
        dtoToEntity(studentDto,student);
       student= studentRepository.save(student);
        entityToDto(student,studentDto);
        return studentDto;
    }

    @Override
    public void delete(StudentDto studentDto) {
        Student student = new Student();
        dtoToEntity(studentDto,student);
        studentRepository.delete(student);
       // entityToDto(student,studentDto);

    }


    private void entityToDto(Student student,StudentDto studentDto){
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setNumber(student.getNumber());
        studentDto.setAge(student.getAge());

    }
    private void dtoToEntity(StudentDto studentDto,Student student){
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setNumber(studentDto.getNumber());
        student.setAge(studentDto.getAge());
    }
}
