package com.icoffee.weixin.server;

/**
 * <xml>
 <ToUserName><![CDATA[toUser]]></ToUserName>
 <FromUserName><![CDATA[fromUser]]></FromUserName>
 <CreateTime>1348831860</CreateTime>
 <MsgType><![CDATA[text]]></MsgType>
 <Event><![CDATA[subscribe]]></Event>
 <Content><![CDATA[this is a test]]></Content>
 <MsgId>1234567890123456</MsgId>
  <PicUrl><![CDATA[this is a url]]></PicUrl>
  <MediaId><![CDATA[media_id]]></MediaId>
  <Recognition><![CDATA[腾讯微信团队]]></Recognition>
  <ThumbMediaId><![CDATA[thumb_media_id]]></ThumbMediaId>
 <Format><![CDATA[Format]]></Format>
 <Ticket><![CDATA[TICKET]]></Ticket>
 <EventKey><![CDATA[qrscene_123123]]></EventKey>
 <Latitude>23.137466</Latitude>
<Longitude>113.352425</Longitude>
<Precision>119.385040</Precision>
<EventKey><![CDATA[EVENTKEY]]></EventKey>
 </xml>
 * @author lixiaojing
 *
 */
public class WeixinMessage {
	private Long createTime;
	private String toUserName, fromUserName, msgType, content, msgId, picUrl, mediaId, recognition,
	thumbMediaId, Format, ticket, eventKey, event;
	private Double latitude, longitude, precision;
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	public String getRecognition() {
		return recognition;
	}
	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}
	public String getThumbMediaId() {
		return thumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		Format = format;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public String getEventKey() {
		return eventKey;
	}
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
	@Override
	public String toString() {
		return "WeixinMessage [createtime=" + createTime + ", toUserName=" + toUserName + ", fromUserName="
				+ fromUserName + ", msgType=" + msgType + ", content=" + content + ", msgId=" + msgId + ", picUrl="
				+ picUrl + ", mediaId=" + mediaId + ", recognition=" + recognition + ", thumbMediaId=" + thumbMediaId
				+ ", Format=" + Format + ", ticket=" + ticket + ", eventKey=" + eventKey + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", precision=" + precision + "]";
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createtime) {
		this.createTime = createtime;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getPrecision() {
		return precision;
	}
	public void setPrecision(Double precision) {
		this.precision = precision;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
}
