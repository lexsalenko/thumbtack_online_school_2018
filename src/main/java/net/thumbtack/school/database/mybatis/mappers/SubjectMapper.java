package net.thumbtack.school.database.mybatis.mappers;

import net.thumbtack.school.database.model.Subject;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SubjectMapper {

    @Insert("INSERT INTO `subject` (name) VALUES ( #{name} )")
    @Options(useGeneratedKeys = true)
    Integer insert(Subject subject);

    @Select("SELECT id, name FROM `subject` WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name")
    })
    Subject getById(int id);

    @Select("SELECT * FROM `subject`")
    List<Subject> getAll();

    @Update("UPDATE `subject` SET name = #{subject.name} WHERE id = #{subject.id}")
    void update(@Param("subject") Subject subject);

    @Delete("DELETE FROM `subject` WHERE id = #{subject.id}")
    void delete(@Param("subject") Subject subject);

    @Delete("DELETE FROM `subject`")
    void deleteAll();

    // Inner methods
    @Select("SELECT  id, name FROM subject WHERE id IN (SELECT subjectid FROM group_subject WHERE groupid=#{id})")
    Subject getSubjectByGroupId(int id);
}
