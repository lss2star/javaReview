package helloworld;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test3 {

	public static void main(String[] args) throws IOException {
		File k21_f = new File("C:\\Users\\kopo24\\Desktop\\12_04_07_E_���������������.csv"); // �ٿ���� ������ ��ü ����
		BufferedReader k21_br = new BufferedReader(new FileReader(k21_f)); //������ �б� ���� BufferedReader ��ü ����
		
		String k21_readtxt; // k21_readtxt��� ���ڿ� ���� ����
		
		if ((k21_readtxt = k21_br.readLine()) == null) { //ù��° ���� �а� �� �����̸� if���� ���ǹ��� Ž
			System.out.printf("�� �����Դϴ�\n"); // �� �����Դϴٸ� ���
			return; //�������� return��
		}
		String[] k21_field_name = k21_readtxt.split(","); // ù��° ������ ��ǥ�� �������� ������ k21_field_name�迭�� ����
		
		int k21_LineCnt = 0; //���� ���� ������ ����  
		while((k21_readtxt = k21_br.readLine()) != null) { //������ ������ ������ ���� while loop ��ȷ
			String[] k21_field = k21_readtxt.split(","); //,�� �������� ������ k21_field �迭�� ����
			System.out.printf("**[%d��° �׸�]*****************\n", k21_LineCnt); // ���� ���� ��� ->���° ���� �� �� ����
			for (int k21_j = 0; k21_j < k21_field_name.length; k21_j++) { //�� �پ��������� for���� ����
				System.out.printf("%s : %s\n", k21_field_name[k21_j], k21_field[k21_j]); //���پ� �������� ���
			}
			System.out.printf("***********************************\n"); //���پ� ���� �� ������ ����ϱ� ���� ���� �� ���
			if (k21_LineCnt == 100) break; //100���� �Ǹ� while loop Ż��
			k21_LineCnt++; //������ �� ���� �� ���� ���� �б� ���� k21_LineCnt 1�� ����
		}

	}

}
