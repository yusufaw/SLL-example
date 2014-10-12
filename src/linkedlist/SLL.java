package linkedlist;

/**
 * @author Yusuf Aji Wibowo
 *
 */
public class SLL {
	private NodeSLL pointer;
	
	public SLL(){
		pointer = null;
	}
	public void buatNode(int dt){
		NodeSLL nodeBaru = new NodeSLL();
		nodeBaru.data = dt;
		nodeBaru.next = pointer;
		pointer = nodeBaru;
	}
	/**
	 * @param dt1
	 * @param dt2
	 * @return
	 */
	public boolean titip(int dt1, int dt2){
		NodeSLL n = pointer;
		while ((n!=null) && (n.data != dt2))
			n = n.next;
		if(n == null)
			return false;
		NodeSLL nn = new NodeSLL();
		nn.data = dt1;
		nn.next = n.next;
		n.next = nn;
		return true;
	}
	public void hapusData(int dtHapus) {
		NodeSLL psblHapus, pHapus;
		psblHapus = null;
		pHapus = pointer;
		boolean ketemu = false;
		while(!ketemu && pHapus != null){
			if(pHapus.data == dtHapus){
				ketemu =true;
			}
			else{
				psblHapus = pHapus;
				pHapus = pHapus.next;
			}
		}
		if(ketemu){
			psblHapus.next = pHapus.next;
			pHapus = null;
		}
	}
	public void sisipDataUrut(int dt){
		NodeSLL psblKini, pKini;
		psblKini = null;
		pKini = pointer;
		NodeSLL baru = new NodeSLL();
		baru.data = dt;
		baru.next = null;
		boolean ketemu = false;
		while(!ketemu && pKini !=null){
			if(baru.data < pKini.data){
				ketemu = true;
				
				
			}
			else{
				psblKini = pKini;
				pKini = pKini.next;
			}
		}
		if(ketemu){
			psblKini.next = baru;
			baru.next = pKini;
		}
	}
	public int hapusDiDepan() {
		NodeSLL hapus = pointer;
		pointer = pointer.next;
		return hapus.data;
	}
	public void cetak(String komentar){
		System.out.println(komentar);
		NodeSLL n = pointer;
		while (n!=null){
			System.out.print(n.data+"->");
			n = n.next;
		}
		System.out.println("NULL");
	}
	public void sisipDiAkhir(int dt){
		NodeSLL baru = new NodeSLL();
		baru.data = dt;
		baru.next =null;
		NodeSLL psblAkhir = null;
		NodeSLL pAkhir = pointer;
		while(pAkhir != null){
			psblAkhir = pAkhir;
			pAkhir = pAkhir.next;
		}
		psblAkhir.next = baru;
	}
	public static void main(String[] args) {
		SLL l = new SLL();
		l.buatNode(2);
		l.buatNode(4);
		l.buatNode(9);
		
		l.cetak("coba");
		l.hapusDiDepan();
		l.cetak("Setelah dihapus didepan");
		l.sisipDiAkhir(100);
		l.cetak("Setelah disisipi 100");	
	}
}
