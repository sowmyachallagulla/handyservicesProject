package com.rest.RestAPI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import java.util.Properties;  

import javax.mail.*;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage;  
  


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.rest.dto.Customer;
import com.rest.dto.Department;
import com.rest.dto.Employee;
import com.rest.dto.Handyman;
import com.rest.dto.Service;
import com.rest.dto.ServiceT;
import com.ts.dao.CustomerDAO;
import com.ts.dao.DeptDAO;
import com.ts.dao.EmployeeDAO;
import com.ts.dao.HandyManDAO;
import com.ts.dao.ServiceDAO;
import com.ts.dao.ServiceTDAO;
import com.ts.db.HibernateTemplate;


@Path("myresource")
public class MyResource {
	@Path("hi")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hi() throws UnsupportedEncodingException {
		System.out.println("Hi...");
		return "Hi Service!";
	}

    
	@Path("getEmpByEmail/{email}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmpByUserPass(@PathParam("email") String email) {
		System.out.println("Recieved path params: "+email); 
		EmployeeDAO employeeDAO = new EmployeeDAO();
		Employee employee = employeeDAO.getEmpByEmail(email);
		return employee;
	}

	/*@Path("getEmpByUserPass/{loginId}/{password}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmpByUserPass(@PathParam("loginId") String loginId,@PathParam("password") String password) {
		System.out.println("Recieved path params: "+loginId+" "+password); 
		EmployeeDAO employeeDAO = new EmployeeDAO();
		Employee employee = employeeDAO.getEmpByUserPass(loginId, password);
		return employee;
	}
*/

	@Path("getEmployees")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployees() {

		EmployeeDAO employeeDAO = new EmployeeDAO();
		List <Employee> empList = employeeDAO.getAllEmployees();

		return empList;
	}


	@Path("getDepartments")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Department> getDepartments() {        
		DeptDAO deptDao = new DeptDAO();
		List <Department> deptList = deptDao.getAllDepts();
		return deptList;
	}

	@Path("getDeptByName/{deptName}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Department> getDeptByName(@PathParam("deptName") String deptName) {        
		System.out.println(deptName);      
		DeptDAO deptDao = new DeptDAO();
		List<Department> depts = deptDao.getDeptByName(deptName);
		System.out.println(depts); 
		return depts;
	}
	
	@Path("registerEmp")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void registerEmp(Employee employee) {
		System.out.println("Data Recieved in Emp Register : " + employee);
		EmployeeDAO employeeDao = new EmployeeDAO();
		employeeDao.register(employee);
	
	}
	@Path("registerDept")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void registerDept(Department department) {
		System.out.println("Data Recieved in Dept Register : "+department); 
		DeptDAO deptDao = new DeptDAO();
		deptDao.register(department);
	}
	
	//It is sample code if need to test and insert values into any tables
	/*@Path("registerEmp")
	@GET
	public void registerEmp() {
		DeptDAO deptDao = new DeptDAO();
		
		Department dept = deptDao.getDept(1);
		
		Employee employee = new Employee();
		employee.setEmpName("PASHA");
		employee.setEmail("email@gmail.com");
		employee.setGender("Male");
		employee.setJoinDate(new java.util.Date());
		employee.setDepartment(dept); 
		
		EmployeeDAO employeeDao = new EmployeeDAO();
		employeeDao.register(employee);
	
	}*/
	//It is sample code if need to test and insert values into any tables
			@Path("registerEmp1")
			@GET
			public String registerEmp1() {
				DeptDAO deptDao = new DeptDAO();
				
				Department dept = deptDao.getDept(1);
				
				Employee employee = new Employee();
				employee.setEmpName("sowmya");
				employee.setEmail("email@gmail.com");
				employee.setGender("Male");
				employee.setJoinDate(new java.util.Date());
				employee.setDepartment(dept); 
				
				EmployeeDAO employeeDao = new EmployeeDAO();
				employeeDao.register(employee);
				return "Success";
			}
			
