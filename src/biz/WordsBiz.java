package biz;

import java.util.List;

import vo.SubPage;
import vo.Users;
import vo.Words;
import dao.WordsDao;

public class WordsBiz {

	private WordsDao dao;
	public WordsBiz(){
		dao=new WordsDao();
	}
	public List<Words> searchNowUserWords(String uid){
		return dao.searchNowUserWords(uid);
	}
	public List<Words> searchNowUserWords(Users user,SubPage page){
		return dao.searchNowUserWords(user,page);
	}
	public int searchWordsCount(String uid){
		return dao.searchWordsCount(uid);
	}
	public boolean addWords(Words wor){
		boolean flag=false;
		if(dao.addWords(wor)>0){
			flag=true;
		}
		return flag;
	}
		public int searchWordsCount(){
			return dao.searchWordsCount();
		}
}
