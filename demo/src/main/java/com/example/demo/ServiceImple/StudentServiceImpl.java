package com.example.demo.ServiceImple;

import com.example.demo.dtos.AddressDto;
import com.example.demo.dtos.StudentDetailsResponseDto;
import com.example.demo.dtos.StudentDto;
import com.example.demo.entity.Address;
import com.example.demo.entity.Student;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import com.example.demo.studentDao.StudentDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService, StudentDao {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AddressRepository addressRepository;

   @Autowired
    ModelMapper modelMapper;

   @Autowired
   EntityManager entityManager;


    @Override
    public StudentDto createStudentDto(StudentDto student) {

        Student s1 = new Student();
        s1.setName(student.getName());
        s1.setEmail(student.getEmail());
        s1.setDateOfBirth(student.getDateOfBirth());

        Student studentCreated = studentRepository.save(s1);

          return studentToDto(studentCreated);
    }

    @Override
    public AddressDto addAddress(AddressDto addressDto){
        Address address = new Address();
        address.setStudentId(addressDto.getStudentId());
        address.setAddressType(addressDto.getAddressType());
        address.setStreet(addressDto.getStreet());
        address.setPincode(addressDto.getPincode());
          Address address1 =  addressRepository.save(address);

         return modelMapper.map(address1,AddressDto.class);


    }

    @Override
    public List<StudentDetailsResponseDto> getStudentDetails(Integer studentId) {

        Class<StudentDetailsResponseDto> studentDetails = StudentDetailsResponseDto.class;
        String studentQuery = strSelect + studentDetails.getName() + strStudent;
        TypedQuery<StudentDetailsResponseDto> query = entityManager.createQuery(studentQuery, studentDetails);
        return query.setParameter("studentId", studentId).getResultList();
    }

    StudentDto studentToDto(Student student) {

        StudentDto dto = new StudentDto();
        dto.setStudentId(student.getStudentId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setDateOfBirth(student.getDateOfBirth());

        return dto;

    }

}
