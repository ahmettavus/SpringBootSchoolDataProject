package general.service.impl;

import general.dto.LectureDto;
import general.entity.Lecture;
import general.service.LectureService;
import org.springframework.stereotype.Service;
import general.repository.LectureRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class LectureServiceImpl implements LectureService {
    private final LectureRepository lectureRepository;
    private final ContentServiceImpl contentService;
    private final LectureStudentServiceImpl lectureStudentService;



    public LectureServiceImpl(LectureRepository lectureRepository, ContentServiceImpl contentService, LectureStudentServiceImpl lectureStudentService) {
        this.lectureRepository = lectureRepository;
        this.contentService = contentService;
        this.lectureStudentService = lectureStudentService;

    }

    @Override
    public List<LectureDto> getAll() {
        List<LectureDto> lectureDtoList = new ArrayList<>();
        lectureRepository.findAll().forEach(lecture -> {
            LectureDto lectureDto = new LectureDto();
            entityToDto(lecture,lectureDto);
            lectureDtoList.add(lectureDto);
        });
        return lectureDtoList;
    }

    @Override
    public Optional<LectureDto> getById(long id) {
        Optional<LectureDto> lectureDto = Optional.of(new LectureDto());
        Optional<Lecture> lecture = lectureRepository.findById(id);
        entityToDto(lecture.orElseGet(Lecture::new), lectureDto.get());
        return lectureDto;
    }

    @Override
    public LectureDto add(LectureDto lectureDto) {
        Lecture lecture = new Lecture();
        dtoToEntity(lectureDto, lecture);
      lecture=  lectureRepository.save(lecture);
        entityToDto(lecture,lectureDto);
        return lectureDto;
    }

    @Override
    public void delete(LectureDto lectureDto) {
    Lecture lecture = new Lecture();
    dtoToEntity(lectureDto,lecture);
    lectureRepository.delete(lecture);
    entityToDto(lecture,lectureDto);

    }

    @Override
    public LectureDto update(LectureDto lectureDto) {
        Optional<LectureDto> optionalLectureDto = Optional.of(getById(lectureDto.getId()).orElseThrow());
        Lecture lecture = new Lecture();
        dtoToEntity(optionalLectureDto.get(),lecture);
        entityToDto(lectureRepository.save(lecture),lectureDto);
        return lectureDto;
    }

    protected void entityToDto(Lecture lecture, LectureDto lectureDto){
       lectureDto.setId(lecture.getId());
       lectureDto.setLectureName(lecture.getLectureName());

    }

    protected void dtoToEntity(LectureDto lectureDto, Lecture lecture){
        lecture.setId(lectureDto.getId());
        lecture.setLectureName(lectureDto.getLectureName());
    }

}
