package com.icoffee.weixin.pay.service;

@Deprecated
public class UnifiedOrderResponse implements IUnifiedOrderResponse {
	private String return_code; //  �� String(16) SUCCESS  SUCCESS/FAIL ���ֶ���ͨ�ű�ʶ���ǽ��ױ�ʶ�������Ƿ�ɹ���Ҫ�鿴result_code���ж�
	private String return_msg; //  �� String(128) ǩ��ʧ�� ������Ϣ����ǿգ�Ϊ����ԭ�� 
	
	private String appid; // �� String(32) wx8888888888888888 ���ýӿ��ύ�Ĺ����˺�ID
	private String mch_id; // �� String(32) 1900000109 ���ýӿ��ύ���̻���
	private String device_info; // �� String(32) 013467007045764 �Զ������������Ϊ����֧�����ն��豸�ŵ�
	private String nonce_str; // �� String(32) 5K8264ILTKCH16CQ2502SI8ZNMTM67VS ΢�ŷ��ص�����ַ���
	private String sign; // �� String(32) C380BEC2BFD727A4B6845133519F3AD6 ΢�ŷ��ص�ǩ��ֵ�����ǩ���㷨
	private String result_code; // �� String(16) SUCCESS SUCCESS/FAIL
	private String err_code; // �� String(32) SYSTEMERROR ��ϸ�μ����Ĵ����б�
	private String err_code_des; // �� String(128) ϵͳ���� ������Ϣ����
	
	private String trade_type; // �� String(16) JSAPI �������ͣ�ȡֵΪ��JSAPI��NATIVE��APP�ȣ�˵����������涨
	private String prepay_id; // �� String(64) wx201410272009395522657a690389285100 ΢�����ɵ�Ԥ֧���ػ���ʶ�����ں����ӿڵ�����ʹ�ã���ֵ��Ч��Ϊ2Сʱ
	private String code_url; // �� String(64) URl��weixin��//wxpay/s/An4baqw trade_typeΪNATIVEʱ�з��أ��������ɶ�ά�룬չʾ���û�����ɨ��֧�� 
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderResponse#getReturn_code()
	 */
	@Override
	public String getReturn_code() {
		return return_code;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderResponse#setReturn_code(java.lang.String)
	 */
	@Override
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderResponse#getReturn_msg()
	 */
	@Override
	public String getReturn_msg() {
		return return_msg;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderResponse#setReturn_msg(java.lang.String)
	 */
	@Override
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderResponse#getAppid()
	 */
	@Override
	public String getAppid() {
		return appid;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderResponse#setAppid(java.lang.String)
	 */
	@Override
	public void setAppid(String appid) {
		this.appid = appid;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderResponse#getMch_id()
	 */
	@Override
	public String getMch_id() {
		return mch_id;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderResponse#setMch_id(java.lang.String)
	 */
	@Override
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderResponse#getDevice_info()
	 */
	@Override
	public String getDevice_info() {
		return device_info;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderResponse#setDevice_info(java.lang.String)
	 */
	@Override
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderResponse#getNonce_str()
	 */
	@Override
	public String getNonce_str() {
		return nonce_str;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderResponse#setNonce_str(java.lang.String)
	 */
	@Override
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderResponse#getSign()
	 */
	@Override
	public String getSign() {
		return sign;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderResponse#setSign(java.lang.String)
	 */
	@Override
	public void setSign(String sign) {
		this.sign = sign;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderResponse#getResult_code()
	 */
	@Override
	public String getResult_code() {
		return result_code;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderResponse#setResult_code(java.lang.String)
	 */
	@Override
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderResponse#getErr_code()
	 */
	@Override
	public String getErr_code() {
		return err_code;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderResponse#setErr_code(java.lang.String)
	 */
	@Override
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderResponse#getErr_code_des()
	 */
	@Override
	public String getErr_code_des() {
		return err_code_des;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderResponse#setErr_code_des(java.lang.String)
	 */
	@Override
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderResponse#getTrade_type()
	 */
	@Override
	public String getTrade_type() {
		return trade_type;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderResponse#setTrade_type(java.lang.String)
	 */
	@Override
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderResponse#getPrepay_id()
	 */
	@Override
	public String getPrepay_id() {
		return prepay_id;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderResponse#setPrepay_id(java.lang.String)
	 */
	@Override
	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderResponse#getCode_url()
	 */
	@Override
	public String getCode_url() {
		return code_url;
	}
	/* (non-Javadoc)
	 * @see com.icoffee.weixin.pay.service.IUnifiedOrderResponse#setCode_url(java.lang.String)
	 */
	@Override
	public void setCode_url(String code_url) {
		this.code_url = code_url;
	}
}
