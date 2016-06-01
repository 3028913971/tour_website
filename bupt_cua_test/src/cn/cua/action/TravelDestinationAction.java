package cn.cua.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.cua.domain.AdminInfo;
import cn.cua.domain.TravelDestinationInfo;
import cn.cua.service.AdminException;
import cn.cua.service.TravelDestinationException;
import cn.cua.service.TravelDestinationService;
import cn.itcast.utils.CommonUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;



public class TravelDestinationAction extends ActionSupport implements ModelDriven<TravelDestinationInfo> {

	private TravelDestinationService travelDestinationService= new TravelDestinationService();
	private TravelDestinationInfo model = new TravelDestinationInfo();
	private List<String> themeList = new ArrayList<String>();
	
	
	
	public List<String> getThemeList() {
		return themeList;
	}

	public void setThemeList(List<String> themeList) {
		this.themeList = themeList;
	}

	private int pageNum;
	private int totalpage;
	private int pageSize;
	
	private String qcityName;
	private String qprovince;
	private String qarea;
	private String qtopSeason;
	private String qthemeType;
	private String qhomeOrAbroad;
	private String qisHomeTopSeason;
	private String qisHomeThemeType;
	private String qisTopSeason;
	private String qisThemeType;
	private String qisPublic;
	
	public String getQcityName() {
		return qcityName;
	}
	public void setQcityName(String qcityName) {
		this.qcityName = qcityName;
	}
	
	public String getQisPublic() {
		return qisPublic;
	}
	public void setQisPublic(String qisPublic) {
		this.qisPublic = qisPublic;
	}
	
	public String getQprovince() {
		return qprovince;
	}
	public void setQprovince(String qprovince) {
		this.qprovince = qprovince;
	}
	
	public String getQarea() {
		return qarea;
	}
	public void setQarea(String qarea) {
		this.qarea = qarea;
	}
	
	public String getQthemeType() {
		return qthemeType;
	}
	public void setQthemeType(String qthemeType) {
		this.qthemeType = qthemeType;
	}
	
	public String getQtopSeason() {
		return qtopSeason;
	}
	public void setQtopSeason(String qtopSeason) {
		this.qtopSeason = qtopSeason;
	}
	
	public String getQhomeOrAbroad() {
		return qhomeOrAbroad;
	}
	public void setQhomeOrAbroad(String qhomeOrAbroad) {
		this.qhomeOrAbroad = qhomeOrAbroad;
	}
	
	public String getQisHomeTopSeason() {
		return qisHomeTopSeason;
	}
	public void setQisHomeTopSeason(String qisHomeTopSeason) {
		this.qisHomeTopSeason = qisHomeTopSeason;
	}
	
	public String getQisHomeThemeType() {
		return qisHomeThemeType;
	}
	public void setQisHomeThemeType(String qisHomeThemeType) {
		this.qisHomeThemeType = qisHomeThemeType;
	}
	
	public String getQisThemeType() {
		return qisThemeType;
	}
	public void setQisThemeType(String qisThemeType) {
		this.qisThemeType = qisThemeType;
	}
	
	public String getQisTopSeason() {
		return qisTopSeason;
	}
	public void setQisTopSeason(String qisTopSeason) {
		this.qisTopSeason = qisTopSeason;
	}
	
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 查询所有的分页操作
	 * @return
	 */
	public String page(){
		pageSize = 30;
		int userAmount = travelDestinationService.getDestinationAmount();
		if(userAmount==0){
			themeList = travelDestinationService.getThemeList();
			return "pageFailed";
		}
		this.totalpage = userAmount%pageSize==0?(userAmount/pageSize):(userAmount/pageSize+1);
		if(pageNum<=0){
			this.pageNum=1;
		}
		if(pageNum>totalpage){
			this.pageNum=totalpage;
		}
		return "page";
	}
	
