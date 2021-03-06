package pkgCore;

import java.util.ArrayList;
import java.util.Collections;
import pkgConstants.*;
import pkgEnum.eCardNo;
import pkgEnum.eHandStrength;
import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandPoker extends Hand {

	private ArrayList<CardRankCount> CRC = null;

	public HandPoker() {
		this.setHS(new HandScorePoker());
	}

	protected ArrayList<CardRankCount> getCRC() {
		return CRC;
	}

	@Override
	public HandScorePoker ScoreHand() {
		// TODO : Implement this method... call each of the 'is' methods (isRoyalFlush,
		// etc) until
		// one of the hands is true, then score the hand

		Collections.sort(super.getCards());
		Frequency();
		
		HandScorePoker HSP = (HandScorePoker)this.getHS();
		
		// Set the HSP information that is independent of the a hand
				int iGetCard = this.getCRC().get(0).getiCardPosition();
				HSP.setHiCard(this.getCards().get(iGetCard));
				HSP.setLoCard(null);
				//HSP.setKickers(FindTheKickers(this.getCRC()));
				this.setHS(HSP);

		if (isRoyalFlush())
		{
			HSP.seteHandStrength(eHandStrength.RoyalFlush);
			HSP.setKickers(null);
			HSP.setHiCard(null);
		} else if (isStraightFlush())
		{
			HSP.seteHandStrength(eHandStrength.StraightFlush);
			HSP.setKickers(null);
		} else if (isFourOfAKind())
		{
			HSP.seteHandStrength(eHandStrength.FourOfAKind);
			HSP.setKickers(FindTheKickers(this.getCRC()));
		} else if (isFullHouse())
		{
			HSP.seteHandStrength(eHandStrength.FullHouse);
			HSP.setKickers(null);
		} else if (isFlush())
		{
			HSP.seteHandStrength(eHandStrength.Flush);
			HSP.setKickers(null);
		} else if (isStraight())
		{
			HSP.seteHandStrength(eHandStrength.Straight);
			HSP.setKickers(null);
		} else if (isThreeOfAKind())
		{
			HSP.seteHandStrength(eHandStrength.ThreeOfAKind);
			HSP.setKickers(FindTheKickers(this.getCRC()));
		} else if (isTwoPair())
		{
			HSP.seteHandStrength(eHandStrength.TwoPair);
			HSP.setKickers(FindTheKickers(this.getCRC()));
		} else if (isPair())
		{
			HSP.seteHandStrength(eHandStrength.Pair);
			HSP.setKickers(FindTheKickers(this.getCRC()));
		} else
		{
			HSP.seteHandStrength(eHandStrength.HighCard);
			HSP.setKickers(FindTheKickers(this.getCRC()));
		}
		
		

		return (HandScorePoker) this.getHS();
	}

	public boolean isRoyalFlush() {
		return this.isStraightFlush() && super.getCards().get(0).geteRank() == eRank.ACE && super.getCards().get(1).geteRank() == eRank.KING;
	}

	public boolean isStraightFlush() {
		return this.isFlush() && this.isStraight();
	}
	
	// DONE in Master : Implement this method
	public boolean isFourOfAKind() {
		boolean bisFourOfAKind = false;
		if (this.getCRC().size() == 2) {
			if (this.getCRC().get(0).getiCnt() == Constants.FOUR_OF_A_KIND) {
				bisFourOfAKind = true;
			}
		}
		return bisFourOfAKind;
	}

	// DONE : Implement this method
	public boolean isFullHouse() {
		return (this.getCRC().size() == 2 &&
				this.getCRC().get(0).getiCnt() == Constants.THREE_OF_A_KIND &&
				this.getCRC().get(1).getiCnt() == Constants.TWO_OF_A_KIND);
	}

	public boolean isFlush() {
		boolean bisFlush = false;

		int iCardCnt = super.getCards().size();
		int iSuitCnt = 0;

		for (eSuit eSuit : eSuit.values()) {
			for (Card c : super.getCards()) {
				if (eSuit == c.geteSuit()) {
					iSuitCnt++;
				}
			}
			if (iSuitCnt > 0)
				break;
		}

		if (iSuitCnt == iCardCnt)
			bisFlush = true;
		else
			bisFlush = false;

		return bisFlush;
	}

	public boolean isStraight() {
		boolean bisStraight = true;
		int i = 0;
		
		if(super.getCards().get(0).geteRank() == eRank.ACE && super.getCards().get(1).geteRank() == eRank.FIVE)
		{
			i++;
		}
		
		for(; i < super.getCards().size()-1; i++)
		{
			if(super.getCards().get( i).geteRank().getiRankNbr() - 1 != super.getCards().get(i+1).geteRank().getiRankNbr())
			{
				bisStraight = false;
				break;
			}
				
		}
		return bisStraight;
	}

	// This is how to implement one of the 'counting' hand types. Testing to see if
	// there are three of the same rank.
	public boolean isThreeOfAKind() {
		boolean bisThreeOfAKind = false;
		if (this.getCRC().size() == 3) {
			if (this.getCRC().get(0).getiCnt() == Constants.THREE_OF_A_KIND) {
				bisThreeOfAKind = true;
			}
		}
		return bisThreeOfAKind;
	}
	

	public boolean isTwoPair() {
		boolean bisTwoPair = false;
		if (this.getCRC().size() == 3) 
		{
			if (this.getCRC().get(0).getiCnt() == 2 && 
				this.getCRC().get(1).getiCnt() == 2)
				{
					bisTwoPair = true;
				}
		}
		return bisTwoPair;
	}

	public boolean isPair() {
		boolean bisPair = false;
		// DONE : Implement this method
		if (this.getCRC().size() == 4) {
			if (this.getCRC().get(0).getiCnt() == Constants.TWO_OF_A_KIND) {
				bisPair = true;
			}
		}
		return bisPair;
	}

	public boolean isHighCard() {
		boolean bisHighCard = false;
		// DONE : Implement this method
		if (this.getCRC().size() == 5) {
			if (this.getCRC().get(0).getiCnt() == Constants.ONE_OF_A_KIND) {
				bisHighCard = true;
			}
		}
		return bisHighCard;
	}

	private ArrayList<Card> FindTheKickers(ArrayList<CardRankCount> CRC) {
		ArrayList<Card> kickers = new ArrayList<Card>();

		for (CardRankCount crcCheck : CRC) {
			if (crcCheck.getiCnt() == 1) {
				kickers.add(this.getCards().get(crcCheck.getiCardPosition()));
			}
		}

		return kickers;
	}

	private void Frequency() {
		CRC = new ArrayList<CardRankCount>();
		int iCnt = 0;
		int iPos = 0;
		for (eRank eRank : eRank.values()) {
			iCnt = (CountRank(eRank));
			if (iCnt > 0) {
				iPos = FindCardRank(eRank);
				CRC.add(new CardRankCount(eRank, iCnt, iPos));
			}
		}
		Collections.sort(CRC);
	}

	private int CountRank(eRank eRank) {
		int iCnt = 0;
		for (Card c : super.getCards()) {
			if (c.geteRank() == eRank) {
				iCnt++;
			}
		}
		return iCnt;
	}

	private int FindCardRank(eRank eRank) {
		int iPos = 0;

		for (iPos = 0; iPos < super.getCards().size(); iPos++) {
			if (super.getCards().get(iPos).geteRank() == eRank) {
				break;
			}
		}
		return iPos;
	}

}
