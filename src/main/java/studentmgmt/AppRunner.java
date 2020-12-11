package studentmgmt;

//STEP 1. Import required packages
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import studentmgmt.models.Lecture;
import studentmgmt.repo.LectureRepo;
import studentmgmt.repo.LectureRepoMySQLImpl;
import studentmgmt.services.LectureService;
import studentmgmt.services.LectureServiceImpl;

@SpringBootApplication
public class AppRunner implements CommandLineRunner {

    @Autowired
    LectureService lectureService;

    public static void main(String[] args) {
        SpringApplication.run(AppRunner.class, args);
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


    @Override
    public void run(String... args) throws Exception {
        //dependency injection : TODO read about it
/*        LectureRepo lec = new LectureRepoMySQLImpl();
        LectureService lectureService = new LectureServiceImpl(lec);*/

        System.out.println(lectureService.getAllTeacherNames());
        System.out.println(lectureService.getAllTopicsLongerThanDuration(2));
    }
}