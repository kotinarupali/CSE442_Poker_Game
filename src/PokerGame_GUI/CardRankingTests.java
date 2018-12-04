package AllTestsCases;

import java.io.File;

public class CardRankingTests {
	enum rankings {
		RoyalFlush, StraighFlush, fOUR_of_A_King, Full_house, Flush, Straight, ThreeOf_A_Kind, Two_Pair, One_Pair,
		High_Card
	};

	public static void main(String[] args) {
		for (rankings r : rankings.values()) {
			getRanking(r);
		}
	}

	public static void getRanking(rankings ranking) {
		File dir = new File("C:\\Users\\bing\\eclipse-workspace\\Sprint3_Updated4\\src\\Ranking_PNG");
		switch (ranking) {
		case RoyalFlush:

			File r = new File(
					"C:\\Users\\bing\\eclipse-workspace\\Sprint3_Updated4\\src\\Ranking_PNG\\royal_flush.png");

			if (r.exists() && r.isFile() && dir.isDirectory() && dir.exists()) {
				System.out.println("1: royal_flush(Best Hand possible)");
			}
			break;
		case StraighFlush:

			File sf = new File(
					"C:\\Users\\bing\\eclipse-workspace\\Sprint3_Updated4\\src\\Ranking_PNG\\straight_flush.png");

			if (sf.exists() && sf.isFile() && dir.isDirectory() && dir.exists()) {
				System.out.println("2: Straight Flush");
			}

			break;

		case fOUR_of_A_King:

			File fa = new File(
					"C:\\Users\\bing\\eclipse-workspace\\Sprint3_Updated4\\src\\Ranking_PNG\\four_of_a_kind.png");

			if (fa.exists() && fa.isFile() && dir.isDirectory() && dir.exists()) {
				System.out.println("3: Four of A kind");
			}

			break;
		case Full_house:

			File fh = new File(
					"C:\\Users\\bing\\eclipse-workspace\\Sprint3_Updated4\\src\\Ranking_PNG\\Full_House.png");

			if (fh.exists() && fh.isFile() && dir.isDirectory() && dir.exists()) {
				System.out.println("4: Full House");
			}

			break;
		case Flush:

			File fss = new File("C:\\Users\\bing\\eclipse-workspace\\Sprint3_Updated4\\src\\Ranking_PNG\\Flush.png");

			if (fss.exists() && fss.isFile() && dir.isDirectory() && dir.exists()) {
				System.out.println("5: Flush");
			}

			break;
		case Straight:

			File st = new File("C:\\Users\\bing\\eclipse-workspace\\Sprint3_Updated4\\src\\Ranking_PNG\\Straight.png");

			if (st.exists() && st.isFile() && dir.isDirectory() && dir.exists()) {
				System.out.println("6: Straight");
			}

			break;
		case ThreeOf_A_Kind:

			File thr = new File(
					"C:\\Users\\bing\\eclipse-workspace\\Sprint3_Updated4\\src\\Ranking_PNG\\three_of_a_kind.png");

			if (thr.exists() && thr.isFile() && dir.isDirectory() && dir.exists()) {
				System.out.println("7: Three of A Kind");
			}

			break;
		case Two_Pair:

			File two = new File("C:\\Users\\bing\\eclipse-workspace\\Sprint3_Updated4\\src\\Ranking_PNG\\two_pair.png");

			if (two.exists() && two.isFile() && dir.isDirectory() && dir.exists()) {
				System.out.println("8: Two Pair");
			}

			break;
		case One_Pair:

			File one_pair = new File(
					"C:\\Users\\bing\\eclipse-workspace\\Sprint3_Updated4\\src\\Ranking_PNG\\one_pair.png");

			if (one_pair.exists() && one_pair.isFile() && dir.isDirectory() && dir.exists()) {
				System.out.println("9: One Pair");
			}

			break;
		case High_Card:

			File hc = new File("C:\\Users\\bing\\eclipse-workspace\\Sprint3_Updated4\\src\\Ranking_PNG\\High_Card.png");

			if (hc.exists() && hc.isFile() && dir.isDirectory() && dir.exists()) {
				System.out.println("10: High Card");
			}

			break;
		default:

		}
	}
}