	/**
	 * 查询所有旅游地
	 * @return
	 */
	public String findAll(){
		themeList = travelDestinationService.getThemeList();
		ActionContext.getContext().getValueStack().push(travelDestinationService.findAll(pageNum, pageSize));
		return "list";
	}

	/**
	 * 增加旅游地信息
	 * @return
	 */
	private String descriptionPhotoFileName;
	private File descriptionPhoto;
	
	private String trafficFileName;
	private File traffic;
	
	private String spotFileName;
	private File spot;
	
	private String shoppingFileName;
	private File shopping;
	
	private String foodFileName;
	private File food;
	
	public void setDescriptionPhotoFileName(String descriptionPhotoFileName) {
		this.descriptionPhotoFileName = descriptionPhotoFileName;
	}

	public void setDescriptionPhoto(File descriptionPhoto) {
		this.descriptionPhoto = descriptionPhoto;
	}

	public void setTrafficFileName(String trafficFileName) {
		this.trafficFileName = trafficFileName;
	}

	public void setTraffic(File traffic) {
		this.traffic = traffic;
	}

	public void setSpotFileName(String spotFileName) {
		this.spotFileName = spotFileName;
	}

	public void setSpot(File spot) {
		this.spot = spot;
	}
	
	public void setShoppingFileName(String shoppingFileName) {
		this.shoppingFileName = shoppingFileName;
	}

	public void setShopping(File shopping) {
		this.shopping = shopping;
	}

	public void setFoodFileName(String foodFileName) {
		this.foodFileName = foodFileName;
	}

	public void setFood(File food) {
		this.food = food;
	}

	public String add() throws IOException{
		/*
		 * 1.添加上传文件的一对三
		 * 2.判读是否上传了5个图片文件
		 */
		//如果上传了旅游地封面图片文件
		if(descriptionPhoto != null){
			String[] t = this.descriptionPhotoFileName.split("\\.");
			model.setCityPhotoFileName(this.descriptionPhotoFileName);
			model.setCityPhotoRealName(CommonUtils.uuid() + "." + this.descriptionPhotoFileName.split("\\.")[1]);
			
			String savepath = ServletActionContext.getServletContext().getRealPath("/tdDescriptionPhotos");
			File destFile = new File(savepath,model.getCityPhotoRealName());
			FileUtils.copyFile(descriptionPhoto, destFile);
		}
		//如果上传了交通图片文件
		if(traffic != null){
			model.setTrafficPhotoFileName(this.trafficFileName);
			model.setTrafficPhotoRealName(CommonUtils.uuid() + "." +this.trafficFileName.split("\\.")[1]);
			
			String savepath = ServletActionContext.getServletContext().getRealPath("/tdTrafficPhotos");
			File destFile = new File(savepath,model.getTrafficPhotoRealName());
			FileUtils.copyFile(traffic, destFile);
		}
		//如果上传了景点图片文件
		if(spot != null){
			model.setSpotPhotoFileName(this.spotFileName);
			model.setSpotPhotoRealName(CommonUtils.uuid() + "." +this.spotFileName.split("\\.")[1]);
			
			String savepath = ServletActionContext.getServletContext().getRealPath("/tdSpotPhotos");
			File destFile = new File(savepath,model.getSpotPhotoRealName());
			FileUtils.copyFile(spot, destFile);
		}
		
		//如果上传了购物图片文件
		if(shopping != null){
			model.setShoppingPhotoFileName(this.shoppingFileName);
			model.setShoppingPhotoRealName(CommonUtils.uuid() + "." +this.shoppingFileName.split("\\.")[1]);
			
			String savepath = ServletActionContext.getServletContext().getRealPath("/tdShoppingPhotos");
			File destFile = new File(savepath,model.getShoppingPhotoRealName());
			FileUtils.copyFile(shopping, destFile);
		}
		//如果上传了美食图片文件
		if(food != null){
			model.setFoodPhotoFileName(this.foodFileName);
			model.setFoodPhotoRealName(CommonUtils.uuid() + "." +this.foodFileName.split("\\.")[1]);
			
			String savepath = ServletActionContext.getServletContext().getRealPath("/tdFoodPhotos");
			File destFile = new File(savepath,model.getFoodPhotoRealName());
			FileUtils.copyFile(food, destFile);
			
		}		
		
		try {
			model.setTdOrder(travelDestinationService.findAll().size()+1);
			travelDestinationService.add(model);
			return "pageSucc";
		} catch (TravelDestinationException e) {
			this.addActionError(e.getMessage());
			return "add";
		}		
	}	
	
