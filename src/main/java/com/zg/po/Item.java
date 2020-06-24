package com.zg.po;

import java.util.Date;

public class Item {
    private Integer itemId;

    private String userName;

    private String itemName;

    private Float itemPrice;

    private String itemPic;

    private Date itemCreateTime;

    private Date itemBuyTime;

    private Integer itemState;

    private String itemSchool;

    private String itemDetail;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public Float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemPic() {
        return itemPic;
    }

    public void setItemPic(String itemPic) {
        this.itemPic = itemPic == null ? null : itemPic.trim();
    }

    public Date getItemCreateTime() {
        return itemCreateTime;
    }

    public void setItemCreateTime(Date itemCreateTime) {
        this.itemCreateTime = itemCreateTime;
    }

    public Date getItemBuyTime() {
        return itemBuyTime;
    }

    public void setItemBuyTime(Date itemBuyTime) {
        this.itemBuyTime = itemBuyTime;
    }

    public Integer getItemState() {
        return itemState;
    }

    public void setItemState(Integer itemState) {
        this.itemState = itemState;
    }

    public String getItemSchool() {
        return itemSchool;
    }

    public void setItemSchool(String itemSchool) {
        this.itemSchool = itemSchool == null ? null : itemSchool.trim();
    }

    public String getItemDetail() {
        return itemDetail;
    }

    public void setItemDetail(String itemDetail) {
        this.itemDetail = itemDetail == null ? null : itemDetail.trim();
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", userName='" + userName + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemPic='" + itemPic + '\'' +
                ", itemCreateTime=" + itemCreateTime +
                ", itemBuyTime=" + itemBuyTime +
                ", itemState=" + itemState +
                ", itemSchool='" + itemSchool + '\'' +
                ", itemDetail='" + itemDetail + '\'' +
                '}';
    }
}