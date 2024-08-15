class Main{
    public static void main(String[] args){
        String str1 ;
        str1 = new String("Hello");
        String str2 = new String("HI");

        String s = str1 ;
        str1 = null ;
        s = null ;
        //throw null pointer exception
        str1.length();
    }
}