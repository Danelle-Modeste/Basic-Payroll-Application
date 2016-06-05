import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
//GUI FOR THE ENTIRE APPLICATION

//Main menu GUI
public class ZGUI extends JFrame implements ActionListener{
	
	public ZGUI(){
		setTitle("Payroll Application");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(800,600);
		setResizable(true);
		setLocationRelativeTo(null);
	

		/********************CREATE MENU*********************/
		JMenuBar coreMenu = new JMenuBar();
		
		JMenu data = new JMenu("Data");
		JMenu tasks = new JMenu("Tasks");
		
		JMenuItem exit =new JMenuItem("Exit");
		exit.addActionListener(this);
		
		JMenuItem empInf = new JMenuItem("Employee Information");
		empInf.addActionListener(this);
		
		JMenuItem compInf = new JMenuItem("Company Information");
		compInf.addActionListener(this);
		
		JMenuItem calcPay = new JMenuItem("Calculate Payroll");
		calcPay.addActionListener(this);
		
		JMenuItem viewPay = new JMenuItem("View Payroll");
		viewPay.addActionListener(this);
		
		data.add(empInf);
		data.add(compInf);
		tasks.add(calcPay);
		tasks.add(viewPay);
		
		coreMenu.add(data);
		coreMenu.add(tasks);
		coreMenu.add(exit);
		setJMenuBar(coreMenu);
		/********************End of core menu******************/
		
		/********************Create CORE PANEL*****************/
		JPanel corePanel = new JPanel();
		FlowLayout flowLayout = new FlowLayout();
		corePanel.setLayout(flowLayout);
		
		
		add(corePanel);
		setVisible(true);
	}
	//Action performed for each button
	public void actionPerformed(ActionEvent e){
    	String cmd = e.getActionCommand();
    	if(cmd.equals("Employee Information")){
			System.out.println(cmd + " selected");
			JFrame employees = new EmpGui();
    	}
    	else if(cmd.equals("Company Information")){
    		System.out.println(cmd + " selected");
    		JFrame company = new CompGui();
    	}
    	else if(cmd.equals("Calculate Payroll")){
    		System.out.println(cmd + " selected");
    		JFrame calculate = new CalcGui();
    	}
    	else if(cmd.equals("View Payroll")){
    		System.out.println(cmd + " selected");
    		JFrame view = new ViewGui();
    	}
    	else if(cmd.equals("Exit")){
    		System.exit(0);
    	}
    	
    }
}

/********************EMPLOYEE TAB GUI***************************/
class EmpGui extends JFrame implements ActionListener{
	
	final empStorage emp =new empStorage();
    int move = 0,i=0;
    JTextField txt_fName,txt_sName,txt_address,txt_sal,txt_child,find_txt;
    JComboBox marStatus,sex;
    
