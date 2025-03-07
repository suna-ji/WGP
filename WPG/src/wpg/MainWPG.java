package wpg;

import java.util.ArrayList;

public class MainWPG {
	public static void main(String[] args) throws DuplicateException, RangeException {
		InteractionWithParent iwp = new InteractionWithParent(); 
		GenerateWorkBook gwb = new GenerateWorkBook();
		InteractionWithChild iwc = new InteractionWithChild();
		System.out.println("------------------프로그램을 시작합니다------------------");
		Child child = iwp.getChild(); // 아이 생성
		ArrayList<Problem> workBook = gwb.getWorkBook(iwp.getOperationType(), iwp.getProblemNum(), iwp.getOperandRange());// 문제집 생성
		iwc.run(workBook, child); // 아이가 문제집 풀기
		
		
		
	}

}
