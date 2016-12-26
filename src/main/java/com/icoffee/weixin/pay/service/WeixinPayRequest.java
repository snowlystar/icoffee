package com.icoffee.weixin.pay.service;

public class WeixinPayRequest implements IUnifiedOrderRequest {
	private String appid;   // �� String(32) wxd678efh567hg6787 ΢��֧������Ĺ����˺�ID����ҵ��corpid��Ϊ��appId�� 
	private String mch_id;  // �� ΢��֧��������̻���
	private String device_info;  // �� String(32) 013467007045764 �Զ������������Ϊ�ն��豸��(�ŵ�Ż������豸ID)��PC��ҳ���ں���֧�����Դ�"WEB"
	private String nonce_str; // �� String(32) 5K8264ILTKCH16CQ2502SI8ZNMTM67VS ����ַ���������Ҫ����32λ���ڡ��Ƽ�����������㷨 
	private String sign; // �� String(32) C380BEC2BFD727A4B6845133519F3AD6 ͨ��ǩ���㷨����ó���ǩ��ֵ�����ǩ�������㷨
	private String sign_type; // �� String(32) HMAC-SHA256 ǩ�����ͣ�Ĭ��ΪMD5��֧��HMAC-SHA256��MD5��
	private String body; // �� String(128) ��Ѷ��ֵ����-QQ��Ա��ֵ  ��Ʒ�����������ֶ��밴�չ淶���ݣ�������������涨
	private String detail; // �� String(6000) ��Ʒ��ϸ�б�ʹ��Json��ʽ������ǩ��ǰ�����ʹ��CDATA��ǩ��JSON�ı�������������
	private String attach; // �� String(127) ���ڷֵ� �������ݣ��ڲ�ѯAPI��֧��֪ͨ��ԭ�����أ�����Ϊ�Զ������ʹ�á�
	private String out_trade_no; // �� String(32) 20150806125346 �̻�ϵͳ�ڲ������ţ�Ҫ��32���ַ��ڡ�����ͬһ���̻�����Ψһ�� ����̻�������
	private String fee_type = "CNY"; // �� String(16) CNY ����ISO 4217��׼����λ��ĸ���룬Ĭ������ң�CNY����ϸ�б���μ���������
	private Integer total_fee; // �� Int 88 �����ܽ���λΪ�֣����֧�����
	private String spbill_create_ip; // �� String(16) 123.12.12.123 APP����ҳ֧���ύ�û���ip��Native֧�������΢��֧��API�Ļ���IP��
	private String time_start; // �� String(14) 20091225091010 ��������ʱ�䣬��ʽΪyyyyMMddHHmmss����2009��12��25��9��10��10���ʾΪ20091225091010���������ʱ�����
	private String time_expire; // �� String(14) 20091227091010  ����ʧЧʱ�䣬��ʽΪyyyyMMddHHmmss����2009��12��27��9��10��10���ʾΪ20091227091010���������ʱ����� ע�⣺���ʧЧʱ�����������5����
	private String goods_tag; // �� String(32) WXG
	private String notify_url; // �� String(256) http://www.weixin.qq.com/wxpay/pay.php �첽����΢��֧�����֪ͨ�Ļص���ַ��֪ͨurl����Ϊ�����ɷ��ʵ�url������Я��������
	private String trade_type; // �� String(16) JSAPI ȡֵ���£�JSAPI��NATIVE��APP�ȣ�˵����������涨
	private String product_id; // �� String(32) 12235413214070356458058 trade_type=NATIVEʱ����ɨ��֧�������˲����ش����˲���Ϊ��ά���а�������ƷID���̻����ж��塣
	private String limit_pay; // �� String(32) no_credit �ϴ��˲���no_credit--�������û�����ʹ�����ÿ�֧��
	private String openid; // �� String(128) oUpF8uMuAJO_M2pxb1Q9zNjWeS6o trade_type=JSAPIʱ�������ں�֧�������˲����ش����˲���Ϊ΢���û����̻���Ӧappid�µ�Ψһ��ʶ��openid��λ�ȡ���ɲο�����ȡopenid������ҵ����ʹ�á���ҵ��OAuth2.0�ӿڡ���ȡ��ҵ���ڳ�Աuserid���ٵ��á���ҵ��useridתopenid�ӿڡ�����ת�� 
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#getAppid()
	 */
	@Override
	public String getAppid() {
		return appid;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#setAppid(java.lang.String)
	 */
	@Override
	public void setAppid(String appid) {
		this.appid = appid;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#getMch_id()
	 */
	@Override
	public String getMch_id() {
		return mch_id;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#setMch_id(java.lang.String)
	 */
	@Override
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#getDevice_info()
	 */
	@Override
	public String getDevice_info() {
		return device_info;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#setDevice_info(java.lang.String)
	 */
	@Override
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#getNonce_str()
	 */
	@Override
	public String getNonce_str() {
		return nonce_str;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#setNonce_str(java.lang.String)
	 */
	@Override
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#getSign()
	 */
	@Override
	public String getSign() {
		return sign;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#setSign(java.lang.String)
	 */
	@Override
	public void setSign(String sign) {
		this.sign = sign;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#getSign_type()
	 */
	@Override
	public String getSign_type() {
		return sign_type;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#setSign_type(java.lang.String)
	 */
	@Override
	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#getBody()
	 */
	@Override
	public String getBody() {
		return body;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#setBody(java.lang.String)
	 */
	@Override
	public void setBody(String body) {
		this.body = body;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#getDetail()
	 */
	@Override
	public String getDetail() {
		return detail;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#setDetail(java.lang.String)
	 */
	@Override
	public void setDetail(String detail) {
		this.detail = detail;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#getAttach()
	 */
	@Override
	public String getAttach() {
		return attach;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#setAttach(java.lang.String)
	 */
	@Override
	public void setAttach(String attach) {
		this.attach = attach;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#getOut_trade_no()
	 */
	@Override
	public String getOut_trade_no() {
		return out_trade_no;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#setOut_trade_no(java.lang.String)
	 */
	@Override
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#getFee_type()
	 */
	@Override
	public String getFee_type() {
		return fee_type;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#setFee_type(java.lang.String)
	 */
	@Override
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#getTotal_fee()
	 */
	@Override
	public Integer getTotal_fee() {
		return total_fee;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#setTotal_fee(java.lang.Integer)
	 */
	@Override
	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#getSpbill_create_ip()
	 */
	@Override
	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#setSpbill_create_ip(java.lang.String)
	 */
	@Override
	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#getTime_start()
	 */
	@Override
	public String getTime_start() {
		return time_start;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#setTime_start(java.lang.String)
	 */
	@Override
	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#getTime_expire()
	 */
	@Override
	public String getTime_expire() {
		return time_expire;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#setTime_expire(java.lang.String)
	 */
	@Override
	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#getGoods_tag()
	 */
	@Override
	public String getGoods_tag() {
		return goods_tag;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#setGoods_tag(java.lang.String)
	 */
	@Override
	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#getNotify_url()
	 */
	@Override
	public String getNotify_url() {
		return notify_url;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#setNotify_url(java.lang.String)
	 */
	@Override
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#getTrade_type()
	 */
	@Override
	public String getTrade_type() {
		return trade_type;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#setTrade_type(java.lang.String)
	 */
	@Override
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#getProduct_id()
	 */
	@Override
	public String getProduct_id() {
		return product_id;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#setProduct_id(java.lang.String)
	 */
	@Override
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#getLimit_pay()
	 */
	@Override
	public String getLimit_pay() {
		return limit_pay;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#setLimit_pay(java.lang.String)
	 */
	@Override
	public void setLimit_pay(String limit_pay) {
		this.limit_pay = limit_pay;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#getOpenid()
	 */
	@Override
	public String getOpenid() {
		return openid;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderRequest#setOpenid(java.lang.String)
	 */
	@Override
	public void setOpenid(String openid) {
		this.openid = openid;
	}

}
