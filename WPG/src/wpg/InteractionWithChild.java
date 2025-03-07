package wpg;

import java.util.ArrayList;
import java.util.Scanner;

public class InteractionWithChild {
	private Scanner scanner;
	
	public InteractionWithChild() {
		scanner = new Scanner(System.in);
	}
	
	public void run(ArrayList<Problem> workBook, Child child) {
		System.out.println("------------------문제풀이를 시작합니다------------------");
		for(int i = 0; i < workBook.size(); i++) {
			System.out.print(i+1 + ")");
			workBook.get(i).printProblem(child);
			int studentAnswer = scanner.nextInt();
			if(studentAnswer == workBook.get(i).answer) {
				System.out.println("정답입니다!");
			}else {
				System.out.println("틀렸습니다! 정답은" + workBook.get(i).answer +"입니다.");
			}   
		}
		System.out.println("----------수고하셨습니다. 프로그램을 종료합니다.----------");
	}
}