			@Path("registerDept1")
			@GET
			public String registerDept1() {
				DeptDAO deptDao = new DeptDAO();
				
				Department dept = new Department();
				dept.setDeptId(1);
				dept.setDeptName("IT");
				dept.setLocation("Hyd");
				
				DeptDAO deptDAO = new DeptDAO();
				deptDAO.register(dept);
			
				return "Success";
			}
			
			@Path("registerCus")
			@POST
			@Consumes(MediaType.APPLICATION_JSON)
			public String registerCus( Customer customer) {
				System.out.println("Recieved Reqest :"+customer); 
				CustomerDAO customerdao = new CustomerDAO();
				
				//epartment dept = deptDao.getDept(1);
				
				customerdao.register(customer);
				return "Success";
			}
			
			
			@Path("checkUser/{email}/{password}")
			@GET
			public  Object checkUser(@PathParam("email") String email, @PathParam("password") String password){
				CustomerDAO customerdao=new CustomerDAO();
				System.out.println(email+" "+password);
				return customerdao.checkUser(email,  password) ;
		
			}
			@Path("checkHandy/{email}/{password}")
			@GET
			public  Object checkHandy(@PathParam("email") String email, @PathParam("password") String password){
				HandyManDAO handymandao = new HandyManDAO();
				System.out.println(email+" "+password);
				return handymandao.checkUser(email, password);
		
			}
			@Path("updateUser")
			@PUT
			@Consumes(MediaType.APPLICATION_JSON)
			public Object updateUser(Customer editUser) {
				System.out.println("Data Recieved to Update : " + editUser);
				CustomerDAO userDao = new CustomerDAO();
				return userDao.update(editUser);
			}

			
			@Path("registerCus1")
			@GET
			public String registerCus() {
				CustomerDAO customerdao = new CustomerDAO();
				Customer c=new Customer();
				c.setCusName("srujana G");
				c.setEmail("srujana@gmail.com");
				c.setPassword("suji");
				c.setPhno("8788567854");
			
				
				//epartment dept = deptDao.getDept(1);
				
				customerdao.register(c);
				return "Success";
			}
			
			
			@Path("getHandymans")
			@GET
			@Produces(MediaType.APPLICATION_JSON)
			public List<Handyman> getHandmans() {

				HandyManDAO handymanDAO = new HandyManDAO();
				List <Handyman> handyList = handymanDAO.getAllHandyman();

				return handyList;
			}
			
			
			//upload image
			@Path("uploadImage")
			@POST
			@Consumes(MediaType.MULTIPART_FORM_DATA)
			public void uploadImage(@FormDataParam("handyImage") InputStream fileInputStream,@FormDataParam("handyImage") FormDataContentDisposition
			formDataContentDisposition, @FormDataParam("handName") String handName, @FormDataParam("email") String email,@FormDataParam("role") String role,@FormDataParam("rating") float rating,@FormDataParam("password") String password) throws IOException {; 
				int read = 0;
				byte[] bytes = new byte[1024];
				
				String path = this.getClass().getClassLoader().getResource("").getPath();
				
				String pathArr[] = path.split("/WEB-INF/classes/");
				
				FileOutputStream out = new FileOutputStream(new File(pathArr[0]+"/image/", formDataContentDisposition.getFileName()));
						
						
				while((read = fileInputStream.read(bytes)) != -1){	
					
					out.write(bytes,0,read);
				}
				out.flush();
				out.close();
				
				Handyman handy = new Handyman();
				handy.setHandName(handName);
				handy.setEmail(email);
				handy.setRole(role);
				handy.setRating(rating);
				handy.setPassword(password);
				
				handy.setHandyImage(formDataContentDisposition.getFileName());
				HandyManDAO handyDao = new HandyManDAO();
				handyDao.addHandyman(handy);
			}
			
			
			@Path("getItems")
			@GET
			@Produces(MediaType.APPLICATION_JSON)
			public List<Handyman> getItems() {

				HandyManDAO itemDAO = new HandyManDAO();
				
				List <Handyman> itemList = itemDAO.getAllHandyman();
				return itemList;
			}
			
