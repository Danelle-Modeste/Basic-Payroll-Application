
import java.io.*;
import java.util.*;

//Creates class Company to hold company information
public class Company {
	private String compName;
	private int year;
	private int month;
	private double annual;
	private double taxRate;
	private double nis; 
    public Company(){
    	compName= "No Name";
    	year=1;
    	month=1;
    	annual =0;
    	taxRate=0;
    	nis=0;
    }
    public void setCompName(String name){
			compName=name;
	}
    public void setYear(int yr){
    		year=yr;
    }
    public void setMonth(int mnth){
    		month=mnth;
    }
	public void setAnnual(double ann){
			annual=ann;
	}    
	public void setTaxRate(double tr){
			taxRate=tr;
	}
	public void setNis(double nr){
			nis=nr;
	}
	public String getCompName(){
			return compName;
	}
	public int getYear(){
			return year;
	}
	public int getMonth(){
			return month;
	}
	public double getAnnual(){
			return annual;
	}
	public double getTaxRate(){
			return taxRate;
	}
	public double getNis(){
			return nis;
	}
	public String toString(){
			return (getCompName()+" "+" "+getYear()+" "+getMonth()+" "+getAnnual()+" "+getTaxRate()+" "+getNis()+"\n");
	}
	//Loads company data from Company.dat file into instance of company
	public void loadCompany(){
			String line=null,cn;
			int yr,mnth;
			double ann,tr,nr;
								
				try{
					BufferedReader in  = new BufferedReader(new FileReader("Company.dat"));
	   				in.readLine();
	            	while((line = in.readLine()) != null){
	            		
			                StringTokenizer st= new StringTokenizer(line,"-");
							while(st.hasMoreTokens()){
									//read from file
									cn=st.nextToken();
									yr=Integer.parseInt(st.nextToken());
									mnth=Integer.parseInt(st.nextToken());
									ann=Double.parseDouble(st.nextToken());
									tr=Double.parseDouble(st.nextToken());
									nr=Double.parseDouble(st.nextToken());
									//store in instance
									this.setCompName(cn);
									this.setYear(yr);
									this.setMonth(mnth);
									this.setAnnual(ann);
									this.setTaxRate(tr);
									this.setNis(nr);  						            		
							}  
			        }
	            	in.close();
	        	}
				catch(IOException e){
						System.out.println(e.getMessage());
				}
				this.toString();
		}
		//SvaEs the company data to the companY.dAT file
		public void saveCompany(){
				
				try{
					PrintWriter out =new PrintWriter(new BufferedWriter(new FileWriter("Company.dat")));
					out.println("companyname-currentyear-currentmonth-annualallowance-taxrate-nisrate");
					out.println(getCompName()+"-"+getYear()+"-"+getMonth()+"-"+getAnnual()+"-"+getTaxRate()+"-"+getNis());
					out.close();
				}
				catch(IOException e){
						System.out.println(e.getMessage());
				}
		}
}