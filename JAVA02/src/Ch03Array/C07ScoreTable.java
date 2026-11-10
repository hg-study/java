package Ch03Array;

import java.util.Scanner;

// =======================================
// 성적표 문제
// 2차원 배열로 학생별, 과목별 합계와 평균
// =======================================

public class C07ScoreTable {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 문제 ------
		// 5명의 학생에 대해 국어, 영어, 수학 점수를 입력받아 2차원 배열에 저장하고
		// 1) 학생별 합계와 평균, 2) 과목별 합계와 평균을 구하는 문제
		int[][] scores = new int[5][3];		// 행(0-4)은 학생, 열(0-2)은 국어(0) 영어(1) 수학(2)

		// 입력 : 바깥 반복은 학생, 안쪽 반복은 과목
		for (int i = 0; i<scores.length; i++) {
			System.out.printf("%d번째 학생 국영수 점수 입력: ", i+1);
			for(int j=0; j<scores[i].length; j++) {
				scores[i][j] = sc.nextInt();
			}
		}

		// 학생별 합계와 평균 ------
		// 한 학생의 과목 점수를 모두 더하고, 평균은 과목 수(scores[i].length)로 나눔
		int students_sum[] = new int[5];
		double students_avg[] = new double[5];

		for(int i=0; i<scores.length; i++) {
			int sum = 0;

			for(int j=0; j<scores[i].length; j++) {
				sum+=scores[i][j];
			}

			students_sum[i] = sum;
			students_avg[i] = (double) sum / scores[i].length;

			System.out.println((i+1)+"번째 학생 국영수 점수 합: "+students_sum[i]);
			System.out.println((i+1)+"번째 학생 국영수 평균: "+students_avg[i]);
		}

		// 과목별 합계와 평균 ------
		// 같은 열의 점수를 학생 수만큼 더하고, 평균은 학생 수(scores.length)로 나눔
		String subjects[] = {"국어", "영어", "수학"};
		int subjectSum[] = new int[3];

		for(int i=0; i<scores.length; i++) {
			for(int j=0; j<scores[i].length; j++) {
				subjectSum[j] += scores[i][j];
			}
		}

		for(int j=0; j<subjectSum.length; j++) {
			System.out.println(subjects[j]+" 총점: "+subjectSum[j]);
			System.out.println(subjects[j]+" 평균: "+(double) subjectSum[j] / scores.length);
		}

		sc.close();
	}

}
