package services;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseDao courseDao;

    public CourseServiceImpl(){

//        list = new ArrayList<>();
//        list.add(new Course(145,"Java Core Course","This course contains basic of java"));
//        list.add(new Course(433,"spring boot course","creating rest api course"));

    }

    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {
//        Course c = null;
//
//        for(Course course:list){
//            if(course.getId()==courseId){
//                c = course;
//                break;
//            }
//        }
        return courseDao.getOne(courseId);
    }

    @Override
    public Course addCourse(Course course) {
        courseDao.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {

        courseDao.save(course);
        return course;
    }

    @Override
    public void deleteCourse(long parseLong) {
            Course entity = courseDao.getOne(parseLong);
            courseDao.delete(entity);
    }

}
