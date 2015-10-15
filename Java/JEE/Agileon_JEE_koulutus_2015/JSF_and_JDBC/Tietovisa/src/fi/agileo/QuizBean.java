package fi.agileo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class QuizBean {
	private Integer currentQuestion;
	private Integer score;
	private Question questions[];
	private boolean bAfterLastPage;
	private String links[];
	private static final int MAX_QUESTIONS = 6;
	
	public QuizBean() {
		questions = new Question[MAX_QUESTIONS];
		questions[0] = new Question("Father of Java?", "Gospling", "Wall", "Pedersen", 0);
		questions[1] = new Question("What is Servlet?", "Web Server Application",
				"Service of service", "Part of Service",0);
		questions[2] = new Question("JSP?", "Java Server Pages", 
				"Just Search Pages", "Java Simple Patterns", 0);
		questions[3] = new Question("JDBC?", "Datawarehouse", "database API", "Collection framework", 1);
		questions[4] = new Question("JSF?", "Just Server Fitness", "Java Service Framework", "JavaServer Faces", 2);
		questions[5] = new Question("JPA?", "Just Player's Apps", "Java-Pascal AppBridge", "Java Persistence API", 2);		
		currentQuestion = 0;
		score = 0;
		links = new String[2];
		links[0] = "index.xhtml"; // Linkki ensimmäiseen kysymykseen
		links[1] = "question.xhtml"; // Linkki muihin kysymyksiin
		bAfterLastPage = false;
	}
	
	public String getQuestionStr() {
		bAfterLastPage = false;
		return questions[currentQuestion].getQuestion();
	}
	
	public int getScore() {
		return score;
	}
	
	public String getCorrectAnswer() {
		if (currentQuestion != 0)
			return questions[currentQuestion -1].getCorrectAnswerString();
		return "";
	}
	
	public String getLastCorrectAnswer() {
		return questions[MAX_QUESTIONS - 1].getCorrectAnswerString();
	}
	
	public int getLastScore() {
		int lastScore = score;
		score = 0;
		return lastScore;
	}
	
	public String getResponse() {
		return "";
	}
	
	public void setResponse(String response) {
		if (response.equals(questions[currentQuestion].getCorrectAnswerString())) {
			score++;
		}
	}
	
	public String[] getChoices() {
		return questions[currentQuestion].getChoices();
	}
	
	public boolean isJustAfterLastPage() {
		return bAfterLastPage;
	}
	
	public String next() {
		currentQuestion++;
		if (currentQuestion >= MAX_QUESTIONS) {
			bAfterLastPage = true;
			currentQuestion = 0;
			return links[0];
		}
		return links[1];
	}
}
