package wpg;

public class ProblemFactory {
	public static Problem getProblem(int pid) {
		Problem problem = null;
		if(pid == 1) return new AddProblem("더하기 문제");
		else if(pid == 2) return new SubProblem("빼기 문제");
		else if(pid == 3) return new MulProblem("곱하기 문제");
		else if(pid == 4) return new DivProblem("나누기 문제");
		else return null;
	}

}
