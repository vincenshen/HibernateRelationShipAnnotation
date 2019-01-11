package mtm_fk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class TestStudents {

    private static SessionFactory sessionFactory;
    private static Session session;
    private static Transaction transaction;

    @BeforeAll
    public static void init(){
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.getCurrentSession();
        transaction = session.beginTransaction();
    }

    @AfterAll
    public static void destroy(){
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testSchemaExport(){
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();
        SchemaExport schemaExport = new SchemaExport();
        schemaExport.create(EnumSet.of(TargetType.DATABASE), metadata);
    }

    @Test
    public void testAddStudents(){
        // 第一步，创建教师对象
        Teachers t1 = new Teachers("T001", "沈老师");
        Teachers t2 = new Teachers("T002", "李老师");
        Teachers t3 = new Teachers("T003", "陈老师");
        Teachers t4 = new Teachers("T004", "石老师");

        // 第二步，创建学生对象
        Students s1 = new Students("张三", "man", new Date(), "Compute");
        Students s2 = new Students("李四", "man", new Date(), "Compute");
        Students s3 = new Students("王五", "man", new Date(), "Compute");
        Students s4 = new Students("赵六", "man", new Date(), "Compute");

        // 创建教师集合
        Set<Teachers> set1 = new HashSet<>();
        set1.add(t1);
        set1.add(t2);

        Set<Teachers> set2 = new HashSet<>();
        set2.add(t3);
        set2.add(t4);

        // 在学生类中添加教师
        s1.setTeachers(set1);
        s2.setTeachers(set2);
        s3.setTeachers(set1);
        s4.setTeachers(set2);

        // 先保存教师
        session.save(t1);
        session.save(t2);
        session.save(t3);
        session.save(t4);

        // 再保存学生
        session.save(s1);
        session.save(s2);
        session.save(s3);
        session.save(s4);

    }
}