	/**
	 * 修改信息之前的加载操作
	 * 将封装的model的信息添加到新页面的valueStack中去
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String loadForEdit() throws UnsupportedEncodingException{
		themeList = travelDestinationService.getThemeList();
		model.setCityName(new String(model.getCityName().getBytes("ISO-8859-1"),"UTF-8"));
		ActionContext.getContext().getValueStack().push(travelDestinationService.load(model.getCityName()));
		return "edit";
	}
	
	
	/**
	 * 修改操作，需要设置默认的页面隐藏域
	 * @return
	 * @throws IOException 
	 */
	public String edit() throws IOException{
		
		if(descriptionPhoto != null){
			//删除老封面图片		
			String savepath = ServletActionContext.getServletContext().getRealPath("/tdDescriptionPhotos");
			File deleteFile = new File(savepath,model.getCityPhotoRealName());
			deleteFile.delete();
			//修改model的值
			model.setCityPhotoFileName(this.descriptionPhotoFileName);
			model.setCityPhotoRealName(CommonUtils.uuid() + this.descriptionPhotoFileName);
			
			File destFile = new File(savepath,model.getCityPhotoRealName());
			FileUtils.copyFile(descriptionPhoto, destFile);
		}
		
		if(traffic != null){
			//删除交通图片		
			String savepath = ServletActionContext.getServletContext().getRealPath("/tdTrafficPhotos");
			File deleteFile = new File(savepath,model.getTrafficPhotoRealName());
			deleteFile.delete();
			//修改model的值
			model.setTrafficPhotoFileName(this.trafficFileName);
			model.setTrafficPhotoRealName(CommonUtils.uuid() + this.trafficFileName);
			
			File destFile = new File(savepath,model.getTrafficPhotoRealName());
			FileUtils.copyFile(traffic, destFile);
		}
		
		if(spot != null){
			//删除景点图片
			String savepath = ServletActionContext.getServletContext().getRealPath("/tdSpotPhotos");
			File deleteFile = new File(savepath,model.getSpotPhotoRealName());
			deleteFile.delete();
			//修改model的值
			model.setSpotPhotoFileName(this.spotFileName);
			model.setSpotPhotoRealName(CommonUtils.uuid() + this.spotFileName);
			
			File destFile = new File(savepath,model.getSpotPhotoRealName());
			FileUtils.copyFile(spot, destFile);
		}
		
		if(shopping != null){
			//删除购物图片
			String savepath = ServletActionContext.getServletContext().getRealPath("/tdShoppingPhotos");
			File deleteFile = new File(savepath,model.getShoppingPhotoRealName());
			deleteFile.delete();
			//修改model的值
			model.setShoppingPhotoFileName(this.shoppingFileName);
			model.setShoppingPhotoRealName(CommonUtils.uuid() + this.shoppingFileName);
			
			File destFile = new File(savepath,model.getShoppingPhotoRealName());
			FileUtils.copyFile(shopping, destFile);
			
		}
		
		if(food != null){
			//删除食物图片
			String savepath = ServletActionContext.getServletContext().getRealPath("/tdFoodPhotos");
			File deleteFile = new File(savepath,model.getFoodPhotoRealName());
			deleteFile.delete();
			//修改model的值
			model.setFoodPhotoFileName(this.foodFileName);
			model.setFoodPhotoRealName(CommonUtils.uuid() + this.foodFileName);
			
			File destFile = new File(savepath,model.getFoodPhotoRealName());
			FileUtils.copyFile(food, destFile);
					
		}
		
		try {		
			travelDestinationService.edit(model);
			return "pageSucc";
		} catch (TravelDestinationException e) {
			this.addActionError(e.getMessage());
			return "edit";
		}
		
	}
	
