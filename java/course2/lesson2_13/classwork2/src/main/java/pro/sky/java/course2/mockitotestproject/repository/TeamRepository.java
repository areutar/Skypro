package pro.sky.java.course2.mockitotestproject.repository;

import java.util.Collection;

public interface TeamRepository {
    String add(String teamName);

    String remove(String teamName);

    String find(String teamName);

    Collection<String> findAll();

    Collection<String> removeAll();
}