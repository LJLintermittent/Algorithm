package Hanoitower;
//***************************************************************�����㷨����ŵ�����⣩*********************************************************************
public class Hanoitower {

	public static void main(String[] args) {
		hanoiTower(5, 'A', 'B', 'C');
	}

	// ��ŵ�����ƶ�����
	// ʹ�÷����㷨
	public static void hanoiTower(int num, char a, char b, char c) {
		// ���ֻ��һ����
		if (num == 1) {
			System.out.println("��1���̴� " + a + "->" + c);
		} else {
			// �������һ���̣��������ǿ��԰���������������
			// �����±ߵ�һ����
			// �������������

			// 1. ������������� A->B�� �ƶ����̻�ʹ�õ� c
			hanoiTower(num - 1, a, c, b);
			// 2. �����±ߵ��� A->C
			System.out.println("��" + num + "���̴� " + a + "->" + c);
			// 3. ��B���������� �� B->C , �ƶ����̻�ʹ�õ� a
			hanoiTower(num - 1, b, a, c);

		}
	}

}