	/**
	 * 查看旅游地信息
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String load() throws UnsupportedEncodingException{
		model.setCityName(new String(model.getCityName().getBytes("ISO-8859-1"),"UTF-8"));
		ActionContext.getContext().getValueStack().push(travelDestinationService.load(model.getCityName()));
		return "view";
	}
	
	/**
	 * 删除操作
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws TravelDestinationException 
	 */
	public String delete() throws UnsupportedEncodingException, TravelDestinationException{
		model.setCityName(new String(model.getCityName().getBytes("ISO-8859-1"),"UTF-8"));
		model.setCityPhotoRealName(new String(model.getCityPhotoRealName().getBytes("ISO-8859-1"),"UTF-8"));
		model.setTrafficPhotoRealName(new String(model.getTrafficPhotoRealName().getBytes("ISO-8859-1"),"UTF-8"));
		model.setSpotPhotoRealName(new String(model.getShoppingPhotoRealName().getBytes("ISO-8859-1"),"UTF-8"));
		model.setFoodPhotoRealName(new String(model.getFoodPhotoRealName().getBytes("ISO-8859-1"),"UTF-8"));
		
		String savepath = ServletActionContext.getServletContext().getRealPath("/tdDescriptionPhotos");
		new File(savepath,model.getCityPhotoRealName()).delete(); 
		
		savepath =  ServletActionContext.getServletContext().getRealPath("/tdTrafficPhotos");
		new File(savepath,model.getTrafficPhotoRealName()).delete();
		
		savepath = ServletActionContext.getServletContext().getRealPath("/tdSpotPhotos");
		new File(savepath,model.getSpotPhotoRealName());
		
		savepath = ServletActionContext.getServletContext().getRealPath("/tdShoppingPhotos");
		new File(savepath,model.getShoppingPhotoRealName());
		
		savepath = ServletActionContext.getServletContext().getRealPath("/tdFoodPhotos");
		new File(savepath,model.getFoodPhotoRealName());
		
		List<TravelDestinationInfo> tdInfos = travelDestinationService.findAll();
		int pos = locateElem(tdInfos, model.getCityName());
		for(int i=tdInfos.size()-1;i>pos;i--){
			TravelDestinationInfo tdInfo = tdInfos.get(i);
			tdInfo.setTdOrder(tdInfo.getTdOrder()-1);
			travelDestinationService.edit(tdInfo);
		}
		travelDestinationService.delete(model.getCityName());
		return "pageSucc";
	}
	
