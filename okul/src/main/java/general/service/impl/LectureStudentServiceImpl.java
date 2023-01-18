package general.service.impl;

import general.dto.LectureStudentDto;
import general.service.LectureStudentService;
import org.springframework.stereotype.Service;
import general.repository.LectureStudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LectureStudentServiceImpl implements LectureStudentService {
    private final LectureStudentRepository lectureStudentRepository;

    public LectureStudentServiceImpl(LectureStudentRepository lectureStudentRepository) {
        this.lectureStudentRepository = lectureStudentRepository;
    }

    @Override
    public List<LectureStudentDto> getAll() {
        return null;
    }

    @Override
    public Optional<LectureStudentDto> getById(long id) {
        return Optional.empty();
    }

    @Override
    public LectureStudentDto add(LectureStudentDto data) {
        return null;
    }

    @Override
    public void delete(LectureStudentDto data) {

    }

    @Override
    public LectureStudentDto update(LectureStudentDto data) {
        return null;
    }
}
