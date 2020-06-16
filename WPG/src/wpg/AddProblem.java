package wpg;

public class AddProblem extends Problem{

	public AddProblem(String myDescription) {
		super(myDescription);
	}
	
	public void printProblem(Child child) {
		String iThing = child.getImportantThing();
		String iPerson = child.getImportantPeople();
	    String problemString = child.getName() + "은 " + iThing + "을 "+ operand1 +"개 가지고 있습니다. " +
	                           iPerson + "은" + iThing + "을" + operand2 + 
	                           "개 가지고 있습니다. 그들이 가지고 있는" + iThing + "은 모두 몇 개입니까?";
	    System.out.println(problemString);
	}

	public void setAnswer() {
		answer = operand1 + operand2;
	}

}
