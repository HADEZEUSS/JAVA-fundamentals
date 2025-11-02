package org.example.projects.project2.service;


import org.example.projects.project2.model.Lecturer;

import java.util.List;

public interface LecturerServiceInterface {
    void addLecturer(Lecturer lecturer);

    void updateLecturer(Lecturer lecturer);

    void deleteLecturer(Long id);

    Lecturer getLecturerById(Long id);

    List<Lecturer> getLecturers();
}
