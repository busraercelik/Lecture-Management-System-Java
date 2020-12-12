package studentmgmt.services;

import studentmgmt.models.Lecture;

import java.util.List;

public interface LectureService {
    List<String> getAllTeacherNames();
    List<String> getAllTopicsLongerThanDuration(int lectureDuration);
    void saveLecture(Lecture lecture);
    List<Lecture> getAllLectures();
    Lecture getLectureById(int id);
    void updateNameInLectureById(int id, String name);
}