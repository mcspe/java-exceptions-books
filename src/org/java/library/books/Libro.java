package org.java.library.books;

public class Libro {
	
	private String titolo;
	private int numPagine;
	private String autore;
	private String editore;
	
	public Libro(String titolo, int numPagine, String autore, String editore) throws Exception {
		setTitolo(titolo);
		setNumPagine(numPagine);
		setAutore(autore);
		setEditore(editore);
	}
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) throws Exception {
		if (titolo.isBlank()) throw new Exception("Title can't be empty");
		this.titolo = titolo;
	}
	
	public int getNumPagine() {
		return numPagine;
	}
	public void setNumPagine(int numPagine) throws Exception {
		if (numPagine <= 0) throw new Exception("Page number can't be 0 or less");
		this.numPagine = numPagine;
	}
	
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) throws Exception {
		if (autore.isBlank()) throw new Exception("Author can't be empty");
		this.autore = autore;
	}
	
	public String getEditore() {
		return editore;
	}
	public void setEditore(String editore) throws Exception {
		if (editore.isBlank()) throw new Exception("Editor can't be empty");
		this.editore = editore;
	}

	@Override
	public String toString() {
		return "Titolo: " + getTitolo() + "\n\tNumero Pagine: " + getNumPagine() + "\n\tAutore: " + getAutore() + "\n\tEditore: " + getEditore();
	}

}
