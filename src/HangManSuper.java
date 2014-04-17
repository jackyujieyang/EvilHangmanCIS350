
public class HangManSuper implements HangmanGame{

	protected String originalSecretWord = "";//To store the secret word
	protected int guessesRemaining;// to store the number of guess for the user
	protected String currentState = "";// store the current guessing situation
	protected String letterGuessHistory = "";// store the letters user has tried
	protected char letterGuess;// the letter the user guess right now
	
	
	@Override
	public String getSecretWord() {
		return originalSecretWord;
	}

	@Override
	public boolean makeGuess(char ch) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isWin() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gameOver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int numGuessesRemaining() {
		return guessesRemaining;
	}

	@Override
	public int numLettersRemaining() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String displayGameState() {
		return currentState;
	}

	@Override
	public String lettersGuessed() {
		return letterGuessHistory;
	}

}
