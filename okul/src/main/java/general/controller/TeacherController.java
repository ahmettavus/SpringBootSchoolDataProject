package general.controller;

import general.dto.TeacherDto;
import general.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class TeacherController {
    private final TeacherService teacherService;


    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/getall")
    public List<TeacherDto> getAll() {
        return teacherService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public Optional<TeacherDto> getById(@PathVariable long id) {
        return teacherService.getById(id);
    }

    @PostMapping("/add")
    public TeacherDto add(@RequestBody TeacherDto ogretmenDto) {
        return teacherService.add(ogretmenDto);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody TeacherDto ogretmenDto) {
        teacherService.delete(ogretmenDto);
    }

    @PutMapping("/update")
    public TeacherDto update(@RequestBody TeacherDto ogretmenDto) {

        return teacherService.update(ogretmenDto);
    }
}