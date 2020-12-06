package studentmgmt;

//STEP 1. Import required packages
import studentmgmt.models.Lecture;
import studentmgmt.repo.LectureRepo;
import studentmgmt.repo.LectureRepoImpl;
import studentmgmt.services.LectureService;
import studentmgmt.services.LectureServiceImpl;

public class AppRunner {

    public static void main(String[] args) {
        //dependency injection : TODO read about it
        LectureRepo lec = new LectureRepoImpl();
        LectureService lectureService = new LectureServiceImpl(lec);

        System.out.println(lectureService.getAllTeacherNames());
        System.out.println(lectureService.getAllTopicsLongerThanDuration(2));
    }

    public static void testRepoCode(){
        Lecture lecture = new Lecture();
       /* lecture.setName("physics");
        lecture.setTeacherName("Steve");
        lecture.setTopic("free fall");
        lecture.setTotalTime(4);*/
        lecture.setName("data structures");
        lecture.setId(4);

        //System.out.println(lec.getAllLectures());
        //System.out.println(lec.getLectureById(1));
        //lec.saveLecture(lecture);
        //lec.updateLecture(lecture);
        //lec.deleteLecture(lecture);
    }
}