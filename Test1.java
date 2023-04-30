package helloworld;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Test1 {

	public static void main(String[] args) {
		try { // 파일을 실행하는데 발생하는 오류를 잡아내는 try ~ catch구문의 시작
			File k21_f = new File("c:\\Users\\kopo24\\Desktop\\text.txt"); // k21_f라는 파일 변수에 지정된 경로의 파일을 불러온다
			FileWriter k21_fw = new FileWriter(k21_f); // FileWriter를 이용하여 k21_fw변수로 파일 쓰기
			
			k21_fw.write("안녕 파일\n");  //파일에 안녕파일이라는 문자열 쓰기
			k21_fw.write("hello 헬로\n"); // 파일에 hello 헬로 이라는 문자열 쓰기
			k21_fw.close(); // FileWriter 객체를 닫음
			
			FileReader k21_fr = new FileReader(k21_f);  // FileReader를 이용하여 위에 작성한 k21_f를 읽음
			
			int k21_n = -1; // 파일에서 읽은 문자열의 길이
			char [] k21_ch; // 문자열을 담을 배열
			
			while (true) { // 파일을 읽는 동안 반복시킬 반복문의 시작
				k21_ch = new char[100]; //100개의 문자열을 담을 배열의 생성 - >굳이 100이 아니라 여유롭게 설정한 숫자
				k21_n = k21_fr.read(k21_ch); //파일에서 100글자를 읽음
				
				if (k21_n == -1) break; //더 이상 읽을 내용이 없으면 while문의 루프를 탈출
				
				for (int k21_i = 0; k21_i < k21_n; k21_i++) { //읽은 문자열을 출력하기 위한 for문 시작
					System.out.printf("%c", k21_ch[k21_i]); // 문자열을 출력
				}
			}
			
			k21_fr.close(); //FileReader 객체를 닫음
			System.out.printf("\n FILE READ END"); //파일을 다 읽으면 File Read END를 출력하며 끝
		} catch (Exception e) { // 예외처리
			System.out.printf("나 에러[%s]\n", e); // 예외가 발생한다면 나 에러[에러항목]을 출력
		}

	}

}
