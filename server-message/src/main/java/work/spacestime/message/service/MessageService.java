package work.spacestime.message.service;

import java.util.List;

import work.spacestime.core.service.CurdService;
import work.spacestime.message.model.Message;

public interface MessageService  extends CurdService<Message>  {
	
	public Message addOne(Message obj);
	
	
	public void delOne(Long id);
	
	
	public Message updateOne(Message obj);
	
	
	public List<Message> findAll();

}
