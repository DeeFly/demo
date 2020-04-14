package com.gaofei.Date;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;


/**
 * HashMap中用来存放X年X月信息：
 *  * 对内目标GMV
 *  * 对外目标GMV
 *  * 供应链预估GMV
 *  * 商家提报GMV
 *  * 商品提报GMV
 * @author qingming.gqm
 * @date 2020/3/26
 */
public class IndustryRowOverviewDO extends HashMap<String, Object> implements Serializable {
    private static final long serialVersionUID = -6285653607504153954L;

    private Long industryId;
    /**
     * 行业名称
     */
    private String industryName;

    private Long industry2Id;

    private String industry2Name;

    private Long cate1Id;

    private String cate1Name;
    /**
     *
     * 行业业务整体活动目标(对内GMV)
     */
    private Double innerSalesGoalGmv;
    /**
     * 【商家需确认】活动总目标GMV
     */
    private Double confirmTargetGmv;

    /**
     * submitTargetGmv
     * 【商家表提报】
     * 活动总目标GMV
     */
    private Double submitTargetGmv;

    /**
     * 【商品表提报】
     * 活动总目标GMV
     */
    private Double submitItemTargetGmv;

    /**
     * 商品历史参考
     */
    private Double histReferenceItem;

    /**
     * 活动gmv目标（对内）/参考期gmv
     */
    private String indSalesGoalY2Y;

    /**
     * 在线商家数
     * 注意：这个是全行业的在线商家数，不是盘货覆盖商家数
     */
    private Integer onlineSellerNum;

    /**
     * 目标盘货商家数
     */
    private Integer phTargetSellerNum;


    /**
     * 目标商家未盘货
     */
    private Integer phTargetUnsubmitSellerNum;

    /**
     * 盘货商家未确认
     */
    private Integer phSellerUnconfirmNum;


    /**
     * 盘货商家已确认
     */
    private Integer phSellerConfirmNum;

    /**
     * 商家表提报GMV
     */
    private Double phSellerEstPayOrd;

    /**
     * 商家提报GMV/对内目标GMV
     */
    private String phSellerPayOrdRatio;

    /**
     * 盘货商家参考期成交
     */
    private Double phSellerHistPayOrd;

    /**
     * 盘货商家参考期
     * 成交占类目比
     * （查所选tmc活动的历史gmv，所占类目比指的是：如果你这一行是一级类目，那就用【当前一级类目/当前类目所属的上一级】
     */
    private String phSellerHistPayOrdRatio;

    /**
     * 【供应链预估】
     * 活动总GMV
     */
    private Double promotionSalesGmv;

    /**
     * 在线商品数
     * 行业下所有
     */
    private Integer onlineItemNum;

    /**
     * 盘货商品数
     */
    private Integer phItemNum;

    /**
     * 【商品表提报】
     * 活动总目标GMV
     */
    private Double phItemPayOrd;

    /**
     * 盘货商品GMV/对内GMV
     */
    private String phItemPayOrdRatio;

    /**
     * 盘货商品参考期
     * 成交
     */
    private Double phItemHistPayOrd;

    /**
     * 盘货商品参考期
     * 成交占类目比
     * （所看类目/上一级）
     */
    private String phItemHistPayOrdRatio;

    /**
     * 站内总计
     */
    private Double innerTradeExpense;

    /**
     * 直通车
     */
    private Double  directTrainExpense;

    /**
     * 钻展
     */
    private Double diamondShowExpense;

    /**
     * 淘宝客
     */
    private Double  taobaokeExpense;

    /**
     * 站外总计
     */
    private Double outerTradeExpense;

    //----------------------------- 供应链数据开始 ------------------------------------------
    /**
     * 盘货保税商品
     * 预估成交占比
     * 供应链
     */
    private String bondedEstGmvRatio;

    /**
     * 供应链
     * 盘货GFC商品
     * 预估成交占比
     */
    private String gfcGmvRatio;

    /**
     * 供应链
     * 盘货集货商品
     * 预估成交占比
     */
    private String jhEstGmvRatio;

    /**
     * 菜鸟仓保税
     * 件单价
     */
    private Double bondedQtyOrderPrice;

    /**
     * 菜鸟仓GFC件单价
     */
    private Double gfcBuyOrderPrice;

    /**
     * 菜鸟仓集货
     * 件单价
     */
    private Double submitGroupedCargoBuyOrderJianPrice;

    /**
     * 菜鸟仓保税
     * 笔单价
     */
    private Double bondedBuyOrderPrice;

