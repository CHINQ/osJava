package vo;

public class SubPage {
	private int showNumber;
	private int currentPage;
	private int totalElement; 
	public int getShowNumber() {
		return showNumber;
	}
	public void setShowNumber(int showNumber) {
		this.showNumber = showNumber;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalElement() {
		return totalElement;
	}
	public void setTotalElement(int totalElement) {
		this.totalElement = totalElement;
	}
	public SubPage() {
		super();
	}
	public SubPage(int showNumber, int currentPage, int totalElement) {
		super();
		this.showNumber = showNumber;
		this.currentPage = currentPage;
		this.totalElement = totalElement;
	}
	public int getTotalPage(){
		return (totalElement-1)/showNumber+1;
	}
	public int getStartIndex(){
		return (currentPage-1)*showNumber;
	}
	public int getPrev(){
		int temp=currentPage-1;
		if(temp<1){
			temp=1;			
		}
		return temp;
	}
	public int getNexts(){
		int temp=currentPage+1;
		if(temp>this.getTotalPage()){
			temp=this.getTotalPage();
		}		
		return temp;
	}

}
