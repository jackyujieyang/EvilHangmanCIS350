/**
 * <p>A class that keeps track of the current state of a game of hangman.</p>
 * <p> The class is constructed with a secret word and some number of guesses.</p>
 * <p>Every time a letter is guessed, the state of the game is updated appropriately
 * integrating the guessed letter into the word, updating the number of guesses
 * remaining, etc.</p>
 * 
 * <p>This class can then be used by a user interface to administer a regular game of Hangman.</p>
 */
import java.util.*;
public class NormalHangMan extends HangManSuper {
	//private String originalSecretWord = "";//To store the secret word
    //private int guessesRemaining;//to store the number of guess for the user
    private int numLettersLeft;//to store the number of the letters in the secret word has not been guessed correctly
    //private String currentState = "";//store the current guessing situation
    //private String letterGuessHistory = "";//store the letter user has tried
    //private char letterGuess;//the letter the user guess right now

    /**
     * Constructor sets up the game to be played with a word and some number of
     * guesses.  The class should have private variables that keep track of:
     * <li>The original secret word
     * <li>The number of guesses remaining
     * <li>The number of letters that still need to be guessed
     * <li>The current state of word to be guessed (e.g. "L A B _ R A _ _ R Y")
     * @param secretWord the word that the player is trying to guess
     * @param numGuesses the number of guesses allowed
     */
    public NormalHangMan(String secretWord, int numGuesses, String LetterHistory){
        originalSecretWord = secretWord;
        guessesRemaining = numGuesses;
        numLettersLeft = secretWord.length();
        for(int i = 0; i < secretWord.length(); i++)
        {
            currentState += "_ ";
            for(int j = i; j > 0; j--)
            {
                if(secretWord.charAt(i) == secretWord.charAt(j-1))
                {
                    numLettersLeft--;//If the letter appears many times in the secret word, it will be counted just once.
                    break;
                }
            }
        }
        letterGuessHistory = LetterHistory;
    }   
    /*
    public String getSecretWord()
    {
        return originalSecretWord;
    }
    */
    /*
    public int numGuessesRemaining()
    {
        return guessesRemaining;
    }
    */
    public int numLettersRemaining()
    {
        return numLettersLeft;
    }
    public boolean isWin()
    {
        if (guessesRemaining == 0)
            return false;//if the user has no chance to guess again, it means the user loses.
        else
            return true;
    }
    public boolean gameOver()
    {
        if (guessesRemaining == 0 || numLettersLeft == 0)
            return true;
        else
            return false;
    }
    /*
    public String lettersGuessed()
    {
        return letterGuessHistory;
    }
    */
    /*
    public String displayGameState()
    {
        return currentState;
    }
    */
    public boolean updateState(char ch) {
    	for (int i = 0; i < originalSecretWord.length(); i++) {
    		if (originalSecretWord.charAt(i) == ch) {
    			String temp = "";
    			for (int j = 0; j < originalSecretWord.length(); j++) {
    				if (originalSecretWord.charAt(j) == ch) {
    					temp = temp + ch + " ";
    				} else {
    					temp = temp + currentState.charAt(2*j) + currentState.charAt(2*j+1); 
    				}
    			}
    			currentState = temp;
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean makeGuess(char ch)
    {
    	if (Character.isLetter(ch) == false) return false;
        //boolean tempB = true;
        letterGuess = ch;
        boolean isGuessCorrect = updateState(ch);
        /*
        for (int i = 0; i < originSecretWord.length(); i++)
        {
            if (originSecretWord.charAt(i) == ch)//if the user guess right, adjust the current state.
            {
                String temp = "";
                for (int j = 0; j < originSecretWord.length(); j++)
                {
                    if (originSecretWord.charAt(j) == ch)
                    {
                        temp = temp + ch + " ";
                    }
                    else
                    {
                        temp = temp + currentState.charAt(2*j) + currentState.charAt(2*j+1);              
                    }
                }
                currentState = temp;
                tempB = true;
                break;
            }
            else
            {
                tempB = false;
            }
        }
        */
        if (!alreadyGuessed(ch))
        {
            letterGuessHistory = letterGuessHistory + letterGuess;

            if (isGuessCorrect)
            {
                numLettersLeft--;
            }
            else
            {
                guessesRemaining--;
            }
            return isGuessCorrect;
        }
        else return false;
    }
    
    public boolean alreadyGuessed(char c)
    {
    	for (int i = 0; i < letterGuessHistory.length(); i++) {
    		if (letterGuessHistory.charAt(i) == c) return true;
    	}
    	return false;
    }
    
   
}
    
       