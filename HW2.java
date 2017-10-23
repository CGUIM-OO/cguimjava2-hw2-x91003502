import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO: B0322017 ªL¨°«Ø
 * This program will be needed to key in how many deck, then it will show all cards on the screen 
   according to the order.
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards
	 * @param nDeck 
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/**
 * Description: TODO: This class includes three methods which are Deck, printDeck, and getAllCards.
 * Deck method is used to create cards, and each deck has 52 cards.
 * PrintDeck method is used to show all cards on the screen.
 * getAllCards is used by teachers in order to check whether students' programs work precisely.
 */
class Deck{
	private ArrayList<Card> cards;
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		for(int i=1;i<=nDeck;i++) {
			for(int j=1;j<=4;j++) {
				for(int k=1;k<=13;k++) {
					Card card=new Card(j,k);
					cards.add(card);
				}
			}
		}
		
					
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end

	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		for(int index=0;index<cards.size();index++) {
		Card CardDetail= cards.get(index);
		Card c=new Card(CardDetail.getSuit(),CardDetail.getRank());
		c.printCard(CardDetail.getSuit(),CardDetail.getRank());
		}
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)

	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/**
 * Description: TODO: This section will construct the properties of each cards which are suit and rank.
 * For example; Clubs Ace, etc
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s,int r){
		suit=s;
		rank=r;
	}	
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(int s,int r){
		switch(s){
		case 1:
			System.out.print("Clubs ");
			break;
		case 2:
			System.out.print("Diamonds ");
			break;
		case 3:
			System.out.print("Hearts ");
			break;
		case 4:
			System.out.print("Spades ");
			break;
		}
		switch(r){
		case 1:
			System.out.println("Ace");
			break;
		case 2:
			System.out.println(r);
			break;
		case 3:
			System.out.println(r);
			break;
		case 4:
			System.out.println(r);
			break;
		case 5:
			System.out.println(r);
			break;
		case 6:
			System.out.println(r);
			break;
		case 7:
			System.out.println(r);
			break;
		case 8:
			System.out.println(r);
			break;
		case 9:
			System.out.println(r);
			break;
		case 10:
			System.out.println(r);
			break;
		case 11:
			System.out.println("Jack");
			break;
		case 12:
			System.out.println("Queen");
			break;
		case 13:
			System.out.println("King");
			break;
		}
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace

	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}