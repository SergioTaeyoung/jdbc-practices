package vo;

public class CategoryVo {
	private Long no;
	private String CategoryName;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", CategoryName=" + CategoryName + "]";
	}
}
