package org.example.projects.project2.service;


import org.example.projects.project2.data.HashMapDb;
import org.example.projects.project2.exception.LecturerNotFoundException;
import org.example.projects.project2.model.Lecturer;

import java.util.ArrayList;
import java.util.List;

public class LecturerService implements LecturerServiceInterface {

    //Add a new lecturer
    @Override
    public void addLecturer(Lecturer lecturer) {
        if (lecturer == null || lecturer.getId() == null) throw new IllegalArgumentException("Invalid lecturer data");
        HashMapDb.lecturers.put(lecturer.getId(), lecturer);
        System.out.println("Lecturer added: " + lecturer.getFirstName() + " " + lecturer.getLastName());
    }

    //Update lecturer info
    @Override
    public void updateLecturer(Lecturer lecturer) {
        if (!HashMapDb.lecturers.containsKey(lecturer.getId()))
            throw new LecturerNotFoundException("Lecturer not found");
        HashMapDb.lecturers.put(lecturer.getId(), lecturer);
        System.out.println("Lecturer updated: " + lecturer.getFirstName());
    }

    //Delete lecturer by ID
    @Override
    public void deleteLecturer(Long id) {
        if (!HashMapDb.lecturers.containsKey(id)) throw new LecturerNotFoundException("Lecturer not found");
        HashMapDb.lecturers.remove(id);
        System.out.println("Lecturer deleted (ID: " + id + ")");
    }

    //Get lecturer by ID
    @Override
    public Lecturer getLecturerById(Long id) {
        Lecturer lecturer = HashMapDb.lecturers.get(id);
        if (lecturer == null) throw new LecturerNotFoundException("Lecturer not found");
        return lecturer;
    }

    //Get list of all lecturers
    @Override
    public List<Lecturer> getLecturers() {
        return new ArrayList<>(HashMapDb.lecturers.values());
    }
}
