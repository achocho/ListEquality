package voting;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		List<Vote> votes = new ArrayList<>();

		Scanner sc1 = new Scanner(System.in);
		boolean Form = true;
		Scanner sc = new Scanner(System.in);
		
br:
		while (Form) {
			
			System.out.println("Enter name!");

			String name = sc1.nextLine();
			System.out.println("Enter Egn!");
			String Egn = sc1.nextLine();
			for(int i=0;i<votes.size();i++) 
			{
				if(Egn.equals(votes.get(i).getEgn())) 
				{
				System.out.println("This person already voted");
				System.out.println();
				continue br;
				}
				
			}
			System.out.println("Enter vote!");
			int vote = sc.nextInt();
			votes.add(new Vote(name, Egn, vote));
			System.out.println("------------------------");
			System.out.println("Voted!!!");
			System.out.println("------------------------");
			System.out.println("Do you want to exit?");
			String exit = sc1.nextLine();
			if (exit.equalsIgnoreCase("yes")) {
				Form = false;
			}
		}


		

		
		int[][] vot = Votes(votes);

		System.out.println("Voted for :");
		System.out.println();
		System.out.println("--------------------------");
		for (int i = 0; i < vot.length; i++) {

			if (vot[i].length != 1) {
				System.out.println("Option " + vot[i][0] + " :" + vot[i].length + " votes");
			} else {
				System.out.println("Option " + vot[i][0] + " :" + vot[i].length + " vote");

			}
			System.out.println("--------------------------");

		}
Winner(vot);
		

	}

	public static int[][] Votes(List<Vote> list) {
		List<Integer> vote = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			vote.add(list.get(i).getVote());

		}
		int buff = 0;
		for (int i = 0; i < vote.size() - 1; i++) {
			for (int j = 0; j < vote.size() - 1; j++) {
				int vote1 = vote.get(j);
				int vote2 = vote.get(j + 1);
				if (vote1 > vote2) {
					buff = vote1;
					vote.set(j, vote2);
					vote.set(j + 1, buff);

				}

			}

		}

		int size = 1;
		for (int i = 0; i < vote.size() - 1; i++) {

			if (vote.get(i) != vote.get(i + 1)) {
				size++;

			}

		}
		int size1 = 0;
		int temCurr = vote.get(0);
		int temSize = 0;
		int[] sizes = new int[size];
		int s3 = 0;
		while (temSize < vote.size()) {
			if (temCurr == vote.get(temSize)) {
				temSize++;
				size1++;
				sizes[s3] = size1;
			} else {
				size1 = 0;
				s3++;
				temCurr = vote.get(temSize);
			}
		}

		int currSize = 0;
		int[][] eq = new int[size][];
		for (int i = 0; i < eq.length; i++) {
			eq[i] = new int[sizes[i]];

		}
		int s1 = 0;
		int s2 = 0;
		int curr = vote.get(0);
		while (currSize < vote.size()) {
			if (curr == vote.get(currSize)) {

				eq[s1][s2] = vote.get(currSize);

				currSize++;
				s2++;
			} else {
				s2 = 0;
				s1++;

				curr = vote.get(currSize);
			}
		}

		return eq;

	}
public static void Winner(int[][] vot) 
{
	int[] sizes = new int[vot.length];
	int[] els = new int[vot.length];
	for (int i = 0; i < vot.length; i++) {
		sizes[i] = vot[i].length;
		els[i] = vot[i][0];
	}

	int buff = 0;
	int buff1 = 0;
	for (int i = 0; i < sizes.length - 1; i++) {
		for (int j = 0; j < sizes.length - 1; j++) {
			int l1 = sizes[j];
			int l2 = sizes[j + 1];
			if (l1 > l2) {
				buff1 = els[j];
				els[j] = els[j + 1];
				els[j + 1] = buff1;
				buff = l1;
				sizes[j] = l2;
				sizes[j + 1] = buff;

			}

		}

	}
	int len1 = 0;
	for (int i = 0; i < sizes.length; i++) {
		if (len1 < sizes[i]) {
			len1 = sizes[i];

		}

	}
	int Min = 0;
	for (int i = 0; i < sizes.length; i++) {
		if (len1 == sizes[i]) {
			Min = i;
			
			break;
		}

	}
	int Max = 0;
	for (int i = Min; i < sizes.length - 1; i++) {
		if (sizes[i] == sizes[i + 1]) {
			Max = i;

		}

	}

	boolean rem = false;

	if (len1 > sizes[Max]) {
		rem = false;

	} else if (len1 == sizes[Max] && sizes.length > 1) {
		rem = true;

	}
	List<Integer> equals = new ArrayList<>();

	if (rem) {
		for (int i = Min; i < vot.length; i++) {
			equals.add(els[i]);

		}
		System.out.print("Equality between: ");
		for (int i = 0; i < equals.size() - 1; i++) {
			System.out.print(equals.get(i) + "-");

		}
		System.out.print(equals.get(equals.size() - 1));
		if(len1!=1) {
		System.out.print(" with " + len1 + " votes");
		}else 
		{
			System.out.print(" with " + len1 + " vote");
		}
	} else {
		if(len1!=1) {
		System.out.println("The winner is " + els[els.length - 1] + " with " + len1 + " votes");
		}else 
		{
			System.out.println("The winner is " + els[els.length - 1] + " with " + len1 + " vote");
			
		}
	}	
}
}