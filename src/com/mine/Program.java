package com.mine;

import java.io.BufferedReader;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStreamReader;

public class Program {
	
	public static void main(String[] args) throws IOException{
		String[] arrItems;
		String[] param=null;
		
		if(args.length<2){
			System.out.println("Please provide input file path and value of N");
			return;
		}		
		
		String fileSource = args[0];
		int N = Integer.parseInt(args[1]);
		FileInputStream fileInput = new FileInputStream(fileSource);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInput));
		
		String line = bufferedReader.readLine();
		param = line.split(",");
		arrItems = new String[param.length];
		if(N>(param.length-1)||N<1){
			System.out.println("Value of N should be between then 0 and" + (param.length)+ "for the given Input");
			return;
		}
		
		//Split the elements from the given file,convert to lower case and store it into the array
		for(int paramIndex=0;paramIndex<param.length ;paramIndex++){
			if(paramIndex==0){
				arrItems[paramIndex]= (param[paramIndex].substring(2,param[paramIndex].length()-1)).toLowerCase();
			}
			else if(paramIndex==param.length-1){
				arrItems[paramIndex]= (param[paramIndex].substring(1,param[paramIndex].length()-2)).toLowerCase();
			}
			else{
				arrItems[paramIndex]= (param[paramIndex].substring(1,param[paramIndex].length()-1)).toLowerCase();
			}
		}
		int arrLen = arrItems.length;
		
		
		//LexoGraphical Sorting
		for(int i=0;i<arrLen;i++){
			for(int j=0;j<arrLen;j++){
				if(arrItems[i].compareToIgnoreCase(arrItems[j])<0){
					String temp = arrItems[j];
					arrItems[j]=arrItems[i];
					arrItems[i]=temp;
				}
			}
		}
		
		// Sorted Array for the reference
		for (String string : arrItems){
			System.out.println(string);
		}
		
		// Algorithm Implementation 
		
		for(int iIndex = 0;iIndex<arrLen;iIndex++){
			
			System.out.println();
			if(iIndex==0){
				System.out.print("The closest "+N+" items for "+arrItems[iIndex]+" is ");
				for(int j=iIndex+1;j<=N;j++){
					System.out.print(arrItems[j]+",");
				}
			} 

			else if(iIndex==arrLen-1){
				System.out.print("The closest "+N+" items for "+arrItems[iIndex]+" is ");
					for(int j=iIndex-1;j>=(arrLen-N)-1;j--){
						System.out.print(arrItems[j]+",");
					}
			}
			
			else if(iIndex>0 && iIndex<arrLen-1){
				int lfI =iIndex-1,rfI=iIndex+1,tempN=0,strIndex=0;
				System.out.print("The closest "+N+" items for "+arrItems[iIndex]+" is ");
				while(lfI>=0 && rfI<=arrLen-1 && tempN<N){
									
					while(strIndex < arrItems[lfI].length() || strIndex < arrItems[rfI].length()){
						
						if((arrItems[rfI].charAt(strIndex) - arrItems[iIndex].charAt(strIndex))==(arrItems[iIndex].charAt(strIndex)-arrItems[lfI].charAt(strIndex))){
							strIndex++;
						}
						else if( Math.abs((arrItems[rfI].charAt(strIndex)-arrItems[iIndex].charAt(strIndex))) < Math.abs((arrItems[iIndex].charAt(strIndex)-arrItems[lfI].charAt(strIndex)))){
							System.out.print(arrItems[rfI]+",");
							rfI++;tempN++;
							strIndex=0;
							break;
						}
						else if( Math.abs((arrItems[rfI].charAt(strIndex)-arrItems[iIndex].charAt(strIndex))) > Math.abs(arrItems[iIndex].charAt(strIndex)-arrItems[lfI].charAt(strIndex))){
							System.out.print(arrItems[lfI]+",");
							lfI--;tempN++;
							strIndex=0;
							break;
						}
					}
					if(lfI>=0 && rfI<arrLen && arrItems[lfI].length()==arrItems[rfI].length() && strIndex==arrItems[rfI].length()){
						 System.out.print(arrItems[rfI]+",");
							rfI++;tempN++;
							strIndex=0;
					 }
					if(lfI==-1){
						while(tempN<N){
							System.out.print(arrItems[rfI]+",");
							rfI++;tempN++;
						}
					}
					else if(rfI==arrLen){
						while(tempN<N){
							System.out.print(arrItems[lfI]+",");
							lfI--;tempN++;
						}
					}
				}
			}
		}
	bufferedReader.close();
	fileInput.close();
	}
 }
	


