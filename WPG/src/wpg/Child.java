package wpg;

import java.util.ArrayList;
import java.util.Collections;

public class Child {
	private String name;
	private ArrayList<String> importantPeople;  // 자녀에게 중요한 사람들의 이름
	private ArrayList<String> importantThings; // 자녀가 관심을 갖고 있는 항목의 이름 (예: 인형, 책, 축구공, 비디오 게임)
	
	
	public Child() { //생성자
		this.importantPeople = new ArrayList<String>();
		this.importantThings = new ArrayList<String>();
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String getImportantPeople() {
		Collections.shuffle(importantPeople);
		return importantPeople.get(0);
	}
	public String getImportantThing(){
		Collections.shuffle(importantThings);
		return importantThings.get(0);
	}// 호출할때마다 랜덤하게 리턴해줌
	public void setImportantPeople(String pName) {
		importantPeople.add(pName);	
	}
	public void setImportantThings(String tName) {
		importantThings.add(tName);
	}
	// private인 importantPeople/Things에 접근할 수 있도록 해주는 set메서드
	public int getImportantPeopleNum() {
		return importantPeople.size();
	}
	public int getImportantThingNum() {
		return importantPeople.size();
	}
}
