package wpg;

import java.util.ArrayList;

public class GenerateWorkBook {
	
	private ProblemFactory pfactory = new ProblemFactory();
	private ArrayList<Problem> workBook = new ArrayList<Problem>();
	
	public ArrayList<Problem> getWorkBook(SelectOperationType selectOperationType, int problemNum, OperandRange opRange) { // 여기서는 매개변수로 학부모랑 interaction한 정보 받아서 걍 생성만 해 
		// 입력받은 정보를 바탕으로 문제집 생성
		ArrayList<Integer> selectedOperationType = selectOperationType.getSelectedOperationType();
		for(int i = 0; i <selectedOperationType.size(); i++) {
			int j = selectedOperationType.get(i);
			for(int k = 0; k < problemNum; k++) {
				Problem problem = pfactory.getProblem(j);
				problem.setOperand(opRange);
				problem.setAnswer();
				workBook.add(problem);
			}
		}
		return workBook;
	}

}