	public EmpGui(){
		
		setTitle("Employee Data");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(800,600);
		setResizable(true);
		setLocationRelativeTo(null);
	
		
		JPanel epanel = new JPanel();
		FlowLayout fl = new FlowLayout();
		epanel.setLayout(fl);
		
		JPanel main = new JPanel();
		GridLayout gl = new GridLayout(4,1,0,30);
		main.setLayout(gl);
		
		/*Navigation Control buttons*/
		JPanel control = new JPanel();
		GridLayout ctrl = new GridLayout(1,6,20,0);
		control.setLayout(ctrl);

		JButton load = new JButton("Load Data");
		load.addActionListener(this);
		
		JButton first = new JButton("First");
		first.addActionListener(this);
		
		JButton prev = new JButton("<<");
		prev.addActionListener(this);
		
		JButton next = new JButton(">>");
		next.addActionListener(this);
		
		JButton last = new JButton("Last");
		last.addActionListener(this);
		
		JButton save = new JButton("Save Data");
		save.addActionListener(this);
		
		control.add(load);
		control.add(first);
		control.add(prev);
		control.add(next);
		control.add(last);
		control.add(save);
		
		main.add(control);
		
		/*Find employee GUI */
		JPanel find = new JPanel();
		GridLayout findLay = new GridLayout(1,2,20,0);
		find.setLayout(findLay);
		
		JPanel findEmp = new JPanel();
		GridLayout fin = new GridLayout(2,1);
		findEmp.setLayout(fin);
		
		JLabel find_lbl = new JLabel("Employee No");
		find_txt = new JTextField(10);
		findEmp.add(find_lbl);
		findEmp.add(find_txt);
		
		JButton srch = new JButton("Find");
		srch.addActionListener(this);
		find.add(findEmp);
		find.add(srch);
		
		main.add(find);
		
	/*EMPLOYEE TEXT INFO*/
		
		JPanel txt = new JPanel();
		GridLayout txtLayout = new GridLayout(2,3,20,0);
		txt.setLayout(txtLayout);

		JLabel lbl_fName = new JLabel("First Name:");
		txt_fName = new JTextField(10);
		
		JLabel lbl_sName = new JLabel("Surname:");
		txt_sName = new JTextField(10);
		
		JLabel lbl_address = new JLabel("Address:");
		txt_address = new JTextField(20);
	
		txt.add(lbl_fName);
		txt.add(lbl_sName);
		txt.add(lbl_address);
		txt.add(txt_fName);
		txt.add(txt_sName);
		txt.add(txt_address);
			
		main.add(txt);
		
		
		/*Employee Extra details*/
		JPanel extra = new JPanel();
		GridLayout ed = new GridLayout(2,4,20,0);
		extra.setLayout(ed);
		
	
			
		JLabel lbl_status = new JLabel("Marital Status");
		marStatus= new JComboBox();
		marStatus.addItem("M");			marStatus.addItem("S");
		marStatus.setSelectedItem("M");
		
		JLabel lbl_sex = new JLabel("Sex");
		sex = new JComboBox();
		sex.addItem("M");		sex.addItem("F");
		sex.setSelectedItem("M");
		
		JLabel lbl_sal = new JLabel("Salary");
		txt_sal = new JTextField(10);
		
		JLabel lbl_child = new JLabel("No of Children");
		txt_child = new JTextField(10);
		
		extra.add(lbl_status);
		extra.add(lbl_sex);
		extra.add(lbl_sal);
		extra.add(lbl_child);
		extra.add(marStatus);
		extra.add(sex);
		extra.add(txt_sal);	
		extra.add(txt_child);
		
		main.add(extra);
		epanel.add(main);
		add(epanel);
		setVisible(true);
	}//END OF CONSTRUCTOR
	
	//Display Employee information
	public void display(Employee e){
		txt_fName.setText(e.getFname());
		txt_sName.setText(e.getSname());
		txt_address.setText(e.getAddress());
		txt_sal.setText(String.valueOf(e.getSalary()));
		txt_child.setText(String.valueOf(e.getChildren()));
		
		if(e.getMaritalStatus()=='M')
				marStatus.setSelectedIndex(0);
		else marStatus.setSelectedIndex(1);
		
		if(e.getSex()=='M')
				sex.setSelectedIndex(0);
		else sex.setSelectedIndex(1);
	}
	//Button actions for employee tab
	public void actionPerformed(ActionEvent e){
    	String cmd = e.getActionCommand();
    	
    	if(cmd.equals("Load Data")){
			System.out.println(cmd + " selected");
			emp.loadEmployees();	
			JOptionPane.showMessageDialog(null,"Employee records loaded","Load Employee Records",JOptionPane.INFORMATION_MESSAGE);
    	}
    	else if(cmd.equals("First")){
    		System.out.println(cmd + " selected");
    		move=0;
    		display(emp.employees.get(move));
    	
    	}
    	else if(cmd.equals("<<")){
    		System.out.println(cmd + " selected");
    		if(move-1>=0){
    			move=move-1;
    			display(emp.employees.get(move));	
    		}
    		else
    			JOptionPane.showMessageDialog(null,"There is no previous record","Invalid Navigation",JOptionPane.INFORMATION_MESSAGE);
    	}
    	else if(cmd.equals(">>")){
    		System.out.println(cmd + " selected");
    		if(move+1<emp.employees.size()){
    			move=move+1;
    			display(emp.employees.get(move));
    		}
    		else
    			JOptionPane.showMessageDialog(null,"There is no next record","Invalid Navigation",JOptionPane.INFORMATION_MESSAGE);
    	}
    	else if(cmd.equals("Last")){
    		System.out.println(cmd + " selected");
    		move=(emp.employees.size())-1;
    		display(emp.employees.get(move));
    	}
    	else if(cmd.equals("Save Data")){
    		System.out.println(cmd + " selected");
    		emp.storeEmployees();
    		JOptionPane.showMessageDialog(null,"Employee records saved","Save Employee Records",JOptionPane.INFORMATION_MESSAGE);
    	}
    	else if(cmd.equals("Find")){
    		System.out.println(cmd + " selected");
    		if(!find_txt.getText().equals("")){
    				int key= Integer.parseInt(find_txt.getText());
    		
    				for(i=0;i<emp.employees.size();i++){
    		 			if(emp.employees.get(i).getEmpNo() == key)
    		 					break;
    				}
    		}
    		else
    			 i=emp.employees.size();
    			 
    		if(i<emp.employees.size()){
    				display(emp.employees.get(i));
    		}
    		else 
    				JOptionPane.showMessageDialog(null,"RECORD NOT FOUND,PLEASE ENSURE DATA IS LOADED, ELSE RECORD DOES NOT EXIST","Record doesn't exist",JOptionPane.INFORMATION_MESSAGE); 
    	}	
    }
}

