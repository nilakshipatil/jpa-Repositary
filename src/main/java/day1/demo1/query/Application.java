package day1.demo1.query;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.query.model.Emp;

import repositary.DeptRepositary;
import repositary.EmpRepositary;

//@SpringBootApplication(scanBasePackages="repositary")

@SpringBootApplication(scanBasePackages="com.controller")
@EnableJpaRepositories(basePackages="repositary")
@EntityScan(basePackages="com.query.model")
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(Application.class, args);
		//EmpRepositary repo=ctx.getBean(EmpRepositary.class);
		
	}
	/*@Bean
	public String test(EmpRepositary repo){
		
		for(int i=1;i<=200;i++){
			Emp emp=new Emp();
			emp.setEmpno(i);
			emp.seteName("Employee"+i);
			emp.setSalary(i*100);
			emp.setDept("Dname"+i);
			repo.save(emp);
		}
		
		System.out.println("Records in emp table");
		repo.findAll().forEach((e)->System.out.println(e));
		return "success";
	}*/
/*	@Bean
	public String insertEmp(EmpRepositary repo,DeptRepositary deprepo){
		List<String> name=Arrays.asList("nilakshi","abcd","pqrs");
		List<String> dept=Arrays.asList("Dname1","Dname2","Dname3");
		for(int i=1;i<1000;i+=1){
			Emp e=new Emp();
			
			e.seteName(name.get(i%name.size()));
			e.setSalary(i*100);
			e.setDept(dept.get(i%dept.size()));
			repo.save(e);
		}
		return "inserted";
	}*/
	
	/*@Bean
	public String pageDemo(EmpRepositary repo){
		Pageable page=new PageRequest(0, 10);
		repo.findAll(page).forEach((e)->System.out.println(e.toString()));
		
		Pageable page1=page.next();
		repo.findAll(page1).forEach((e)->System.out.println(e.toString()));
		
		
		return "Pagination";
	}*/
	
	/*@Bean
	public String PageDemo2(EmpRepositary repo){
		int pagecount=0;
		Pageable page=new PageRequest(0, 10);
		Scanner sc= new Scanner(System.in);
		while(true){
			repo.findAll(page).forEach(e->System.out.println(e.toString()));
			System.out.println("Press y to continue");
			if(!(sc.next().equalsIgnoreCase("y"))){
				break;
			}
			pagecount+=1;
			page=new PageRequest(pagecount,10);
		}
		
		return "success";
	}*/
	
	@Bean
	public String sortDemo(EmpRepositary repo){
		Sort sort = new Sort(new Sort.Order(Direction.ASC, "ename"));
		repo.findAll(sort).forEach(e->System.out.println(e.toString()));
		return "";
	}
/*	@Bean 
	public String sortDemo2(EmpRepositary repo){
		Scanner sc=new Scanner(System.in);
		System.out.println("Sorting fields");
		String fields=sc.next();
		Order order;
		if(sc.nextBoolean()){
			order=new Order(Direction.ASC,fields);
		}
		else
			order=new Order(Direction.DESC,fields);
		Sort sort=new Sort(order);
		repo.findAll(sort).forEach(e->System.out.println(e.toString()));
		sc.close();
		return "Sorted";	
	}*/
	@Bean
	public String exampleDemo(EmpRepositary repo){
		ExampleMatcher matcher=ExampleMatcher.matchingAny();
		Emp e=new Emp();
		e.setDept("Dname1");
		e.seteName("nilakshi");
		
		Example <Emp> empExample=Example.of(e,matcher);
		repo.findAll(empExample).forEach(f->System.out.println(f.toString()));
		
		//Matcher All example where every fields needs to set criteria for search
		System.out.println("Using Example for matching all");
		ExampleMatcher matcher2=ExampleMatcher.matchingAll();
		Emp e1=new Emp();
		e1.setDept("Dname1");
		e1.seteName("nilakshi");
		e1.setSalary(600);
		e1.setEmpno(5);
		Example <Emp> empExample2=Example.of(e1,matcher2);
		repo.findAll(empExample2).forEach(f->System.out.println(f.toString()));
		
		
		return "";
	}
}
