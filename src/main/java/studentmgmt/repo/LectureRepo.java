package studentmgmt.repo;

import studentmgmt.models.Lecture;

import java.util.ArrayList;
import java.util.List;
//CRUD operations
//Create
//Read
//Update
//Delete

// separation of logic, meaning a class will only do one type of job
// example: repository classes only deal with Databases
public interface LectureRepo {

    // returns data from database
    List<Lecture> getAllLectures();
    Lecture getLectureById(int id);
    void saveLecture(Lecture lecture);
    void saveLectures(List<Lecture> lectures);
    void updateLecture(Lecture lecture);
    void deleteLecture(Lecture lecture);
    
}
