package studentmgmt;

//STEP 1. Import required packages
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import studentmgmt.models.Lecture;
import studentmgmt.services.LectureService;

@SpringBootApplication
public class AppRunnerController implements CommandLineRunner {

    @Autowired
    LectureService lectureService;

    public static void main(String[] args) {
        SpringApplication.run(AppRunnerController.class, args);
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
        LectureService lectureService = new LectureServiceImpl();*/

        /*Lecture inputFromUser = getLectureFromUser();

        lectureService.saveLecture(inputFromUser);

        System.out.println(lectureService.getAllTeacherNames());
        System.out.println(lectureService.getAllTopicsLongerThanDuration(2));*/
       /* for (Lecture l:lectureService.getAllLectures()){
            System.out.println(l);
        }
        */
        //update the lecture by a id and a name
        lectureService.updateNameInLectureById(1,"computer science");
        //get the lecture by id, and check if the name has changed
        Lecture updatedLecture = lectureService.getLectureById(1);
        System.out.println(updatedLecture);
    }

    public Lecture getLectureFromUser(){
        Lecture inputLec=new Lecture();
        inputLec.setName("Artificial Intelligence");
        inputLec.setTotalTime(96);
        inputLec.setTopic("Advanced statistics");
        inputLec.setTeacherName("Buyuk Ercelik");
        return inputLec;
    }
}