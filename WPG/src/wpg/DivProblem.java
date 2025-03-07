package wpg;

public class DivProblem extends Problem{

	public DivProblem(String myDescription) {
		super(myDescription);
	}
	public boolean isDenominatorZero() {
		if(operand2 == 0) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public void printProblem(Child child) {
		if(isDenominatorZero()) {
			operand2 = 1;
		}
		String iThing = child.getImportantThing();
	    String problemString = child.getName() + "은 " + iThing + "을 " + operand1 +"개 가지고 있습니다. " +
	                           "(그/그녀)는 " +operand2+ "의 친구에게 똑같이 나누어 주고 싶습니다. 각각 " + 
	                           iThing + "을 몇 개씩 가지게 되나요?";
	    System.out.println(problemString);
	}
	
	public void setAnswer() {
		if(isDenominatorZero()) {
			operand2 = 1;
		}
		double temp = (double)operand1 / operand2;
	    answer = Math.round(temp * 1000)/ 1000.0;
	}

}
