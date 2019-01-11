package otm_fk;

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
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(standardServiceRegistry).buildMetadata();
        SchemaExport schemaExport = new SchemaExport();
        schemaExport.create(EnumSet.of(TargetType.DATABASE), metadata);

        ClassRoom classRoom1 = new ClassRoom("1001", "软件工程");
        ClassRoom classRoom2 = new ClassRoom("1002", "网络管理");

        Students student1 = new Students("Miles", "man", new Date(), "Compute");
        Students student2 = new Students("Monroe", "man", new Date(), "Compute");
        Students student3 = new Students("Jack", "woman", new Date(), "Compute");
        Students student4 = new Students("Rook", "woman", new Date(), "Compute");

        // 创建两个集合对象
        Set<Students> set1 = new HashSet<>();
        Set<Students> set2 = new HashSet<>();

        // 向集合中添加学生
        set1.add(student1);
        set1.add(student2);

        set2.add(student3);
        set2.add(student4);

        // 向班级中添加学生集合
        classRoom1.setStudentsSet(set1);
        classRoom1.setStudentsSet(set2);

        // 第一步 保存学生
        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);

        // 第二步 保存班级
        session.save(classRoom1);
        session.save(classRoom2);
    }

}
