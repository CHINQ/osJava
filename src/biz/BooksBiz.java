package biz;

import java.io.File;
import java.util.List;

import vo.Books;
import vo.SubPage;
import dao.BooksDao;

public class BooksBiz {
	private BooksDao dao;
	public BooksBiz(){
		dao=new BooksDao();
	}
	public List<Books> searchBook(){
		return dao.search();
	}
	public List<Books> searchBook(SubPage page){
		return dao.search(page);
	}
	public List<Books> searchBook(SubPage page,String bnm,String btxt){
		if((bnm==null&&btxt==null)|| ("".equals(bnm)&&"".equals(btxt)) ){
			return dao.search(page);
		}else if(bnm==null || "".equals(bnm)){
			return dao.searchByBtext(page,btxt);
		}else if(btxt==null || "".equals(btxt)){
			return dao.searchByBname(page,bnm);
		}else{
			return dao.searchByBnameAndBtext(page,bnm,btxt);
		}
	}
	public Books searchBook(String bid){
		return dao.search(bid);
	}
	public int searchBookCount(String bnm,String btxt){
		return dao.searchCount(bnm,btxt);
	}
	public boolean addBooks(Books books){
		int temp=dao.insert(books);
		if(temp>0){
			return true;
		}else {
			return false;
		}
	}
	public boolean delBooks(String bid,String path){
		Books  books=dao.search(bid); 	
		int temp=dao.delete(bid);		
		if(temp>0){
			String filePath=path+books.getBimage();
			File file=new File(filePath);
			if(file.exists()){
				file.delete();
			}				
			return true;
		}else{
			return false;
		}
	}
	public boolean upBooks(Books books,String path){
		Books  oldBook=dao.search(books.getBid()+"");
		int temp=-1;
		if(books.getBimage()==null){
			temp=dao.update(books);
		}else{
			temp=dao.update(books);
			if(temp>0){
				String filePath=path+oldBook.getBimage();
				File file=new File(filePath);
				if(file.exists()){
					file.delete();
				}	
			}
		}
		if(temp>0){
			return true;
		}else{
			return false;
		}
	}
}
