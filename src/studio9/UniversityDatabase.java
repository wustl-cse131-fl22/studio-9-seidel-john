package studio9;

import java.util.HashMap;
import java.util.Map;

import assignment7.Student;

public class UniversityDatabase {

	private final Map<String, Student> data = new HashMap<String, Student>();
	
	public UniversityDatabase(Map<String, Student> data) {
		data = data;
	}
	
	public void addStudent(String accountName, Student student) {
		if(!data.containsKey(accountName)) {
		data.put(accountName, student);
		}
	}

	public int getStudentCount() {
		return data.size();
	}

	public String lookupFullName(String accountName) {
		if(data.containsKey(accountName)) {
			Student stu= data.get(accountName);
			return stu.getFullName();
		}else {
		return null;
		}
	}

	public double getTotalBearBucks() {
		double count = 0;
		
		return 0.0;
	}
}
