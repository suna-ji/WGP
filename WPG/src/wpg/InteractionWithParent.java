package wpg;
import java.util.*;

public class InteractionWithParent{
	private Scanner scanner;
	private Child child;
	private Problem[] myPossibleProblems = {
			new AddProblem("더하기 문제"),
			new SubProblem("빼기 문제"),
			new MulProblem("곱하기 문제"),
			new DivProblem("나누기 문제"),
	};
	private ArrayList<Problem> workBook = new ArrayList<Problem>();
	private ArrayList<Integer> selectedOperationType = new ArrayList<Integer>();
	// 멤버변수
	public InteractionWithParent() {
		scanner = new Scanner(System.in);
	}
	// 생성자
	
	public String getChildName() {
		System.out.println("자녀의 이름을 입력해주세요.");
		String childName = scanner.nextLine();
		return childName;
	}
	
	public void getImportantPeople() {
		System.out.println("자녀에게 중요한 사람들의 이름을 적어주세요. 입력이 끝났다면 quit를 입력해주세요.");
		String response = null;
		while(!"quit".equalsIgnoreCase(response)) {
			response = scanner.nextLine();
			if("quit".equalsIgnoreCase(response)) {
				return;
			}
			child.setImportantPeople(response);
			System.out.println("입력이 끝나지 않았다면 다시 이름을 적어주세요. 만약, 입력이 끝났다면 quit를 입력해주세요.");
		}
	}
	
	public void getImportantThings() {
		System.out.println("자녀가 관심을 갖고 있는 항목의 이름을 적어주세요. 입력이 끝났다면 quit를 입력해주세요.");
		String response = null;
		while(!"quit".equalsIgnoreCase(response)) {
			response = scanner.nextLine();
			if("quit".equalsIgnoreCase(response)) {
				return;
			}
			child.setImportantThings(response);
			System.out.println("입력이 끝나지 않았다면 다시 이름을 적어주세요. 만약, 입력이 끝났다면 quit를 입력해주세요.");
		}
	}
	// 자녀에 대한 Interaction
	public void checkAndAdd(Integer whichProblem) throws DuplicateException, RangeException {
		if(selectedOperationType != null) {
			if(selectedOperationType.contains(whichProblem)) {
				throw new DuplicateException("이미 선택한 옵션입니다.");
			}
		}
		if(whichProblem < 1 || whichProblem > myPossibleProblems.length) {
			throw new RangeException("범위를 벗어났습니다. 다시 선택해주세요.");
		}
		else {
			selectedOperationType.add(whichProblem);
		}
	}
	
	// 1. 문제유형
	private void getOperationType() throws DuplicateException, RangeException { 
		System.out.println("아래의 연산중에 선택해주세요:");
		for (int k = 0; k < myPossibleProblems.length; k++) {
			System.out.println((k + 1) + ") " + myPossibleProblems[k].getDescription());
		}
		int whichProblem = scanner.nextInt();
		while(0!=whichProblem) {
		    checkAndAdd(whichProblem);
			System.out.println("선택이 끝나지 않았다면 다시 선택해주세요. 만약, 선택이 끝났다면 0 입력해주세요.");
			whichProblem = scanner.nextInt();
		}
	}
	// 2. 문제 개수
	public int getProblemNum() {
		System.out.println("몇개의 문제를 생성할까요?");
		int problemNum = scanner.nextInt();
		return problemNum;	
	}
	// 3. 피연산자의 범위
	public OperandRange getOperandRange() {
		System.out.println("피연산자의 시작 범위를 입력해주세요.");
		int start = scanner.nextInt();
		System.out.println("피연산자의 끝 범위를 입력해주세요.");
		int end = scanner.nextInt();
		return new OperandRange(start, end);
	}
	// 문제에 대한 Interaction
	
	public void run() throws DuplicateException, RangeException {
		// getChildName()메서드로 name얻어서 child객체 생성
		child = new Child(getChildName());
		getImportantPeople();
		getImportantThings();
		getOperationType(); // 무슨 유형
		int problemNum = getProblemNum(); // 몇개
		OperandRange opRange = getOperandRange(); //피연산자 범위는 어디까지
		
		
		// 입력받은 정보를 바탕으로 문제집 생성
		for(int i = 0; i < selectedOperationType.size(); i++) {
			int j = selectedOperationType.get(i);
			for(int k = 0; k < problemNum; k++) {
				myPossibleProblems[j].setOperand(opRange);
				workBook.add(myPossibleProblems[j]);
			}
		}
		
		// 문제풀이 시작
		for(int i = 0; i < workBook.size(); i++) {
			workBook.get(i).printProblem(child);
			int studentAnswer = scanner.nextInt();
			if(studentAnswer == workBook.get(i).answer) {
				System.out.println("정답입니다!");
			}else {
				System.out.println("틀렸습니다ㅠㅠ 정답은" + workBook.get(i).answer +"입니다.");
			}
		}
		
	}

}
