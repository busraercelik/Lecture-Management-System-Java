package studentmgmt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentmgmt.models.Lecture;
import studentmgmt.repo.LectureRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class LectureServiceImpl implements LectureService {

    LectureRepo lecRepo;
    // when you want spring to inject an object/instance into a field then you use @Autowired
    @Autowired
    public LectureServiceImpl(LectureRepo lecRepo) {
        this.lecRepo = lecRepo;
    }

    @Override
    public List<String> getAllTeacherNames() {
        //get all the lectures from the db
        List<Lecture> allLecturesInSystem = lecRepo.getAllLectures();
        List<String> teacherNames = new ArrayList<String>();

        //loop through all the lectures & keep adding teacher names
        //from each lecture in the teachers list
        for(Lecture lecture: allLecturesInSystem){
            teacherNames.add(lecture.getTeacherName());
        }
        //return all the teacher names as result
        return teacherNames;
    }

    @Override
    public List<String> getAllTopicsLongerThanDuration(int lectureDuration) {
        List<Lecture> allLecturesInTheSystem = lecRepo.getAllLectures();
        List<String> allTopicNames = new ArrayList<>();

        for(Lecture lecture: allLecturesInTheSystem){
            if(lecture.getTotalTime() > lectureDuration){
                allTopicNames.add(lecture.getTopic());
            }
        }
        return allTopicNames;
    }
}
