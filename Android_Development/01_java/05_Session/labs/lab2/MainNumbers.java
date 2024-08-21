class MainNumbers{
    public static void main(String[] args){
        // byTwos two = new byTwos();
        // two.setStart(10);
        // for(int i = 1 ; i <= 5 ; i++){
        //     System.out.println(two.getNext());
        // }
        // two.reset();
        // System.out.println(two.getNext());     
        
        Numbers num ; 
        byThrees three = new byThrees();
        byTwos two = new byTwos();

        num = two ;
        num.setStart(10);
        num = three ;
        num.setStart(0);
        

        three.setStart(10);
        for(int i = 1 ; i <= 5 ; i++){
            num = two ;
            System.out.println(num.getNext());
            num = three ;
            System.out.println(num.getNext());
        }

        num = two ;
        num.reset();
        System.out.println(three.getNext());
        num = three ;
        num.reset();
        System.out.println(three.getNext());
      
        

    }
}