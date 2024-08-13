import java.util.Random;

public class VirtualElectionSimulation {
		public static void main(String[] args) {
				String[] candidates = {"이재명", "윤석열", "심상정", "안철수"};
				int[] votes = new int[candidates.length];
				int totalVotes = 10000;

				Random random = new Random();

				for (int i = 0; i < totalVotes; i++) {
						int randomNumber = random.nextInt(4); // 0~3 사이의 임의번호 생성
						votes[randomNumber]++;
				}

				// Ensure no tie for the winner
				int maxVotes = 0;
				for (int i = 0; i < votes.length; i++) {
						if (votes[i] > maxVotes) {
								maxVotes = votes[i];
						}
				}
				for (int i = 0; i < votes.length; i++) {
						if (votes[i] == maxVotes) {
								votes[i]++;
								break;
						}
				}

				System.out.println("가상 대선 결과:");
				for (int i = 0; i < candidates.length; i++) {
						System.out.println((i + 1) + "번 " + candidates[i] + ": " + votes[i] + "표");
				}
		}
}