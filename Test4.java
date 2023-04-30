package helloworld;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test4 {

	public static void main(String[] args) throws IOException {
		File k21_f = new File("C:\\Users\\kopo24\\Desktop\\12_04_07_E_무료와이파이정보 (2).txt"); // 지정된 경로에 있는 파일 읽기위한 객체 생성
		BufferedReader k21_br = new BufferedReader(new FileReader(k21_f)); //BufferedReader 객체를 생성

		String k21_readtxt; //읽은 파일의 문자열을 저장하기 위한 문자열 변수 선언

		if ((k21_readtxt = k21_br.readLine()) == null) { //만약 읽은 파일이 빈 파일이면 if조건문을 탐
			System.out.printf("빈 파일입니다\n"); //빈 파일입니다 라는 문자열을 출력
			return; //null을 return해줌
		}
		String[] k21_field_name = k21_readtxt.split("\t"); //탭으로 구분된 첫 줄을 읽어 k21_field_name에 저장

		double k21_lat = 37.386138; //내 위치의 위도 설정
		double k21_lng = 127.120748; //내 위치의 경도 설정
		
		//최대거리를 구하기 위한 변수 설정
		double k21_max_dist = Double.MIN_VALUE; //double변수가 저장할 수 있는 최소의 값으로 초기화 -> 최대거리로 계속 초기화
		String k21_max_address = ""; //최대거리에 해당하는 주소명을 받기 위한 변수
		String k21_max_name = ""; //최대거리에 해당하는 설치장소명을 저장하기 위한 변수
		double k21_max_lati = 0.0; //최대거리에 해당하는 위도 받기위한 변수
		double k21_max_lng = 0.0; //최대거리에 해당하는 경도 받기위한 변수
		
		//최소거리를 구하기 위한 변수 설정
		double k21_min_dist = Double.MAX_VALUE; //double변수가 저장할수 있는 최대의 값으로 초기화 -> 최소거리로 계속 초기화
		String k21_min_address = ""; //최소거리에 해당하는 주소명을 받기 위한 변수
		String k21_min_name = ""; //최소거리에 해당하는 설치장소명을 받기 위한 변수
		double k21_min_lati = 0.0; //최소거리에 해당하는 위도 받기 위한 변수
		double k21_min_lng = 0.0; //최소거리에 해당하는 경도 받기 위한 변수
		
		

		int k21_LineCnt = 0; //읽은 줄을 세기 위한 k21_LiceCnt 변수 선언 -> 0으로 초기화
		while ((k21_readtxt = k21_br.readLine()) != null) { //한줄씩 읽는데 공백까지 -> 끝까지 읽을때까지 while문 수행
			String[] k21_field = k21_readtxt.split("\t"); // 각 줄마다 탭으로 구분된 문자열을 읽어서 k21_field에 저장
			System.out.printf("** [%d번째 항목]********\n", k21_LineCnt); //읽은 줄이 몇번째 인지 출력
			System.out.printf(" %s : %s\n", k21_field_name[10], k21_field[10]); // 소재지번 주소 : 해당하는 주소값 출력
			System.out.printf(" %s : %s\n", k21_field_name[13], k21_field[13]); // 위도 : 해당하는 위도값 출력
			System.out.printf(" %s : %s\n", k21_field_name[14], k21_field[14]); // 경도 : 해당하는 경도값 출력
			double k21_dist = Math.sqrt(Math.pow(Double.parseDouble(k21_field[13]) - k21_lat, 2)
					+ Math.pow(Double.parseDouble(k21_field[14]) - k21_lng, 2)); // 피타고라스를 이용한 두 장소 사이의 거리 구하기
																				// 루트 ((1의 경도 - 2의 경도)^2 + (1의 위도 - 2의 위도)^2) = 거리
			System.out.printf(" 현재지점과의 거리 : %f\n", k21_dist); // 거리를 출력
			System.out.printf("********************\n"); //자료 한줄씩 읽은 후 구분자 출력
			
			if (k21_max_dist < k21_dist) { // 최대 거리일때를 구하기 위한 조건문 시작
				k21_max_address = k21_field[10]; // 최대거리일때의 주소를 저장
				k21_max_dist = k21_dist; // 최대거리일때 그 거리값을 변수에 저장
				k21_max_name = k21_field[1]; //최대거리일때의 장소명을 저장
				k21_max_lati = Double.parseDouble(k21_field[13]); // 최대거리일때의 위도값 저장
				k21_max_lng = Double.parseDouble(k21_field[14]); //최대거리일때의 경도값 저장
			}
			
			if (k21_min_dist > k21_dist) { // 최소 거리일때를 구하기 위한 조건문 시작
				k21_min_address = k21_field[10]; // 최소거리일때 주소 저장
				k21_min_dist = k21_dist; //최소거리를 저장
				k21_min_name = k21_field[1]; // 최소거리의 장소명을 저장
				k21_min_lati = Double.parseDouble(k21_field[13]); //최소거리일때의 위도값 저장
				k21_min_lng = Double.parseDouble(k21_field[14]); //최소거리일때의 경도값 저장
			}
			

			k21_LineCnt++; //다음 줄을 읽기 위해 LineCnt를 1 증가

		} // 각 줄을 읽은 후 한 줄씩 다 출력 한 후 whileLoop종료 
		System.out.printf("최대거리\n"); //최대거리일때의 정보 출력 시작
		System.out.printf("거리 : %f\n", k21_max_dist); // 최대거리일때의 거리
		System.out.printf("장소명 : %s\n", k21_max_name); // 최대거리일때의 장소명
		System.out.printf("주소 : %s\n", k21_max_address); //최대거리일때의 주소
		System.out.printf("위도 : %f\n", k21_max_lati); //최대거리일때의 위도
		System.out.printf("경도 : %f\n", k21_max_lng); // 최대거리일때의 경도
		
		System.out.println(); //구분을 위한 한 줄 띄우기
		
		System.out.printf("최소거리\n"); //최소거리일때의 정보 출력 시작
		System.out.printf("거리 : %f\n", k21_min_dist); // 최소거리일때의 거리
		System.out.printf("장소명 : %s\n", k21_min_name); // 최소거리일때의 장소
		System.out.printf("주소 : %s\n", k21_min_address); // 최소기리일때의 주소
		System.out.printf("위도 : %f\n", k21_min_lati); // 최소거리일때의 위도
		System.out.printf("경도 : %f\n", k21_min_lng); //최소거리일때의 경도
		

		k21_br.close(); // BufferedReader의 객체 종료

	}

}