    /**
     * 菜鸟仓GFC笔单价
     */
    private Double gfcBuyOrderPriceAscp;

    /**
     * 菜鸟仓集货
     * 笔单价
     */
    private Double groupedCargoBuyOrderPrice;

    /**
     * 件数售罄率 KPI
     */
    private Double soldOutRatioExternal;

    /**
     * 预估活动
     * 期初库存
     */
    private Double promotionForecastSales;

    /**
     * 大促销售件数
     */
    private Double promotionSales;

    /**
     * 在途库存
     */
    private Double onwayStock;

    /**
     * 在库库存
     */
    private Double inwarehouseStock;

    /**
     * 当前
     * 可补货量
     */
    private Double nowCanCpfrQty;

    /**
     * 赠品预估
     * 数量
     */
    private Double estimatePeriodStartStock;

    /**
     * 已提交待审核补货件数
     */
    private Double submittedUnconfirmedCpfrQty;

    /**
     * 超额件数
     */
    private Double overfulfilQty;

    //-------------------------------------- 供应链数据结束   --------------------------------

    //-------------------------------------- 商家填报数据开始   --------------------------------

    /**
     * 【商家表提报】菜鸟仓保税模式GMV占比
     */
    private String submitBondedGmvRatio;

    /**
     * 【商家表提报】菜鸟仓GFC模式GMV占比
     */
    private String submitGfcGmvRatio;

    /**
     * 【商家表提报】菜鸟仓集货模式GMV占比
     */
    private String submitGroupedCargoGmvRatio;

    /**
     * 【商家需确认】菜鸟仓集货模式GMV占比
     */
    private String groupedCargoGmvRatio;

    /**
     * 【商家表提报】菜鸟仓保税件单价
     */
    private Double submitBondedQtyOrderPrice;

    /**
     * 【商家表提报】菜鸟仓GFC件单价
     */
    private Double submitGfcQtyOrderPrice;
    /**
     * 【商家需确认】菜鸟仓GFC件单价
     */
    private Double gfcQtyOrderPrice;

    /**
     * 【商家表提报】菜鸟仓保税笔单价
     */
    private Double submitBondedBuyOrderPrice;

    /**
     * 【商家表提报】菜鸟仓GFC笔单价
     */
    private Double submitGfcBuyOrderPrice;

    /**
     * 【商家表提报】菜鸟仓集货笔单价
     */
    private Double submitGroupedCargoBuyOrderPrice;

    /**
     * 【商家表提报】菜鸟仓件数售罄率
     */
    private Double submitSoldOutRatio;

    /**
     * 赠品数量
     */
    private Double sellerGiftQty;

    /**
     * 展开
     */
    private List<IndustryRowOverviewDO> children;

    public List<IndustryRowOverviewDO> getChildren() {
        return children;
    }

    public void setChildren(List<IndustryRowOverviewDO> children) {
        this.children = children;
    }

    public String getGroupedCargoGmvRatio() {
        return groupedCargoGmvRatio;
    }

    public void setGroupedCargoGmvRatio(String groupedCargoGmvRatio) {
        this.groupedCargoGmvRatio = groupedCargoGmvRatio;
    }

    public Double getGfcQtyOrderPrice() {
        return gfcQtyOrderPrice;
    }

    public void setGfcQtyOrderPrice(Double gfcQtyOrderPrice) {
        this.gfcQtyOrderPrice = gfcQtyOrderPrice;
    }

    public Double getInnerSalesGoalGmv() {
        return innerSalesGoalGmv;
    }

    public void setInnerSalesGoalGmv(Double innerSalesGoalGmv) {
        this.innerSalesGoalGmv = innerSalesGoalGmv;
    }

    public Double getConfirmTargetGmv() {
        return confirmTargetGmv;
    }

    public void setConfirmTargetGmv(Double confirmTargetGmv) {
        this.confirmTargetGmv = confirmTargetGmv;
    }

    public String getIndSalesGoalY2Y() {
        return indSalesGoalY2Y;
    }

    public void setIndSalesGoalY2Y(String indSalesGoalY2Y) {
        this.indSalesGoalY2Y = indSalesGoalY2Y;
    }

    public Integer getOnlineSellerNum() {
        return onlineSellerNum;
    }

    public void setOnlineSellerNum(Integer onlineSellerNum) {
        this.onlineSellerNum = onlineSellerNum;
    }

    public Integer getPhTargetSellerNum() {
        return phTargetSellerNum;
    }

