package pages.Contribuyente;

public class Contribuyente {
	private String doc_tipo;
	private String doc_doc;
	private String doc_ver;

	public Contribuyente(String doctipo, String docdoc, String docver) {
		this.doc_tipo = doctipo;
		this.doc_doc = docdoc;
		this.doc_ver = docver;
	}

	public String getDoc_tipo() {
		return doc_tipo;
	}

	public void setDoc_tipo(String doc_tipo) {
		this.doc_tipo = doc_tipo;
	}

	public String getDoc_doc() {
		return doc_doc;
	}

	public void setDoc_doc(String doc_doc) {
		this.doc_doc = doc_doc;
	}

	public String getDoc_ver() {
		return doc_ver;
	}

	public void setDoc_ver(String doc_ver) {
		this.doc_ver = doc_ver;
	}
	
	

}

