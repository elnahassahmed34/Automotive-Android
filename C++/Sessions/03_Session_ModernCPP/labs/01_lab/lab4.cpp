#include <iostream>

//name space DynamicAlloc
//create 2d array insid -> size and allocte the them
//delete 2d array insid -> size and allocte the them

using namespace std ;

namespace DynamicAllocation{
    int ** Create2DArray(int size){
        int ** ptr2D = new int * [size] ;
        for(int i = 0 ; i<size ; i++){
            ptr2D[i] = new int[size] ;
            cout << "array no :" << i  <<" created" << endl;
        }
        return ptr2D ;
    }
    void Delete2DArray(int ** ptr2d , int size){
        
        for(int i = 0 ; i<size ; i++){
            delete[] ptr2d[i] ;       
            cout << "array no :" << i << " delete" << endl;
        }
        
        delete[] ptr2d ;
    }
}


int main(){

    int size = 5 ;

    int ** ptr2d = DynamicAllocation::Create2DArray(size);
    DynamicAllocation::Delete2DArray(ptr2d , size);


    return 0 ;
}