	/**
	 * 条件查询分页操作
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String pageQuery() throws UnsupportedEncodingException{
		pageSize = 30;
		int tdAmount = travelDestinationService.getQueryAmount(model);
		model.setCityName(qcityName);
		model.setIsPublic(qisPublic);
		model.setProvince(qprovince);
		model.setArea(qarea);
		model.setTopSeason(qtopSeason);
		model.setThemeType(qthemeType);
		model.setHomeOrAbroad(qhomeOrAbroad);
		model.setIsTopSeason(qisTopSeason);
		model.setIsHomeThemeType(qisHomeThemeType);
		model.setIsThemeType(qisThemeType);
		model.setIsHomeTopSeason(qisHomeTopSeason);
		this.totalpage = tdAmount%pageSize==0?(tdAmount/pageSize):(tdAmount/pageSize+1);
		if(pageNum<=0){
			this.pageNum=1;
		}
		if(pageNum>totalpage){
			this.pageNum=totalpage;
		}
		return "pageQuery";
	}
	

	/**
	 * 条件查询分页操作
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String pageQuery1() throws UnsupportedEncodingException{
		pageSize = 30;
		qcityName = new String(this.qcityName.getBytes("ISO-8859-1"),"UTF-8");
		qisPublic = new String(this.qisPublic.getBytes("ISO-8859-1"),"UTF-8");
		qprovince = new String(this.qprovince.getBytes("ISO-8859-1"),"UTF-8");
		qarea = new String(this.qarea.getBytes("ISO-8859-1"),"UTF-8");
		qtopSeason = new String(this.qtopSeason.getBytes("ISO-8859-1"),"UTF-8");
		qthemeType = new String(this.qthemeType.getBytes("ISO-8859-1"),"UTF-8");
		qhomeOrAbroad = new String(this.qhomeOrAbroad.getBytes("ISO-8859-1"),"UTF-8");
		qisTopSeason = new String(this.qisTopSeason.getBytes("ISO-8859-1"),"UTF-8");
		qisHomeThemeType = new String(this.qisHomeThemeType.getBytes("ISO-8859-1"),"UTF-8");
		qisThemeType = new String(this.qisThemeType.getBytes("ISO-8859-1"),"UTF-8");
		qisHomeTopSeason = new String(this.qisHomeTopSeason.getBytes("ISO-8859-1"),"UTF-8");
		model.setCityName(qcityName);
		model.setIsPublic(qisPublic);
		model.setProvince(qprovince);
		model.setArea(qarea);
		model.setTopSeason(qtopSeason);
		model.setThemeType(qthemeType);
		model.setHomeOrAbroad(qhomeOrAbroad);
		model.setIsTopSeason(qisTopSeason);
		model.setIsHomeThemeType(qisHomeThemeType);
		model.setIsThemeType(qisThemeType);
		model.setIsHomeTopSeason(qisHomeTopSeason);
		int tdAmount = travelDestinationService.getQueryAmount(model);
		this.totalpage = tdAmount%pageSize==0?(tdAmount/pageSize):(tdAmount/pageSize+1);
		if(pageNum<=0){
			this.pageNum=1;
		}
		if(pageNum>totalpage){
			this.pageNum=totalpage;
		}
		return "pageQuery";
	}
	
	/**
	 * 条件查询
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String query() throws UnsupportedEncodingException{
		qcityName = new String(this.qcityName.getBytes("ISO-8859-1"),"UTF-8");
		qisPublic = new String(this.qisPublic.getBytes("ISO-8859-1"),"UTF-8");
		qprovince = new String(this.qprovince.getBytes("ISO-8859-1"),"UTF-8");
		qarea = new String(this.qarea.getBytes("ISO-8859-1"),"UTF-8");
		qtopSeason = new String(this.qtopSeason.getBytes("ISO-8859-1"),"UTF-8");
		qthemeType = new String(this.qthemeType.getBytes("ISO-8859-1"),"UTF-8");
		qhomeOrAbroad = new String(this.qhomeOrAbroad.getBytes("ISO-8859-1"),"UTF-8");
		qisTopSeason = new String(this.qisTopSeason.getBytes("ISO-8859-1"),"UTF-8");
		qisHomeThemeType = new String(this.qisHomeThemeType.getBytes("ISO-8859-1"),"UTF-8");
		qisThemeType = new String(this.qisThemeType.getBytes("ISO-8859-1"),"UTF-8");
		qisHomeTopSeason = new String(this.qisHomeTopSeason.getBytes("ISO-8859-1"),"UTF-8");
		model.setCityName(qcityName);
		model.setIsPublic(qisPublic);
		model.setProvince(qprovince);
		model.setArea(qarea);
		model.setTopSeason(qtopSeason);
		model.setThemeType(qthemeType);
		model.setHomeOrAbroad(qhomeOrAbroad);
		model.setIsTopSeason(qisTopSeason);
		model.setIsHomeThemeType(qisHomeThemeType);
		model.setIsThemeType(qisThemeType);
		model.setIsHomeTopSeason(qisHomeTopSeason);
		themeList = travelDestinationService.getThemeList();
		ActionContext.getContext().getValueStack().push(travelDestinationService.query(model, pageNum, pageSize));
		return "listQuery";
	}
	
	public TravelDestinationInfo getModel() {
		return model;
	}
	
	public String loadForAdd(){
		themeList = travelDestinationService.getThemeList();
		return "loadForAddSucc";
	}
	/**
	 * 不分页修改顺序
	 * @return
	 * @throws Exception
	 */
	public String findAllForEditOrder() throws Exception {
		List<TravelDestinationInfo> tdInfos = travelDestinationService.findAll();
		ActionContext.getContext().getValueStack().push(tdInfos);
		Integer size = tdInfos.size();
		if(size==0){
			return "listForEditOrderFailed";
		}
		return "listForEditOrder";
	}
	/**
	 * 将特定的问题信息顺序前移一位 ——顺序数减1
	 * @return
	 * @throws Exception
	 */
	@InputConfig(resultName="forwardOrderInput")
	public String forwardOrder() throws Exception{
		List<TravelDestinationInfo> tdInfos = travelDestinationService.findAll();
		int pos = locateElem(tdInfos,new String(model.getCityName().getBytes("ISO-8859-1"),"UTF-8"));//定位当前目的地顺序
		
		
		//将当前问题顺序减1
		TravelDestinationInfo tdInfo = travelDestinationService.load(new String(model.getCityName().getBytes("ISO-8859-1"),"UTF-8"));
		tdInfo.setTdOrder(model.getTdOrder()-1);
		travelDestinationService.edit(tdInfo);
		
		//将前一个问题顺序改为当前顺序
		String cityName = tdInfos.get(pos-1).getCityName();
		TravelDestinationInfo tdInfo2 = travelDestinationService.load(cityName);
		tdInfo2.setTdOrder(model.getTdOrder());
		travelDestinationService.edit(tdInfo2);
		
		return "editOrderComplete";
	}
	
	
	public void validateForwardOrder(){
		if(model.getTdOrder()<=1){
			this.addActionError("已经是最上一个！！");
		}
	}
	