			@Path("getHandyman/{role}")
			@GET
			@Produces(MediaType.APPLICATION_JSON)
			public List<Handyman> getHandymans(@PathParam("role") String role){
				HandyManDAO handy = new HandyManDAO();
				List <Handyman> itemList = handy.getHandymanByRole(role);
				return itemList;
				
			}
			
			@Path("booking")
			@POST
			@Consumes(MediaType.APPLICATION_JSON)
			public String booking( ServiceT service) {
				System.out.println("Recieved Reqest :"+service); 
				ServiceTDAO servicedao = new ServiceTDAO();
				
				//epartment dept = deptDao.getDept(1);
				
				servicedao.register(service);
				return "Success";
			}
			
			
			@Path("myorders/{cusId}")
			@GET
			@Produces(MediaType.APPLICATION_JSON)
			public List<ServiceT> myorders(@PathParam("cusId") int cusId){
				ServiceTDAO serviceTdao = new ServiceTDAO();
				List<ServiceT> li =serviceTdao.getAllServices(cusId);
				return li;
				
			}
			
			@Path("myservices/{handId}")
			@GET
			@Produces(MediaType.APPLICATION_JSON)
			public List<ServiceT> myservices(@PathParam("handId") int handId){
				ServiceTDAO serviceTdao = new ServiceTDAO();
				List<ServiceT> li =serviceTdao.getAllServicesByHandy(handId);
				return li;
				
			}
			