/**************COMPANY GUI TAB*******************/
class CompGui extends JFrame implements ActionListener{
	
	final Company comp=new Company();
	JTextField comptxt,Yrtxt,Annualtxt,Mnthtxt,Taxtxt,NIStxt;
	
	public CompGui(){
		
		setTitle("Company Information");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(800,600);
		setResizable(true);
		setLocationRelativeTo(null);
	
		JPanel cpanel = new JPanel();
		FlowLayout cl = new FlowLayout();
		cpanel.setLayout(cl);
		
		JPanel main = new JPanel();
		GridLayout gl = new GridLayout(4,1,0,30);
		main.setLayout(gl);
		
		/*Operation Control buttons*/
		JPanel operate = new JPanel();
		GridLayout ol = new GridLayout(1,2,30,0);
		operate.setLayout(ol);

		JButton load = new JButton("Load Data");
		load.addActionListener(this);
		
		JButton save = new JButton("Save Data");
		save.addActionListener(this);
		
		operate.add(load);
		operate.add(save);
		main.add(operate);
		
		/*Company Name*/
		JPanel company = new JPanel();
		GridLayout com = new GridLayout(2,1);
		company.setLayout(com);
		JLabel comp_lbl = new JLabel("Company Name");
		comptxt = new JTextField(10);
		company.add(comp_lbl);
		company.add(comptxt);
		
		main.add(company);
		
		/*Payroll Information 1*/
		JPanel pay1 = new JPanel();
		GridLayout p1 = new GridLayout(2,2,30,0);
		pay1.setLayout(p1);
		
		JLabel currYr = new JLabel("Current Payroll Year");
		Yrtxt = new JTextField(10);
		
		JLabel Annual = new JLabel("Annual Allowance");
		Annualtxt = new JTextField(10);
			
		pay1.add(currYr);
		pay1.add(Annual);
		pay1.add(Yrtxt);
		pay1.add(Annualtxt);
		main.add(pay1);
				
		/*Payroll Information 2*/
		JPanel pay2 = new JPanel();
		GridLayout p2 = new GridLayout(2,3,30,0);
		pay2.setLayout(p2);
		
		JLabel currMnth = new JLabel("Current Payroll Month");
		Mnthtxt = new JTextField(10);
		
		JLabel Tax = new JLabel("Tax Rate");
		Taxtxt = new JTextField(10);
		
		JLabel NIS = new JLabel("NIS Rate");
		NIStxt = new JTextField(10);
			
		pay2.add(currMnth);
		pay2.add(Tax);
		pay2.add(NIS);
		pay2.add(Mnthtxt);
		pay2.add(Taxtxt);
		pay2.add(NIStxt);
		
		main.add(pay2);
		
		cpanel.add(main);
		add(cpanel);
		setVisible(true);
	}//END OF CONSTRUCTOR
	
	//Display company information
	public void display(Company c){
	 	comptxt.setText(c.getCompName());
		Yrtxt.setText(String.valueOf(c.getYear()));
		Mnthtxt.setText(String.valueOf(String.valueOf(c.getMonth())));
		Annualtxt.setText(String.valueOf(c.getAnnual()));
		Taxtxt.setText(String.valueOf(c.getTaxRate()));
		NIStxt.setText(String.valueOf(c.getNis()));
	}
	//Company buttons actions
	public void actionPerformed(ActionEvent e){
    	String cmd = e.getActionCommand();
    	
    	if(cmd.equals("Load Data")){
			System.out.println(cmd + " selected");
			comp.loadCompany();
			JOptionPane.showMessageDialog(null,"Company record loaded","Load Employee Record",JOptionPane.INFORMATION_MESSAGE);
			display(comp);
			}
    	else if(cmd.equals("Save Data")){
    		System.out.println(cmd + " selected");
    		comp.saveCompany();
    		JOptionPane.showMessageDialog(null,"Company record saved","Save Employee Records",JOptionPane.INFORMATION_MESSAGE);
    	}
    }		
}

