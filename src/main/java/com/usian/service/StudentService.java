package com.usian.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.usian.dao.StudentMapper;
import com.usian.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

/**
 * @author zby
 * @create 2020-10-29 7:22
 */
@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;




    public Student queryStudentByid(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    public void updateStudentByUid(Student student) {
        studentMapper.updateByPrimaryKey(student);
    }

    public PageInfo<Student> queryAllStudent(Student student,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
//        List<Student> allStudent = studentMapper.getAllStudent(student);
//        PageInfo<Student> studentPageInfo = new PageInfo<>(allStudent);
//        return  studentPageInfo;
        PageHelper.startPage(pageNum,pageSize);
        Example example = new Example(Student.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(student.getName())){
            criteria.andLike("name","%"+student.getName());
        }
        List<Student> students = studentMapper.selectByExample(example);
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        return pageInfo;
    }
        public void  sss(){
            System.out.println("sdasdasdasdas222222");
            System.out.println("sdasdasdasdas1111111111");
        }


    public void addStudent(Student student) {
        studentMapper.insertSelective(student);
    }


    public void deleteStudentByids(Integer id) {
        studentMapper.deleteByPrimaryKey(id);
    }
}
