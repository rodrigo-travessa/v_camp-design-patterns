package products;

import abstracts.Products;

public class Book extends Products {

	public String Author;
	public int NumberOfPages;


	public Book() {}


	public String getAuthor() {
		return Author;
	}


	public int getNumberOfPages() {
		return NumberOfPages;
	}
	public String toString() {

		return	"Book:" +"SKU: " +this.getSKU()
						+" Author:" + this.getAuthor()
						+", Pages:" + this.getNumberOfPages()
						+", Price:"+ Double.toString(this.getPrice())
						+", Weight:"+Double.toString(this.getWeight()) +"KGs;"
				;}
	
	public Book clone() {
		Book book = new Book();
		book.SKU = this.getSKU();
		book.Price = this.getPrice();
		book.Weight = this.getWeight();
		book.StockQuantity = this.getStockQuantity();
		book.ReservedQuantity = this.getReservedQuantity();
		book.NumberOfPages = this.getNumberOfPages();
		book.Author = this.getAuthor();
		return book;
	}
}
