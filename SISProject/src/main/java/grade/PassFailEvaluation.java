package main.java.grade;

import org.springframework.stereotype.Component;

@Component
public class PassFailEvaluation implements GradeEvaluation{

	@Override
	public String getGrade(int point) {
		
		if( point >= 70) return "P";
		
		else return "F";
	}

}
