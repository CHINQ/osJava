package biz;

import java.util.List;

import vo.Message;
import vo.SubPage;
import dao.MessageDao;

public class MessageBiz {

	private MessageDao dao;
	public MessageBiz(){
		dao=new MessageDao();
	}
	public List<Message> searchAllMessage(SubPage page){
		return dao.searchAllMessage(page);
	}
	public List<Message> searchAllMessage(){
		return dao.searchAllMessage();
	}
	public Message searchOneMessage(String mid){
		return dao.searchOneMessage(mid);
	}
	public boolean changeMessage(Message mes){
		boolean flag=false;
		if(dao.changeMessage(mes)>0){
			flag=true;
		}
		return flag;
	}
	public boolean deleteMessage(String mid){
		boolean flag=false;
		if(dao.deleteMessage(mid)>0){
			flag=true;
		}
		return flag;
	}
	public boolean addNewMessage(Message mes){
		boolean flag=false;
		if(dao.addNewMessage(mes)>0){
			flag=true;
		}
		return flag;
	}
	public int searchMessageCount(){
		return dao.searchMessageCount();
	}
}
