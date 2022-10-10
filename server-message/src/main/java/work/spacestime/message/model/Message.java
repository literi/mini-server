package work.spacestime.message.model;

public class Message extends BaseModel{
	// 发送者
	private Long sendUser;
	private Long receiveUser;
	private Long loginUser;
	private String msgType;
	private String msgContent; 
	private String isRead;
	public Long getSendUser() {
		return sendUser;
	}
	public void setSendUser(Long sendUser) {
		this.sendUser = sendUser;
	}
	public Long getReceiveUser() {
		return receiveUser;
	}
	public void setReceiveUser(Long receiveUser) {
		this.receiveUser = receiveUser;
	}
	public Long getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(Long loginUser) {
		this.loginUser = loginUser;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	public String getIsRead() {
		return isRead;
	}
	public void setIsRead(String isRead) {
		this.isRead = isRead;
	} 
	
}
