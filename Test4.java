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
		File k21_f = new File("C:\\Users\\kopo24\\Desktop\\12_04_07_E_��������������� (2).txt"); // ������ ��ο� �ִ� ���� �б����� ��ü ����
		BufferedReader k21_br = new BufferedReader(new FileReader(k21_f)); //BufferedReader ��ü�� ����

		String k21_readtxt; //���� ������ ���ڿ��� �����ϱ� ���� ���ڿ� ���� ����

		if ((k21_readtxt = k21_br.readLine()) == null) { //���� ���� ������ �� �����̸� if���ǹ��� Ž
			System.out.printf("�� �����Դϴ�\n"); //�� �����Դϴ� ��� ���ڿ��� ���
			return; //null�� return����
		}
		String[] k21_field_name = k21_readtxt.split("\t"); //������ ���е� ù ���� �о� k21_field_name�� ����

		double k21_lat = 37.386138; //�� ��ġ�� ���� ����
		double k21_lng = 127.120748; //�� ��ġ�� �浵 ����
		
		//�ִ�Ÿ��� ���ϱ� ���� ���� ����
		double k21_max_dist = Double.MIN_VALUE; //double������ ������ �� �ִ� �ּ��� ������ �ʱ�ȭ -> �ִ�Ÿ��� ��� �ʱ�ȭ
		String k21_max_address = ""; //�ִ�Ÿ��� �ش��ϴ� �ּҸ��� �ޱ� ���� ����
		String k21_max_name = ""; //�ִ�Ÿ��� �ش��ϴ� ��ġ��Ҹ��� �����ϱ� ���� ����
		double k21_max_lati = 0.0; //�ִ�Ÿ��� �ش��ϴ� ���� �ޱ����� ����
		double k21_max_lng = 0.0; //�ִ�Ÿ��� �ش��ϴ� �浵 �ޱ����� ����
		
		//�ּҰŸ��� ���ϱ� ���� ���� ����
		double k21_min_dist = Double.MAX_VALUE; //double������ �����Ҽ� �ִ� �ִ��� ������ �ʱ�ȭ -> �ּҰŸ��� ��� �ʱ�ȭ
		String k21_min_address = ""; //�ּҰŸ��� �ش��ϴ� �ּҸ��� �ޱ� ���� ����
		String k21_min_name = ""; //�ּҰŸ��� �ش��ϴ� ��ġ��Ҹ��� �ޱ� ���� ����
		double k21_min_lati = 0.0; //�ּҰŸ��� �ش��ϴ� ���� �ޱ� ���� ����
		double k21_min_lng = 0.0; //�ּҰŸ��� �ش��ϴ� �浵 �ޱ� ���� ����
		
		

		int k21_LineCnt = 0; //���� ���� ���� ���� k21_LiceCnt ���� ���� -> 0���� �ʱ�ȭ
		while ((k21_readtxt = k21_br.readLine()) != null) { //���پ� �дµ� ������� -> ������ ���������� while�� ����
			String[] k21_field = k21_readtxt.split("\t"); // �� �ٸ��� ������ ���е� ���ڿ��� �о k21_field�� ����
			System.out.printf("** [%d��° �׸�]********\n", k21_LineCnt); //���� ���� ���° ���� ���
			System.out.printf(" %s : %s\n", k21_field_name[10], k21_field[10]); // �������� �ּ� : �ش��ϴ� �ּҰ� ���
			System.out.printf(" %s : %s\n", k21_field_name[13], k21_field[13]); // ���� : �ش��ϴ� ������ ���
			System.out.printf(" %s : %s\n", k21_field_name[14], k21_field[14]); // �浵 : �ش��ϴ� �浵�� ���
			double k21_dist = Math.sqrt(Math.pow(Double.parseDouble(k21_field[13]) - k21_lat, 2)
					+ Math.pow(Double.parseDouble(k21_field[14]) - k21_lng, 2)); // ��Ÿ��󽺸� �̿��� �� ��� ������ �Ÿ� ���ϱ�
																				// ��Ʈ ((1�� �浵 - 2�� �浵)^2 + (1�� ���� - 2�� ����)^2) = �Ÿ�
			System.out.printf(" ������������ �Ÿ� : %f\n", k21_dist); // �Ÿ��� ���
			System.out.printf("********************\n"); //�ڷ� ���پ� ���� �� ������ ���
			
			if (k21_max_dist < k21_dist) { // �ִ� �Ÿ��϶��� ���ϱ� ���� ���ǹ� ����
				k21_max_address = k21_field[10]; // �ִ�Ÿ��϶��� �ּҸ� ����
				k21_max_dist = k21_dist; // �ִ�Ÿ��϶� �� �Ÿ����� ������ ����
				k21_max_name = k21_field[1]; //�ִ�Ÿ��϶��� ��Ҹ��� ����
				k21_max_lati = Double.parseDouble(k21_field[13]); // �ִ�Ÿ��϶��� ������ ����
				k21_max_lng = Double.parseDouble(k21_field[14]); //�ִ�Ÿ��϶��� �浵�� ����
			}
			
			if (k21_min_dist > k21_dist) { // �ּ� �Ÿ��϶��� ���ϱ� ���� ���ǹ� ����
				k21_min_address = k21_field[10]; // �ּҰŸ��϶� �ּ� ����
				k21_min_dist = k21_dist; //�ּҰŸ��� ����
				k21_min_name = k21_field[1]; // �ּҰŸ��� ��Ҹ��� ����
				k21_min_lati = Double.parseDouble(k21_field[13]); //�ּҰŸ��϶��� ������ ����
				k21_min_lng = Double.parseDouble(k21_field[14]); //�ּҰŸ��϶��� �浵�� ����
			}
			

			k21_LineCnt++; //���� ���� �б� ���� LineCnt�� 1 ����

		} // �� ���� ���� �� �� �پ� �� ��� �� �� whileLoop���� 
		System.out.printf("�ִ�Ÿ�\n"); //�ִ�Ÿ��϶��� ���� ��� ����
		System.out.printf("�Ÿ� : %f\n", k21_max_dist); // �ִ�Ÿ��϶��� �Ÿ�
		System.out.printf("��Ҹ� : %s\n", k21_max_name); // �ִ�Ÿ��϶��� ��Ҹ�
		System.out.printf("�ּ� : %s\n", k21_max_address); //�ִ�Ÿ��϶��� �ּ�
		System.out.printf("���� : %f\n", k21_max_lati); //�ִ�Ÿ��϶��� ����
		System.out.printf("�浵 : %f\n", k21_max_lng); // �ִ�Ÿ��϶��� �浵
		
		System.out.println(); //������ ���� �� �� ����
		
		System.out.printf("�ּҰŸ�\n"); //�ּҰŸ��϶��� ���� ��� ����
		System.out.printf("�Ÿ� : %f\n", k21_min_dist); // �ּҰŸ��϶��� �Ÿ�
		System.out.printf("��Ҹ� : %s\n", k21_min_name); // �ּҰŸ��϶��� ���
		System.out.printf("�ּ� : %s\n", k21_min_address); // �ּұ⸮�϶��� �ּ�
		System.out.printf("���� : %f\n", k21_min_lati); // �ּҰŸ��϶��� ����
		System.out.printf("�浵 : %f\n", k21_min_lng); //�ּҰŸ��϶��� �浵
		

		k21_br.close(); // BufferedReader�� ��ü ����

	}

}