	/**
	 * 将特定的问题信息顺序后移一位
	 * @return
	 * @throws Exception
	 */
	@InputConfig(resultName="backwardOrderInput")
	public String backwardOrder() throws Exception {
		List<TravelDestinationInfo> tdInfos = travelDestinationService.findAll();
		int pos = locateElem(tdInfos,new String(model.getCityName().getBytes("ISO-8859-1"),"UTF-8"));
		
		//将当前问题顺序加1
		TravelDestinationInfo tdInfo = travelDestinationService.load(new String(model.getCityName().getBytes("ISO-8859-1"),"UTF-8"));
		tdInfo.setTdOrder(model.getTdOrder()+1);
		travelDestinationService.edit(tdInfo);
		
		//将前一个问题顺序改为当前顺序
		String cityName = tdInfos.get(pos+1).getCityName();
		TravelDestinationInfo tdInfo2 = travelDestinationService.load(cityName);
		tdInfo2.setTdOrder(model.getTdOrder());
		travelDestinationService.edit(tdInfo2);
		
		return "editOrderComplete";
	}
	
	public void validateBackwardOrder(){
		List<TravelDestinationInfo> tdInfos = travelDestinationService.findAll();
		Integer size=tdInfos.size();
		if(model.getTdOrder()>=size.intValue()){
			this.addActionError("已经是最后一个！！");
		}
	}
	
	/**
	 * 根据Id确认在列表中的位置
	 * @param tdInfos
	 * @param tdId
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public int locateElem(List<TravelDestinationInfo> tdInfos, String cityName) throws UnsupportedEncodingException{
		for(int i=0;i<tdInfos.size();i++){
			if(cityName.equals(tdInfos.get(i).getCityName())){
				return i;
			}
		}
		return 0;
	}
}
