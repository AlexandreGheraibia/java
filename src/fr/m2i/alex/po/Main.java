package fr.m2i.alex.po;

import java.util.Scanner;

public class Main {
	public static double priopOperateur(String saisie){                                                        
		String[] result=saisie.split("[+]");                  
		double somme=0;
		if(result.length>1) {                                 
			for(int i=0;i<result.length;i++) {

				somme+=priopOperateur(result[i]);          
			}
		} 
		else {                                                                                                                                                                                                                        
			result=saisie.split("[-]");                                                                                                                                                                              

			if(result.length>1) {
				somme=priopOperateur(result[0]);                    																									

				for(int i=1;i<result.length;i++) {
					somme-=priopOperateur(result[i]);                                                                                                                                         
				}
			}
			else{somme=1;
			result=saisie.split("[*]");
			if(result.length>1) {
				for(int i=0;i<result.length;i++) {
					somme*=priopOperateur(result[i]);
				}
			}else 
			{result=saisie.split("[/]");
			if(result.length>1) {
				somme=priopOperateur(result[0]);
				for(int i=1;i<result.length;i++) {
					somme/=priopOperateur(result[i]);

				}

			}                                                                                                                                                                                                          
			else {                                                                                                                                          

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
				System.out.println(priopOperateur(saisie));
		}while(!saisie.equalsIgnoreCase("fin"));

	}

}
