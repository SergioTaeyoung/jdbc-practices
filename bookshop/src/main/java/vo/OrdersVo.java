package vo;

public class OrdersVo {
	private Long no;
	private String bisNum ;
	private String name;
	private String email;
	private Long price;
	private String location;
	private Long memberNo;
	private Long quantity;
	private String title;
	private Long orderNo;
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getBisNum() {
		return bisNum;
	}
	public void setBisNum(String bisNum) {
		this.bisNum = bisNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	
	public String orderBook() {
		return "OrderBookVo [no=" + no + ", title=" + title + ", quantity=" + quantity + "]"; 
	}
	@Override
	public String toString() {
		return "OrdersVo [bisNum=" + bisNum + ", " + name + "/" + email  + ", price=" + price + ", location="
				+ location + "]";
	}
	

	
	
}
