package misc;

import java.util.*;
import java.lang.*;

public class Unit78LabAssessment {
	static String[] wordbank = {"java","python","basic"};
	static String[] worddigits;
	static String word;
	static int guessed;
	static String showProgress = "";
	static int missed = 0;

	public static void main(String[] args) {
		Random rng = new Random();
		Scanner scan = new Scanner(System.in);
		
		int nextNum = rng.nextInt(4);
//System.out.println(nextNum);
		word = wordbank[nextNum];
		
		String[] guessword = new String[word.length()];
		String[] worddigits = new String[word.length()];
		for (int i=0;i<word.length();i++){
			guessword[i] = "*";
			
			showProgress = "";
			for(int j=0;j<guessword.length;j++){
				showProgress = showProgress + guessword[i];
				}
			
			char letter =' ';
			letter = word.charAt(i);
			worddigits[i] = Character.toString(letter);
		}
//System.out.println(Arrays.toString(worddigits));
		
		
		
		
//System.out.println(Arrays.toString(guessword));
//System.out.println(showProgress);
		
		guessed = 0;
		int inword = 0;
		do{
			String guess;
			System.out.print(word+"(Guess) Enter a letter in word " + showProgress + ">");
			guess = scan.next();
			inword = 0;
//System.out.println(guess);
			for (int i=0;i<worddigits.length;i++){
				if (Arrays.asList(worddigits).contains(guess)){
					
						
							guessword[i] = worddigits[i];
					inword = 1;
					
					showProgress = "";
					for(int j=0;j<guessword.length;j++){
					showProgress = showProgress + guessword[j];
					
					i = worddigits.length-1;
						}
					
					}
				}
				if (Arrays.asList(guessword).contains(guess)){
				inword = 2;
				}
				else{
					inword = 0;
				}
				
			
System.out.println(Arrays.toString(guessword));
System.out.print(inword);
				
			if (inword == 0){
				System.out.println(guess + " is not in the word");
				missed++;
			}
			else if (inword == 2){
				System.out.println(guess + " is already in the word");
			}
			else if (worddigits==guessword){
				guessed = 1;
			}
			inword = 0;
				
		}while (guessed == 0);
		System.out.println("The word was "+ word + ". You missed " + missed +"time");
		
		System.out.println("Play again?");
		int playagain = scan.nextInt();
		
		
		

	}

}
