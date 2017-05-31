package com.chuizi.wensente.api;

/**
 * 消息ID 用于handler发送消息
 *
 * @author miaoxl
 */
public final class HandlerCode {

    /**
     * 获取结果成功
     */
    public static final int SUCCESS = 10001;
    /**
     * 获取结果有警告
     */
    public static final int WARING = 10002;
    /**
     * 获取结果失败
     */
    public static final int FAIL = 10003;

    /**
     * 清除缓存
     */
    public static final int CLEAR_CACHE = 10004;
    public static final int CHANGE_USER_INFO = 10005;
    public static final int ADD_IMAGE = 11006;
    public static final int TO_DEL = 11007;
    public static final int CHOOSE = 8005;
    /**
     * 播放
     */
    public final static int PLAY_VIDEO = 8007;
    /**
     * 改变分类
     */
    public final static int CHANGE_ACTIVITY = 8008;
//刷新页面
    public static final int REFRESH = 10005;
    public static final int CHANGE = 10006;

    public final static int FINISH = 10007;
    //获取app参数接口
    public final static int APP_PARAM = 10008;
    //获取app参数接口
    public final static int COMMON_PARAM = 10009;
    //获取个人信息接口
    public final static int GET_USERINFO = 10010;

    //获取app用户信息接口
    public final static int GET_APPUSERINFO = 10011;
    //获取个人信息接口
    public final static int LOGIN = 1111;
    //获取验证码
    public final static int GET_SMS = 1112;
    //获取验证码
    public final static int RESTSTER = 1113;
    //忘记密码
    public final static int FORGET_PWD = 1114;
    //修改个人信息
    public final static int USER_UPDATE = 1115;
    //获取省市县
    public final static int GET_AREA = 1116;
    //修改手机号原手机
    public final static int UPDATE_PHONE_OLD = 1117;
    //修改手机号新手机
    public final static int UPDATE_PHONE_NEW = 1116;
    //绑定手机号
    public final static int BIND_PHONE = 1117;
//     28.发布/修改海报红包
    public static final int PUBLISH_POSTER =1118;
    // 29.发布/修改视频红包
    public static final int PUBLISH_VEDIO =1119;
    // 30.发布/修改卡券红包
    public static final int PUBLISH_CARD = 1120;
    // 39.余额支付接口
    public static final int PAY = 1121;
    // 上传文件成功
    public static final int UPLOAD_FILE_SUCCESS = 1122;
// 上传文件失败
    public static final int UPLOAD_FILE_FAIL = 1123;
// 选择城市
    public static final int CHOOSE_CITYS_REQUEST = 1124;
// 选择城市
    public static final int CHOOSE_CITYS_RESULT = 1125;
// 选择分类
    public static final int CHOOSE_CATEGORY_REQUEST = 1126;
// 选择分类
    public static final int CHOOSE_CATEGORY_RESULT = 1127;
// 微信回调
    public static final int WEIXN_PAY_BACK = 1128;


//    选择城市
    public static final int CHOOSE_ADDR_REQUEST = 1129;
    // 银行卡列表
    public static final int BANK_LIST = 1130;
    // 分类
    public static final int GET_CATEGORY_CITY = 1131;
    // 选择银行
    public static final int CHOOSE_BANK_REQUEST = 1132;
    // 选择银行
    public static final int CHOOSE_BANK_RESULT = 1133;
    // 提现接口
    public static final int WITH_DRAW = 1134;
    // 提现接口
    public static final int MONEY_DETAIL = 1135;
    //第三方登录
    public static final int LOGIN_UMENG=1136;
    //第三方登录
    public static final int PERSON_CENTER_NUMBER=1137;
    //51.用户购买的卡券列表
    public static final int BUY_CARD_LIST=1138;
    //51.兑换卡券
    public static final int CARD_DUIHUAN=1139;

    //绑定手机号
    public final static int BIND_PHONE_GO = 1140;
    //获取系统时间
    public final static int SYS_TIME = 1141;
    //视频压缩处理
    public final static int VEDIO_FFMPEG = 1142;
    //视频获取第一秒的图片
    public final static int VEDIO_FFMPEG_GET_IMAGE = 1143;
    //操作的handler
    public final static int OPERATE = 1144;
    //操作的handler
    public final static int ONLY_DISSMISS = 1145;
    //操作的handler
    public final static int DEL_MESS = 1146;


    //获取个人信息接口
    public final static int GET_OPEN_CITY_LIST = 2001;
    //获取首页轮播图
    public final static int HOME_LUNBO = 2002;
    //获取视频轮播图
    public final static int VIDEO_LUNBO = 2003;
    //获取卡券轮播图
    public final static int CARD_VOLUME_LUNBO = 2004;
    //获取首页分类
    public final static int HOME_CATEGORY = 2005;
    //获取视频分类
    public final static int VIDEO_CATEGORY = 2006;
    //获取卡券分类
    public final static int CARD_VOLUME_CATEGORY = 2007;
    //选取首页分类
    public final static int CHOOSE_CATEGORY = 2008;
    //选取海报列表
    public final static int GET_POSTER_LIST = 2009;
    //选取视频列表
    public final static int GET_VIDEO_LIST = 2010;
    //选取海报详情
    public final static int GET_POSTER_DETAILS = 2011;
    //是否收藏
    public final static int IS_COLLECT = 2012;
    //收藏操作
    public final static int USER_COLLECT = 2013;
    //选取卡券列表
    public final static int GET_CARDVOLUME_LIST = 2014;
    //选取卡券详情
    public final static int GET_CARDVOLUME_DETAILS = 2015;
    //选取视频详情
    public final static int GET_VIDEO_DETAILS = 2016;

