import java.io.*;
import java.util.*;

//Class to hold employee information
public class Employee implements Comparable <Employee>{
	
	private int empNo;
	private String fname;
	private String sname;
	private char sex;
	private char maritalStatus;
	private String address;
	private double salary;
	private int children;
	
	Employee(int en,String fn,String sn,char s,char ms,String adr,double sal,int child){
			empNo=en;
			fname=fn;
			sname=sn;
			sex=s;
			maritalStatus=ms;
			address=adr;
			salary=sal;
			children=child;
	}
	public void setEmpNo(int en){
			empNo=en;
	}
	public void setFname(String fn){
			fname=fn;
	}
	public void setSname(String sn){
			sname=sn;
	}
	public void setSex(char s){
			sex=s;
	}
	public void setMaritalStatus(char ms){
			maritalStatus=ms;
	}
	public void setAddress(String adr){
			address=adr;
	}
	public void setSalary(double sal){
			salary=sal;
	}
	public void setChildren(int child){
			children=child;
	}
	public int getEmpNo(){
			return empNo;
	}
	public String getFname(){	
			return fname;
	}
	public String getSname(){
			return sname;
	}
	public char getSex(){
			return sex;
	}
	public char getMaritalStatus(){
			return maritalStatus;
	}
	public String getAddress(){
			return address;
	}
	public double getSalary(){
			return salary;
	}
	public int getChildren(){
			return children;
	}
	public String toString(){
			return getEmpNo()+" "+getFname()+" "+getSname()+" "+getSex()+" "+getMaritalStatus()+" "+getAddress()+" "+getSalary()+" "+getChildren()+ "\n";
	}
	//Allows the data to be sorted by employee no
	public int compareTo(Employee e){
			return (this.getEmpNo()- e.getEmpNo());
	}
}
	

//Storage to hold a collection of employees
class empStorage{
	
	ArrayList<Employee> employees;
	
	public empStorage(){
		employees= new ArrayList<Employee>();
	}
	//Loads employee data from file and stores into data structure
	public void loadEmployees(){
			String line=null,fn,sn,adr;
			int eno,child;
			char s,ms;
			double sal;
			Employee temp; 
			employees.clear();					
				try{
					BufferedReader in  = new BufferedReader(new FileReader("Employees.dat"));
	   				in.readLine();
	            	while((line = in.readLine()) != null){
	            		
			                StringTokenizer st= new StringTokenizer(line,"-");
							while(st.hasMoreTokens()){
									//reads data
									eno=Integer.parseInt(st.nextToken());
									fn=st.nextToken();
									sn=st.nextToken();
									s=st.nextToken().charAt(0);
									ms=st.nextToken().charAt(0);
									adr=st.nextToken();
									sal=Double.parseDouble(st.nextToken());
									child=Integer.parseInt(st.nextToken());
									//adds to collection list
									temp = new Employee(eno,fn,sn,s,ms,adr,sal,child);
									employees.add(temp);	
										  						            		
							}  
			        }
	            	in.close();
	        	}
				catch(IOException e){
						System.out.println(e.getMessage());
				}
		}
		//Writes information from data structure to file
		public void storeEmployees(){
				
				try{
					PrintWriter out =new PrintWriter(new BufferedWriter(new FileWriter("Employees.dat")));
					out.println("empno-firstname-surname-sex-marital_status-address-Salary-Children");
					
					Employee temp=null;
					for(int i=0;i<employees.size();i++){
    						temp=employees.get(i);
							out.println(temp.getEmpNo()+"-"+temp.getFname()+"-"+temp.getSname()+"-"+temp.getSex()+"-"+temp.getMaritalStatus()+"-"+temp.getAddress()+"-"+temp.getSalary()+"-"+temp.getChildren());
    				}
					out.close();
				}
				catch(IOException e){
						System.out.println(e.getMessage());
				}
		}
}
		
			