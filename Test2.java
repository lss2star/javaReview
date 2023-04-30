package helloworld;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test2 {

	public static void main(String[] args) throws IOException { //IOException 을 던진다
		FileWrite(); //파일을 쓰기위한 객체 생성
		FileRead(); //파일을 읽기위한 객체 생성
	}

	public static void FileWrite() throws IOException { //파일을 쓰기위한 클래스
		File k21_f = new File("c:\\Users\\kopo24\\Desktop\\text2.txt"); // 파일을 쓸 경로와 파일 생성
		BufferedWriter k21_bw = new BufferedWriter(new FileWriter(k21_f)); //BufferedWriter 객체 생성

		k21_bw.write("안녕 파일"); // 안녕파일을 파일에 씀
		k21_bw.newLine(); //새로운 줄로 넘어가기
		k21_bw.write("hello 헬로"); //hello 헬로를 파일에 씀
		k21_bw.newLine(); //새로운 줄로 넘어가기

		k21_bw.close(); // BufferedWriter객체 닫기
	}

	public static void FileRead() throws IOException { //파일을 읽기위한 클래스
		File k21_f = new File("c:\\Users\\kopo24\\Desktop\\text2.txt"); //앞서 FileWrite에서 생성된 파일의 경로
		BufferedReader k21_br = new BufferedReader(new FileReader(k21_f)); //BufferedReader의 객체 생성

		String k21_readtxt; // k21_readtxt라는 문자열 선언

		while ((k21_readtxt = k21_br.readLine()) != null) { // 한 줄, 한 줄 읽어서 다 읽을때까지 while loop진행
			System.out.printf("%s\n", k21_readtxt); //한줄한줄 출력
		}
		k21_br.close(); //BufferedReader 객체 닫기

	}

}