    public void setPhTargetSellerNum(Integer phTargetSellerNum) {
        this.phTargetSellerNum = phTargetSellerNum;
    }

    public Integer getPhTargetUnsubmitSellerNum() {
        return phTargetUnsubmitSellerNum;
    }

    public void setPhTargetUnsubmitSellerNum(Integer phTargetUnsubmitSellerNum) {
        this.phTargetUnsubmitSellerNum = phTargetUnsubmitSellerNum;
    }

    public Integer getPhSellerUnconfirmNum() {
        return phSellerUnconfirmNum;
    }

    public void setPhSellerUnconfirmNum(Integer phSellerUnconfirmNum) {
        this.phSellerUnconfirmNum = phSellerUnconfirmNum;
    }

    public Integer getPhSellerConfirmNum() {
        return phSellerConfirmNum;
    }

    public void setPhSellerConfirmNum(Integer phSellerConfirmNum) {
        this.phSellerConfirmNum = phSellerConfirmNum;
    }

    public Double getPhSellerEstPayOrd() {
        return phSellerEstPayOrd;
    }

    public void setPhSellerEstPayOrd(Double phSellerEstPayOrd) {
        this.phSellerEstPayOrd = phSellerEstPayOrd;
    }

    public String getPhSellerPayOrdRatio() {
        return phSellerPayOrdRatio;
    }

    public void setPhSellerPayOrdRatio(String phSellerPayOrdRatio) {
        this.phSellerPayOrdRatio = phSellerPayOrdRatio;
    }

    public Double getPhSellerHistPayOrd() {
        return phSellerHistPayOrd;
    }

    public void setPhSellerHistPayOrd(Double phSellerHistPayOrd) {
        this.phSellerHistPayOrd = phSellerHistPayOrd;
    }

    public String getPhSellerHistPayOrdRatio() {
        return phSellerHistPayOrdRatio;
    }

    public void setPhSellerHistPayOrdRatio(String phSellerHistPayOrdRatio) {
        this.phSellerHistPayOrdRatio = phSellerHistPayOrdRatio;
    }

    public Double getPromotionSalesGmv() {
        return promotionSalesGmv;
    }

    public void setPromotionSalesGmv(Double promotionSalesGmv) {
        this.promotionSalesGmv = promotionSalesGmv;
    }

    public Integer getOnlineItemNum() {
        return onlineItemNum;
    }

    public void setOnlineItemNum(Integer onlineItemNum) {
        this.onlineItemNum = onlineItemNum;
    }

    public Integer getPhItemNum() {
        return phItemNum;
    }

    public void setPhItemNum(Integer phItemNum) {
        this.phItemNum = phItemNum;
    }

    public Double getPhItemPayOrd() {
        return phItemPayOrd;
    }

    public void setPhItemPayOrd(Double phItemPayOrd) {
        this.phItemPayOrd = phItemPayOrd;
    }

    public String getPhItemPayOrdRatio() {
        return phItemPayOrdRatio;
    }

    public void setPhItemPayOrdRatio(String phItemPayOrdRatio) {
        this.phItemPayOrdRatio = phItemPayOrdRatio;
    }

    public Double getPhItemHistPayOrd() {
        return phItemHistPayOrd;
    }

    public void setPhItemHistPayOrd(Double phItemHistPayOrd) {
        this.phItemHistPayOrd = phItemHistPayOrd;
    }

    public Double getInnerTradeExpense() {
        return innerTradeExpense;
    }

    public void setInnerTradeExpense(Double innerTradeExpense) {
        this.innerTradeExpense = innerTradeExpense;
    }

    public Double getDirectTrainExpense() {
        return directTrainExpense;
    }

    public void setDirectTrainExpense(Double directTrainExpense) {
        this.directTrainExpense = directTrainExpense;
    }

    public Double getDiamondShowExpense() {
        return diamondShowExpense;
    }

    public void setDiamondShowExpense(Double diamondShowExpense) {
        this.diamondShowExpense = diamondShowExpense;
    }

    public Double getTaobaokeExpense() {
        return taobaokeExpense;
    }

    public void setTaobaokeExpense(Double taobaokeExpense) {
        this.taobaokeExpense = taobaokeExpense;
    }

    public Double getOuterTradeExpense() {
        return outerTradeExpense;
    }

    public void setOuterTradeExpense(Double outerTradeExpense) {
        this.outerTradeExpense = outerTradeExpense;
    }

    public String getBondedEstGmvRatio() {
        return bondedEstGmvRatio;
    }

