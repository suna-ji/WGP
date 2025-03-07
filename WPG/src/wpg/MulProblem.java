package wpg;

public class MulProblem extends Problem{
	
	public MulProblem(String myDescription) {
		super(myDescription);
	}
	public void printProblem(Child child) {
		String iThing = child.getImportantThing();
	    String problemString = child.getName() + "은 " + operand1 +"개의 " + iThing + "을 " + 
	    					   operand2 +"묶음 가지고 있습니다. " +child.getName()+ 
	    					   "는 전부 "+iThing+"이 몇 개 있습니까?";  
	    System.out.println(problemString);
	}

	public void setAnswer() {
		answer = operand1 * operand2;
	}

}
