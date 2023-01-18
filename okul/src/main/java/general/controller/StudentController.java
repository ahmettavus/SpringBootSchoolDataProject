package general.controller;

import general.dto.StudentDto;
import org.springframework.web.bind.annotation.*;
import general.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/getall")
    public List<StudentDto> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public Optional<StudentDto> getById(@PathVariable long id) {
        return studentService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody StudentDto studentDto) {
        studentService.add(studentDto);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody StudentDto studentDto) {
        studentService.delete(studentDto);
    }

    @PutMapping("/update")
    public void update(@RequestBody StudentDto studentDto) {
        studentService.update(studentDto);
    }
}