    public void setBondedEstGmvRatio(String bondedEstGmvRatio) {
        this.bondedEstGmvRatio = bondedEstGmvRatio;
    }

    public Double getSubmitTargetGmv() {
        return submitTargetGmv;
    }

    public void setSubmitTargetGmv(Double submitTargetGmv) {
        this.submitTargetGmv = submitTargetGmv;
    }

    public Double getSubmitItemTargetGmv() {
        return submitItemTargetGmv;
    }

    public void setSubmitItemTargetGmv(Double submitItemTargetGmv) {
        this.submitItemTargetGmv = submitItemTargetGmv;
    }

    public Double getHistReferenceItem() {
        return histReferenceItem;
    }

    public void setHistReferenceItem(Double histReferenceItem) {
        this.histReferenceItem = histReferenceItem;
    }

    public String getPhItemHistPayOrdRatio() {
        return phItemHistPayOrdRatio;
    }

    public void setPhItemHistPayOrdRatio(String phItemHistPayOrdRatio) {
        this.phItemHistPayOrdRatio = phItemHistPayOrdRatio;
    }

    public String getGfcGmvRatio() {
        return gfcGmvRatio;
    }

    public void setGfcGmvRatio(String gfcGmvRatio) {
        this.gfcGmvRatio = gfcGmvRatio;
    }

    public String getJhEstGmvRatio() {
        return jhEstGmvRatio;
    }

    public void setJhEstGmvRatio(String jhEstGmvRatio) {
        this.jhEstGmvRatio = jhEstGmvRatio;
    }

    public Double getBondedQtyOrderPrice() {
        return bondedQtyOrderPrice;
    }

    public void setBondedQtyOrderPrice(Double bondedQtyOrderPrice) {
        this.bondedQtyOrderPrice = bondedQtyOrderPrice;
    }

    public Double getGfcBuyOrderPrice() {
        return gfcBuyOrderPrice;
    }

    public void setGfcBuyOrderPrice(Double gfcBuyOrderPrice) {
        this.gfcBuyOrderPrice = gfcBuyOrderPrice;
    }

    public Double getSubmitGroupedCargoBuyOrderJianPrice() {
        return submitGroupedCargoBuyOrderJianPrice;
    }

    public void setSubmitGroupedCargoBuyOrderJianPrice(Double submitGroupedCargoBuyOrderJianPrice) {
        this.submitGroupedCargoBuyOrderJianPrice = submitGroupedCargoBuyOrderJianPrice;
    }

    public Double getBondedBuyOrderPrice() {
        return bondedBuyOrderPrice;
    }

    public void setBondedBuyOrderPrice(Double bondedBuyOrderPrice) {
        this.bondedBuyOrderPrice = bondedBuyOrderPrice;
        System.out.println(getBondedBuyOrderPrice());
    }

    public Double getGfcBuyOrderPriceAscp() {
        return gfcBuyOrderPriceAscp;
    }

    public void setGfcBuyOrderPriceAscp(Double gfcBuyOrderPriceAscp) {
        this.gfcBuyOrderPriceAscp = gfcBuyOrderPriceAscp;
    }

    public Double getGroupedCargoBuyOrderPrice() {
        return groupedCargoBuyOrderPrice;
    }

    public void setGroupedCargoBuyOrderPrice(Double groupedCargoBuyOrderPrice) {
        this.groupedCargoBuyOrderPrice = groupedCargoBuyOrderPrice;
    }

    public Double getSoldOutRatioExternal() {
        return soldOutRatioExternal;
    }

    public void setSoldOutRatioExternal(Double soldOutRatioExternal) {
        this.soldOutRatioExternal = soldOutRatioExternal;
    }

    public Double getPromotionForecastSales() {
        return promotionForecastSales;
    }

    public void setPromotionForecastSales(Double promotionForecastSales) {
        this.promotionForecastSales = promotionForecastSales;
    }

    public Double getPromotionSales() {
        return promotionSales;
    }

    public void setPromotionSales(Double promotionSales) {
        this.promotionSales = promotionSales;
    }

    public Double getOnwayStock() {
        return onwayStock;
    }

    public void setOnwayStock(Double onwayStock) {
        this.onwayStock = onwayStock;
    }

    public Double getInwarehouseStock() {
        return inwarehouseStock;
    }

    public void setInwarehouseStock(Double inwarehouseStock) {
        this.inwarehouseStock = inwarehouseStock;
    }

    public Double getNowCanCpfrQty() {
        return nowCanCpfrQty;
    }

