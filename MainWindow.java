import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

import java.awt.Color;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.mysql.jdbc.DatabaseMetaData;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField txtSearch;
	private String[] sColumns=new String[] {"Sr#","Name", "ID", "Department", "Year", "E-mail", "PAT Name"};
	private String[][] data;
	private String[] pColumns=new String[] {"Sr#","Name", "Department", "E-mail", "Load"};
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtSName;
	private JTextField txtSDep;
	private JTextField txtSId;
	private JTextField txtSEmail;
	private JTextField txtPName;
	private JTextField txtPDep;
	private JTextField txtPEmail;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private DataBaseManager m;
	private JTable table_2;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1390, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 153));
		panel.setBounds(0, 0, 1362, 193);
		contentPane.add(panel);
		panel.setLayout(null);

		txtSearch = new JTextField();
		txtSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(txtSearch.getText().equals("Search Here")){
					txtSearch.setText("");
					txtSearch.setForeground(Color.BLACK);
				}
				System.out.println("Entered");
			}
		});
		txtSearch.setBorder(null);
		txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSearch.setForeground(Color.LIGHT_GRAY);
		txtSearch.setHorizontalAlignment(SwingConstants.CENTER);
		txtSearch.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtSearch.setToolTipText("Search Data");
		txtSearch.setText("Search Here");
		txtSearch.setBounds(537, 90, 265, 41);
		panel.add(txtSearch);
		txtSearch.setColumns(10);

		JRadioButton rdbtnName = new JRadioButton("Name");
		rdbtnName.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonGroup.add(rdbtnName);
		rdbtnName.setOpaque(false);
		rdbtnName.setFocusPainted(false);
		rdbtnName.setSelected(true);
		rdbtnName.setForeground(Color.WHITE);
		rdbtnName.setBounds(534, 145, 62, 23);
		panel.add(rdbtnName);

		JRadioButton rdbtnId = new JRadioButton("ID");
		rdbtnId.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonGroup.add(rdbtnId);
		rdbtnId.setSelected(true);
		rdbtnId.setOpaque(false);
		rdbtnId.setForeground(Color.WHITE);
		rdbtnId.setFocusPainted(false);
		rdbtnId.setBounds(470, 145, 62, 23);
		panel.add(rdbtnId);

		JRadioButton rdbtnDepartment = new JRadioButton("Department");
		rdbtnDepartment.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonGroup.add(rdbtnDepartment);
		rdbtnDepartment.setSelected(true);
		rdbtnDepartment.setOpaque(false);
		rdbtnDepartment.setForeground(Color.WHITE);
		rdbtnDepartment.setFocusPainted(false);
		rdbtnDepartment.setBounds(598, 145, 103, 23);
		panel.add(rdbtnDepartment);

		JRadioButton rdbtnEmail = new JRadioButton("E-mail");
		rdbtnEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonGroup.add(rdbtnEmail);
		rdbtnEmail.setSelected(true);
		rdbtnEmail.setOpaque(false);
		rdbtnEmail.setForeground(Color.WHITE);
		rdbtnEmail.setFocusPainted(false);
		rdbtnEmail.setBounds(703, 145, 77, 23);
		panel.add(rdbtnEmail);

		JRadioButton rdbtnYear = new JRadioButton("Year");
		rdbtnYear.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonGroup.add(rdbtnYear);
		rdbtnYear.setSelected(true);
		rdbtnYear.setOpaque(false);
		rdbtnYear.setForeground(Color.WHITE);
		rdbtnYear.setFocusPainted(false);
		rdbtnYear.setBounds(783, 145, 72, 23);
		panel.add(rdbtnYear);

		JRadioButton rdbtnPat = new JRadioButton("PAT");
		rdbtnPat.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonGroup.add(rdbtnPat);
		rdbtnPat.setSelected(true);
		rdbtnPat.setOpaque(false);
		rdbtnPat.setForeground(Color.WHITE);
		rdbtnPat.setFocusPainted(false);
		rdbtnPat.setBounds(845, 145, 62, 23);
		panel.add(rdbtnPat);

		JCheckBox chckbxNotAllocated = new JCheckBox("Not Allocated");
		chckbxNotAllocated.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxNotAllocated.setForeground(Color.WHITE);
		chckbxNotAllocated.setOpaque(false);
		chckbxNotAllocated.setBounds(930, 138, 126, 36);
		panel.add(chckbxNotAllocated);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(10, 42, 142, 140);
		panel.add(label_2);
		
		JLabel lblNewLabel = new JLabel("Namal PAT Manager");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(503, 11, 331, 41);
		panel.add(lblNewLabel);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 14));
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(tabbedPane.getSelectedIndex()==0 || tabbedPane.getSelectedIndex()==3){
					txtSearch.setVisible(false);
					rdbtnDepartment.setVisible(false);
					rdbtnName.setVisible(false);
					rdbtnEmail.setVisible(false);
					rdbtnId.setVisible(false);
					rdbtnYear.setVisible(false);
					rdbtnPat.setVisible(false);
					chckbxNotAllocated.setVisible(false);
				}
				else{
					rdbtnDepartment.setVisible(true);
					rdbtnName.setVisible(true);
					rdbtnEmail.setVisible(true);
					rdbtnId.setVisible(true);
					rdbtnYear.setVisible(true);
					rdbtnPat.setVisible(true);
					chckbxNotAllocated.setVisible(true);
					txtSearch.setVisible(true);
				}
			}
		});
		tabbedPane.setBackground(new Color(51, 153, 153));
		tabbedPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		tabbedPane.setBounds(-11, 191, 1373, 520);
		contentPane.add(tabbedPane);
		tabbedPane.setForeground(Color.white);

		JPanel Home = new JPanel();
		Home.setFont(UIManager.getFont("OptionPane.font"));
		tabbedPane.addTab("Home", new ImageIcon("G:\\WorkSpace\\home.png"), Home, null);
		Home.setLayout(null);

		JList list = new JList();
		list.setFont(new Font("Arial", Font.PLAIN, 14));
		list.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		list.setFixedCellHeight(40);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(104, 89, 385, 387);
		Home.add(list);
		list.setBackground(SystemColor.info);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Allocate Muhammad Ikram to Malik Adnan.", "Allocate  Ajmal Awan to Malik Adnan.", "Allocate Naeem Ul Haq  to Ambreen Hanif.", "Allocate Jamal to Malik Shahzad Iqbal.", "Allocate Zain ul Abideen to Dr. Adil Raja.", "Allocate Muhammad Kamran to Dr. Adil Raja."};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JLabel lblRequests = new JLabel("Requests");
		lblRequests.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRequests.setBounds(104, 49, 133, 29);
		Home.add(lblRequests);
		
		JLabel lblRecentActivity = new JLabel("Recent Activity");
		lblRecentActivity.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRecentActivity.setBounds(574, 49, 178, 29);
		Home.add(lblRecentActivity);
		
		JList list_2 = new JList();
		list_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		list_2.setFixedCellHeight(40);
		list_2.setModel(new AbstractListModel() {
			String[] values = new String[] {"Kamal Khan De-Allocated from Dr. Nusrat", "Ahmad Nadeem De-Allocated from Dr. Amir Khurram", "Allocated all students automatically.", "De-Allocated  All students.", "Dr. Adil raja's load was set to Full.", "Sajid Ali allocated to Dr. Adil Raja.", "Nasir Kamal allocated to Dr. Israr.", "Yahya Husain allocated to Malik Jahan Khan"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_2.setBounds(574, 89, 385, 387);
		Home.add(list_2);

		JPanel records = new JPanel();
		tabbedPane.addTab("Records", new ImageIcon("G:\\WorkSpace\\history.png"), records, null);
		records.setLayout(null);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.RIGHT);
		tabbedPane_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(tabbedPane_1.getSelectedIndex()==0){
					rdbtnDepartment.setVisible(true);
					rdbtnName.setVisible(true);
					rdbtnEmail.setVisible(true);
					rdbtnId.setVisible(true);
					rdbtnYear.setVisible(true);
					rdbtnPat.setVisible(true);
					chckbxNotAllocated.setVisible(true);
				}
				else if(tabbedPane_1.getSelectedIndex()==1){
					rdbtnId.setVisible(false);
					rdbtnYear.setVisible(false);
					rdbtnPat.setVisible(false);
					chckbxNotAllocated.setVisible(false);
				}
			}
		});
		tabbedPane_1.setBorder(null);
		tabbedPane_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		tabbedPane_1.setBounds(0, 0, 1198, 515);
		records.add(tabbedPane_1);

		JPanel studentRecords = new JPanel();
		tabbedPane_1.addTab("Student Records", null, studentRecords, null);
		studentRecords.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 41, 708, 407);
		studentRecords.add(scrollPane);

		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		m=new DataBaseManager();
		updateTable();
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(0).setMinWidth(4);
		table.getColumnModel().getColumn(5).setMinWidth(47);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowHeight(25);
		table.setFillsViewportHeight(true);

		JButton btnSEdit = new JButton("Edit");
		btnSEdit.setEnabled(false);
		btnSEdit.setFocusPainted(false);
		btnSEdit.setForeground(Color.WHITE);
		btnSEdit.setBackground(new Color(0, 153, 153));
		btnSEdit.setBounds(838, 71, 104, 48);
		studentRecords.add(btnSEdit);

		JButton btnSDeAlloc = new JButton("De-Allocate");
		btnSDeAlloc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pat=table.getValueAt(table.getSelectedRow(), 6).toString();
				if(!pat.equals("-")){
					int a=JOptionPane.showConfirmDialog(null, "Are you sure to de-allocate this student?");
					if(a==0){
							String s=table.getValueAt(table.getSelectedRow(),2).toString();
							m.updateStudent("update students set pat='-' where id="+s);
							int n=m.getSizeOfPat(pat);
							System.out.println(n);
							m.updatePat("update pats set students="+(n-1)+" where name='"+pat+"'");
							updateTable();
					}
				}

			}
		});
		btnSDeAlloc.setEnabled(false);
		btnSDeAlloc.setFocusPainted(false);
		btnSDeAlloc.setForeground(Color.WHITE);
		btnSDeAlloc.setBackground(new Color(153, 153, 153));
		btnSDeAlloc.setBounds(838, 124, 104, 48);
		studentRecords.add(btnSDeAlloc);

		JButton btnSChngPat = new JButton("Change PAT");
		btnSChngPat.setEnabled(false);
		btnSChngPat.setFocusPainted(false);
		btnSChngPat.setForeground(Color.WHITE);
		btnSChngPat.setBackground(new Color(204, 153, 0));
		btnSChngPat.setBounds(838, 177, 104, 48);
		studentRecords.add(btnSChngPat);

		JButton btnSDelete = new JButton("Delete");
		btnSDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!table.getValueAt(table.getSelectedRow(),0).toString().equals("")){
					int n=JOptionPane.showConfirmDialog(null, "Are You Sure to Delete this Student?");
					if(n==0){
						String id=table.getValueAt(table.getSelectedRow(), 2).toString();
						m.delete("delete from students where id="+id);
						updateTable();
					}
				}
			}
		});
		btnSDelete.setEnabled(false);
		btnSDelete.setFocusPainted(false);
		btnSDelete.setForeground(Color.WHITE);
		btnSDelete.setBackground(new Color(204, 0, 51));
		btnSDelete.setBounds(838, 262, 104, 48);
		studentRecords.add(btnSDelete);

		JPanel patRecords = new JPanel();
		tabbedPane_1.addTab("PAT Records", null, patRecords, null);
		patRecords.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane_1.setName("PAT Data");
		scrollPane_1.setBounds(42, 46, 709, 430);
		patRecords.add(scrollPane_1);

		table_1 = new JTable();
		table_1.setAutoCreateRowSorter(true);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(table_1);
		table_1.setRowHeight(30);
		table_1.setModel(new DefaultTableModel(
				m.getPatList("select * from pats"),pColumns));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(10);
		JButton button_3 = new JButton("Edit");
		button_3.setBounds(847, 68, 104, 54);
		patRecords.add(button_3);

		JButton btnDeallocate = new JButton("De-Allocate");
		btnDeallocate.setBounds(847, 122, 104, 54);
		patRecords.add(btnDeallocate);

		JButton btnAdd_1 = new JButton("Add");
		btnAdd_1.setBounds(847, 204, 104, 54);
		patRecords.add(btnAdd_1);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(847, 258, 104, 54);
		patRecords.add(btnDelete);

		JPanel newPat = new JPanel();
		tabbedPane_1.addTab("Add new PAT", null, newPat, null);
		newPat.setLayout(null);

		JLabel label = new JLabel("Name:");
		label.setFont(new Font("Arial", Font.BOLD, 14));
		label.setBounds(438, 100, 54, 29);
		newPat.add(label);

		txtPName = new JTextField();
		txtPName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPName.setColumns(10);
		txtPName.setBounds(574, 100, 202, 29);
		newPat.add(txtPName);

		JLabel label_1 = new JLabel("Department:");
		label_1.setFont(new Font("Arial", Font.BOLD, 14));
		label_1.setBounds(400, 158, 92, 29);
		newPat.add(label_1);

		txtPDep = new JTextField();
		txtPDep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPDep.setColumns(10);
		txtPDep.setBounds(574, 158, 202, 29);
		newPat.add(txtPDep);

		JLabel lblEmail_1 = new JLabel("E-mail:");
		lblEmail_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblEmail_1.setBounds(438, 217, 54, 29);
		newPat.add(lblEmail_1);

		txtPEmail = new JTextField();
		txtPEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPEmail.setColumns(10);
		txtPEmail.setBounds(574, 217, 202, 29);
		newPat.add(txtPEmail);

		JLabel lblLoad = new JLabel("Load:");
		lblLoad.setFont(new Font("Arial", Font.BOLD, 14));
		lblLoad.setBounds(438, 274, 54, 29);
		newPat.add(lblLoad);

		JButton btnAddNewPat = new JButton("Add New PAT");
		btnAddNewPat.setForeground(Color.WHITE);
		btnAddNewPat.setFocusPainted(false);
		btnAddNewPat.setBackground(new Color(0, 153, 102));
		btnAddNewPat.setBounds(574, 344, 125, 40);
		newPat.add(btnAddNewPat);
		JCheckBox chckbxOnFullLoad = new JCheckBox("On Full Load");

		JButton btnPReset = new JButton("Reset");
		btnPReset.setForeground(Color.WHITE);
		btnPReset.setFocusPainted(false);
		btnPReset.setBackground(new Color(51, 102, 153));
		btnPReset.setBounds(730, 344, 86, 40);
		newPat.add(btnPReset);
		chckbxOnFullLoad.setFocusPainted(false);
		chckbxOnFullLoad.setSelected(true);
		buttonGroup_1.add(chckbxOnFullLoad);
		chckbxOnFullLoad.setFont(new Font("Arial", Font.PLAIN, 14));
		chckbxOnFullLoad.setBounds(574, 278, 114, 23);
		newPat.add(chckbxOnFullLoad);

		JCheckBox chckbxOnPartialLoad = new JCheckBox("On Partial Load");
		chckbxOnPartialLoad.setFocusPainted(false);
		buttonGroup_1.add(chckbxOnPartialLoad);
		chckbxOnPartialLoad.setFont(new Font("Arial", Font.PLAIN, 14));
		chckbxOnPartialLoad.setBounds(691, 277, 125, 23);
		newPat.add(chckbxOnPartialLoad);
		btnPReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtPDep.setText("");
				txtPName.setText("");
				txtPEmail.setText("");
				chckbxOnFullLoad.setSelected(true);
			}
		});

		JPanel newStudent = new JPanel();
		tabbedPane_1.addTab("Add New Student", null, newStudent, null);
		newStudent.setLayout(null);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Arial", Font.BOLD, 14));
		lblName.setBounds(344, 69, 54, 29);
		newStudent.add(lblName);

		txtSName = new JTextField();
		txtSName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSName.setBounds(480, 69, 202, 29);
		newStudent.add(txtSName);
		txtSName.setColumns(10);

		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setFont(new Font("Arial", Font.BOLD, 14));
		lblDepartment.setBounds(306, 127, 92, 29);
		newStudent.add(lblDepartment);

		txtSDep = new JTextField();
		txtSDep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSDep.setColumns(10);
		txtSDep.setBounds(480, 127, 202, 29);
		newStudent.add(txtSDep);

		txtSId = new JTextField();
		txtSId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSId.setColumns(10);
		txtSId.setBounds(480, 181, 202, 29);
		newStudent.add(txtSId);

		JLabel lblStudentId = new JLabel("Student ID:");
		lblStudentId.setFont(new Font("Arial", Font.BOLD, 14));
		btnAddNewPat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!txtPName.getText().equals("")){
					if(!txtPDep.getText().equals("")){
						if(!txtPEmail.getText().equals("") && txtPEmail.getText().contains("@")){
							String load="P";
							if(chckbxOnFullLoad.isSelected()){
								load="F";
							}
							String[][] l=m.getPatList("select * from pats where email='"+txtPEmail.getText()+"'");
							if(l.length==0){
								m.addPat(txtPName.getText(), txtPDep.getText(), txtPEmail.getText(), load);
								JOptionPane.showMessageDialog(null, "New PAT added!","New PAT",JOptionPane.INFORMATION_MESSAGE);
								txtPName.setText("");
								txtPEmail.setText("");
								txtPDep.setText("");
								chckbxOnFullLoad.setSelected(true);
								updateTable1();
							}
							else{
								JOptionPane.showMessageDialog(null, "PAT with same E-mail Already Exist","Error",JOptionPane.ERROR_MESSAGE);
							}
						}
						else{
							JOptionPane.showMessageDialog(null, "Invalid E-mail","Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});

		lblStudentId.setBounds(315, 181, 83, 29);
		newStudent.add(lblStudentId);

		JLabel lblYear = new JLabel("Year:");
		lblYear.setFont(new Font("Arial", Font.BOLD, 14));
		lblYear.setBounds(354, 292, 44, 29);
		newStudent.add(lblYear);

		txtSEmail = new JTextField();
		txtSEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSEmail.setColumns(10);
		txtSEmail.setBounds(480, 239, 202, 29);
		newStudent.add(txtSEmail);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 14));
		lblEmail.setBounds(344, 239, 54, 29);
		newStudent.add(lblEmail);

		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.setFocusPainted(false);
		btnAddStudent.setForeground(Color.WHITE);
		btnAddStudent.setBackground(new Color(0, 153, 102));
		btnAddStudent.setBounds(480, 366, 125, 40);
		newStudent.add(btnAddStudent);

		JComboBox comboBoxYear = new JComboBox();
		comboBoxYear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxYear.setModel(new DefaultComboBoxModel(new String[] {"One", "Two", "Three", "Four"}));
		comboBoxYear.setBounds(484, 289, 115, 28);
		newStudent.add(comboBoxYear);
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!txtSName.getText().equals("")){
					if(!txtSDep.getText().equals("")){
						if(!txtSId.getText().equals("")){
							if(!txtSEmail.equals("") && txtSEmail.getText().contains("@")){
								String[][] l=m.getDataList("select * from students where id="+txtSId.getText());
								if(l.length==0){
									m.addStudent(txtSName.getText(),txtSId.getText(), txtSEmail.getText(),txtSDep.getText(),(comboBoxYear.getSelectedIndex()+1)+"");
									JOptionPane.showMessageDialog(null, "New Student Added!","Added",JOptionPane.INFORMATION_MESSAGE);
									txtSName.setText("");
									txtSDep.setText("");
									txtSEmail.setText("");
									txtSId.setText("");
									comboBoxYear.setSelectedIndex(0);
									updateTable();
								}
								else{
									JOptionPane.showMessageDialog(null, "Student already exist!","Student",JOptionPane.INFORMATION_MESSAGE);
								}
							}
							else{
								JOptionPane.showMessageDialog(null, "Invalid E-mail Address!","Error",JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}
			}
		});
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtSDep.setText("");
				txtSName.setText("");
				txtSId.setText("");
				comboBoxYear.setSelectedIndex(0);
				txtSEmail.setText("");

			}
		});
		btnReset.setForeground(Color.WHITE);
		btnReset.setFocusPainted(false);
		btnReset.setBackground(new Color(51, 102, 153));
		btnReset.setBounds(628, 366, 83, 40);
		newStudent.add(btnReset);


		table.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				super.mouseClicked(arg0);
				if(!table.getModel().getValueAt(table.getSelectedRow(),1).toString().equals("")){

					btnSEdit.setEnabled(true);
					btnSChngPat.setEnabled(true);
					btnSDeAlloc.setEnabled(true);
					btnSDelete.setEnabled(true);
				}

			}

		});
		JPanel allocations = new JPanel();
		tabbedPane.addTab("Allocations", new ImageIcon("G:\\WorkSpace\\alloc.png"), allocations, null);
		allocations.setLayout(null);

		JButton btnNewButton = new JButton("Auto Allocate");
		btnNewButton.setBounds(245, 76, 169, 169);
		allocations.add(btnNewButton);

		JButton btnDeallocate_1 = new JButton("De-Allocate All");
		btnDeallocate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDeallocate_1.setBounds(513, 76, 169, 169);
		allocations.add(btnDeallocate_1);

		JButton btnImportList = new JButton("Import List");
		btnImportList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnImportList.setBounds(783, 76, 169, 169);
		allocations.add(btnImportList);

		JPanel prefrences = new JPanel();
		FlowLayout fl_prefrences = (FlowLayout) prefrences.getLayout();
		fl_prefrences.setHgap(0);
		tabbedPane.addTab("Prefrences", new ImageIcon("G:\\WorkSpace\\pref.png"), prefrences, null);

		JPanel history = new JPanel();
		tabbedPane.addTab("History", new ImageIcon("G:\\WorkSpace\\history.png"), history, null);
		history.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(118, 35, 895, 444);
		history.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setRowHeight(34);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		scrollPane_2.setViewportView(table_2);
		tabbedPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{Home, list, records, allocations, prefrences, history}));
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(tabbedPane.getSelectedIndex()==1){
					String p="",atrb="name";
					if(chckbxNotAllocated.isSelected())
						p=" AND pat='-'";
					if(rdbtnDepartment.isSelected())
						atrb="dep";
					else if(rdbtnEmail.isSelected())
						atrb="email";
					else if(rdbtnPat.isSelected())
						atrb="pat";
					else if(rdbtnId.isSelected())
						atrb="id";
					else if(rdbtnYear.isSelected())
						atrb="year";
					if(tabbedPane_1.getSelectedIndex()==0 && !txtSearch.getText().equals("")){
						String[][]data=m.getDataList("select * from students where "+atrb+" like '"+txtSearch.getText()+"%'"+p);
						table.setModel(new DefaultTableModel(data,sColumns));
					}
					else if(tabbedPane_1.getSelectedIndex()==1 && !txtSearch.getText().equals("")){
						String[][]data=m.getPatList("select * from pats where "+atrb+" like '"+txtSearch.getText()+"%'"+p);
						table_1.setModel(new DefaultTableModel(data,pColumns));
					}

				}
			}
		});
	}
	public void updateTable(){

		data=m.getDataList("select * from students");
		table.setModel(new DefaultTableModel(data,sColumns));
	}
	public void updateTable1(){

		data=m.getDataList("select * from pats");
		table.setModel(new DefaultTableModel(data,pColumns));
	}
}
