package com.test;

import com.model.Durable;
import com.model.Idurable.IdurableOperation;
import kr.co.aim.nanotrack.durable.management.data.DurableKey;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

/**
 * Created by admin on 2017/2/14.
 */
public class DurableTest {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }

    public static void main(String[] args) {
/*        SqlSession session = sqlSessionFactory.openSession();
        try {
            //case 1:
            *//*Durable durable = session.selectOne("com.models.DurableMapper.selectDurableByDurableName","CT1C1906");*//*
            IdurableOperation durableOperation = session.getMapper(IdurableOperation.class);
            //Durable durable = durableOperation.selectDurableByDurableName("CT1C1906");
            List<Durable> durableList = durableOperation.selectDurables("%CT1C%");
            for (Durable durable : durableList) {
                System.out.println(durable.getDurableType() + "--" + durable.getDurableSpecName());
            }
        } finally {
            session.close();
        }*/
           // addDurable();

            updateDurable();
    }

    public static void addDurable(){
        Durable durable = new Durable();
        //DurableKey durableKey = durable.getKey();
        durable.setDurableName("LingTest");
        durable.setAreaName("haha");

        SqlSession session = sqlSessionFactory.openSession();
        try {
            IdurableOperation durableOperation = session.getMapper(IdurableOperation.class);
            durableOperation.addDurable(durable);
            session.commit();
            System.out.println("add durableName = "+durable.getDurableName());
        }finally {
            session.close();
        }
    }

    public static void updateDurable(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IdurableOperation idurableOperation = session.getMapper(IdurableOperation.class);
            Durable durable = idurableOperation.selectDurableByDurableName("LingTest");
            durable.setAreaName("mm");
            idurableOperation.updateDurable(durable);
            session.commit();

        }finally {
            session.close();
        }
    }

    public static void deleteDurable(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IdurableOperation idurableOperation = session.getMapper(IdurableOperation.class);
            idurableOperation.deleteDurable("mmTest");
            session.commit();
        }finally {
            session.close();
        }
    }
}