    public void setNowCanCpfrQty(Double nowCanCpfrQty) {
        this.nowCanCpfrQty = nowCanCpfrQty;
    }

    public Double getEstimatePeriodStartStock() {
        return estimatePeriodStartStock;
    }

    public void setEstimatePeriodStartStock(Double estimatePeriodStartStock) {
        this.estimatePeriodStartStock = estimatePeriodStartStock;
    }

    public Double getSubmittedUnconfirmedCpfrQty() {
        return submittedUnconfirmedCpfrQty;
    }

    public void setSubmittedUnconfirmedCpfrQty(Double submittedUnconfirmedCpfrQty) {
        this.submittedUnconfirmedCpfrQty = submittedUnconfirmedCpfrQty;
    }

    public Double getOverfulfilQty() {
        return overfulfilQty;
    }

    public void setOverfulfilQty(Double overfulfilQty) {
        this.overfulfilQty = overfulfilQty;
    }

    public String getSubmitBondedGmvRatio() {
        return submitBondedGmvRatio;
    }

    public void setSubmitBondedGmvRatio(String submitBondedGmvRatio) {
        this.submitBondedGmvRatio = submitBondedGmvRatio;
    }

    public String getSubmitGfcGmvRatio() {
        return submitGfcGmvRatio;
    }

    public void setSubmitGfcGmvRatio(String submitGfcGmvRatio) {
        this.submitGfcGmvRatio = submitGfcGmvRatio;
    }

    public String getSubmitGroupedCargoGmvRatio() {
        return submitGroupedCargoGmvRatio;
    }

    public void setSubmitGroupedCargoGmvRatio(String submitGroupedCargoGmvRatio) {
        this.submitGroupedCargoGmvRatio = submitGroupedCargoGmvRatio;
    }

    public Double getSubmitBondedQtyOrderPrice() {
        return submitBondedQtyOrderPrice;
    }

    public void setSubmitBondedQtyOrderPrice(Double submitBondedQtyOrderPrice) {
        this.submitBondedQtyOrderPrice = submitBondedQtyOrderPrice;
    }

    public Double getSubmitGfcQtyOrderPrice() {
        return submitGfcQtyOrderPrice;
    }

    public void setSubmitGfcQtyOrderPrice(Double submitGfcQtyOrderPrice) {
        this.submitGfcQtyOrderPrice = submitGfcQtyOrderPrice;
    }

    public Double getSubmitBondedBuyOrderPrice() {
        return submitBondedBuyOrderPrice;
    }

    public void setSubmitBondedBuyOrderPrice(Double submitBondedBuyOrderPrice) {
        this.submitBondedBuyOrderPrice = submitBondedBuyOrderPrice;
    }

    public Double getSubmitGfcBuyOrderPrice() {
        return submitGfcBuyOrderPrice;
    }

    public void setSubmitGfcBuyOrderPrice(Double submitGfcBuyOrderPrice) {
        this.submitGfcBuyOrderPrice = submitGfcBuyOrderPrice;
    }

    public Double getSubmitGroupedCargoBuyOrderPrice() {
        return submitGroupedCargoBuyOrderPrice;
    }

    public void setSubmitGroupedCargoBuyOrderPrice(Double submitGroupedCargoBuyOrderPrice) {
        this.submitGroupedCargoBuyOrderPrice = submitGroupedCargoBuyOrderPrice;
    }

    public Double getSubmitSoldOutRatio() {
        return submitSoldOutRatio;
    }

    public void setSubmitSoldOutRatio(Double submitSoldOutRatio) {
        this.submitSoldOutRatio = submitSoldOutRatio;
    }

    public Double getSellerGiftQty() {
        return sellerGiftQty;
    }

    public void setSellerGiftQty(Double sellerGiftQty) {
        this.sellerGiftQty = sellerGiftQty;
    }

    public Long getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Long industryId) {
        this.industryId = industryId;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public Long getIndustry2Id() {
        return industry2Id;
    }

    public void setIndustry2Id(Long industry2Id) {
        this.industry2Id = industry2Id;
    }

    public String getIndustry2Name() {
        return industry2Name;
    }

    public void setIndustry2Name(String industry2Name) {
        this.industry2Name = industry2Name;
    }

    public Long getCate1Id() {
        return cate1Id;
    }

    public void setCate1Id(Long cate1Id) {
        this.cate1Id = cate1Id;
    }

    public String getCate1Name() {
        return cate1Name;
    }

    public void setCate1Name(String cate1Name) {
        this.cate1Name = cate1Name;
    }
}
