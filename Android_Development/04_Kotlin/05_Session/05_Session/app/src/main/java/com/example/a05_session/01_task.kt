
open class LibraryItem(val title: String, val isbn: String, val publication: String, val numberOfPages: Int) {

    var isAvailable: Boolean = true

    fun checkAvailability(): Boolean {
        return isAvailable
    }

    fun borrowItem() {
        isAvailable = false
    }

    fun returnItem() {
        isAvailable = true
    }
}

class Book(title: String, isbn: String, publication: String, numberOfPages: Int) :
    LibraryItem(title, isbn, publication, numberOfPages)

class Magazine(title: String, isbn: String, publication: String, numberOfPages: Int) :
    LibraryItem(title, isbn, publication, numberOfPages)

class Journal(title: String, isbn: String, publication: String, numberOfPages: Int) :
    LibraryItem(title, isbn, publication, numberOfPages)

open class Person(val name: String, val id: String)

class Librarian(name: String, id: String, val password: String) : Person(name, id)

class User(name: String, id: String, val job: String) : Person(name, id)

class LibraryDatabase(librarian: Librarian) {

    private val availableBooks: MutableList<LibraryItem> = mutableListOf()
    private val borrowedBooks: MutableMap<LibraryItem, User> = mutableMapOf()

    fun addBook(book: LibraryItem) {
        availableBooks.add(book)
        println("Added: ${book.title}")
    }


    fun lendBook(book: LibraryItem, user: User) {
        if (book.checkAvailability()) {
            book.borrowItem()
            borrowedBooks[book] = user
            println("${user.name} borrowed: ${book.title}")
        } else {
            println("Sorry, ${book.title} is not available.")
        }
    }

    fun viewAvailableBooks() {
        println("Available Books:")
        availableBooks.filter { it.checkAvailability() }
            .forEach { println("- ${it.title} (ISBN: ${it.isbn})") }
    }


    fun searchForABook(title: String) {
        val foundBooks = availableBooks.filter { it.title.contains(title, ignoreCase = true) }
        if (foundBooks.isNotEmpty()) {
            println("Found Books:")
            foundBooks.forEach { println("- ${it.title} (ISBN: ${it.isbn})") }
        } else {
            println("No books found with the title: $title")
        }
    }


    fun receiveBookFromBorrower(book: LibraryItem, user: User) {
        if (borrowedBooks.containsKey(book) && borrowedBooks[book] == user) {
            book.returnItem()
            borrowedBooks.remove(book)
            println("${user.name} returned: ${book.title}")
        } else {
            println("${user.name} did not borrow: ${book.title}")
        }
    }

    fun getAvailableBooks(): List<LibraryItem> {
        return availableBooks.filter { it.isAvailable }
    }
}

fun main() {

    val librarian = Librarian("Nahass", "123", "010")
    val libraryDatabase = LibraryDatabase(librarian)

    libraryDatabase.addBook(Book("AA", "11", "CC", 180))
    libraryDatabase.addBook(Magazine("BB", "22", "DD", 56))
    libraryDatabase.addBook(Journal("CC", "33", "KK", 120))

    libraryDatabase.viewAvailableBooks()

    val user = User("Ahmed", "55", "Eng")

    libraryDatabase.lendBook(libraryDatabase.getAvailableBooks()[0], user)

    libraryDatabase.searchForABook("AA")

    libraryDatabase.receiveBookFromBorrower(libraryDatabase.getAvailableBooks()[0], user)

    libraryDatabase.viewAvailableBooks()
}
