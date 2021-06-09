package net.thumbtack.school.database.mybatis.daoimpl;

import net.thumbtack.school.database.model.Subject;
import net.thumbtack.school.database.mybatis.dao.SubjectDao;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SubjectDaoImpl extends DaoImplBase implements SubjectDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubjectDaoImpl.class);

    public Subject insert(Subject subject) {
        LOGGER.debug("DAO insert Subject {}", subject);
        try (SqlSession sqlSession = getSession()) {
            try {
                getSubjectMapper(sqlSession).insert(subject);
            } catch (RuntimeException ex) {
                LOGGER.info("Can't insert Subject {} {}", subject, ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
        return subject;
    }

    public Subject getById(int id) {
        LOGGER.debug("DAO get Subject by Id {}", id);
        try (SqlSession sqlSession = getSession()) {
            return getSubjectMapper(sqlSession).getById(id);
        } catch (RuntimeException ex) {
            LOGGER.info("Can't get Subject by Id {}", ex);
            throw ex;
        }
    }

    public List<Subject> getAll() {
        LOGGER.debug("DAO get all Subject");
        try (SqlSession sqlSession = getSession()) {
            return getSubjectMapper(sqlSession).getAll();
        } catch (RuntimeException ex) {
            LOGGER.info("Can't get all Subject {}", ex);
            throw ex;
        }
    }

    // изменяет Subject  в базе данных
    public Subject update(Subject subject) {
        LOGGER.debug("DAO update Subject {}", subject);
        try (SqlSession sqlSession = getSession()) {
            try {
                getSubjectMapper(sqlSession).update(subject);
            } catch (RuntimeException ex) {
                LOGGER.info("Can't update Subject {} {}", subject, ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
        return subject;
    }

    // удаляет Subject из базы данных
    public void delete(Subject subject) {
        LOGGER.debug("DAO delete Subject {}", subject);
        try (SqlSession sqlSession = getSession()) {
            try {
                getSubjectMapper(sqlSession).delete(subject);
            } catch (RuntimeException ex) {
                LOGGER.info("Can't delete Subject {} {}", subject, ex);
                sqlSession.rollback();
            }
            sqlSession.commit();
        }
    }

    // удаляет все Subject из базы данных
    public void deleteAll() {
        LOGGER.debug("DAO delete all Subject");
        try (SqlSession sqlSession = getSession()) {
            try {
                getSubjectMapper(sqlSession).deleteAll();
            } catch (RuntimeException ex) {
                LOGGER.info("Can't delete all {}", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
    }

}
