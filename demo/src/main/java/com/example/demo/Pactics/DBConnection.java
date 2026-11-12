package com.example.demo.Pactics;

public class DBConnection {
// EGAR
//    private static  DBConnection obj = new DBConnection();
//
//    private DBConnection(){
//
//    }
//
//    public static DBConnection getInstance(){
//
//        return  obj;
//    }

    private static  DBConnection obj ;

    private DBConnection(){

   }

   public static DBConnection getInstance(){

        if(obj == null){

            synchronized (DBConnection.class){
                obj = new DBConnection();
            }
        }

    return obj ;
   }



}
