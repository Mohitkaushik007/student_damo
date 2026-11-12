package com.example.demo.studentDao;

public interface StudentDao {

    public static final String strSelect = "SELECT NEW ";

    public static  final String strStudent = "(a.addressId as addressId,a.studentId as studentId,a.addressType as addressType," +
            "a.street as street,a.pincode as pincode,s.name as name,s.email as email) FROM Address a JOIN Student s ON a.studentId = s.studentId WHERE a.studentId = :studentId ";

}
