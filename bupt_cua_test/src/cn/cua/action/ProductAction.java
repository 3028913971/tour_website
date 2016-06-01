package cn.cua.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.cua.domain.JourneyInfo;
import cn.cua.domain.ProductInfo;
import cn.cua.domain.QuestionInfo;
import cn.cua.service.JourneyService;
import cn.cua.service.ProductService;
import cn.itcast.utils.CommonUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

/**
 * ProductAction��
 * @author Sandm
 *
 */
public class ProductAction extends ActionSupport implements ModelDriven<ProductInfo>{
	
	private ProductInfo model = new ProductInfo();//�ֶ�ʵ����
	private ProductService productService = new ProductService();
	
	private String jourRealName;
	private Integer jourId;
	
	private int proDays;//��Ʒ����
	private String proName;//��Ʒ����
	private String proCityName;//��������
	private String proDescription;//��Ʒ����
	private String topOrNot;//�Ƿ�����
	private int proId;//��Ʒid
	
	private int totalPage;//��ҳ��
	private int pageNum;//��ǰҳ��
	private int pageSize;//ÿҳ��Ʒ��
	private int ps = 30;//����pageSize
	
	//��Ʒ�ļ�һ����
	private File file;
	private String fileFileName;
	private String fileContentType;
	
	private List<JourneyInfo> journeyInfo = new ArrayList<JourneyInfo>();
	private JourneyService journeyService = new JourneyService();
	
	//�г��ļ�һ����
	private List<File> jfile;
	private List<String> jfileFileName;
	private List<String> jfileContentType;
	
	public List<JourneyInfo> getJourneyInfo() {
		return journeyInfo;
	}
	
	public List<File> getJfile() {
		return jfile;
	}

	public List<String> getJfileFileName() {
		return jfileFileName;
	}

	public List<String> getJfileContentType() {
		return jfileContentType;
	}

	public void setJfile(List<File> jfile) {
		this.jfile = jfile;
	}

	public void setJfileFileName(List<String> jfileFileName) {
		this.jfileFileName = jfileFileName;
	}

	public void setJfileContentType(List<String> jfileContentType) {
		this.jfileContentType = jfileContentType;
	}

