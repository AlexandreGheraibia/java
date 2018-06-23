package fr.m2i.alex.po;

import java.util.Scanner;

public class Main {
	/*
	 * priorite calcul la prioritée des operateurs mathematique 
	 * de base
	 * */
	public static void affiche(int n) {
		for(int i=0;i<n;i++) {
			System.out.print(" ");         
		}
	}
	public static double priopOperateur(String saisie,int n){                                                        
		String[] result=saisie.split("[+]");                  
		double somme=0;
		if( n>1 )System.out.print("\t");  
		if(result.length>1) { 


			for(int i=0;i<result.length;i++) {
				if(i>0)
					System.out.print("+\n");
				somme+=priopOperateur(result[i],n+1);          
			}
			System.out.println();
		} 
		else {                                                                                                                                                                                                                        
			result=saisie.split("[-]");                                                                                                                                                                              

			if(result.length>1) {

				somme=priopOperateur(result[0],n+1);                    																									

				for(int i=1;i<result.length;i++) {
					System.out.println("-");
					somme-=priopOperateur(result[i],n+1);                                                                                                                                         
				}
				System.out.println();
			}
			else{somme=1;
			result=saisie.split("[*]");
			if(result.length>1) {

				for(int i=0;i<result.length;i++) {

					if(i>0)
						System.out.println("\t*\n");
					System.out.print("\t");
					somme*=priopOperateur(result[i],n+1);
				}
				System.out.println();
			}else 
			{result=saisie.split("[/]");
			if(result.length>1) {
				System.out.print("\t");
				somme=priopOperateur(result[0],n+1);
				for(int i=1;i<result.length;i++) {
					System.out.println("\t/");
					System.out.print("\t");
					somme/=priopOperateur(result[i],n+1);

				}
				System.out.println();

			}                                                                                                                                                                                                          
			else {

				System.out.println(saisie);
				return (double)Double.parseDouble(saisie);                     
			}
			}
			}
		}

		return somme;                                                        
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String saisie;
		// TODO Auto-generated method stub
		do {
			System.out.println("Entrer une expression");
			saisie=sc.nextLine();
			if(!saisie.equals("fin"))
				System.out.println(priopOperateur(saisie,0));
		}while(!saisie.equalsIgnoreCase("fin"));

	}

}
