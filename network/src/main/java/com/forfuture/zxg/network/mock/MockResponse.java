package com.forfuture.zxg.network.mock;

import java.util.ArrayList;
import java.util.HashMap;

public class MockResponse {

    static HashMap<String, String> responseMap = new HashMap<>();

    static {
        responseMap.put("api_api_api", "value_value.json");
    }

    /**
     * 默认只要在json目录下添加json文件都会被mock
     * 文件名命名与接口映射:
     * /gtw/v1/pay/v1/makePay映射的文件名为gtw_v1_pay_v1_makePay.json
     * path中带有可变参数的接口,例如"/message/wechat/{driverId}"
     * 添加到list,specialList.add("message/wechat");
     *
     * @return
     */
    static ArrayList<String> getSpecialList() {
        ArrayList<String> specialList = new ArrayList<>();

        specialList.add("pay/v1/queryInvoiceHis");
        specialList.add("pay/v1/queryInvoiceDetail");
        specialList.add("message/wechat");
//        specialList.add("address/insert");
//        specialList.add("passenger/v1/order/detail");
//        specialList.add("pay/v1/queryOrdersForInvoice");
//        specialList.add("order/list/1");
//        specialList.add("order/detail/1");
//        specialList.add("order/detail/3");
//        specialList.add("order/detail/4");
//        specialList.add("order/detail/6");
//        specialList.add("passenger/v2/order/statement");
        return specialList;
    }

    /**
     * 忽略某个接口的mock
     * ignoreList.add("message/wechat/{driverId}")
     * 则/message/wechat/{driverId}则不会被mock
     * 第一个/不要加
     * 第一个/不要加
     * 第一个/不要加
     *
     * @return
     */
    static ArrayList<String> getIgnoreList() {
        ArrayList<String> ignoreList = new ArrayList<>();
        ignoreList.add("pay/v1/queryPassengerDetails");//我的余额，收支详情
        ignoreList.add("pay/v1/queryExchanges");//礼品卡兑换明细
        ignoreList.add("pay/v1/queryCoupons");//我的优惠券列表，所有的
        ignoreList.add("pay/v1/queryCard");//查询礼品卡
        ignoreList.add("pay/v1/queryPassengerBindCards");//银行卡列表
        ignoreList.add("passenger/v2/auth/inviteBonus");//邀请有奖分享参数
        ignoreList.add("pay/v1/makePayRequest");
        ignoreList.add("pay/v1/confirmPayRequest");
        ignoreList.add("pay/v1/passengerUnbindCard");
        ignoreList.add("pay/v1/queryOrdersForInvoice");
        ignoreList.add("pay/v1/applyInvoice");
        ignoreList.add("pay/v1/queryInvoiceHis");
        ignoreList.add("pay/v1/queryInvoiceDetail");
        ignoreList.add("pay/v1/makePayRequest");//发起支付请求
        ignoreList.add("pay/v1/confirmPayRequest");//确认支付
        ignoreList.add("order/list/1");//我的行程
        ignoreList.add("order/detail/1");
        ignoreList.add("order/detail/3");
        ignoreList.add("order/detail/4");
        ignoreList.add("order/detail/6");
        ignoreList.add("passenger/v2/order/statement");//订单结算详情
        return ignoreList;
    }
}
