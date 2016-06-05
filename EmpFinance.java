import java.util.*;
import java.io.*;
//Creates class to hold employee financial data
public class EmpFinance implements Comparable <EmpFinance>{
	private int empNo;
	private String fname;
	private String sname;
	private double salary;
	private double tax;
	private double nis;
	private double netPay;
	
    public EmpFinance(int en,String fn,String sn,double sal,double tx,double n,double np) {
    	empNo=en;
    	fname=fn;
		sname=sn;
		salary=sal;
		tax=tx;
	    nis=n;
	    netPay=np;
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
	public void setSalary(double sal){
			salary=sal;
	}
    public void setTax(double tx){
		tax=tx;
	}
	public void setNis(double n){
			nis=n;
	}
	public void setNetPay(double np){
			netPay=np;
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
	public double getSalary(){
			return salary;
	}
	public double getTax(){
			return tax;
	}
	public double getNis(){
			return nis;
	}
	public double getNetPay(){
			return netPay;
	}
	public int compareTo(EmpFinance e){
			return (this.getEmpNo()- e.getEmpNo());
	}
	public String toString(){
			return getEmpNo()+" "+getFname()+" "+getSname()+" "+getSalary()+" "+getTax()+" "+getNis()+getNetPay()+ "\n";
	}
	//Allows sorting by Surname
	public static Comparator<EmpFinance> SortBySurname = new Comparator<EmpFinance>() {
		public int compare(EmpFinance e1, EmpFinance e2){
			return e1.getSname().toUpperCase().compareTo(e2.getSname().toUpperCase());
		}
	};
	//Allows sorting by net pay
	public static Comparator<EmpFinance> SortByNetPay = new Comparator<EmpFinance>() {

		public int compare(EmpFinance e1, EmpFinance e2){
			if (e1.getNetPay() < e2.getNetPay())
					return -1;
			else return 1;	
		}
	};
}
//Storage for a collection of employee finance records
class EmpFinanceStorage{
	
	ArrayList<EmpFinance> employeeFin;
	
	public EmpFinanceStorage(){
		employeeFin= new ArrayList<EmpFinance>();
	}
	//loads records from payroll.dat file	
	public void loadEmpFinance(){
		
			String line=null,fn,sn;
			int eno;
			double sal,tx,n,np;
			EmpFinance temp; 
			employeeFin.clear();					
				try{
					BufferedReader in  = new BufferedReader(new FileReader("payroll.dat"));
	   				in.readLine();
	            	while((line = in.readLine()) != null){
	            		
			                StringTokenizer st= new StringTokenizer(line,"-");
							while(st.hasMoreTokens()){
								
									eno=Integer.parseInt(st.nextToken());
									fn=st.nextToken();
									sn=st.nextToken();
									sal=Double.parseDouble(st.nextToken());
									tx=Double.parseDouble(st.nextToken());
									n=Double.parseDouble(st.nextToken());
									np=Double.parseDouble(st.nextToken());
									temp = new EmpFinance(eno,fn,sn,sal,tx,n,np);
									
									employeeFin.add(temp);	
										  						            		
							}  
			        }
	            	in.close();
	        	}
				catch(IOException e){
						System.out.println(e.getMessage());
				}
		}
		//Stores records in payroll.dat file
		public void storeEmpFinance(){
				
				try{
					PrintWriter out =new PrintWriter(new BufferedWriter(new FileWriter("payroll.dat")));
					out.println("empno-firstname-surname-salary-tax-nis-netpay");
					
					EmpFinance temp=null;
					for(int i=0;i<employeeFin.size();i++){
    						temp=employeeFin.get(i);
							out.println(temp.getEmpNo()+"-"+temp.getFname()+"-"+temp.getSname()+"-"+temp.getSalary()+"-"+temp.getTax()+"-"+temp.getNis()+"-"+temp.getNetPay());
    				}
					out.close();
				}
				catch(IOException e){
						System.out.println(e.getMessage());
				}
		}
		//loads employee history data from history.dat
		public void loadEmpHistory(){
		
			String line=null,fn,sn;
			int eno;
			double sal,tx,n,np;
			EmpFinance temp; 
			employeeFin.clear();					
				try{
					BufferedReader in  = new BufferedReader(new FileReader("History.dat"));
	   				in.readLine();
	            	while((line = in.readLine()) != null){
	            		
			                StringTokenizer st= new StringTokenizer(line,"-");
							while(st.hasMoreTokens()){
								
									eno=Integer.parseInt(st.nextToken());
									fn=st.nextToken();
									sn=st.nextToken();
									sal=Double.parseDouble(st.nextToken());
									tx=Double.parseDouble(st.nextToken());
									n=Double.parseDouble(st.nextToken());
									np=Double.parseDouble(st.nextToken());
									temp = new EmpFinance(eno,fn,sn,sal,tx,n,np);
									
									employeeFin.add(temp);	
										  						            		
							}  
			        }
	            	in.close();
	        	}
				catch(IOException e){
						System.out.println(e.getMessage());
				}
		}
		//Store employee history(year-to-date) in history file
		public void storeEmpHistory(){
				
				try{
					PrintWriter out =new PrintWriter(new BufferedWriter(new FileWriter("History.dat")));
					out.println("empno-firstname-surname-salary-tax-nis-netpay");
					
					EmpFinance temp=null;
					for(int i=0;i<employeeFin.size();i++){
    						temp=employeeFin.get(i);
							out.println(temp.getEmpNo()+"-"+temp.getFname()+"-"+temp.getSname()+"-"+temp.getSalary()+"-"+temp.getTax()+"-"+temp.getNis()+"-"+temp.getNetPay());
    				}
					out.close();
				}
				catch(IOException e){
						System.out.println(e.getMessage());
				}
		} 
}