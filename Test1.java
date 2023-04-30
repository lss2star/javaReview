package helloworld;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Test1 {

	public static void main(String[] args) {
		try { // ������ �����ϴµ� �߻��ϴ� ������ ��Ƴ��� try ~ catch������ ����
			File k21_f = new File("c:\\Users\\kopo24\\Desktop\\text.txt"); // k21_f��� ���� ������ ������ ����� ������ �ҷ��´�
			FileWriter k21_fw = new FileWriter(k21_f); // FileWriter�� �̿��Ͽ� k21_fw������ ���� ����
			
			k21_fw.write("�ȳ� ����\n");  //���Ͽ� �ȳ������̶�� ���ڿ� ����
			k21_fw.write("hello ���\n"); // ���Ͽ� hello ��� �̶�� ���ڿ� ����
			k21_fw.close(); // FileWriter ��ü�� ����
			
			FileReader k21_fr = new FileReader(k21_f);  // FileReader�� �̿��Ͽ� ���� �ۼ��� k21_f�� ����
			
			int k21_n = -1; // ���Ͽ��� ���� ���ڿ��� ����
			char [] k21_ch; // ���ڿ��� ���� �迭
			
			while (true) { // ������ �д� ���� �ݺ���ų �ݺ����� ����
				k21_ch = new char[100]; //100���� ���ڿ��� ���� �迭�� ���� - >���� 100�� �ƴ϶� �����Ӱ� ������ ����
				k21_n = k21_fr.read(k21_ch); //���Ͽ��� 100���ڸ� ����
				
				if (k21_n == -1) break; //�� �̻� ���� ������ ������ while���� ������ Ż��
				
				for (int k21_i = 0; k21_i < k21_n; k21_i++) { //���� ���ڿ��� ����ϱ� ���� for�� ����
					System.out.printf("%c", k21_ch[k21_i]); // ���ڿ��� ���
				}
			}
			
			k21_fr.close(); //FileReader ��ü�� ����
			System.out.printf("\n FILE READ END"); //������ �� ������ File Read END�� ����ϸ� ��
		} catch (Exception e) { // ����ó��
			System.out.printf("�� ����[%s]\n", e); // ���ܰ� �߻��Ѵٸ� �� ����[�����׸�]�� ���
		}

	}

}
