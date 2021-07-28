package project3;

public class BstTest {

	public static void main(String[] args) {
		
		String[] keys = { "QR", "SQ", "CX", "EK", "KE", "LH", "OZ", "DL", "AHC", "QF" };
		String[] values = { "Qatar Airways  (Q.C.S.C)", "Singapore Airlines  Ltd.", "Cathay Pacific  Airways Ltd.", "Emirates", "Korean Air Lines Co.  Ltd."
				, "Lufthansa German  Airlines", "Asiana Airlines Inc.", "Delta Air Lines Inc.", "Air Hawaii", "Qantas Airways Ltd." };

		BST<String, String> bst = new BST<String, String>();
		
		// 동적삽입
		for (int i = 0; i < keys.length; i++) {
			bst.insert(keys[i], values[i]);
		}

		// BST 확인
		bst.inorder();
		System.out.println("height = " + bst.height());
		System.out.println("root key = " + bst.getRootKey());

		// 검색
		/*if (bst.search("B") == null) {
			System.out.println("No such key");
		} else {
			System.out.println(bst.getValue(bst.search("B")));
		}*/
	}
}
