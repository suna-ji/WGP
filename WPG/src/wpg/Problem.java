package wpg;
import java.util.Random;
import java.util.Random;

public abstract class Problem { // 템플릿 메서드 패턴 적용// 팩토리 메서드 패턴 적용 
	String myDescription;
	protected int operand1;
	protected int operand2;
    public double answer;
	
	Random random = new Random();
	
	public Problem(String myDescription) {
		this.myDescription = myDescription;
	}
	public void setOperand(OperandRange opRange) {
		operand1 = getOperand(opRange);
		operand2 = getOperand(opRange);
	}
	public String getDescription() {
		return myDescription;
	}
	//	피연산자 범위(시작, 끝) 은 같이 있는 것이 자연스러운 파라미터 이다.
	//	따라서 객체로 묶고 객체로 전달하도록 설계하였다.
	public int getOperand(OperandRange opRange) {
		 return random.nextInt(opRange.end) + opRange.start; 
	}
	// 하위 클래스에 구현을 맡기는 템플릿메서드(1)-setAnswer
	public abstract void setAnswer();
	// 하위 클래스에 구현을 맡기는 템플릿메서드(2)-printProblem
	public abstract void printProblem(Child child); 
}
