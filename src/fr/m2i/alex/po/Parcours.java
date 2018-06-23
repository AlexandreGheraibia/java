package fr.m2i.alex.po;

public class Parcours {
	static String[] symb= {"c","a","r","r","e"};
	public static void triangleRec(int n) {
		for (int j = 0; j < n; j++) {
			for (int i = 0; i <= j; i++) {
				System.out.print("*");
			}
			System.out.println(" ");
		}
	}

	public static void triangleRecI(int n) {
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < n - j; i++) {
				System.out.print(symb[i%4]);
			}
			System.out.println("");
		}
	}

	public static void triangleEqui(int n, int decal, boolean estNonVide) {
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < n - j + decal; i++) {
				System.out.print(" ");
			}
			System.out.print("*");
			for (int i = 0; i < 2 * j; i++) {
				if (estNonVide || i == (2 * j - 1)) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}

			}
			System.out.println("");
		}
	}
	public static void triangleEquiI(int n, int decal, boolean estNonVide) {
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < j + 1 + decal; i++) {
				System.out.print(" ");
			}

			for (int i = 0; i < 2 * (n - j) - 1; i++) {
				if (estNonVide || (i == 0 || i == 2 * (n - j) - 2)) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}

			}

			System.out.println("");

		}
	}
	public static void triangleEquiM(int n,int m, int decal, boolean estNonVide) {
		
		triangleEquiM(n,m,0,decal, estNonVide);
		
	}
	public static void triangleEquiM(int n,int m,int trans, int decal, boolean estNonVide) {
		
		for (int j = 0; j < n; j++) {
			for(int k=0;k<m;k++) {
				for (int i = 0; i < n - j + (k>0?0:decal); i++) {
					System.out.print(" ");
				}
				System.out.print("*");
				for (int i = 0; i < 2 * j; i++) {
					if (estNonVide || i == (2 * j - 1)) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
	
				}
				for (int i =  n - j -1+trans; i>0; i--) {
					System.out.print(" ");
				}
				
			}
			System.out.println("");
		}
	
}

	public static void triangleEquiIM(int n,int m, int decal, boolean estNonVide) {
		 triangleEquiIM(n,m,0,decal, estNonVide);
	}
	public static void triangleEquiIM(int n,int m,int trans, int decal, boolean estNonVide) {
		for (int j = 0; j < n; j++) {
			for(int k=0;k<m;k++) {
				for (int i = 0; i < j + 1 + (k>0?0:decal); i++) {
					System.out.print(" ");
				}
	
				for (int i = 0; i < 2 * (n - j) - 1; i++) {
					if (estNonVide || (i == 0 || i == 2 * (n - j) - 2)) {
						System.out.print(symb[j%5]);
					} else {
						System.out.print(" ");
					}
	
				}
				for (int i = j+trans  ; i >0 ; i--) {
					System.out.print(" ");
				}
			}
			System.out.println("");

		}
	}

	public static void losangeCroissant(int n,boolean sap) {
		for(int i=1;i<=n;i++)
		losangeM(n-1,i,0,n*(n-i+1),i%(n+1)!=1||sap,i%n==0||sap);
	}
	public static void losangeDecroissant(int n,boolean sap) {
		for(int i=n;i>=0;i--)
		losangeM(n-1,i,0,n*(n-i+1),i%(n+1)!=1||sap,i%n==0||sap);
	}

	public static void losange(int n, int decal, boolean estNonVideH, boolean estNonVideB) {
		losangeM(n,1,0,decal,estNonVideH,estNonVideB);
	}
	
	public static void losange(int n, int decal, boolean estNonVide) {
		losangeM(n,1,0,decal,estNonVide,estNonVide);
	}
	
	public static void losangeM(int n,int m,int trans, int decal, boolean estNonVideH,boolean estNonVideB) {
		if (estNonVideB) {
			triangleEquiM(n,m,2+trans, 1 + decal, estNonVideH);
			triangleEquiIM(n+1,m,trans, decal, estNonVideB);
		} else {
			triangleEquiM(n + 1,m,trans, decal, estNonVideH);
			triangleEquiIM(n,m,2+trans, decal +1, estNonVideB);
		}
	}
	
	public static void losangeM(int n,int m,  int decal, boolean estNonVide) {
		losangeM(n,m,0,decal,estNonVide,estNonVide);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	triangleRec(5);
		System.out.println(" ");
		triangleRecI(3);
		System.out.println(" ");
		triangleEqui(6, 0, true);
		System.out.println(" ");
		triangleEquiI(6, 0, true);
		System.out.println(" ");
		losange(6, 0, false, true);
		losange(12, 6, true, false);
		losange(12, 18, false);
		System.out.println(" ");
		losange(12, 18, true);
		System.out.println(" ");
		triangleEquiM(5,10,10, false);
		triangleEquiIM(5,10, 10,false);
		System.out.println(" ");
		losangeM(5,10, 10,false);
		losangeM(5,10,0, 10,true,false);
		losangeM(5,10,0, 10,false,true);
		losangeM(5,10,0, 16,true,false);
		System.out.println(" ");
		losangeM(5,10,5, 0,false,true);
		losangeM(0,5,15, 10,true,true);*/
		losangeCroissant(5,true);
		losangeDecroissant(5,true);
		
	}


}
