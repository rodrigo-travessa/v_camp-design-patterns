package Products;

import abstracts.Products;

public class Book extends Products {

	private String Author;
	private int NumberOfPages;


	public Book(int sku, double price, double weight, int StockQuantity, int ReservedQuantity, String author,int numberOfPages) {
		super();
		SKU = sku;
		Price = price;
		Weight = weight;
		Author = author;
		NumberOfPages = numberOfPages;
	}


	public String getAuthor() {
		return Author;
	}


	public int getNumberOfPages() {
		return NumberOfPages;
	}
	public String toString() {

		return	

				"Author:" + this.getAuthor()
				+" "
				+"Pages:" + this.getNumberOfPages()
				+" "
				+"Price:"+ Double.toString(this.getPrice())
				+" "
				+"Weight:"+Double.toString(this.getWeight()) +"KGs"
				;}
}
