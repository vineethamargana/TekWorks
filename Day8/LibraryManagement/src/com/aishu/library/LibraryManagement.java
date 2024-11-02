package com.aishu.library;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class LibraryItem {
	private String itemNum;
	private String publisher;
	private String language;

	public LibraryItem(String itemNum, String publisher, String language) {
		this.itemNum = itemNum;
		this.publisher = publisher;
		this.language = language;

	}

	public String getItemNum() {
		return itemNum;
	}

	public void setItemNum(String itemNum) {
		this.itemNum = itemNum;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "Item Number: " + itemNum + ", Publisher: " + publisher + ", Language: " + language;
	}
}

class Book extends LibraryItem {

	String bookName;

	public Book(String itemNum, String publisher, String language, String bookName) {
		super(itemNum, publisher, language);
		this.bookName = bookName;

	}

	@Override
	public String toString() {
		return super.toString() + ", Book Name: " + bookName;
	}

}

class Magazine extends LibraryItem {
	String MagazineName;

	public Magazine(String itemNum, String publisher, String language, String MagazineName) {
		super(itemNum, publisher, language);
		this.MagazineName = MagazineName;
	}
	
	@Override
    public String toString() {
        return super.toString() + ", Magazine Name: " + MagazineName;
    }

}

class Library {
	Map<String, LibraryItem> lib = new HashMap<>();
	Scanner sc = new Scanner(System.in);

	// add book or magazine
	public void add() {
		System.out.println("enter the type of the library item : \n1.Book \n2.Magazine");
		int n = sc.nextInt();
		sc.nextLine();
		if (n == 1) {
			System.out.println("Enter the book name:");
			String bookname = sc.nextLine();
			System.out.println("Enter the book number( it should include B at the start):");
			String itemNum = sc.nextLine();
			System.out.println("Enter the publisher Name:");
			String publisher = sc.nextLine();
			System.out.println("Enter the Language:");
			String language = sc.nextLine();
			Book book = new Book( itemNum, publisher, language,bookname);
			lib.put(itemNum, book);
		} 
		else if (n == 2) {
			System.out.println("Enter the magazine name:");
			String magname = sc.nextLine();
			System.out.println("Enter the magazine number:  it should include M at the start");
			String itemNum = sc.nextLine();
			System.out.println("Enter the publisher Name:");
			String publisher = sc.nextLine();
			System.out.println("Enter the Language:");
			String language = sc.nextLine();
			Magazine mag = new Magazine(itemNum, publisher, language,magname);
			lib.put(itemNum, mag);
		}
		else {
			System.out.println("choose correct option");
		}
	} 

	// remove book
	public void removeItem(String itemNum) {
		LibraryItem item = lib.get(itemNum);
		if (item != null) {
			if (lib.remove(itemNum) != null) {
				System.out.println("Student with ID " + itemNum + " deleted successfully.");
			} else {
				System.out.println("Student with ID " + itemNum + " not found.");
			}
		} else {
			System.out.println("Item doesnot exist");
		}
	}

	// search for item by number
	public void searchItem(String itemNum) {
		LibraryItem item = lib.get(itemNum);
		if (item != null) {
			System.out.println(itemNum + " " + item);
		} else {
			System.out.println("item doesnot exist");
		}
	}

	// update book
	public void updateItem(String itemNum) {
		LibraryItem item = lib.get(itemNum);
		if (item != null) {
			if (item instanceof Book) {
				Book book = (Book) item; // converting lib item to book... // Cast to Book
				System.out.println("enter the new name of the book " + book.bookName + ":");
				String NbookName = sc.nextLine();
				System.out.println("Enter the new publisher name " + book.getPublisher() + ":");
				String Npn = sc.nextLine();
				System.out.println("enter the new language:");
				String Nlang = sc.nextLine();

				book.bookName = NbookName; // Update the book name
				book.setPublisher(Npn); // Update the publisher
				book.setLanguage(Nlang); // Update the language
				System.out.println("Book updated successfully.");
				System.out.println("book name :" + book.getItemNum());
				System.out.println(book.bookName);
			} 
			else if (itemNum.charAt(0) == 'M' || itemNum.charAt(0)=='m' ) 
			{
				Magazine magazine = (Magazine) item; // Cast to Magazine
				System.out.println("Enter the new name of the magazine (current: " + magazine.MagazineName + "):");
				String newMagazineName = sc.nextLine();
				System.out.println("Enter the new publisher name (current: " + magazine.getPublisher() + "):");
				String newPublisher = sc.nextLine();
				System.out.println("Enter the new language (current: " + magazine.getLanguage() + "):");
				String newLanguage = sc.nextLine();

				// Update the Magazine's details
				magazine.MagazineName = newMagazineName; // Update the magazine name
				magazine.setPublisher(newPublisher); // Update the publisher
				magazine.setLanguage(newLanguage); // Update the language

				System.out.println("Magazine updated successfully.");
			}
		} else {
			System.out.println("Item does not exist.");
		}

	}
	// Display all items in the library
    public void displayAllItems() {
        if (lib.isEmpty()) {
            System.out.println("No items in the library.");
        } else {
            System.out.println("Items in the library:");
            for (LibraryItem item : lib.values()) {
                System.out.println(item);
            }
        }
    }

}

public class LibraryManagement {
	public static void main(String[] args) {

		Library library = new Library();
		Scanner sc = new Scanner(System.in);

		boolean exit = false;

		while (!exit) {
			System.out.println(
					"Choose one: \n1.Add the item \n2.Update an Existing item \n3.Search and display for an item \n4.delete an item \n5.display all items \n6.exit");
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				library.add();
				System.out.println("Item added succesfully");
				break;

			case 2:
				System.out.println("enter the number of the item you want to update:");
				String itemNum = sc.nextLine();
				library.updateItem(itemNum);
                 break;
			 case 3:
                 System.out.println("Enter the number of the item you want to search:");
                 itemNum = sc.nextLine();
                 library.searchItem(itemNum);
                 break;
             case 4:
                 System.out.println("Enter the number of the item you want to delete:");
                 itemNum = sc.nextLine();
                 library.removeItem(itemNum);
                 break;
             case 5:
                 library.displayAllItems();
                 break;
             case 6:
                 exit = true;
                 System.out.println("Exiting the program. Goodbye!");
                 break;
             default:
                 System.out.println("Invalid choice. Please try again.");
         }
     }

     sc.close(); // Close the scanner to prevent resource leak

		}
	}

