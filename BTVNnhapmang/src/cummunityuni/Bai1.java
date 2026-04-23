package cummunityuni;
import java.util.*;
public class Bai1 {

	public static void main(String[] args) {
		System.out.println("Nhap kich thuc mang");
		Scanner sc=new Scanner(System.in);
		
			int n = 0;
			 n= sc.nextInt();
			int[] a =new int[n];
			
			int tong=0,tam=0;
			int k=0,dem=0;
			int solonnhat=0,sonhonhat=100000;
			try
			{
				for(int i=0;i<n;i++)
				{
					a[i]=sc.nextInt();
					
				}
				
				System.out.println("Nhap k");
				k = sc.nextInt();
				
				System.out.println("Mang vua nhap la");
				
				 for(int i = 0;i<n;i++)
				   {
						  System.out.println(a[i]);
						  tong +=a[i];
						  if(a[i]==k)
						  {
							  dem++;
						  }
						  if(a[i]>solonnhat)
						  {
							  solonnhat=a[i];
						  }
						  if(a[i]<sonhonhat)
						  {
							  sonhonhat=a[i];
						  }
				   }
				  
				   System.out.printf("tong mang: " + tong);
				  
			      
			  	System.out.println( "\n" + k + " xuat hien: " + dem);
			  	System.out.printf("Số lớn nhất là: " + solonnhat);
			  	System.out.printf("\nSố nhỏ nhất là: " + sonhonhat);
				System.out.println("\n Cac so nguyen to trong mang:");
			  	for (int i = 0 ; i < n; i++)
				{
				    if (isPrime(a[i])) {
				        System.out.print(a[i] + " ");
				    }
				}
			  	
			  	 for(int i = 0;i<n;i++)
				   {
					   if(a[i]>a[i++])
					   {
						   a[i]=tam;
		                   a[i+1]=a[i];
		                   tam=a[i+1];
					   }
					   System.out.println("" + a[i]);
				   }
			 	System.out.println("\n tang dan");
			  	SelectionSorttangdan(a);
			  	System.out.println("\n giam dan");
			  	SelectionSortgiamdan(a);
					
				}
				catch(InputMismatchException e) 
				{
					System.out.println("Kich thuoc mang phai >0");
				}
	  
	        
		}
		public static boolean isPrime(int n) 
		{
		    if (n < 2) return false;

		    for (int i = 2; i <= Math.sqrt(n); i++) {
		        if (n % i == 0) {
		            return false;
		        }
		    }
		    return true;
		}
		
		public static void SelectionSorttangdan(int []a)
		{
			int min;
			for(int i=0;i<a.length;i++)
			{
			min = i;
				for(int j=i+1;j<a.length;j++)
				{
					if (a[j] < a[min])
					min = j;
				}
				if(min!=i)
				{
					int temp = a[i];
					a[i] = a[min];
					a[min] = temp;
				}
			    System.out.println("  " + a[i] );

			}
			
		}
		
		public static void SelectionSortgiamdan(int []a)
		{
			int min;
			for(int i=0;i<a.length;i++)
			{
			min = i;
				for(int j=i+1;j<a.length;j++)
				{
					if (a[j] > a[min])
					min = j;
				}
				if(min!=i)
				{
					int temp = a[i];
					a[i] = a[min];
					a[min] = temp;
				}
			    System.out.println("  " + a[i] );

			}
			
		}
		
	}
