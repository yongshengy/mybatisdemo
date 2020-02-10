package local.test.mybatis;

import java.util.List;

public class Classes {

    private int id;
    private String name;

    private List<NewStudent> newStudents;

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

    public List<NewStudent> getNewStudents() {
        return newStudents;
    }

    public void setNewStudents(List<NewStudent> newStudents) {
        this.newStudents = newStudents;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
