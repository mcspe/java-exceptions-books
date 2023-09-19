package org.java.library;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.java.library.books.Libro;

public class Main {
	
	private static final String FILE_PATH = "C:/Users/Utente1/Desktop/JAVA/java-exceptions-books/books/books.txt";

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean isValid = false;
		Libro[] books = null;
		FileWriter myWriter = null;
		
		while(!isValid) {
		
			try {
				
				System.out.print("Benvenuto. Quanti libri vuoi inserire? ");
				int booksCounter = Integer.valueOf(sc.nextLine());			
				books = new Libro[booksCounter];
				isValid = true;
				
			} catch (Exception e) {
				
				System.err.println("Il valore inserito non è corretto. Riprova");
				continue;
			
			}
			
		}
		
		for (int i = 0; i < books.length; i++) {
			
			System.out.println("-----------------------------");
			System.out.println("Libro n. " + (i + 1));
			
			System.out.print("Inserire il titolo: ");
			String title = sc.nextLine();
			
			System.out.print("Inserire il numero di pagine: ");
			int pageN = Integer.valueOf(sc.nextLine());
			
			System.out.print("Inserire l'autore: ");
			String author = sc.nextLine();
			
			System.out.print("Inserire l'editore: ");
			String editor = sc.nextLine();
			
			try {
			
				books[i] = new Libro(title, pageN, author, editor);
			
			} catch (Exception e) {
			
				System.err.println("-----------------------------");
				System.err.println("Uno o più dei valori inseriti non sono validi" + 
									"\n\t" + 
									e.getMessage());
				System.err.println("-----------------------------");
				i--;
			
			}
		
			try {
				
				myWriter = new FileWriter(FILE_PATH, true);
				myWriter.write(books[i].toString());
				myWriter.write("\n----------------------------------------------------------\n");
			
			} catch (IOException e) {
				
				System.err.println("-----------------------------");
				System.err.println("Errore nella scrittura del file: " + 
									"\n\t" + 
									e.getMessage());
				System.err.println("-----------------------------");
				
			} finally {
				
				try {
					myWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		sc.close();
		
		System.out.println("\n-----------------------------\n");

		File booksFile = new File(FILE_PATH);
		Scanner reader = null;
		try {
			
			reader = new Scanner(booksFile);
			
			while (reader.hasNextLine()) {
				
				String line = reader.nextLine();
				System.out.println(line);
				
			}
			
		} catch (Exception e) { 
		
			System.out.println("Error reading file: " + e.getMessage());
			
		} finally {
			
			if (reader != null)
				reader.close();
		}
		
	}

}
