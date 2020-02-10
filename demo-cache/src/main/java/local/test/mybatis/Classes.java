package local.test.mybatis;

import java.io.Serializable;
import java.util.List;

// 使用MyBatis自带的二级缓存必须Serializable，使用EhCache不需要
public class Classes implements Serializable {

    private int id;
    private String name;

    private List<Student> students;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
