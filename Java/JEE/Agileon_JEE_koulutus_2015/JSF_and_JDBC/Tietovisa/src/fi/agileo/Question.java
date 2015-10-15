package fi.agileo;

public class Question {
	private String question;
	private String[] choices;
	private int correctAnswer;

	public Question() {}
	
	public Question(String question, 
			String choise1, 
			String choise2, 
			String choise3, 
			int correctAnswer) {
		this.question = question;
		this.choices  = new String[3];
		this.choices[0] = choise1;
		this.choices[1] = choise2;
		this.choices[2] = choise3;
		this.correctAnswer = correctAnswer;
	}
	
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String[] getChoices() {
		return choices;
	}
	
	public void setChoices(String[] choices) {
		this.choices = choices;
	}
	
	public int getCorrectAnswer() {
		return correctAnswer;
	}
	
	public void setCorrectAnswer(int correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	public String getCorrectAnswerString() {
		return choices[correctAnswer];
	}
	
	public boolean isCorrect(int iAnswer) {
		return iAnswer == correctAnswer;
	}
	
}