    //关注操作
    public final static int USER_GUANZHU = 2017;
    //分享操作
    public final static int USER_FX = 2018;
    //我的关注列表
    public final static int GET_MY_ATTENTION_LIST = 2019;

    //是否关注
    public final static int IS_ATTENTION = 2020;
    //关注操作
    public final static int USER_ATTENTION = 2021;
    //我的收藏列表
    public final static int GET_MY_COLLECT_LIST = 2022;

    //所有勋章列表
    public final static int GET_ALL_MEDAL_LIST = 2023;
    //获取个人信息接口
    public final static int GET_INFO = 2024;
    //收藏数量统计
    public final static int GET_COLLECT_COUNT = 2025;


    public static final int REFRESH_COUNT = 2026;
    /**
     * s申请勋章
     */
    public static final int APPLY_MEDAL = 2027;
    /**
     * 消息列表
     */
    public static final int GET_MY_MSG_LIST = 2028;

    /**
     * 意见反馈
     */
    public static final int SAVE_FEEDBACK = 2029;

    /**
     * 修改密码
     */
    public static final int USER_ALTER_PWD = 2030;

    /**
     * 兑换卡券
     */
    public static final int EXCHANGE_CARD = 2032;

    /**
     * 抢红包统计
     */
    public static final int QIANG_PACKAGE_COUNT = 2033;


    /**
     * 抢红包列表
     */
    public static final int QIANG_PACKAGE_LIST = 2034;
    /**
     * 抢海报红包
     */
    public static final int GET_POSTER_PACKAGE = 2035;

    /**
     *兑换卡券列表
     */
    public static final int EXCHANGE_CARD_LIST = 2036;

    /**
     *兑换卡券列表
     */
    public static final int GET_VIDEO_PACKAGE = 2037;

    /**
     *消息置为已读
     */
    public static final int READ_MSG = 2038;
    /**
     *消息置为已读
     */
    public static final int SET_READ_MSG = 2039;

    /**
     *分享结果
     */
    public static final int FX_RESULT = 2040;

    /**
     *分享
     */
    public static final int USER_FX_SUCC = 2041;
    /**
     *删除系统消息
     */
    public static final int DEL_MSSAGE_ = 2042;


    /**
     * 获取城市
     */
    public static final int GET_CITY = 2031;

    /**
     *获取一级分类
     */
    public static final int GET_ALL_FIRST_CATRGORY = 3006;

    /**
     *获取二三级分类
     */
    public static final int GET_ALL_TWO_AND_THREE_CATRGORY = 3007;

    /**
     * 传递二三级数据
     */
    public static final int MSG_ALL_TWO_AND_THREE_CATRGORY = 3008;

    /**
     * 商品列表
     */
    public static final int GET_GOODS_LIST = 3009;

    /**
     * 提交审核资料
     */
    public static final int CHECK = 3010;

    /**
     * 发布优惠券
     */
    public static final int COUPON_UPDATE = 3011;

    /**
     * 发布商品
     */
    public static final int GOOD_UPDATE = 3012;

    /**
     * 商品详情
     */
    public static final int GET_GOODS_DETAILS = 3013;

    /**
     * 评价列表
     */
    public static final int GET_COMMENT_LIST = 3014;

    /**
     * 优惠券列表
     */
    public static final int GET_COUPON_LIST = 3015;

    /**
     * 获取下班时间
     */
    public static final int GET_WORK_TIME = 3016;

    /**
     * 设置上下班时间
     */
    public static final int UPDATE_WORK_TIME = 3017;

    /**
     * 订单列表
     */
    public static final int GET_ORDER_LIST = 3018;

    /**
     * 订单详情
     */
    public static final int GET_ORDER = 3019;

    /**
     * 我的推单列表
     */
    public static final int FREELIST = 3020;

    /**
     * 我的推单详情
     */
    public static final int FREEDETAILS = 3021;

    /**
     * 系统时间
     */
    public static final int GET_TIME = 3022;

    /**
     * 倒计时
     */
    public static final int COUNTDOWN = 3023;

    /**
     * 奖励排行列表
     */
    public static final int GET_AWARD_RANK_LIST = 3024;

    /**
     * 人物排行
     */
    public static final int GET_PERSOMAGE_RANK_LIST = 3025;

    /**
     * 订单操作
     */
    public static final int OPERATE_ORDER = 3033;

    /**
     * 订单操作
     */
    public static final int MSGOPERATE_ORDER = 3034;

    /**
     * 退款订单列表
     */
    public static final int RETURNLIST = 3035;

    /**
     * 商品退款原因
     */
    public static final int GOODSREASON = 3036;

    /**
     * 发单退款原因
     */
    public static final int ORDERREASON = 3037;

    /**
     * 取消订单按钮
     */
    public static final int CANCELORDER = 3038;

    /**
     * 取消订单接口
     */
    public static final int REMOVEORDER = 3039;

    /**
     * 是否同意退款
     */
    public static final int TECRETURN = 3040;

    /**
     * 技师投标接口
     */
    public static final int UPDATEBID = 3041;

    /**
     * 删除商品
     */
    public static final int DELETEGOOD = 3042;

    /**
     * 拨打电话
     */
    public static final int PHONE = 3043;

    /**
     * 系统下拉单列表接口
     */
    public static final int SYSTEMTYPE = 3044;
}