			@Path("mail/{emailId}/{issue}/{address}/{cusName}/{phno}")
		    @GET
		    @Produces(MediaType.TEXT_PLAIN)
		    public String mail(@PathParam("emailId") String emailId,@PathParam("issue") String issue,@PathParam("address") String address,@PathParam("cusName") String cusName,@PathParam("phno") String phno) throws MessagingException {
				System.out.println("hi sowmya ch");
		 String subject="Test Mail";
		 String body="Hello Handyman ,you have a new request to service them !!!!!"
		 		+ "customer Name:"+cusName+"\nphno:"+phno+"\n"+"issue:"+issue+"\naddress:"+address;
		 String email=emailId;
		String host = "smtp.gmail.com";
		String from = "aparna8222@gmail.com";
		String pass = "nagendraV";

		Properties props = System.getProperties();

		props.put("mail.smtp.starttls.enable", "true"); // added this line
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		String[] to = {email}; // added this line

		Session session = Session.getDefaultInstance(props, null);
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));

		InternetAddress[] toAddress = new InternetAddress[to.length];

		// To get the array of addresses

		for( int i=0; i < to.length; i++ )
		{
		// changed from a while loop
		toAddress[i] = new InternetAddress(to[i]);
		}

		for( int i=0; i < toAddress.length; i++)
		{
		// changed from a while loop
		message.addRecipient(Message.RecipientType.TO, toAddress[i]);
		}

		message.setSubject(subject);
		message.setText(body);

		Transport transport = session.getTransport("smtp");

		transport.connect(host, from, pass);
		transport.sendMessage(message, message.getAllRecipients());

		transport.close();

		        return "Successful";
		    }
			
			
			@Path("rejectedmail/{emailId}/{cusName}")
		    @GET
		    @Produces(MediaType.TEXT_PLAIN)
		    public String mail(@PathParam("emailId") String emailId,@PathParam("cusName") String cusName) throws MessagingException {
				System.out.println("hi sowmya ch");
		 String subject="rejected Mail";
		 String body="Hello Handyman ,your service is cancelled by customer"+cusName+"\n ";
		 String email=emailId;
		String host = "smtp.gmail.com";
		String from = "aparna8222@gmail.com";
		String pass = "nagendraV";

		Properties props = System.getProperties();

		props.put("mail.smtp.starttls.enable", "true"); // added this line
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		String[] to = {email}; // added this line

		Session session = Session.getDefaultInstance(props, null);
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));

		InternetAddress[] toAddress = new InternetAddress[to.length];

		// To get the array of addresses

		for( int i=0; i < to.length; i++ )
		{
		// changed from a while loop
		toAddress[i] = new InternetAddress(to[i]);
		}

		for( int i=0; i < toAddress.length; i++)
		{
		// changed from a while loop
		message.addRecipient(Message.RecipientType.TO, toAddress[i]);
		}

		message.setSubject(subject);
		message.setText(body);

		Transport transport = session.getTransport("smtp");

		transport.connect(host, from, pass);
		transport.sendMessage(message, message.getAllRecipients());

		transport.close();

		        return "Successful";
		    }
		   

			@Path("rejectedmailbyhand/{emailId}")
		    @GET
		    @Produces(MediaType.TEXT_PLAIN)
		    public String sendmail(@PathParam("emailId") String emailId) throws MessagingException {
				System.out.println("hi sowmya ch");
		 String subject="rejected Mail";
		 String body="Hello customer ,your order is cancelled !!!!!"
		 		+"email Id:"+emailId+"\n";
		 String email=emailId;
		String host = "smtp.gmail.com";
		String from = "aparna8222@gmail.com";
		String pass = "nagendraV";

		Properties props = System.getProperties();

		props.put("mail.smtp.starttls.enable", "true"); // added this line
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		String[] to = {email}; // added this line

		Session session = Session.getDefaultInstance(props, null);
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));

		InternetAddress[] toAddress = new InternetAddress[to.length];

		// To get the array of addresses

		for( int i=0; i < to.length; i++ )
		{
		// changed from a while loop
		toAddress[i] = new InternetAddress(to[i]);
		}

		for( int i=0; i < toAddress.length; i++)
		{
		// changed from a while loop
		message.addRecipient(Message.RecipientType.TO, toAddress[i]);
		}

		message.setSubject(subject);
		message.setText(body);

		Transport transport = session.getTransport("smtp");

		transport.connect(host, from, pass);
		transport.sendMessage(message, message.getAllRecipients());

		transport.close();

		        return "Successful";
		    }
		   

			@Path("ratingupdate")
			@PUT
			@Consumes(MediaType.APPLICATION_JSON)
			public String ratingupdate(Handyman handyman){
				HandyManDAO handymandao= new HandyManDAO();
				handymandao.updateRating(handyman);
			//	handymandao.updateRating(handId, rating);
				
				return "sucess";
				
				
			}
		   
			
			@Path("cancelOrder/{servId}")
			@DELETE
			@Consumes(MediaType.APPLICATION_JSON)
			public void cancelOrder(@PathParam("servId") int servId){
				HibernateTemplate.deleteService(servId);
				System.out.println("sucessful deletion");
			}
			
			@Path("getbyId/{handId}")
			@GET
			@Produces(MediaType.APPLICATION_JSON)
			public Handyman getHandymanById(@PathParam("handId") int handId){
				HandyManDAO handymandao = new HandyManDAO();
				return handymandao.getHandymanById(handId);
			}

			@Path("getCusbyId/{cusId}")
			@GET
			@Produces(MediaType.APPLICATION_JSON)
			public Customer getCustomerById(@PathParam("cusId") int cusId){
				CustomerDAO customerdao = new CustomerDAO();
				return customerdao.getCustomerById(cusId);
			}
			
			@Path("getHandytime/{bookingDate}/{slot}/{handId}")
			@GET
			@Produces(MediaType.APPLICATION_JSON)
			public ServiceT getHandymanTime(@PathParam("bookingDate") String bookingDate,@PathParam("slot") String slot,@PathParam("handId") int handId){
				System.out.println("HI");
				System.out.println(bookingDate+" "+slot+" "+handId);
				ServiceTDAO serviceTDAO = new ServiceTDAO();
				
				return (ServiceT) serviceTDAO.checkTime(bookingDate, slot,handId);
				
				
			}


			
}
