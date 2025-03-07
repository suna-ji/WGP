package wpg;

import java.util.ArrayList;
import java.util.HashMap;

public class SelectOperationType {
	private ArrayList<Integer> selectedOperationType;
	private HashMap myPossibleProblems;
	
	public SelectOperationType() {
		selectedOperationType = new ArrayList<Integer>();
		myPossibleProblems = new HashMap();{
			myPossibleProblems.put(0, "더하기 문제");
			myPossibleProblems.put(1, "빼기 문제");
			myPossibleProblems.put(2, "곱하기 문제");
			myPossibleProblems.put(3, "나누기 문제");
		}
	}
	public HashMap getMyPossibleOperationType() {
		return myPossibleProblems;
		
	}
	public ArrayList<Integer> getSelectedOperationType(){
		return selectedOperationType;
	}
	public void checkAndAdd(Integer whichProblem) throws DuplicateException, RangeException {
		if(selectedOperationType != null) {
			if(selectedOperationType.contains(whichProblem)) {
					throw new DuplicateException("이미 선택한 옵션입니다.");
			}
		}
		if(whichProblem < 1 || whichProblem > myPossibleProblems.size()) {
			throw new RangeException("범위를 벗어났습니다. 다시 선택해주세요.");
		}
		else {
			selectedOperationType.add(whichProblem);
		}
	}

}
