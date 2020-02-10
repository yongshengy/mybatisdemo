package local.test.mybatis;

public interface StudentMapper {

    public Student findById(int id);

    public Student findById1(int id);

    public Student findByName(String name);

    public Student findByIdAndName(int id, String name);

    public Student findByStudent(Student student);

    public int count();
}
