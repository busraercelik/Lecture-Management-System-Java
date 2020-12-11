package studentmgmt.repo;

import studentmgmt.models.Lecture;

import java.util.List;

//dummy implementation
public class LectureRepoMongoDBImpl implements LectureRepo{

    @Override
    public List<Lecture> getAllLectures() {
        return null;
    }

    @Override
    public Lecture getLectureById(int id) {
        return null;
    }

    @Override
    public void saveLecture(Lecture lecture) {

    }

    @Override
    public void saveLectures(List<Lecture> lectures) {

    }

    @Override
    public void updateLecture(Lecture lecture) {

    }

    @Override
    public void deleteLecture(Lecture lecture) {

    }
}
