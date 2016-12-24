import java.util.Scanner;
public class dollar
{
    static int center = 0;
    static int[] money;
	public static void main(String[]args)
	{
        startGame();
	}
    public static void takeTurn()
    {
        for (int i = 0; i < money.length; i++)
        {
            int max = money[i];
            if(money[i] > 0)
            {
                for (int j = 0; j < max && j < 3; j++)
                {
                    int roll = (int)(Math.random()*6)+1;
                    if (roll == 1)
                    {
                        System.out.print("C ");
                        center += 1;
                        money[i] -= 1;
                    }
                    else if (roll == 2)
                    {
                        System.out.print("L ");
                        money[i] -= 1;
                        // move dollar left
                        if (i == 0)
                            money[money.length-1] += 1;
                        else
                            money[i-1] += 1;
                    }
                    else if (roll == 3)
                    {
                        System.out.print("R ");
                        money[i] -= 1;
                        // move dollar right
                        if (i == money.length-1)
                            money[0] += 1;
                        else
                            money[i+1] += 1;
                    }
                    else
                    {
                        System.out.print("K ");
                    }
                }
            } 
            System.out.println(); 
        }
        System.out.println("Center: " + center);
        printMoney();
    }
    public static void printMoney()
    {
        for (int i = 0; i < money.length; i++)
        {
            if (money[i] == 0)
                System.out.print("X ");
            else
            {
                for (int j = 0; j < money[i]; j++)
                {
                    System.out.print("$ ");
                }
            }
            System.out.print("|| ");
        }
        System.out.println();
    }
    public static void startGame()
    {
        Scanner kb = new Scanner(System.in);
        System.out.println("How many players will be in this game?");
        int numPlayers = kb.nextInt();
        kb.nextLine();
        money = new int[numPlayers];
        for (int i = 0; i < numPlayers; i++)
        {
            money[i] = 3;
        }
        int totalMoney = money.length*3;
        System.out.println("Center: 0");
        printMoney();
        while (center < (money.length*3)-1)
        {
            System.out.println("Press enter to complete a turn.");
            String nextTurn = kb.nextLine();
            takeTurn();
        }
        System.out.println("The player with money left wins $" + totalMoney + "! Game Over");
        center = 0;
        System.out.println("Play Again? 'y' or 'n'");
        String playAgain = kb.next();
        if (playAgain.equals("y"))
            startGame();
        else
            System.out.println("Thanks for playing!");
    }
}