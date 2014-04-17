import java.util.*;
import java.io.*;


public class EvilHangMan extends HangManSuper {

	private ArrayList<String> wordlist = new ArrayList<String>();
	private int secretStringLength;// the length of the secret string
	private boolean guessResult = false;

	public EvilHangMan(int StringLength, int numGuesses) {
		guessesRemaining = numGuesses;
		secretStringLength = StringLength;
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("dictionary.txt"));// read the dictionary
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		while (scanner.hasNext()) {
			String temp = scanner.nextLine().toUpperCase();
			if (temp.length() == StringLength) {
				wordlist.add(temp);
			}
		}

		for (int i = 0; i < StringLength; i++) {
			currentState += "_ ";
		}
		scanner.close();

	}

	public int numLettersRemaining() {
		return 26; // because they never get one right!
	}

	public boolean isWin() {
		return false;
	}

	public boolean gameOver() {
		if (guessesRemaining == 0)
			return true;
		else
			return false;
	}

	public boolean makeGuess(char ch) {
		//System.out.println("makeGuess: " + ch + "; numWords=" + wordlist.size());
		guessResult = false;
		letterGuess = ch;
		if (Character.isLetter(ch) && !isRepeatInput(ch)) {
			// adjust the Wordlist in order to avoid the word with the letter
			// user guessed
			String firstWord = wordlist.get(0);
			for (int i = 0; i < wordlist.size(); i++) {
				for (int j = 0; j < secretStringLength; j++) {
					if (wordlist.get(i).charAt(j) == ch) {
						wordlist.remove(wordlist.get(i));
						i--;
						break;
					}
				}
			}
			if (wordlist.size() == 0) {
				//System.out.println("tempWordNum is zero!");
				originalSecretWord = firstWord;
				wordlist.add(firstWord);
				guessResult = true;
			} else {
				originalSecretWord = wordlist.get(0);
				guessesRemaining--;
				guessResult = false;
			}
			if (!guessResult) {
				letterGuessHistory = letterGuessHistory + letterGuess;
			}	
		} else {
			return false;
		}
		return guessResult;	
	}

    public boolean isRepeatInput(char c)
    {
    	for (int i = 0; i < letterGuessHistory.length(); i++) {
    		if (letterGuessHistory.charAt(i) == c) return true;
    	}
    	return false;
    }
}