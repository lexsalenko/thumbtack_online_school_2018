package net.thumbtack.school.database.mybatis.mappers;

import net.thumbtack.school.database.model.Group;
import net.thumbtack.school.database.model.Trainee;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TraineeMapper {

    @Insert("INSERT INTO trainee ( firstName, lastName, rating, groupid) VALUES" +
            " ( #{trainee.firstName}, #{trainee.lastName}, #{trainee.rating}, #{group.id} )")
    @Options(useGeneratedKeys = true, keyProperty = "trainee.id")
    Integer insert(@Param("group") Group group, @Param("trainee") Trainee trainee);

    @Select("SELECT id, firstName, lastName, rating from trainee WHERE id = #{id}")
    Trainee getById(int id);

    @Select("SELECT * from trainee")
    List<Trainee> getAll();

    @Update("UPDATE trainee SET firstName = #{trainee.firstName}, lastName = #{trainee.lastName}, rating = #{trainee.rating} WHERE id = #{trainee.id}")
    void update(@Param("trainee") Trainee trainee);

    @Select({
            "<script>",
            "SELECT id, firstName, lastName, rating FROM trainee",
            "<where>" +
                    "<if test='firstName != null'> AND firstName like #{firstName}",
            "</if>",
            "<if test='lastName != null'> AND lastName like #{lastName}",
            "</if>",
            "<if test='rating != null'> AND rating = #{rating}",
            "</if>",
            "</where>" +
                    "</script>"
    })
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "firstName", column = "firstName"),
            @Result(property = "lastName", column = "lastName"),
            @Result(property = "rating", column = "rating")
    })
    List<Trainee> getAllWithParams(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("rating") Integer rating);

    @Insert({"<script>",
            "INSERT INTO trainee (firstName, lastName, rating) VALUES",
            "<foreach item='item' collection='list' separator=','>",
            "( #{item.firstName}, #{item.lastName}, #{item.rating} )",
            "</foreach>",
            "</script>"})
    @Options(useGeneratedKeys = true)
    void batchInsert(List<Trainee> trainees);

    @Delete("DELETE FROM trainee WHERE id = #{trainee.id}")
    void delete(@Param("trainee") Trainee trainee);

    @Delete("DELETE FROM trainee")
    void deleteAll();

    // Inner methods
    @Select("SELECT id, firstName, lastName, rating FROM trainee WHERE groupid = #{id}")
    Trainee getTraineeByGroupId(int id);


}
