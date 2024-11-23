import java.util.Random;
import java.util.Scanner;
class NumberGuessingGame{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Random random=new Random();
		int score=0;
		String playAgain;
		System.out.println("welcome to game");
		do{
			int attempt=0;
			int maxattempt=5;
			int randomNumber=random.nextInt(100)+1;
			boolean guessCorrectly=false;
			System.out.println("\n A random number between 1 to 100 has generated");
			System.out.println("Maxmimum attempt to play the game will be"+maxattempt);
			while(attempt<maxattempt)
			{
				System.out.println("Enter your guess");
				int userGuess=sc.nextInt();
				attempt++;
				if(userGuess==randomNumber){
					System.out.println("Congrats you guess a right number");
					score+=(maxattempt-attempt+1);
					guessCorrectly=true;
					break;
				}else if(userGuess<randomNumber){
					System.out.println("To low,Try again");
				}else{
					System.out.println("To high,Try again");
				}
				System.out.println("Attempt reamining:"+(maxattempt-attempt));
			}
			if(! guessCorrectly){
				System.out.println(" All attempts get over the correct number was:"+randomNumber);
			}
			System.out.println("you current score is:"+score);
			System.out.println("Do you want to another round?(yes/no):");
			playAgain=sc.next();
		}
		while(playAgain.equalsIgnoreCase("yes"));
		System.out.println("Thank you! your final score is: "+score);
		sc.close();
	}
}