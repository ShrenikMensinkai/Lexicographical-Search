package com.mine;

public class Program {
	
	public static void main(String[] args)
	{
		//String[] arr ={"aaa","def","bbb","abc","bcd","deg"};
		//String[] arr ={"aaa","de","bbb","ab","bcd","deg"};
//		String[] arr = {"aa","ab","ac","ad"	,"af","aj","ak"};
		//String[] arr ={"aa","ab","ac","ad","da"};
		String[] arr = {"ba","ca","cb","cx"};
		
		
		
		int arrLen = arr.length,N=2;
		
	
		for(int i=0;i<arrLen;i++)
		{
			for(int j=0;j<arrLen;j++)
			{
				if(arr[i].compareToIgnoreCase(arr[j])<0)
				{
					String temp = arr[j];
					arr[j]=arr[i];
					arr[i]=temp;
				}
			}
		}
		for (String string : arr) 
		{
			System.out.println(string);
		}
		
		for(int iIndex = 0;iIndex<arrLen;iIndex++)
		{
			
			System.out.println();
			if(iIndex==0)
			{
				System.out.print("The closest "+N+" items for "+arr[iIndex]+" is ");
				for(int j=iIndex+1;j<=N;j++)
				{
					System.out.print(arr[j]+",");
				}
			} 

			else if(iIndex==arrLen-1)
			{
				System.out.print("The closest "+N+" items for "+arr[iIndex]+" is ");
					for(int j=iIndex-1;j>=(arrLen-N)-1;j--)
					{
						System.out.print(arr[j]+",");
					}
			}
			
			else if(iIndex>0 && iIndex<arrLen-1)
			{
				int lfI =iIndex-1,rfI=iIndex+1,tempN=0,strIndex=0;
				System.out.print("The closest "+N+" items for "+arr[iIndex]+" is ");
				while(lfI>=0 && rfI<=arrLen-1 && tempN<N)
				{
					//System.out.println();					
					while(strIndex < arr[lfI].length() || strIndex < arr[rfI].length())
					{
						
						if((arr[rfI].charAt(strIndex) - arr[iIndex].charAt(strIndex))==(arr[iIndex].charAt(strIndex)-arr[lfI].charAt(strIndex)))
						{
								
								strIndex++;
//								rfI++;tempN++;
								
						}
						else if( Math.abs((arr[rfI].charAt(strIndex)-arr[iIndex].charAt(strIndex))) < Math.abs((arr[iIndex].charAt(strIndex)-arr[lfI].charAt(strIndex))))
						{
							System.out.print(arr[rfI]+",");
							rfI++;tempN++;
							strIndex=0;
							break;
							
						}
						else if( Math.abs((arr[rfI].charAt(strIndex)-arr[iIndex].charAt(strIndex))) > Math.abs(arr[iIndex].charAt(strIndex)-arr[lfI].charAt(strIndex)))
						{
							System.out.print(arr[lfI]+",");
							lfI--;tempN++;
							strIndex=0;
							break;
							//continue;
						}
					}
					 if(lfI>=0 && rfI<arrLen && arr[lfI].length()==arr[rfI].length() && strIndex==arr[rfI].length()){
						 System.out.print(arr[rfI]+",");
							rfI++;tempN++;
							strIndex=0;
//							break;
					 }
					
					if(lfI==-1)
					{
						while(tempN<N)
						{
							System.out.print(arr[rfI]+",");
							rfI++;tempN++;
						}
					}
					else if(rfI==arrLen)
					{
						while(tempN<N)
						{
							System.out.print(arr[lfI]+",");
							lfI--;tempN++;
						}
					}

				}
			}
		}
	}
 }
	


