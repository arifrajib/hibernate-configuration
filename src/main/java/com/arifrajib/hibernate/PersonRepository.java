package com.arifrajib.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PersonRepository {

    public static void save(Person person){
        Transaction transaction = null;
        /// get session
        try(Session session = FactoryUtility.getSessionFactory().openSession()){
            /// start transaction
            transaction = session.beginTransaction();

            /// save in DB
            session.save(person);

            /// commit transaction
            transaction.commit();
        }
        catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static List<Person> getAll(){
        Transaction transaction = null;

        List<Person> people = null;

        /// get Session
        try(Session session = FactoryUtility.getSessionFactory().openSession()){

            /// start transaction
            transaction = session.beginTransaction();

            /// retrieve records
            people = session.createQuery("from Person", Person.class).list();

            /// commit the transaction
            transaction.commit();

        }
        catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }

        return people;
    }
}