/*******************Calculate Pay GUI*********************/
class CalcGui extends JFrame implements ActionListener {
	
	JTextField find_txt,txt_fName,txt_sName,txt_sal,txt_taxes,NIS_txt,Net_txt;
	EmpFinanceStorage empFin = new EmpFinanceStorage();
	EmpFinanceStorage empHist = new EmpFinanceStorage();
	EmpFinance temp,temp1,temp2;
	Company comp = new Company();
	empStorage emp = new empStorage();
	Employee tempE;
	String fn,sn;
	int move=0,i=0,eno;
	double sal,tx,n,np;
			
	
	public CalcGui(){
		
		setTitle("Calculate Payroll");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(800,600);
		setResizable(true);
		setLocationRelativeTo(null);
	
		
		JPanel calcpanel = new JPanel();
		FlowLayout fl = new FlowLayout();
		calcpanel.setLayout(fl);
		
		JPanel main = new JPanel();
		GridLayout gl = new GridLayout(3,1,0,30);
		main.setLayout(gl);
		
		/*Operation Buttons*/
		JPanel ctrl = new JPanel();
		GridLayout cl = new GridLayout(1,7,15,0);
		ctrl.setLayout(cl);
		
		JButton first = new JButton("First");
		first.addActionListener(this);
		
		JButton prev = new JButton("<<");
		prev.addActionListener(this);
		
		JButton next = new JButton(">>");
		next.addActionListener(this);
		
		JButton last = new JButton("Last");
		last.addActionListener(this);	
		
		JButton load = new JButton("Load Previous Calculate");
		load.addActionListener(this);
		
		JButton calc = new JButton("Calculate Pay");
		calc.addActionListener(this);
		
		JButton commit = new JButton("Commit to History");
		commit.addActionListener(this);
		
		ctrl.add(first);
		ctrl.add(prev);
		ctrl.add(next);
		ctrl.add(last);
		ctrl.add(load);
		ctrl.add(calc);
		ctrl.add(commit);
		main.add(ctrl);
		
		
		/*Find employee GUI */
		JPanel findEmp = new JPanel();
		GridLayout f = new GridLayout(1,2,30,0);
		findEmp.setLayout(f);
		
		JPanel empFind = new JPanel();
		GridLayout fin = new GridLayout(2,1,30,0);
		empFind.setLayout(fin);
		
		JLabel find_lbl = new JLabel("Employee No");
		find_txt = new JTextField(8);
		
		empFind.add(find_lbl);
		empFind.add(find_txt);
		
		JButton search = new JButton("Find");
		search.addActionListener(this);
		
		findEmp.add(empFind);
		findEmp.add(search);
		
		main.add(findEmp);
		
		
		/*EMPLOYEE INFORMATION*/
		
		JPanel info = new JPanel();
		GridLayout inf = new GridLayout(2,6,30,0);
		info.setLayout(inf);

		JLabel lbl_fName = new JLabel("First Name");
		txt_fName = new JTextField(10);
		
		JLabel lbl_sName = new JLabel("Surname");
		txt_sName = new JTextField(10);
		
		JLabel lbl_sal = new JLabel("Salary");
		txt_sal = new JTextField(10);
		
		JLabel lbl_Taxes = new JLabel("Taxes");
		txt_taxes = new JTextField(10);
		
		JLabel lbl_NIS = new JLabel("NIS Rate");
		NIS_txt = new JTextField(10);
		
		JLabel lbl_Net = new JLabel("Net Pay");
		Net_txt = new JTextField(10);
				
	
		info.add(lbl_fName);
		info.add(lbl_sName);
		info.add(lbl_sal);
		info.add(lbl_Taxes);
		info.add(lbl_NIS);
		info.add(lbl_Net);
		info.add(txt_fName);
		info.add(txt_sName);
		info.add(txt_sal);
		info.add(txt_taxes);
		info.add(NIS_txt);
		info.add(Net_txt);	
			
		main.add(info);
		calcpanel.add(main);
		add(calcpanel);
		setVisible(true);		
	}//END OF CONSTRUCTOR
	
