package helloworld;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test2 {

	public static void main(String[] args) throws IOException { //IOException �� ������
		FileWrite(); //������ �������� ��ü ����
		FileRead(); //������ �б����� ��ü ����
	}

	public static void FileWrite() throws IOException { //������ �������� Ŭ����
		File k21_f = new File("c:\\Users\\kopo24\\Desktop\\text2.txt"); // ������ �� ��ο� ���� ����
		BufferedWriter k21_bw = new BufferedWriter(new FileWriter(k21_f)); //BufferedWriter ��ü ����

		k21_bw.write("�ȳ� ����"); // �ȳ������� ���Ͽ� ��
		k21_bw.newLine(); //���ο� �ٷ� �Ѿ��
		k21_bw.write("hello ���"); //hello ��θ� ���Ͽ� ��
		k21_bw.newLine(); //���ο� �ٷ� �Ѿ��

		k21_bw.close(); // BufferedWriter��ü �ݱ�
	}

	public static void FileRead() throws IOException { //������ �б����� Ŭ����
		File k21_f = new File("c:\\Users\\kopo24\\Desktop\\text2.txt"); //�ռ� FileWrite���� ������ ������ ���
		BufferedReader k21_br = new BufferedReader(new FileReader(k21_f)); //BufferedReader�� ��ü ����

		String k21_readtxt; // k21_readtxt��� ���ڿ� ����

		while ((k21_readtxt = k21_br.readLine()) != null) { // �� ��, �� �� �о �� ���������� while loop����
			System.out.printf("%s\n", k21_readtxt); //�������� ���
		}
		k21_br.close(); //BufferedReader ��ü �ݱ�

	}

}
