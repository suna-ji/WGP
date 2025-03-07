package wpg;

public class SubProblem extends Problem{
	
	public SubProblem(String myDescription) {
		super(myDescription);
	}
	@Override
	public void printProblem(Child child) {
		String iThing = child.getImportantThing();
		String iPerson = child.getImportantPeople();
	    String problemString = child.getName() + "은 " + iThing + "을 " + operand1 +"개 가지고 있습니다. " +
	                           child.getName() + "은 " + iPerson+ "에게 " + iThing + operand2 + "개를 주었습니다. "+
	                           child.getName()+ "에게 몇 개의 " + iThing + "가 남았습니까?";                   
	    System.out.println(problemString);
	}
	
	public void setAnswer() {
		answer = operand1 - operand2;
	}

}
