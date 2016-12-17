/**
 * 
 */
package kottarath.assign3.topquiz.data;

import java.util.List;
import java.util.ArrayList;

/**
 * Class to store Question details
 * @author Priya
 *
 */
public class Question {
	
	//Constructor
	public Question()
	{
		
	}
	
	//DATA MEMBERS
	private int questionID;
	private String questionText;
	private List<String> options;
	private String answer;
	private QuestionType questionType;
	private String questionImage;
	
	
	
	//ACCESSORS, MUTATORS
	
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public QuestionType getQuestionType() {
		return questionType;
	}
	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}
	public String getQuestionImage() {
		return questionImage;
	}
	public void setQuestionImage(String questionImage) {
		this.questionImage = questionImage;
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb=new StringBuilder();
		sb.append(questionID+". "+questionText+"\n");
		sb.append("Options: "+options+"\n");
		sb.append("Answer: "+answer);
		
		return sb.toString();
	}
	
	

}
