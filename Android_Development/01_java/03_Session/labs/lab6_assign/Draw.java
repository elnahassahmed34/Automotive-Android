class Pattern {
	public static void main (String[] args){
		String str1 = new String("*");
		String str2 = new String("          *");
String str=str1;
String strr=str2;
	for (int i =0;i<5;i++)
	{
		System.out.println(str + strr);
		str+=str1;
		strr=strr.substring(2);
		strr+=" *";
	}		
	}	
}