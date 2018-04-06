package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgEnum.eHandStrength;
import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandPokerTest {
	
	@Test
	public void RoyalFlushTest1()
	{
		System.out.println("Royal Flush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TEN));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.JACK));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.QUEEN));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.KING));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.ACE));
		hp.ScoreHand();
		
		assertEquals(hp.isRoyalFlush(), true);
		
		HandScorePoker HSP = (HandScorePoker) hp.getHS();
		
		assertEquals(HSP.geteHandStrength(), eHandStrength.RoyalFlush);
		assertNull(HSP.getHiCard());
		assertNull(HSP.getKickers());
		
		System.out.println("");
	}
	
	@Test
	public void StraightFlushTest1()
	{
		System.out.println("Straight Flush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TEN));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.JACK));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.QUEEN));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.KING));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.ACE));
		hp.ScoreHand();
		
		assertEquals(hp.isStraightFlush(), true);
		
		HandScorePoker HSP = (HandScorePoker) hp.getHS();
		
		assertEquals(HSP.geteHandStrength(), eHandStrength.RoyalFlush);
		assertNull(HSP.getHiCard());
		assertNull(HSP.getKickers());
		
		System.out.println("");
	}

	@Test
	public void StraightFlushTest2()
	{
		System.out.println("Straight Flush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.ACE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FOUR));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
		hp.ScoreHand();
		
		assertEquals(hp.isStraightFlush(), true);

		HandScorePoker HSP = (HandScorePoker) hp.getHS();
		
		assertEquals(HSP.geteHandStrength(), eHandStrength.StraightFlush);
		assertEquals(HSP.getHiCard().geteRank(), eRank.ACE);
		assertNull(HSP.getKickers());
		
		System.out.println("");
	}
	
	@Test
	public void StraightFlushTest3()
	{
		System.out.println("Straight Flush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FOUR));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.SIX));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.SEVEN));
		hp.ScoreHand();
		
		assertEquals(hp.isStraightFlush(), true);

		HandScorePoker HSP = (HandScorePoker) hp.getHS();
		
		assertEquals(HSP.geteHandStrength(), eHandStrength.StraightFlush);
		assertEquals(HSP.getHiCard().geteRank(), eRank.SEVEN);
		assertNull(HSP.getKickers()
				);
		
		System.out.println("");
	}
	
	@Test
	public void FourOfAKindTest1() {
		System.out.println("Four of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES,eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.ScoreHand();
		
		assertEquals(hp.isFourOfAKind(), true);
		
		HandScorePoker HSP = (HandScorePoker) hp.getHS();
		
		assertEquals(HSP.geteHandStrength(), eHandStrength.FourOfAKind);
		assertEquals(HSP.getHiCard().geteRank(), eRank.TWO);
		assertEquals(HSP.getKickers().size(), 1);
		assertEquals(HSP.getKickers().get(0).geteRank(), eRank.THREE);
		assertEquals(HSP.getKickers().get(0).geteSuit(), eSuit.CLUBS);
		
		
		System.out.println("");
	}
	
	@Test
	public void FourOfAKindTest2() {
		System.out.println("Four of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES,eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.ScoreHand();
		
		assertEquals(hp.isFourOfAKind(), true);
		
		HandScorePoker HSP = (HandScorePoker) hp.getHS();
		
		assertEquals(HSP.geteHandStrength(), eHandStrength.FourOfAKind);
		assertEquals(HSP.getHiCard().geteRank(), eRank.TWO);
		assertEquals(HSP.getKickers().size(), 1);
		assertEquals(HSP.getKickers().get(0).geteRank(), eRank.THREE);
		assertEquals(HSP.getKickers().get(0).geteSuit(), eSuit.CLUBS);
		
		System.out.println("");
	}
	
	@Test
	public void FullHouseTest1() {
		System.out.println("Full House");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES,eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.ScoreHand();
		
		assertEquals(hp.isFullHouse(), true);
		
		HandScorePoker HSP = (HandScorePoker) hp.getHS();
		
		assertEquals(HSP.geteHandStrength(), eHandStrength.FullHouse);
		assertEquals(HSP.getHiCard().geteRank(), eRank.TWO);
		assertNull(HSP.getKickers());
		
		System.out.println("");
	}
	
	@Test
	public void FullHouseTest2() {
		System.out.println("Full House");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.SIX));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.SIX));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.SIX));
		hp.AddCard(new Card(eSuit.SPADES,eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.ScoreHand();
		
		assertEquals(hp.isFullHouse(), true);
		
		HandScorePoker HSP = (HandScorePoker) hp.getHS();
		
		assertEquals(HSP.geteHandStrength(), eHandStrength.FullHouse);
		assertEquals(HSP.getHiCard().geteRank(), eRank.SIX);
		assertNull(HSP.getKickers());
		
		System.out.println("");
	}
	
	@Test
	public void FlushTest1()
	{
		System.out.println("Flush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FOUR));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.NINE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.ACE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.JACK));
		hp.ScoreHand();
		
		assertEquals(hp.isFlush(), true);
		
		HandScorePoker HSP = (HandScorePoker) hp.getHS();
		
		assertEquals(HSP.geteHandStrength(), eHandStrength.Flush);
		assertEquals(HSP.getHiCard().geteRank(), eRank.ACE);
		assertNull(HSP.getKickers());
		
		System.out.println("");
	}
	
	@Test
	public void StraightTest1()
	{
		System.out.println("Staight");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TEN));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.JACK));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.QUEEN));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.KING));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.ACE));
		hp.ScoreHand();
		
		assertEquals(hp.isStraight(), true);
		
		HandScorePoker HSP = (HandScorePoker) hp.getHS();
		
		assertEquals(eHandStrength.Straight, HSP.geteHandStrength());
		assertEquals(HSP.getHiCard().geteRank(), eRank.ACE);
		assertNull(HSP.getKickers());
		
		System.out.println("");
	}
	
	@Test
	public void StraightTest2()
	{
		System.out.println("Staight");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.SIX));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.SEVEN));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.EIGHT));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.NINE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TEN));
		hp.ScoreHand();
		
		assertEquals(hp.isStraight(), true);
		
		HandScorePoker HSP = (HandScorePoker) hp.getHS();
		
		assertEquals(eHandStrength.Straight, HSP.geteHandStrength());
		assertEquals(HSP.getHiCard().geteRank(), eRank.TEN);
		assertNull(HSP.getKickers());
		
		System.out.println("");
	}
	
	@Test
	public void ThreeOfAKindTest1() {
		System.out.println("Three of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.ScoreHand();
		
		assertEquals(hp.isThreeOfAKind(), true);
		
		HandScorePoker HSP = (HandScorePoker) hp.getHS();
		
		assertEquals(HSP.geteHandStrength(), eHandStrength.ThreeOfAKind);
		assertEquals(HSP.getHiCard().geteRank(), eRank.TWO);
		assertEquals(HSP.getKickers().size(), 2);
		assertEquals(HSP.getKickers().get(0).geteRank(), eRank.FIVE);
		assertEquals(HSP.getKickers().get(0).geteSuit(), eSuit.SPADES);
		
		System.out.println("");
	}
	
	@Test
	public void ThreeOfAKindTest2() {
		System.out.println("Three of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.EIGHT));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.TEN));
		hp.AddCard(new Card(eSuit.SPADES,eRank.TEN));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TEN));
		hp.ScoreHand();
		
		assertEquals(hp.isThreeOfAKind(), true);
		
		HandScorePoker HSP = (HandScorePoker) hp.getHS();
		
		assertEquals(HSP.geteHandStrength(), eHandStrength.ThreeOfAKind);
		assertEquals(HSP.getHiCard().geteRank(), eRank.TEN);
		assertEquals(HSP.getKickers().size(), 2);
		assertEquals(HSP.getKickers().get(0).geteRank(), eRank.EIGHT);
		assertEquals(HSP.getKickers().get(0).geteSuit(), eSuit.CLUBS);
		
		System.out.println("");
	}
	
	@Test
	public void ThreeOfAKindTest3() {
		System.out.println("Three of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.ACE));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES,eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.ScoreHand();
		
		assertEquals(hp.isThreeOfAKind(), true);
		
		HandScorePoker HSP = (HandScorePoker) hp.getHS();
		
		assertEquals(HSP.geteHandStrength(), eHandStrength.ThreeOfAKind);
		assertEquals(HSP.getHiCard().geteRank(), eRank.TWO);
		assertEquals(HSP.getKickers().size(), 2);
		assertEquals(HSP.getKickers().get(0).geteRank(), eRank.ACE);
		assertEquals(HSP.getKickers().get(0).geteSuit(), eSuit.CLUBS);
		
		System.out.println("");
	}
	
	@Test
	public void TwoPairTest1() {
		System.out.println("Two Pair");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.ScoreHand();
		
		assertEquals(hp.isTwoPair(), true);
		
		HandScorePoker HSP = (HandScorePoker) hp.getHS();
		
		assertEquals(HSP.geteHandStrength(), eHandStrength.TwoPair);
		assertEquals(HSP.getHiCard().geteRank(), eRank.FIVE);
		assertEquals(HSP.getKickers().size(), 1);
		assertEquals(HSP.getKickers().get(0).geteRank(), eRank.THREE);
		assertEquals(HSP.getKickers().get(0).geteSuit(), eSuit.CLUBS);
		
		System.out.println("");
	}
	
	@Test
	public void TwoPairTest2() {
		System.out.println("Two Pair");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.SIX));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
		hp.ScoreHand();
		
		assertEquals(hp.isTwoPair(), true);
		
		HandScorePoker HSP = (HandScorePoker) hp.getHS();
		
		assertEquals(HSP.geteHandStrength(), eHandStrength.TwoPair);
		assertEquals(HSP.getHiCard().geteRank(), eRank.FIVE);
		assertEquals(HSP.getKickers().size(), 1);
		assertEquals(HSP.getKickers().get(0).geteRank(), eRank.SIX);
		assertEquals(HSP.getKickers().get(0).geteSuit(), eSuit.CLUBS);
		
		System.out.println("");
	}
	
	@Test
	public void PairTest1() {
		System.out.println("Pair");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FOUR));
		hp.AddCard(new Card(eSuit.SPADES,eRank.ACE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.KING));
		hp.ScoreHand();
		
		assertEquals(hp.isPair(), true);
		
		HandScorePoker HSP = (HandScorePoker) hp.getHS();
		
		assertEquals(HSP.geteHandStrength(), eHandStrength.Pair);
		assertEquals(HSP.getHiCard().geteRank(), eRank.FIVE);
		assertEquals(HSP.getKickers().size(), 3);
		assertEquals(HSP.getKickers().get(0).geteRank(), eRank.ACE);
		assertEquals(HSP.getKickers().get(0).geteSuit(), eSuit.SPADES);
		
		System.out.println("");
	}
	
	@Test
	public void PairTest2() {
		System.out.println("Pair");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.NINE));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.ACE));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FOUR));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FOUR));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.KING));
		hp.ScoreHand();
		
		assertEquals(hp.isPair(), true);
		
		HandScorePoker HSP = (HandScorePoker) hp.getHS();
		
		assertEquals(HSP.geteHandStrength(), eHandStrength.Pair);
		assertEquals(HSP.getHiCard().geteRank(), eRank.FOUR);
		assertEquals(HSP.getKickers().size(), 3);
		assertEquals(HSP.getKickers().get(0).geteRank(), eRank.ACE);
		assertEquals(HSP.getKickers().get(0).geteSuit(), eSuit.HEARTS);
		
		System.out.println("");
	}
	
	@Test
	public void HighCardTest1() {
		System.out.println("High Card");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.EIGHT));
		hp.AddCard(new Card(eSuit.SPADES,eRank.JACK));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.KING));
		hp.ScoreHand();
		
		assertEquals(hp.isHighCard(), true);
		
		HandScorePoker HSP = (HandScorePoker) hp.getHS();
		
		assertEquals(HSP.geteHandStrength(), eHandStrength.HighCard);
		assertEquals(HSP.getHiCard().geteRank(), eRank.KING);
		assertEquals(HSP.getKickers().size(), 5);
		assertEquals(HSP.getKickers().get(0).geteRank(), eRank.KING);
		assertEquals(HSP.getKickers().get(0).geteSuit(), eSuit.CLUBS);
		
		System.out.println("");
	}
	
	@Test
	public void HighCardTest2() {
		System.out.println("High Card");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.ACE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.JACK));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.KING));
		hp.ScoreHand();
		
		assertEquals(hp.isHighCard(), true);
		
		HandScorePoker HSP = (HandScorePoker) hp.getHS();
		
		assertEquals(HSP.geteHandStrength(), eHandStrength.HighCard);
		assertEquals(HSP.getHiCard().geteRank(), eRank.ACE);
		assertEquals(HSP.getKickers().size(), 5);
		assertEquals(HSP.getKickers().get(0).geteRank(), eRank.ACE);
		assertEquals(HSP.getKickers().get(0).geteSuit(), eSuit.DIAMONDS);
		
		System.out.println("");
	}
}
