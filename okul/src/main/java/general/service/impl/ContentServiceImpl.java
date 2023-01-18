package general.service.impl;

import general.dto.ContentDto;
import general.entity.Content;
import general.service.ContentService;
import org.springframework.stereotype.Service;
import general.repository.ContentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ContentServiceImpl implements ContentService {
    private final ContentRepository contentRepository;

    public ContentServiceImpl(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Override
    public List<ContentDto> getAll() {
        List<ContentDto> contentDtoList = new ArrayList<>();
        contentRepository.findAll().forEach(content -> {
            ContentDto contentDto = new ContentDto();
            entityToDto(content,contentDto);
            contentDtoList.add(contentDto);

        });
        return contentDtoList;
    }

    @Override
    public Optional<ContentDto> getById(long id) {
        Optional<ContentDto> contentDto = Optional.of(new ContentDto());
        Content content = contentRepository.findById(id).orElseThrow(() -> new RuntimeException("Content could not founded!"));
        entityToDto(content, contentDto.get());

        return contentDto;
    }

    @Override
    public ContentDto update(ContentDto contentDto) {
        Optional<ContentDto> contentDtoOptional = Optional.of(getById(contentDto.getId()).orElseThrow());
        contentDtoOptional.get().setName(contentDto.getName());
        Content content = new Content();
        dtoToEntity(contentDto,content);
        content=contentRepository.save(content);
        entityToDto(content,contentDto);
        return contentDto;
    }
    @Override
    public ContentDto add(ContentDto contentDto) {
       Content content = new Content();
       dtoToEntity(contentDto,content);
      content= contentRepository.save(content);
       entityToDto(content,contentDto);
       return contentDto;
    }

    @Override
    public void delete(ContentDto contentDto) {
        Content content = new Content();
        dtoToEntity(contentDto,content);
        contentRepository.delete(content);
        entityToDto(content,contentDto);

    }


    protected void dtoToEntity(ContentDto contentDto, Content content){
        contentDto.setId(content.getId());
        contentDto.setName(content.getName());
    }

    protected void entityToDto(Content content,ContentDto contentDto){
        content.setId(contentDto.getId());
        content.setName(contentDto.getName());
    }
}
