package general.controller;

import general.dto.ContentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import general.service.ContentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
public class ContentController {
    @Autowired
    ContentService contentService;

    @GetMapping("/getall")
    ResponseEntity<List<ContentDto>> getAll() {
        return new ResponseEntity<>(contentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getbyid/{id}")
    ResponseEntity<Optional<ContentDto>> getById(@PathVariable long id) {
        return new ResponseEntity<>(contentService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    ContentDto add(@RequestBody ContentDto contentDto) {
        return contentService.add(contentDto);
    }

    @DeleteMapping("/delete")
    void delete(@RequestBody ContentDto contentDto) {
        contentService.delete(contentDto);
    }

    @PutMapping("/update")
    void update(@RequestBody ContentDto contentDto) {
        contentService.update(contentDto);
    }
}
