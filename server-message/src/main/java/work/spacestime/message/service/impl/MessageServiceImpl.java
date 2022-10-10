package work.spacestime.message.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import work.spacestime.core.page.PageRequest;
import work.spacestime.core.page.PageResult;
import work.spacestime.message.model.Message;
import work.spacestime.message.service.MessageService;



@Service
public class MessageServiceImpl implements MessageService{

	@Override
	public int save(Message record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Message record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(List<Message> records) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Message findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message addOne(Message obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delOne(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Message updateOne(Message obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