	public ProductInfo getModel() {
		return model;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public int getPageNum() {
		return pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	

	public File getFile() {
		return file;
	}


	public String getFileFileName() {
		return fileFileName;
	}


	public String getFileContentType() {
		return fileContentType;
	}


	public void setFile(File file) {
		this.file = file;
	}


	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}


	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	

	public int getProDays() {
		return proDays;
	}
	public String getProName() {
		return proName;
	}
	public void setProDays(int proDays) {
		this.proDays = proDays;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	
	public String getProDescription() {
		return proDescription;
	}
	public String getTopOrNot() {
		return topOrNot;
	}
	
	public void setProDescription(String proDescription) {
		this.proDescription = proDescription;
	}
	public void setTopOrNot(String topOrNot) {
		this.topOrNot = topOrNot;
	}
	
	public String getProCityName() {
		return proCityName;
	}

	public void setProCityName(String proCityName) {
		this.proCityName = proCityName;
	}

	public String getJourRealName() {
		return jourRealName;
	}
	public Integer getJourId() {
		return jourId;
	}
	public void setJourRealName(String jourRealName) {
		this.jourRealName = jourRealName;
	}

	public void setJourId(Integer jourId) {
		this.jourId = jourId;
	}
	
	/**
	 * ��ҳ����
	 * @return
	 * @throws Exception
	 */
	public String page() throws Exception {
		int productAmount = productService.getProductAmount();
		if(productAmount==0){
			return "pageFailed";
		}
		this.pageSize = this.ps;
		this.totalPage = (productAmount % pageSize==0)?(productAmount/pageSize):(productAmount/pageSize +1);
		if(this.pageNum <= 0){
			this.pageNum = 1;
		}
		if(this.pageNum > totalPage ){
			this.pageNum = totalPage;
		}
		return "page";
	}

	/**
	 * �Է�����Ӧ��ѯ��Ʒ����ķ�ҳ����
	 * @return
	 * @throws Exception
	 */
	public String queryPage() throws Exception {
		model.setProductName(proName);
		model.setProductDescription(proDescription);
		model.setCityName(proCityName);
		model.setIsTop(topOrNot);
		
		
		int productAmount = productService.getProductAmount(model);
		this.pageSize = this.ps;
		this.totalPage = (productAmount % pageSize==0)?(productAmount/pageSize):(productAmount/pageSize+1);
		if(this.pageNum <= 0){
			this.pageNum = 1;
		}
		if(this.pageNum > totalPage ){
			this.pageNum = totalPage;
		}
		return "queryPage";
	}
	
	/**
	 * �Է�����Ӧ��ѯ������Ʒ�ķ�ҳ����1
	 * @return
	 * @throws Exception
	 */
	public String queryPage1() throws Exception {
		proName = new String(proName.getBytes("ISO-8859-1"),"UTF-8");
		proDescription=new String(proDescription.getBytes("ISO-8859-1"),"UTF-8");
		proCityName = new String(proCityName.getBytes("ISO-8859-1"),"UTF-8");
		topOrNot = new String(topOrNot.getBytes("ISO-8859-1"),"UTF-8");
		model.setProductName(proName);
		model.setProductDescription(proDescription);
		model.setCityName(proCityName);
		model.setIsTop(topOrNot);
		
		int questionAmount = productService.getProductAmount(model);
		this.pageSize = this.ps;
		this.totalPage = (questionAmount % pageSize==0)?(questionAmount/pageSize):(questionAmount/pageSize+1);
		if(this.pageNum <= 0){
			this.pageNum = 1;
		}
		if(this.pageNum > totalPage ){
			this.pageNum = totalPage;
		}
		return "queryPage1";
	}
	
	/**
	 * ��ʾ���в�Ʒ
	 * 1.ͨ��ProductService��findAll��������List<Product>
	 * 2.���浽ValueStack��
	 * 3.��product_listҳ������<s:iterator>��ǩ��ʾ
	 * @return
	 * @throws Exception
	 */
	public String findAll() throws Exception {
		ActionContext.getContext().getValueStack().push(productService.findAll(pageNum,pageSize));
		return "list";
	}
	
	/**
	 * ��ʾ���з��ϲ�ѯ�����Ĳ�Ʒ
	 * 1.ͨ��ProductService��findAll��������List<Product>
	 * 2.���浽ValueStack��
	 * 3.��product_listҳ������<s:iterator>��ǩ��ʾ
	 * @return
	 * @throws Exception
	 */
	public String queryFindAll() throws Exception {
		model.setProductName(new String(proName.getBytes("ISO-8859-1"),"UTF-8"));
		model.setProductDescription(new String(proDescription.getBytes("ISO-8859-1"),"UTF-8"));
		model.setCityName(new String(proCityName.getBytes("ISO-8859-1"),"UTF-8"));
		model.setIsTop(new String(topOrNot.getBytes("ISO-8859-1"),"UTF-8"));
		proName = new String(proName.getBytes("ISO-8859-1"),"UTF-8");
		proDescription=new String(proDescription.getBytes("ISO-8859-1"),"UTF-8");
		proCityName = new String(proCityName.getBytes("ISO-8859-1"),"UTF-8");
		topOrNot = new String(topOrNot.getBytes("ISO-8859-1"),"UTF-8");
		
		ActionContext.getContext().getValueStack().push(productService.findAll(model,pageNum,pageSize));
		return "queryList";
	}
	
	/**
	 * ���Ӳ�Ʒ��Ϣ
	 * 1.�����Ʒ�ļ�
	 * 2.�����ݿ������Ӳ�Ʒ��Ϣ
	 * 3.����"addJourney"��ת��journey_add.jspҳ��
	 * @return
	 * @throws Exception
	 */
	@InputConfig(resultName="addInput")
	public String add() throws Exception {
		//����model�е���ֹʱ�����proDays
		/*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = format.parse(model.getEndDate());
		Date date2 = format.parse(model.getStartDate());
		int sec = (int)(date1.getTime() - date2.getTime());
		proDays = sec/1000/60/60/24 + 1;
		*/
		
		proName = model.getProductName();
		
		
		if(file!=null){
			model.setProductFileName(fileFileName);
			model.setProductRealName(CommonUtils.uuid() +"." + fileFileName.split("\\.")[1]);
		
			//�ϴ��ļ�
			String savePath = ServletActionContext.getServletContext().getRealPath("/productFiles");
			File destFile = new File(savePath,model.getProductRealName());
			FileUtils.copyFile(file, destFile);
		}
		
		productService.add(model);
		
		ServletActionContext.getRequest().getSession().setAttribute("proDays", proDays);
		return "addJourney";
	}
	
	/**
	 * ���Ӳ�Ʒ��У��
	 * @return
	 */
	public void validateAdd() throws Exception{
		proName = model.getProductName();
		
		if(!productService.isUnique(proName)){
			this.addActionError("��Ʒ����ռ�ã�");
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = format.parse(model.getEndDate());
		Date date2 = format.parse(model.getStartDate());
		//int sec = (int)(date1.getTime() - date2.getTime());
		
		if((date1.getTime() - date2.getTime()) < 0){
			this.addFieldError("endDate","��ʼ���ڲ������ڽ������ڣ�");
		}
		
	}
	
	/**
	 * �����г���Ϣ
	 * 1.�����г��ļ�
	 * 2.�����ݿ��������г���Ϣ
	 * 3.����"editSucc"�ض���product_page
	 * @return
	 * @throws Exception
	 */
	@InputConfig(resultName="addJourneyInput")
	public String addJourney() throws Exception{
		String savePath = ServletActionContext.getServletContext().getRealPath("/journeyFiles");
		File destFile;
		
		//proDays = (Integer)ServletActionContext.getRequest().getSession().getAttribute("proDays");
		
		
		for(int i = 0;i < proDays;i++){
			
			if(jfile.get(i)!=null){
				journeyInfo.get(i).setJourneyFileName(jfileFileName.get(i));
				journeyInfo.get(i).setJourneyRealName(CommonUtils.uuid() +"." +
						jfileFileName.get(i).split("\\.")[1]);
			
				//�ϴ��ļ�
				destFile = new File(savePath,journeyInfo.get(i).getJourneyRealName());
				FileUtils.copyFile(jfile.get(i), destFile);
			}
			
			journeyService.add(journeyInfo.get(i));
		}
		return "editSucc";
	}
	
	/**
	 * �����г̵�У��
	 * @return
	 */
	/*
	public void validateAddJourney(){
		proDays = (Integer)ServletActionContext.getRequest().getSession().getAttribute("proDays");
		
		if(jfile == null ||jfile.size() < proDays ){
			this.addFieldError("jfile", "ÿ���г̱����Ӧһ���ļ���");
		}
		
		for(int i = 0; i < proDays;i++){
			String journeyTitle = journeyInfo.get(i).getJourneyTitle();
			if(journeyTitle==null||journeyTitle.trim().isEmpty()){
				this.addFieldError("journeyTitle", "�г̱��ⲻ��Ϊ�գ�");
			}
			if(journeyTitle.length()>20){
				this.addFieldError("journeyTitle", "�г̱��ⳤ������1-20֮�䣡");
			}
			
			String journeyDescription = journeyInfo.get(i).getJourneyDescription();
			if(journeyDescription==null||journeyDescription.trim().isEmpty()){
				this.addFieldError("journeyDescription", "�г���������Ϊ�գ�");
			}
		}
	}
	*/
	
	/**
	 * ����һ���г���Ϣ
	 * 1.�����г��ļ�
	 * 2.�����ݿ��������г���Ϣ
	 * 3.����"editSucc"�ض���product_page
	 * @return
	 * @throws Exception
	 */
	public String addOneJourney() throws Exception{
		//��session����ȡ��model
		model = (ProductInfo)productService.load(proId);
		String savePath = ServletActionContext.getServletContext().getRealPath("/journeyFiles");
		File destFile;
		
		if(jfile.get(0)!=null){
			journeyInfo.get(0).setJourneyFileName(jfileFileName.get(0));
			journeyInfo.get(0).setJourneyRealName(CommonUtils.uuid() +"." +
					jfileFileName.get(0).split("\\.")[1]);
			
			//�ϴ��ļ�
			destFile = new File(savePath,journeyInfo.get(0).getJourneyRealName());
			FileUtils.copyFile(jfile.get(0), destFile);
		}
		journeyInfo.get(0).setProductName(new String(proName.getBytes("ISO-8859-1"),"UTF-8"));
		journeyService.add(journeyInfo.get(0));
		
		
		ActionContext.getContext().getValueStack().push(journeyService.findByProductName(proName));
		
		//����product_edit֮ǰ��Ҫ������session���ύmodel������
		//ServletActionContext.getRequest().getSession().setAttribute("proName", model.getProductName());
		//proDays = (Integer)ServletActionContext.getRequest().getSession().getAttribute("proDays");
		//proDays = proDays+1;
		
		/*Date startDate = (new SimpleDateFormat("yyyy-MM-dd")).parse(model.getStartDate());
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		cal.add(Calendar.DATE, proDays-1);
		model.setEndDate((new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime()));*/
		
		//productService.edit(model);
		//ServletActionContext.getRequest().getSession().setAttribute("model", model);
		//ServletActionContext.getRequest().getSession().setAttribute("proDays", proDays);
		
		return "journeyList";
	}
	
	
	
	/**
	 * ɾ����Ʒ��Ϣ
	 * 1.����ļ����ڣ�ɾ��
	 * 2.ɾ�����ݿ���еĲ�Ʒ��Ϣ
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		model = (ProductInfo)productService.load(model.getProductId());
		ServletActionContext.getRequest().getSession().setAttribute("proName", model.getProductName());
		if(model.getProductRealName()!=null){
			//����ļ����ڣ�ɾ���ļ�
			String savePath = ServletActionContext.getServletContext().getRealPath("/productFiles");
			new File(savePath,model.getProductRealName()).delete();
		}
		//ɾ�����ݿ���еĲ�Ʒ��Ϣ
		productService.delete(model.getProductId());
		return "deleteJourney";
	}
	
	/**
	 * ɾ���г���Ϣ
	 * 1.��ѯ���в�Ʒ����Ϊ�ض����Ƶ��г���Ϣ
	 * 2.ѭ��������ɾ���ļ���Ϣ�����ݿ��е���Ϣ
	 * @return
	 * @throws Exception
	 */
	public String deleteJourney() throws Exception {
		String savePath = ServletActionContext.getServletContext().getRealPath("/journeyFiles");
		String productName = (String)ServletActionContext.getRequest().getSession().getAttribute("proName");
		List<JourneyInfo> journeyInfos = journeyService.findByProductName(productName);
		
		for(JourneyInfo journeyInfo:journeyInfos){
			if(journeyInfo.getJourneyRealName()!=null){
				//������ļ�����,ɾ���ļ�
				new File(savePath,journeyInfo.getJourneyRealName()).delete();
			}
			journeyService.delete(journeyInfo.getJourneyId());
		}
		return "editSucc";
	}
	
	/**
	 * ɾ���г���Ϣ
	 * 1.��������ļ���ɾ��
	 * 2.ɾ�����ݿ��е���Ϣ
	 * @return
	 * @throws Exception
	 */
	public String deleteOneJourney() throws Exception {
		//����model,���ڷ��ز�Ʒ�༭ҳ���չʾ����
		//model = (ProductInfo)productService.load(proId);
		
		String savePath = ServletActionContext.getServletContext().getRealPath("/journeyFiles");
		new File(savePath,jourRealName).delete();
		journeyService.delete(jourId);
		
		ActionContext.getContext().getValueStack().push(journeyService.findByProductName(proName));
		
		//ServletActionContext.getRequest().getSession().setAttribute("proName", model.getProductName());
		//proDays = (Integer)ServletActionContext.getRequest().getSession().getAttribute("proDays");
		//proDays = proDays-1;
		
		/*Date startDate = (new SimpleDateFormat("yyyy-MM-dd")).parse(model.getStartDate());
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		cal.add(Calendar.DATE, proDays-1);
		model.setEndDate((new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime()));
		*/
		
		//productService.edit(model);
		//ServletActionContext.getRequest().getSession().setAttribute("model", model);
		//ServletActionContext.getRequest().getSession().setAttribute("proDays", proDays);
		return "journeyList";
	}
	
	
	
	/**
	 * �鿴��Ʒ������г���Ϣ
	 * @return
	 * @throws Exception
	 */
	public String view() throws Exception {
		model = productService.load(model.getProductId());
		ActionContext.getContext().getValueStack().push(journeyService.findByProductName(model.getProductName()));
		return "view";
	}
	
	/**
	 * Ϊ���ζ����ĺ���
	 * @return
	 */
	public String loadForAdd(){
		return "loadForAdd";
	}
	/**
	 * �༭֮ǰ�ļ���
	 * @return
	 * @throws Exception
	 */
	public String loadForEdit() throws Exception {
		if(model.getProductId()!=0){
			model = productService.load(model.getProductId());
		}else{
			model = productService.load(proId);
		}
		//��model��productName����session���У�����
		//ServletActionContext.getRequest().getSession().setAttribute("proName", model.getProductName());
		this.proName = model.getProductName();
		this.proId = model.getProductId();
		//ServletActionContext.getRequest().getSession().setAttribute("model", model);
		ActionContext.getContext().getValueStack().push(journeyService.findByProductName(model.getProductName()));
		//proDays = journeyService.findByProductName(model.getProductName()).size();
		//ServletActionContext.getRequest().getSession().setAttribute("proDays", proDays);
		return "edit";
	}

	/**
	 * �༭��Ʒ��Ϣ
	 * @return
	 * @throws Exception
	 */
	@InputConfig(resultName="editInput")
	public String edit() throws Exception{
		
		if(file!=null){
			//����ϴ����ļ���ɾ��ԭ�ļ�
			String savePath = ServletActionContext.getServletContext().getRealPath("/productFiles");
			if(model.getProductRealName()!=null){
				new File(savePath,model.getProductRealName()).delete();
			}
			//Ȼ���ϴ����ļ�
			model.setProductFileName(fileFileName);
			model.setProductRealName(CommonUtils.uuid() +"." + fileFileName.split("\\.")[1]);
			File destFile = new File(savePath,model.getProductRealName());
			FileUtils.copyFile(file, destFile);
		}
		//proDays =(Integer)ServletActionContext.getRequest().getSession().getAttribute("proDays");
		
		/*Date startDate = (new SimpleDateFormat("yyyy-MM-dd")).parse(model.getStartDate());
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		cal.add(Calendar.DATE, proDays-1);
		model.setEndDate((new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime()));
		*/
		
		//�����޸�ǰ�Ĳ�Ʒ���ƶ��г���Ϣ�����޸�
		String productName = proName;
		productService.edit(model);
		
		List<JourneyInfo> journeyInfos = journeyService.findByProductName(productName);
		
		for(JourneyInfo journeyInfo:journeyInfos){
			journeyInfo.setProductName(model.getProductName());
			journeyService.edit(journeyInfo);
		}
		
		
		
		
		//proDays = (Integer)ServletActionContext.getRequest().getSession().getAttribute("proDays");
		//ServletActionContext.getRequest().getSession().setAttribute("proDays", proDays);
		return "loadForEdit";
	}
	
	/**
	 * �༭��Ʒ��У��
	 * @throws Exception
	 */
	public void validateEdit() throws Exception{
		
		if(!productService.isUnique(model)){
			this.addActionError("��Ʒ����ռ�ã�");
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = format.parse(model.getEndDate());
		Date date2 = format.parse(model.getStartDate());
		//int sec = (int)(date1.getTime() - date2.getTime());
		
		if((date1.getTime() - date2.getTime()) < 0){
			this.addFieldError("endDate","��ʼ���ڲ������ڽ������ڣ�");
		}
		
	}
	
	/**
	 * �༭�г�֮ǰ�ļ���
	 * @return
	 * @throws Exception
	 */
	public String loadJourneyForEdit() throws Exception {
		journeyInfo.add(journeyService.load(jourId));
		return "editJourney";
	}
	
	/**
	 * �༭�г�
	 * @return
	 * @throws Exception
	 */
	@InputConfig(resultName="editJourneyInput")
	public String editJourney() throws Exception {
		model= productService.load(proId);
		
		if(jfile!=null){
			//����ϴ����ļ���ɾ��ԭ�ļ�
			String savePath = ServletActionContext.getServletContext().getRealPath("/journeyFiles");
			new File(savePath,journeyInfo.get(0).getJourneyRealName()).delete();
			//Ȼ���ϴ����ļ�
			journeyInfo.get(0).setJourneyFileName(jfileFileName.get(0));
			journeyInfo.get(0).setJourneyRealName(CommonUtils.uuid() +"." + jfileFileName.get(0).split("\\.")[1]);
			File destFile = new File(savePath,journeyInfo.get(0).getJourneyRealName());
			FileUtils.copyFile(jfile.get(0), destFile);
		}
		journeyService.edit(journeyInfo.get(0));
		
		ActionContext.getContext().getValueStack().push(journeyService.findByProductName(journeyInfo.get(0).getProductName()));
		
		return "journeyList";
	}

}
