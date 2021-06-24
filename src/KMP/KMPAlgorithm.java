package KMP;
//*****************************************************************KMP�㷨���ַ���ƥ�����⣩
import java.util.Arrays;

public class KMPAlgorithm {

	public static void main(String[] args) {
		String str1 = "BBC ABCDAB ABCDABCDABDE";
		String str2 = "ABCDABD";

		int[] next = kmpNext("ABCDABD");
		System.out.println("next=" + Arrays.toString(next));

		int index = kmpSearch(str1, str2, next);
		System.out.println("index=" + index); 

	}

	// kmp�����㷨
	/**
	 * @param str1
	 *            Դ�ַ���
	 * @param str2
	 *            �Ӵ�
	 * @param next
	 *            ����ƥ���, ���Ӵ���Ӧ�Ĳ���ƥ���
	 * @return �����-1����û��ƥ�䵽�����򷵻ص�һ��ƥ���λ��
	 */
	public static int kmpSearch(String str1, String str2, int[] next) {

		// ����
		for (int i = 0, j = 0; i < str1.length(); i++) {

			// ��Ҫ���� str1.charAt(i) ��= str2.charAt(j), ȥ����j�Ĵ�С
			while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
				j = next[j - 1];
			}

			if (str1.charAt(i) == str2.charAt(j)) {
				j++;
			}
			
			if (j == str2.length()) {  // �ҵ��� 
				return i - j + 1;
			}
		}
		return -1;
	}

	// ��ȡ��һ���ַ���(�Ӵ�) �Ĳ���ƥ��ֵ��
	public static int[] kmpNext(String dest) {
		// ����һ��next ���鱣�沿��ƥ��ֵ
		int[] next = new int[dest.length()];
		next[0] = 0; // ����ַ����ǳ���Ϊ1 ����ƥ��ֵ����0
		for (int i = 1, j = 0; i < dest.length(); i++) {
			
			// ��dest.charAt(i) != dest.charAt(j) ��������Ҫ��next[j-1]��ȡ�µ�j
			// ֱ�����Ƿ��� �� dest.charAt(i) == dest.charAt(j)�������˳�
			// ����kmp�㷨�ĺ��ĵ�
			while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
				j = next[j - 1];
			}

			// ��dest.charAt(i) == dest.charAt(j) ����ʱ������ƥ��ֵ����+1
			if (dest.charAt(i) == dest.charAt(j)) {
				j++;
			}
			next[i] = j;
		}
		return next;
	}
}
