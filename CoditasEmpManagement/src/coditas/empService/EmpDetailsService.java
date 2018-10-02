package coditas.empService;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import coditas.dbUtil.MySQLConnUtil;

public class EmpDetailsService {

	public List empDetails(int m_id) {
		Connection connection = MySQLConnUtil.getConnection();
		List<Employee> list = new ArrayList<Employee>();
		System.out.println("m_id : " + m_id);
		try {
			/*
			 * Statement statement = connection.createStatement(); String query
			 * = "SELECT * FROM employee";
			 */

			PreparedStatement pst = connection.prepareStatement("SELECT * FROM employee where manager_id = ?");
			pst.setInt(1, m_id);
			// pst.setString(0, "Jan");

			// create the java statement
			Statement st = connection.createStatement();
			// execute the query, and get a java resultset
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt(1));
				employee.setName(rs.getString(2));
				System.out.println("sandeep");
				employee.setContactNo(rs.getInt(3));
				employee.setManagerId(rs.getInt(4));
				employee.setDate(rs.getString(5));
				employee.setIn_time(rs.getString(6));
				employee.setOut_time(rs.getString(7));
				employee.setTotal_hours(rs.getString(8));
				employee.setStatus(rs.getString(9));
				employee.setJoining_date(rs.getNString(10));

				list.add(employee);
				/*
				 * list.add(rs.getInt(1)); list.add(rs.getString(2));
				 * list.add(rs.getInt(3)); list.add(rs.getInt(4));
				 * list.add(rs.getString(5)); list.add(rs.getString(6));
				 * list.add(rs.getString(7)); list.add(rs.getString(8));
				 * list.add(rs.getString(9)); list.add(rs.getString(10));
				 */
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	static void readAndSaveFrmExcel(String excelFile) {
		Connection connection = MySQLConnUtil.getConnection();
		System.out.println("IN excel ");
		XSSFWorkbook myExcelBook = null;
		Integer id = null;
		String name = null;
		Integer contact= null;
		Integer managerId= null;
		String date= null;
		String intime= null;
		String outtime= null;
		String totalhour= null;
		String status= null;
		String joiningdate= null;
		try {
			myExcelBook = new XSSFWorkbook(new FileInputStream(excelFile));
			XSSFSheet myExcelSheet = myExcelBook.getSheet("Sheet1");

			//row no of excel 
		
			for(int i=1; i<myExcelSheet.getDefaultRowHeight() ; i++){
			
				XSSFRow row = myExcelSheet.getRow(i);
				
				
				if (row.getCell(0).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
					id = (int) row.getCell(0).getNumericCellValue();
					System.out.println("id : " + id);
				}
				if (row.getCell(1).getCellType() == HSSFCell.CELL_TYPE_STRING) {
					name = row.getCell(1).getStringCellValue();
					System.out.println("NAME : " + name);
				}
				if (row.getCell(2).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
					contact = (int) row.getCell(2).getNumericCellValue();
					System.out.println("NAME : " + name);
				}
				if (row.getCell(3).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
					managerId = (int) row.getCell(3).getNumericCellValue();
					System.out.println("NAME : " + managerId);
				}
				if (row.getCell(4).getCellType() == HSSFCell.CELL_TYPE_STRING) {
					date = row.getCell(4).getStringCellValue();
					System.out.println("NAME : " + date);
				}
				if (row.getCell(5).getCellType() == HSSFCell.CELL_TYPE_STRING) {
					intime = row.getCell(5).getStringCellValue();
					System.out.println("NAME : " + intime);
				}
				if (row.getCell(6).getCellType() == HSSFCell.CELL_TYPE_STRING) {
					outtime = row.getCell(6).getStringCellValue();
					System.out.println("NAME : " + outtime);
				}
				if (row.getCell(7).getCellType() == HSSFCell.CELL_TYPE_STRING) {
					totalhour = row.getCell(7).getStringCellValue();
					System.out.println("NAME : " + totalhour);
				}
				if (row.getCell(8).getCellType() == HSSFCell.CELL_TYPE_STRING) {
					status = row.getCell(8).getStringCellValue();
					System.out.println("NAME : " + status);
				}
				if (row.getCell(9).getCellType() == HSSFCell.CELL_TYPE_STRING) {
					joiningdate = row.getCell(9).getStringCellValue();
					System.out.println("NAME : " + joiningdate);
				}

				// insert data from excel
				PreparedStatement pst;
				try {
					String insertFrmExcel = "insert into employee (e_id, e_name,e_contact,manager_id,date,in_time, out_time,total_hour,status,joining_date) values(?,?,?,?,?,?,?,?,?,?)";
					pst = connection.prepareStatement(insertFrmExcel);
					pst.setInt(1, id);
					pst.setString(2, name);
					pst.setInt(3, contact);
					pst.setInt(4, managerId);
					pst.setString(5, date);
					pst.setString(6, intime);
					pst.setString(7, outtime);
					pst.setString(8, totalhour);
					pst.setString(9, status);
					pst.setString(10, joiningdate);
					pst.executeUpdate();

				} catch (SQLException e) {
					e.printStackTrace();
				}catch (Exception e) {
					System.out.println(e);
				}

			}
		
			myExcelBook.close();
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		readAndSaveFrmExcel("C:\\Users\\Sandeep\\Desktop\\Book1.xlsx");
	}

}
