package com.yan.excersize.hibernate.dao;

import com.yan.excersize.hibernate.domain.Student;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by Mohammad Nur on 10/6/2017.
 */

@Repository
public class StudentDao implements IStudentDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void saveStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student getStudentInfo(int id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteria = cb.createQuery(Student.class);
        Root<Student> from = criteria.from(Student.class);
        criteria.select(cb.construct(Student.class, from.get("id"), from.get("name"), from.get("school")));
        criteria.where(cb.equal(from.get("id"), id));
        return entityManager.createQuery(criteria).getSingleResult();
    }

    @Override
    public Student updateStudent(Student student) {
        Student update = entityManager.merge(student);
        return update;
    }
}
