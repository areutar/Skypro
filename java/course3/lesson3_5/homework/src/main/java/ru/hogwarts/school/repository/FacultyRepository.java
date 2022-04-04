package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Collection<Faculty> findFacultiesByColorIgnoreCase(String color);

    Collection<Faculty> findFacultiesByNameIgnoreCase(String name);

    Faculty findFacultyByColor(String color);

    Faculty findFacultyByName(String name);

}
