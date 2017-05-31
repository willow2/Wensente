package com.chuizi.wensente.api;

/**
 * 错误编号
 * @author jiaolj
 *
 */
public final class ErrorCode {

	/**
	 * JSONObject异常
	 */
	public final static String ERROR_PARSE_JSON = "抱歉，加载失败，我们仍需努力。";

	public static final String ERROR_EXCEPTION = "抱歉，加载失败，我们仍需努力。";

	/**
	 * JSONException
	 */
	public static final String ERROR_CLIENT_DEAL_JSONDATA = "抱歉，加载失败，我们仍需努力";

	/**
	 /**
	 * IOException
	 */
	public final static String ERROR_IOEXCEPTION = "IO异常，请稍候再试";

	/**
	 * Timeout
	 */
	public final static String ERROR_TIMEOUT = "连接超时，请检查网络稍候再试";

	/**
	 * 网络请求失败
	 */
	public final static String ERROR_CONN_SERVER = "暂无数据，请检查网络或稍候再试";

	/**
	 * 首次加载失败，再次尝试
	 */
	public static final String ERROR_FIRST_FAIL = "数据加载中，请稍候...";

	/**
	 * 网络连接错误
	 */
	public static final String ERROR_CLIENT_NETWORK = "网络异常，请检查您的网络！";

	/**
	 * UnsupportedEncodingException
	 */
	public static final String ERROR_CLIENT_DATA_ENCODING = "抱歉，加载失败，我们仍需努力";

	public static final String ERROR_CLIENT_REQUEST_SERVER = "抱歉，加载失败，我们仍需努力";

	/**
	 * 服务器连接失败
	 */
	public static final String ERROR_SERVER_CONNECT_FAIL = "抱歉，加载失败，我们仍需努力";

}
