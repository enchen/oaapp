package cn.beans;

import java.util.Date;

public class News {
private int fromUser;
private int toUser;
private int newsId;
private String newsContent;
private int operate;
private int type;
private Date creatTime;
public int getFrom() {
	return fromUser;
}
public void setFrom(int from) {
	this.fromUser = from;
}
public int getNewsId() {
	return newsId;
}
public void setNewsId(int newsId) {
	this.newsId = newsId;
}

public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
public Date getCreatTime() {
	return creatTime;
}
public void setCreatTime(Date creatTime) {
	this.creatTime = creatTime;
}
public String getNewsContent() {
	return newsContent;
}
public void setNewsContent(String newsContent) {
	this.newsContent = newsContent;
}
public int getOperate() {
	return operate;
}
public void setOperate(int operate) {
	this.operate = operate;
}
public int getToUser() {
	return toUser;
}
public void setToUser(int toUser) {
	this.toUser = toUser;
}
}
