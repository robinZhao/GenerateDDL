import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

public class DDLGenerator {
	public void generateDdl() {
		String[] locations = { "classpath*:appContext-hibernate.xml" };
		ApplicationContext ctx = new ClassPathXmlApplicationContext(locations);
		System.out.println(ctx.getBean("&sessionFactory"));
		AnnotationSessionFactoryBean sf = (AnnotationSessionFactoryBean) ctx
				.getBean("&sessionFactory");
		System.out.println(ctx);
		SchemaExport dbExport = new SchemaExport(sf.getConfiguration());
		dbExport.setFormat(true);
		dbExport.setOutputFile("c:\\bom.sql");
		dbExport.create(true, false);

	}
	
	public static void main(String[] args){
		new DDLGenerator().generateDdl();
	}
}
