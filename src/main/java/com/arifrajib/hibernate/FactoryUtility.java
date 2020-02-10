package com.arifrajib.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class FactoryUtility {

    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry standardServiceRegistry;

    public static SessionFactory getSessionFactory(){

        if(sessionFactory == null){
            try{
                /// Create Registry
                standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();

                /// Create Metadata source
                MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);

                /// Create Metadata
                Metadata metadata = metadataSources.getMetadataBuilder().build();

                /// Create Session Factory
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            }
            catch (Exception e){
                e.printStackTrace();
                if(standardServiceRegistry != null){
                    StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
                }

            }
        }
        return sessionFactory;
    }

    public static void shutDown(){
        if(standardServiceRegistry != null){
            StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
        }
    }
}
