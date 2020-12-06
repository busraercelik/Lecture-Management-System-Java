package studentmgmt;

//STEP 1. Import required packages
import studentmgmt.repo.LectureRepo;
import studentmgmt.repo.LectureRepoImpl;

public class AppRunner {

    public static void main(String[] args) {
        LectureRepo lec = new LectureRepoImpl();
        System.out.println(lec.getAllLectures());
        System.out.println(lec.getLectureById(1));
    }

}