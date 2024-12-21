import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class Main {
	public static void main(String[] args) {
		List<Integer> grades = Arrays.asList(81, 87, 91, 96, 100);
		List<String> gradeSigns = new ArrayList<>();
		Function<Integer, String> gradeConverterFunction = Main::convertGrade;
		addGrades(grades, gradeSigns, gradeConverterFunction);
		printGrades(gradeSigns);
	}
	
	private static String convertGrade(Integer grade) {
		if (grade <= 100 && grade > 90) return "A";
		else if (grade <= 90 && grade > 80) return "B";
		else if (grade <= 80 && grade > 70) return "C";
		else if (grade <= 70 && grade > 60) return "D";
		else if (grade <= 60 && grade > 50) return "E";
		else if (grade <= 50 && grade > 0) return "F";
		return null;
	}
	
	private static void addGrades(
		List<Integer> grades,
		List<String> gradeSigns,
		Function<Integer, String> gradeConverterFunction
	) {
		for (Integer grade : grades) {
			if (Objects.nonNull(gradeConverterFunction.apply(grade))) {
				gradeSigns.add(grade + " - " + gradeConverterFunction.apply(grade));
			}
		}
	}
	
	private static void printGrades(List<String> gradeSigns) {
		for (String sign : gradeSigns) {
			System.out.println(sign);
		}
	}
}