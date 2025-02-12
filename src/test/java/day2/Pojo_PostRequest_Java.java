package day2;

import static org.hamcrest.Matchers.equalTo;

public class Pojo_PostRequest_Java {
	String name;
    String yearsOLD;
    boolean active;
    int grades[];
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYearsOLD() {
		return yearsOLD;
	}
	public void setYearsOLD(String yearsOLD) {
		this.yearsOLD = yearsOLD;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int[] getGrades() {
		return grades;
	}
	public void setGrades(int[] grades) {
		this.grades = grades;
	}
	
    
	
}
