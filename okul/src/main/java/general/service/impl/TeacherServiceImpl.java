package general.service.impl;

import general.dto.TeacherDto;
import general.entity.Teacher;
import general.service.TeacherService;
import org.springframework.stereotype.Service;
import general.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final StudentServiceImpl studentService;

    public TeacherServiceImpl(TeacherRepository teacherRepository, StudentServiceImpl studentService) {
        this.teacherRepository = teacherRepository;
        this.studentService = studentService;
    }

    @Override
    public List<TeacherDto> getAll() {
        List<TeacherDto> teacherDtoList = new ArrayList<>();
        teacherRepository.findAll().forEach(teacher -> {
            TeacherDto teacherDto = new TeacherDto();
            entityToDto(teacher,teacherDto);
            teacherDtoList.add(teacherDto);
        });
        return teacherDtoList;
    }

    @Override
    public Optional<TeacherDto> getById(long id) {
        Optional<TeacherDto> teacherDto = Optional.of(new TeacherDto());
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new RuntimeException("Teacher could not be found!"));
        entityToDto(teacher, teacherDto.get());
        return teacherDto;
    }

    @Override
    public TeacherDto add(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        dtoToEntity(teacherDto, teacher);
        teacher = teacherRepository.save(teacher);
        entityToDto(teacher,teacherDto);
        return teacherDto;
    }

    @Override
    public void delete(TeacherDto teacherDto) {
    Teacher teacher = new Teacher();
    dtoToEntity(teacherDto,teacher);
    teacherRepository.delete(teacher);

    }

    @Override
    public TeacherDto update(TeacherDto teacherDto) {
        Optional<TeacherDto> teacherDtoOptional = Optional.of(getById(teacherDto.getId()).orElseThrow());
        teacherDtoOptional.get().setName(teacherDto.getName());
        Teacher teacher = new Teacher();
        dtoToEntity(teacherDto, teacher);
        entityToDto(teacherRepository.save(teacher), teacherDto);
        return teacherDto;
    }

    private void entityToDto(Teacher teacher, TeacherDto teacherDto) {
        teacherDto.setId(teacher.getId());
        teacherDto.setName(teacher.getName());
        teacherDto.setAge(teacher.getAge());
        teacherDto.setGicik(teacher.isGicik());

    }

    private void dtoToEntity(TeacherDto teacherDto, Teacher teacher){
        teacher.setId(teacherDto.getId());
        teacher.setName(teacherDto.getName());
        teacher.setAge(teacherDto.getAge());
        teacher.setGicik(teacherDto.isGicik());
    }
}
