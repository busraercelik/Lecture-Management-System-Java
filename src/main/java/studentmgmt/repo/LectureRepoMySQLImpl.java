package studentmgmt.repo;

import studentmgmt.models.Lecture;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LectureRepoMySQLImpl implements LectureRepo {
    // JDBC driver name and database URL
    //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/lecture-management-system";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";
    Connection conn = null;

    public LectureRepoMySQLImpl(){
        try {
            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        }
        catch(java.sql.SQLException exception){
            exception.printStackTrace();
        }
    }

    //read operation
    @Override
    public List<Lecture> getAllLectures(){
        Statement stmt = null;
        try{
            //STEP 4: Execute a query
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM lectures";
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Lecture> lectures = new ArrayList<>();

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                String name  = rs.getString("name");
                String topic = rs.getString("topic");
                String teacherName = rs.getString("teacher_name");
                int totalTime = rs.getInt("total_time");

                //Display values
                lectures.add(new Lecture(id, name, topic, teacherName, totalTime));
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            return lectures;

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Lecture getLectureById(int id) {

        Statement stmt = null;
        try{
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM lectures where id="+id;
            ResultSet rs = stmt.executeQuery(sql);
            Lecture lecture = null;

            while(rs.next()){
                int lecId  = rs.getInt("id");
                String name  = rs.getString("name");
                String topic = rs.getString("topic");
                String teacherName = rs.getString("teacher_name");
                int totalTime = rs.getInt("total_time");

                lecture= new Lecture(lecId, name, topic, teacherName, totalTime);
            }

            rs.close();
            stmt.close();
            return lecture;

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveLecture(Lecture lecture) {
            Statement stmt = null;
            try{
                //STEP 4: Execute a query
                stmt = conn.createStatement();
                String sql = "INSERT INTO lectures (`name`, `topic`, `teacher_name`, `total_time`)"
                        +  "VALUES ('"+lecture.getName()+"', '"
                        +lecture.getTopic()+"', '"
                        +lecture.getTeacherName()+"', '"
                        +lecture.getTotalTime()+"')";

                stmt.executeUpdate(sql);

                System.out.println("Inserted records into the table...");

            }catch(SQLException se){
                //Handle errors for JDBC
                se.printStackTrace();
            }catch(Exception e){
                //Handle errors for Class.forName
                e.printStackTrace();
            }
        }


    @Override
    public void saveLectures(List<Lecture> lectures) {
        for (Lecture l:lectures) {
            this.saveLecture(l);
        }
    }

    @Override
    public void updateLecture(Lecture lecture) {
        Statement stmt = null;
        try{
            //STEP 4: Execute a query
            stmt = conn.createStatement();
            String sql = "UPDATE lectures " +
                    "SET name='"+lecture.getName()+"' WHERE id="+lecture.getId();
            stmt.executeUpdate(sql);
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLecture(Lecture lecture) {
        Statement stmt = null;
        try{
            stmt = conn.createStatement();
            String sql = "DELETE FROM lectures " +
                    "WHERE id ="+lecture.getId();
            stmt.executeUpdate(sql);

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }

}
