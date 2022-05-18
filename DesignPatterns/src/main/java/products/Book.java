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

		return	"Book:" +" Author:" + this.getAuthor()
						+" Pages:" + this.getNumberOfPages()
						+" Price:"+ Double.toString(this.getPrice())
						+" Weight:"+Double.toString(this.getWeight()) +"KGs"
				;}
}
