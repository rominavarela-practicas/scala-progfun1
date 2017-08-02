
class Book(val author:String, val title:String) {}

object BookStore {
  val books = Set(
      new Book(author = "auth1", title="programming in scala"),
      new Book(author = "auth2", title="programming in java"),
      new Book(author = "auth1", title="programming a hello world in scala"),
      new Book(author = "auth3", title="programming a furby in scala"),
      new Book(author = "auth4", title="eating cookies"),
      new Book(author = "auth4", title="eating radioactive potatoes")
  )
  
  def showcase() {
    println("All programming books")
    println()
    
    val progBooks =
      for {
        book <- books
        if book.title.contains("programming")
      } yield book
    
    progBooks.foreach(book => println("- " + book.title + " by " + book.author ))
    
    println()
    println("All authors of programming books")
    println()
    
    val progAuthors = 
      for {
        book <- books
        if book.title.contains("programming")
      } yield book.author
    
    progAuthors.foreach(author => println("- " + author))
  }
}