	//Display calculate information
	public void display(EmpFinance e){
		txt_fName.setText(e.getFname());
		txt_sName.setText(e.getSname());
		txt_sal.setText(String.valueOf(e.getSalary()));
		txt_taxes.setText(String.valueOf(e.getTax()));
		NIS_txt.setText(String.valueOf(e.getNis()));
		Net_txt.setText(String.valueOf(e.getNetPay()));
	}
	//Calculate tab Button Actions
	public void actionPerformed(ActionEvent e){
    	String cmd = e.getActionCommand();
    	
    	if(cmd.equals("First")){
    		System.out.println(cmd + " selected");
    		move=0;
    		display(empFin.employeeFin.get(move));
    	}
    	else if(cmd.equals("<<")){
    		System.out.println(cmd + " selected");
    		if(move-1>=0){
    			move=move-1;
    			display(empFin.employeeFin.get(move));	
    		}
    		else
    			JOptionPane.showMessageDialog(null,"There is no previous record","Invalid Navigation",JOptionPane.INFORMATION_MESSAGE);
    	
    	}
    	else if(cmd.equals(">>")){
    		System.out.println(cmd + " selected");
    		if(move+1<empFin.employeeFin.size()){
    			move=move+1;
    			display(empFin.employeeFin.get(move));
    		}
    		else
    			JOptionPane.showMessageDialog(null,"There is no next record","Invalid Navigation",JOptionPane.INFORMATION_MESSAGE);
    	
    	}
    	else if(cmd.equals("Last")){
    		System.out.println(cmd + " selected");
    		move=(empFin.employeeFin.size())-1;
    		display(empFin.employeeFin.get(move));
    	}
    	else if(cmd.equals("Load Previous Calculate")){
    		System.out.println(cmd + " selected");
    		empFin.loadEmpFinance();	
			JOptionPane.showMessageDialog(null,"Employee Finance records loaded","Load Employee Finance Records",JOptionPane.INFORMATION_MESSAGE);
    	
    	}
    	else if(cmd.equals("Calculate Pay")){
    		System.out.println(cmd + " selected");
    		emp.loadEmployees();//get employee info
    		comp.loadCompany();//get company info
    		empFin.employeeFin.clear();//clears emp finance list data structure
    		
    		for(i=0;i<emp.employees.size();i++){//Calculates employee finance information for each employee per month
    					tempE=emp.employees.get(i);

    					eno=tempE.getEmpNo();
						fn=tempE.getFname();
						sn=tempE.getSname();
						sal=tempE.getSalary();
						tx=(((sal*12)-comp.getAnnual())*comp.getTaxRate()*0.01)/12;
						n=comp.getNis()*sal*0.01;
						np=sal-(tx+n);
						
						temp = new EmpFinance(eno,fn,sn,sal,tx,n,np);			
						empFin.employeeFin.add(temp);	
    		}
    		empFin.storeEmpFinance();
    	}
    	else if(cmd.equals("Commit to History")){
    		System.out.println(cmd + " selected");
    		empHist.loadEmpHistory();
    		
    		if(comp.getMonth()==1)
    				empHist.employeeFin.clear();
    		
    		for(i=0;i<empFin.employeeFin.size();i++){
    				int j=0,found =0;
    				temp=empFin.employeeFin.get(i);
    				
    				//Searches payroll data for employee records
    				for(j=0;j<empHist.employeeFin.size();j++){
    							temp1=empHist.employeeFin.get(j);
    							if(temp.getEmpNo() == temp1.getEmpNo()){
    									temp2=temp1;
    									found=1;
    							}
    				}
    				if (found==1){//If record is found updates record information
    						eno=temp.getEmpNo();
    						fn=temp.getFname();
    						sn=temp.getSname();
    						sal=temp2.getSalary()+temp.getSalary();
    						tx=temp2.getTax()+temp.getTax();
    						n=temp2.getNis()+temp.getNis();
    						np=temp2.getNetPay()+temp.getNetPay();
    						temp1= new EmpFinance(eno,fn,sn,sal,tx,n,np);
    						empHist.employeeFin.add(temp1);
    				}
    				//Otherwise appends record to file
    				else empHist.employeeFin.add(temp);
			}
			empHist.storeEmpHistory();//Stores record in file
			comp.loadCompany();//loads company information and incrememnts current payroll year and month
			
			if((comp.getMonth()+1) <= 12)
					comp.setMonth(comp.getMonth()+1);
			else{
				comp.setYear(comp.getYear()+1);
				comp.setMonth(1);
			}
			comp.saveCompany();
    	}
    	else if(cmd.equals("Find")){
    		System.out.println(cmd + " selected");
    			
    		if(!find_txt.getText().equals("")){
    				int key= Integer.parseInt(find_txt.getText());
    		
    				for(i=0;i<empFin.employeeFin.size();i++){
    		 			if(empFin.employeeFin.get(i).getEmpNo() == key)
    		 					break;
    				}
    		}
    		else{
    			 i=emp.employees.size();
    		}
    		
    		if(i<empFin.employeeFin.size()){
    				display(empFin.employeeFin.get(i));
    		}
    		else 
    				JOptionPane.showMessageDialog(null,"RECORD NOT FOUND","Record doesn't exist",JOptionPane.INFORMATION_MESSAGE); 
    	}		
    }			
}
/************************	VIEW GUI ******************/
class ViewGui extends JFrame implements ActionListener {
	JTextArea txt_data;
	JScrollPane display;
	EmpFinanceStorage empHist = new EmpFinanceStorage();
	EmpFinance t;
	
