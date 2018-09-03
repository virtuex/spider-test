package org.virtue.pojo;

public class Product {
    private String productNo;//产品 编号
    private String productName;//产品名称
    private String productType = "集合信托";//产品类型
    private String manager;//管理人
    private String recordDate;//备案日期
    private String endDate;//到期日
    private String toIndustry;//投向行业
    private String wealthOpTyle;//财产运用方式
    private String trustFunction;//信托功能

    @Override
    public String toString() {
        return "Product{" +
                "productNo='" + productNo + '\'' +
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", manager='" + manager + '\'' +
                ", recordDate='" + recordDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", toIndustry='" + toIndustry + '\'' +
                ", wealthOpTyle='" + wealthOpTyle + '\'' +
                ", trustFunction='" + trustFunction + '\'' +
                '}';
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getToIndustry() {
        return toIndustry;
    }

    public void setToIndustry(String toIndustry) {
        this.toIndustry = toIndustry;
    }

    public String getWealthOpTyle() {
        return wealthOpTyle;
    }

    public void setWealthOpTyle(String wealthOpTyle) {
        this.wealthOpTyle = wealthOpTyle;
    }

    public String getTrustFunction() {
        return trustFunction;
    }

    public void setTrustFunction(String trustFunction) {
        this.trustFunction = trustFunction;
    }
}
