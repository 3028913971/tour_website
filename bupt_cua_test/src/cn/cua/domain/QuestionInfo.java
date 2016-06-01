package cn.cua.domain;
/**
 * ������Ϣ��
 * @author LI AO
 *
 */
public class QuestionInfo {
	
	private int questionId;//����id
	private String questionName;//��������
	private String questionContent;//��������
	private String questionTime;//���ⷢ��ʱ��
	private int questionOrder;//����˳��
	
	
	
	public QuestionInfo() {
		super();
	}
	
	

	public QuestionInfo(int questionId, String questionName,
			String questionContent, String questionTime, int questionOrder,
			int qOrder) {
		super();
		this.questionId = questionId;
		this.questionName = questionName;
		this.questionContent = questionContent;
		this.questionTime = questionTime;
		this.questionOrder = questionOrder;
	}



	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestionName() {
		return questionName;
	}
	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}
	public String getQuestionContent() {
		return questionContent;
	}
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}
	public String getQuestionTime() {
		return questionTime;
	}
	public void setQuestionTime(String questionTime) {
		this.questionTime = questionTime;
	}
	

	public int getQuestionOrder() {
		return questionOrder;
	}

	public void setQuestionOrder(int questionOrder) {
		this.questionOrder = questionOrder;
	}
	

	@Override
	public String toString() {
		return "QuestionInfo [questionId=" + questionId + ", questionName="
				+ questionName + ", questionContent=" + questionContent
				+ ", questionTime=" + questionTime + ", questionOrder="
				+ questionOrder + "]";
	}
}
