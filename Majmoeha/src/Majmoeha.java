import java.util.Scanner;

public class Majmoeha {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
//		sc.nextLine();
//		String phrase = sc.nextLine();
		String phrase="";
		for(int i=1;i<=N;i++) {
			phrase+=i+" ";
		}
		String[] ozv= phrase.split(" ");
		int[] donbale=new int[(int)Math.pow(2, N)];
		donbale[0]=0;
		int y=0;
		for(int i=(int)Math.pow(2, y)-1;y<N;y++) {
			for(int j=0;j<(int)Math.pow(2, y);j++) {
				if(i!=(int)Math.pow(2, y+1)-2) {
					donbale[i]=donbale[j]+(int)Math.pow(2, y);
				}else {
					donbale[i]=(int)Math.pow(2, y);
				}
				i++;
			}
		}
		donbale[(int)Math.pow(2, N)-1]=0;
		if(N!=1) {
			zirMajmoe(donbale, donbale.length-1, ozv);
		}else {
			System.out.println("{}\n{"+ozv[0]+"}");
		}
	}
	public static void zirMajmoe(int [] donbale,int i,String[] ozv) {
		if(i==-1) {
			return;
		}else {
			String binary=mabna(donbale[i], 2, "");
			String temp;
			if(binary.length()<=ozv.length) {
				temp=binary;
				binary="";
				int j=0;
				while(j< ozv.length-temp.length()) {
					binary+=0;
					j++;
				}
				binary+=temp;
			}
			System.out.print("{");
			int count=0;
			for(int j=0;j<binary.length();j++) {
				if(binary.charAt(j)=='1') {
					count++;
				}
			}
			int counter=0;
			String[] Temp=new String[binary.length()];
			for(int j=0;j<binary.length();j++) {
				if(binary.charAt(j)=='1') {
					System.out.print(ozv[j]);
					counter++;
					if(counter!=count) {
						System.out.print(", ");
					}
				}
			}
			System.out.print("}\n");
			zirMajmoe(donbale,i-1,ozv);
		}
	}
	public static String mabna(int a, int c, String x) {
		if (a / c < c) {
			x += a / c;
			x += a % c;
			return x;
		} else {
			x += mabna(a / c, c, x);
			x += a % c;
			return x;
		}
	}
}
