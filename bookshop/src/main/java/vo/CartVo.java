package vo;

public class CartVo {
	
	
	private Long quantity;	
	private Long memberNo;
	private Long bookNo;
	private Long price;
	private String bookName;
	
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	@Override
	public String toString() {
		return "CartVo [bookName=" + getBookName() +", quantity= " + getQuantity() + ", price = " + getPrice() +  "]";
	}
	
	
	
}
