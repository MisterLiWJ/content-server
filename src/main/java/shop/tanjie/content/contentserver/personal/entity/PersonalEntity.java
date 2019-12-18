package shop.tanjie.content.contentserver.personal.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liwj
 * @date 2019/12/16 0016 16:28
 * @description
 */
public class PersonalEntity {

    private String userid;//用户主键
    private String name; // 名称
    private String head; // 头像


    private String red_sum="0";//阅读量
    private int volids=0;//最近来访量
    private int fan=0;//粉丝数量
    private int focusNumber=0;//关注数量

    private int read_newly=0;//阅读量变化量数
    private int volids_newly=0;//最近来访变化量数
    private int fans_newly=0;//关注变化量数
    private int focus_newly=0;//粉丝变化量数

    private String gradeImg="";//图标图片       -----

    /**
     * 我的
     */
    private Integer newPersonal=0;//我的小红点   -----

    /**
     * 主页
     */
    private Integer mouthHong=0;//主页小红点
    private String ranking_text="";//提示文字


    /**
     * 宝箱
     */
    private int pointDot=0;//红点:1显示,0不显示
    private String pointText="";//宝箱提示文字


    /**
     * 收藏
     */
    private String collText="";//提示文字
    private int collRed=0;//红点,0不展示,1展示


    /**
     * 分享探街
     */
    private Integer newFriends=0;//新的好友小红点,1 - 有 0 - 没有
    private String invitation="";//提示文字


    /**
     * 客服,
     */
    private String customer="有效建议50";//客户提示文字


    private String showCrownUrl="https://www.tanjie.wang/#/native/crown?userid=''";//皇冠认证 会员级别：0-普通用户 1-普通会员 2-超级会员
    private String showCrownText="身份认证";//皇冠认证文字


    /**
     * 钱包滚动集合,
     */
    private List<String> moneyTextList=new ArrayList<>();//滚动提示文字
    private String moneyText;//钱包提示文字
    private int moneySpot=0;//余额小红点

    private int is_card=0;//0未认证,1认证中,2认证成功,3认证失败

    private int shareStyle=1;//显示影藏:1分享,2地图

    private int pullFriends=0;//我的资料名片红点,1显示,0不显示

    private int judge=0;//头像小红点,1展示,0不展示


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getRed_sum() {
        return red_sum;
    }

    public void setRed_sum(String red_sum) {
        this.red_sum = red_sum;
    }

    public int getVolids() {
        return volids;
    }

    public void setVolids(int volids) {
        this.volids = volids;
    }

    public int getFan() {
        return fan;
    }

    public void setFan(int fan) {
        this.fan = fan;
    }

    public int getFocusNumber() {
        return focusNumber;
    }

    public void setFocusNumber(int focusNumber) {
        this.focusNumber = focusNumber;
    }

    public int getRead_newly() {
        return read_newly;
    }

    public void setRead_newly(int read_newly) {
        this.read_newly = read_newly;
    }

    public int getVolids_newly() {
        return volids_newly;
    }

    public void setVolids_newly(int volids_newly) {
        this.volids_newly = volids_newly;
    }

    public int getFans_newly() {
        return fans_newly;
    }

    public void setFans_newly(int fans_newly) {
        this.fans_newly = fans_newly;
    }

    public int getFocus_newly() {
        return focus_newly;
    }

    public void setFocus_newly(int focus_newly) {
        this.focus_newly = focus_newly;
    }

    public String getGradeImg() {
        return gradeImg;
    }

    public void setGradeImg(String gradeImg) {
        this.gradeImg = gradeImg;
    }

    public Integer getNewPersonal() {
        return newPersonal;
    }

    public void setNewPersonal(Integer newPersonal) {
        this.newPersonal = newPersonal;
    }

    public Integer getMouthHong() {
        return mouthHong;
    }

    public void setMouthHong(Integer mouthHong) {
        this.mouthHong = mouthHong;
    }

    public String getRanking_text() {
        return ranking_text;
    }

    public void setRanking_text(String ranking_text) {
        this.ranking_text = ranking_text;
    }

    public int getPointDot() {
        return pointDot;
    }

    public void setPointDot(int pointDot) {
        this.pointDot = pointDot;
    }

    public String getPointText() {
        return pointText;
    }

    public void setPointText(String pointText) {
        this.pointText = pointText;
    }

    public String getCollText() {
        return collText;
    }

    public void setCollText(String collText) {
        this.collText = collText;
    }

    public int getCollRed() {
        return collRed;
    }

    public void setCollRed(int collRed) {
        this.collRed = collRed;
    }

    public Integer getNewFriends() {
        return newFriends;
    }

    public void setNewFriends(Integer newFriends) {
        this.newFriends = newFriends;
    }

    public String getInvitation() {
        return invitation;
    }

    public void setInvitation(String invitation) {
        this.invitation = invitation;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getShowCrownUrl() {
        return showCrownUrl;
    }

    public void setShowCrownUrl(String showCrownUrl) {
        this.showCrownUrl = showCrownUrl;
    }

    public String getShowCrownText() {
        return showCrownText;
    }

    public void setShowCrownText(String showCrownText) {
        this.showCrownText = showCrownText;
    }

    public List<String> getMoneyTextList() {
        return moneyTextList;
    }

    public void setMoneyTextList(List<String> moneyTextList) {
        this.moneyTextList = moneyTextList;
    }

    public String getMoneyText() {
        return moneyText;
    }

    public void setMoneyText(String moneyText) {
        this.moneyText = moneyText;
    }

    public int getMoneySpot() {
        return moneySpot;
    }

    public void setMoneySpot(int moneySpot) {
        this.moneySpot = moneySpot;
    }

    public int getIs_card() {
        return is_card;
    }

    public void setIs_card(int is_card) {
        this.is_card = is_card;
    }

    public int getShareStyle() {
        return shareStyle;
    }

    public void setShareStyle(int shareStyle) {
        this.shareStyle = shareStyle;
    }

    public int getPullFriends() {
        return pullFriends;
    }

    public void setPullFriends(int pullFriends) {
        this.pullFriends = pullFriends;
    }

    public int getJudge() {
        return judge;
    }

    public void setJudge(int judge) {
        this.judge = judge;
    }
}