	public ViewGui(){
		
		setTitle("Employee History Report (Year-To-Date)");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(800,600);
		setResizable(true);
		setLocationRelativeTo(null);
	
		
		JPanel vpanel = new JPanel();
		FlowLayout vl = new FlowLayout();
		vpanel.setLayout(vl);
		
		JPanel main = new JPanel();
		GridLayout gl = new GridLayout(2,1,0,30);
		main.setLayout(gl);
		
		/*Operation Control buttons*/
		JPanel controls = new JPanel();
		GridLayout cl = new GridLayout(1,3,30,0);
		controls.setLayout(cl);

		JButton load = new JButton("Load History Data");
		load.addActionListener(this);
		
		
		JButton sortName = new JButton("Sort By Last Name");
		sortName.addActionListener(this);
		
		JButton sortPay = new JButton("Sort By Largest Net Pay");
		sortPay.addActionListener(this);
		
		controls.add(load);
		controls.add(sortName);
		controls.add(sortPay);
		
		main.add(controls);
		
		/*Display History data*/
		
		JPanel disp = new JPanel();
		GridLayout dp = new GridLayout(2,1);
		disp.setLayout(dp);
		
		JLabel dispDate = new JLabel("Year_To_Date Employee Data");
		txt_data = new JTextArea(6,30);
		display = new JScrollPane(txt_data);
		disp.add(dispDate);
		disp.add(display);
		
		main.add(disp);
		
		vpanel.add(main);
		add(vpanel);
		setVisible(true);
	}//END OF CONSTRUCTOR
	
	//Display history Data
	public void display(EmpFinanceStorage e){
		String line= null;
		int i;
		EmpFinance t;
		if(e.employeeFin.size()<=0){
				JOptionPane.showMessageDialog(null,"There are no employee history records","Display Employee History Records",JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			line= "\t\t Z bakery\n\t\tYear To Date Payroll Data\n\n";
			line+="EmpNo\tFirstName\tSurname\tSalary\tTaxes\tNIS\tNetPay\n";
			line+="=========================================================================================\n";
			
			for(i=0;i<e.employeeFin.size();i++){
					t=e.employeeFin.get(i);
					line+= t.getEmpNo()+"\t"+t.getFname()+"\t"+t.getSname()+"\t"+t.getSalary()+"\t"+t.getTax()+"\t"+t.getNis()+"\t"+t.getNetPay()+"\n";
			}
			txt_data.setText(line);				
		}	
	}
	//View GUI action buttons
	public void actionPerformed(ActionEvent e){
    	String cmd = e.getActionCommand();
    	
    	if(cmd.equals("Load History Data")){
			System.out.println(cmd + " selected");
			empHist.loadEmpHistory();
			display(empHist);
			if(empHist.employeeFin.size()>0)
				JOptionPane.showMessageDialog(null,"Employee History records loaded","Load Employee History Records",JOptionPane.INFORMATION_MESSAGE);
    	}
    	else if(cmd.equals("Sort By Last Name")){
    		System.out.println(cmd + " selected");
    		Collections.sort(empHist.employeeFin, EmpFinance.SortBySurname);
    		display(empHist);
    	}
    	else if(cmd.equals("Sort By Largest Net Pay")){
    		System.out.println(cmd + " selected");
    		Collections.sort(empHist.employeeFin, EmpFinance.SortByNetPay);
    		display(empHist);
    	}
    }	
}


	