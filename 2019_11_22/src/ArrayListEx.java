import java.util.*;

public class ArrayListEx {
	public static void main(String[] args) {
		// ���ڿ��� ���԰����� ArrayList �÷��� ����
		ArrayList<String> a = new ArrayList<String>();
		// Ű����κ��� 4���� �̸� �Է¹޾� ArrayList�� ����
		Scanner scanner = new Scanner(System.in); 
		while(true) {
			System.out.print("�̸��� �Է��ϼ���>>");
			String s = scanner.next(); // Ű����κ��� �̸� �Է�
			a.add(s); // ArrayList �÷��ǿ� ����
			if(s == "����") {
				break;
			}
		}
		
		// ArrayList�� ��� �ִ� ��� �̸� ���
		for(int i=0; i<a.size(); i++) {
			// ArrayList�� i ��° ���ڿ� ������  
			String name = a.get(i); 
			System.out.print(name + " ");
		}	
	
	// ���� �� �̸� ���
			int longestIndex = 0; 
			for(int i=1; i<a.size(); i++) {
				if(a.get(longestIndex).length() < a.get(i).length())
					longestIndex = i; 
			}
			System.out.println("\n���� �� �̸��� : " + 
					a.get(longestIndex));		
		}
		
	}
