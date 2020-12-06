package studentmgmt;

//STEP 1. Import required packages
import studentmgmt.models.Lecture;
import studentmgmt.repo.LectureRepo;
import studentmgmt.repo.LectureRepoImpl;

public class AppRunner {

    public static void main(String[] args) {
        LectureRepo lec = new LectureRepoImpl();
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
        lec.updateLecture(lecture);
        //lec.deleteLecture(lecture);
    }

}