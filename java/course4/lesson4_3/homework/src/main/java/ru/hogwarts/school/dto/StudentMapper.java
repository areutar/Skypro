package ru.hogwarts.school.dto;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.model.Student;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class StudentMapper {
    private final ModelMapper mapper;

    public StudentMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @PostConstruct
    private void setupMapper() {
        this.mapper.getConfiguration().setSkipNullEnabled(true);
        Converter<Avatar, Boolean> nonNullObject =
                mappingContext -> Objects.nonNull(mappingContext.getSource());
        mapper.createTypeMap(Student.class, StudentDto.class)
                .addMapping(student -> student.getFaculty().getName(), StudentDto::setFaculty)
                .addMappings(mapper -> mapper.using(nonNullObject)
                        .map(Student::getAvatar, StudentDto::setAvatar));
    }

    public Student toEntity(StudentDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Student.class);
    }

    public StudentDto toDto(Student entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, StudentDto.class);
    }
}