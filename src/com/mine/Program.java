package com.mine;

import java.io.BufferedReader;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStreamReader;

public class Program {
	
	public static void main(String[] args) throws IOException{
//		String[] arr ={"aaa","def","bbb","abc","bcd","deg"};
//		String[] arr ={"aaa","de","bbb","ab","bcd","deg"};
//		String[] arr = {"aa","ab","ac","ad"	,"af","aj","ak"};
//		String[] arr ={"aa","ab","ac","ad","da"};
		String[] arrItems;// = {"ba","ca","cb","cx"};
		String[] param=null;
		
		String fileSource = args[0]+args[1];
		int N = Integer.parseInt(args[2]);
		FileInputStream fileInput = new FileInputStream(fileSource);;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInput));
		
		String line = bufferedReader.readLine();
		param = line.split(",");
		arrItems = new String[param.length];
		
		
		//Split the elements from the given file and store it into the array
		for(int paramIndex=0;paramIndex<param.length ;paramIndex++){
			if(paramIndex==0){
				arrItems[paramIndex]= (param[paramIndex].substring(2,param[paramIndex].length()-2));
			}
			else if(paramIndex==param.length-1){
				arrItems[paramIndex]= (param[paramIndex].substring(1,param[paramIndex].length()-3));
			}
			else{
				arrItems[paramIndex]= (param[paramIndex].substring(1,param[0].length()-2));
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
		
		// Displays the sorted Array
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
					//System.out.println();					
					while(strIndex < arrItems[lfI].length() || strIndex < arrItems[rfI].length()){
						
						if((arrItems[rfI].charAt(strIndex) - arrItems[iIndex].charAt(strIndex))==(arrItems[iIndex].charAt(strIndex)-arrItems[lfI].charAt(strIndex))){
								
								strIndex++;
//								rfI++;tempN++;
								
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
							//continue;
						}
					}
					 if(lfI>=0 && rfI<arrLen && arrItems[lfI].length()==arrItems[rfI].length() && strIndex==arrItems[rfI].length()){
						 System.out.print(arrItems[rfI]+",");
							rfI++;tempN++;
							strIndex=0;
//							break;
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
	


