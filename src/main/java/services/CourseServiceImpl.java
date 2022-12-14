package services;

import com.springrest.springrest.entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    List<Course> list;

    public CourseServiceImpl(){
        list = new ArrayList<>();
        list.add(new Course(145,"Java Core Course","This course contains basic of java"));
        list.add(new Course(433,"spring boot course","creating rest api course"));
    }

    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourse(long courseId) {
        Course c = null;

        for(Course course:list){
            if(course.getId()==courseId){
                c = course;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {

        for(Course curCourse: list){
            if(curCourse.getId()==course.getId()){
                curCourse.setTitle(course.getTitle());
                curCourse.setDescription(course.getDescription());
                break;
            }
        }
        return course;
    }

    @Override
    public void deleteCourse(long parseLong) {
        for(Course course:list){
            if(course.getId()==parseLong){
                list.remove(course);
                break;
            }
        }
    }

}
