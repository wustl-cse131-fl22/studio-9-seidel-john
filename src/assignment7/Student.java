package assignment7;

//TODO: Copy a working Student class from Assignment 7 over this file.
public class Student {
	private String firstName;
	private String lastName;
	private int id;
	private int attemptedCredits;
	private int passingCredits;
	private double totalGrdQtPts;
	private double bearBucksBalance;
	

	/**
	 * constructor for Student
	 * 
	 * @param firstName student first name
	 * @param lastName student last name
	 * @param id student ID number
	 */
	public Student(String firstName, String lastName, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}

	/**
	 * Returns the student's full name
	 * 
	 * @return the student's full name
	 */
	public String getFullName() {
		return firstName + " " + lastName;
	}

	/**
	 * Returns student ID number
	 * 
	 * @return Student ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * Updates GPA according to grade
	 * 
	 * @param grade
	 * @param credits
	 */
	public void submitGrade(double grade, int credits) {
		attemptedCredits += credits;
		if (grade >= 1.7) {
			passingCredits += credits;
		}
		totalGrdQtPts += credits * grade;
	}

	/**
	 * total number of attempted credits
	 * 
	 * @return attempted credits
	 */
	public int getTotalAttemptedCredits() {
		return attemptedCredits;
	}

	/**
	 * total number of passing credits (at least 1.7 grade) 
	 * 
	 * @return passing credits
	 */
	public int getTotalPassingCredits() {
		return passingCredits;
	}

	/**
	 * Calculates GPA
	 * 
	 * @return GPA
	 */
	public double calculateGradePointAverage() {
		return totalGrdQtPts/attemptedCredits ;
	}

	/**
	 * Student's class standing based on passing credits
	 * 
	 * @return class standing
	 */
	public String getClassStanding() {
		if (passingCredits < 30) {
			return "First Year";
		}
		else if(passingCredits >= 30 && passingCredits < 60) {
			return "Sophomore";
		}else if(passingCredits >= 60 && passingCredits < 90) {
			return "Junior";
		}else {
			return "Senior";
		}
	}

	/**
	 * Does the student qualify for PBK?
	 * 
	 * @return student's eligibility
	 */
	public boolean isEligibleForPhiBetaKappa() {
		if((calculateGradePointAverage()>= 3.60 && passingCredits >= 98)   ) {
			return true;
		} else if(calculateGradePointAverage() >= 3.80 && passingCredits >= 75) {
			return true;
		}
		return false; 
	}

	/**
	 * increases Bear Bucks balance by amount
	 * 
	 * @param amount
	 */
	public void depositBearBucks(double amount) {
		bearBucksBalance += amount;
	}

	/**
	 * decreases Bear Bucks balance by amount
	 * 
	 * @param amount
	 */
	public void deductBearBucks(double amount) {
		bearBucksBalance -= amount;
	}

	/**
	 * student's Bear Bucks balance
	 * 
	 * @return Bear Bucks balance
	 */
	public double getBearBucksBalance() {
		return bearBucksBalance;
	}

	/**
	 * Cashes out Bear Bucks account
	 * 
	 * @return returns zero
	 */
	public double cashOutBearBucks() {
		double cashOut = bearBucksBalance -10;
		if (cashOut < 0) {
			cashOut = 0;
		}
		bearBucksBalance = 0;
		return cashOut ;
	}

	/**
	 * Takes two parents and creates a child who is the legacy and goes to WashU
	 * 
	 * @param firstName legacy's first name
	 * @param other other parent
	 * @param isHyphenated last name of legacy either be the last name of first parent @param this 
	 * 					   or hyphenated combo of this-other 
	 * @param id legacy's student ID
	 * @return
	 */
	public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) {
		String lastName = this.lastName;
		if(isHyphenated) {
			lastName += "-" + other.lastName; 
		}
		Student legacy = new Student(firstName, lastName, id);
		double parentA = cashOutBearBucks() ;
		double parentB = other.cashOutBearBucks();
		
		legacy.depositBearBucks(parentA + parentB);
		return legacy;
	}

	/**
	 * Student's Full Name and ID as a String
	 * 
	 * @return Student's full name and ID
	 */
	public String toString() {
		return getFullName() + " " + id;
	}


}
