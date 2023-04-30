package helloworld;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test3 {

	public static void main(String[] args) throws IOException {
		File k21_f = new File("C:\\Users\\kopo24\\Desktop\\12_04_07_E_무료와이파이정보.csv"); // 다운받은 파일의 객체 생성
		BufferedReader k21_br = new BufferedReader(new FileReader(k21_f)); //파일을 읽기 위한 BufferedReader 객체 생성
		
		String k21_readtxt; // k21_readtxt라는 문자열 변수 선언
		
		if ((k21_readtxt = k21_br.readLine()) == null) { //첫번째 줄을 읽고 빈 파일이면 if문의 조건문을 탐
			System.out.printf("빈 파일입니다\n"); // 빈 파일입니다를 출력
			return; //공백으로 return함
		}
		String[] k21_field_name = k21_readtxt.split(","); // 첫번째 라인을 쉼표로 기준으로 나누어 k21_field_name배열에 저장
		
		int k21_LineCnt = 0; //읽은 줄을 변수로 설정  
		while((k21_readtxt = k21_br.readLine()) != null) { //파일을 끝까지 읽을때 까지 while loop 진횅
			String[] k21_field = k21_readtxt.split(","); //,를 기준으로 나누어 k21_field 배열에 저장
			System.out.printf("**[%d번째 항목]*****************\n", k21_LineCnt); // 읽은 줄을 출력 ->몇번째 인지 알 수 있음
			for (int k21_j = 0; k21_j < k21_field_name.length; k21_j++) { //한 줄씩읽을려는 for문의 구현
				System.out.printf("%s : %s\n", k21_field_name[k21_j], k21_field[k21_j]); //한줄씩 읽은값을 출력
			}
			System.out.printf("***********************************\n"); //한줄씩 읽은 후 다음줄 출력하기 위한 구분 줄 출력
			if (k21_LineCnt == 100) break; //100줄이 되면 while loop 탈출
			k21_LineCnt++; //한줄을 다 읽은 후 다음 줄을 읽기 위한 k21_LineCnt 1씩 증가
		}

	}

}
