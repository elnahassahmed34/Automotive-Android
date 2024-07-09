#include <iostream>
#include <initializer_list>

class DynamicArray{

/*
        - Private members:
        * array - pointer to the array
        * capacity - capacity of the array
        * currentSize - current size of the array
*/
    int * arr ;
    int size = 0 ;
    int capacity = 0 ;
/*
* The following overload constructors:
        * DynamicArray() - default constructor with capacity of 1
*/
    DynamicArray(){
        arr = new int[size];
    }

/*
        * DynamicArray(size) - constructor with given capacity */
    DynamicArray(int size):capacity(0) , size(size) {
        capacity = size * 2 ;
        arr = new int[size];
    }


/*
        * DynamicArray(size, value) - constructor with given capacity and initial value for all elements --> DynamicArray arr(5, 10);
*/
    DynamicArray(int size , int value):capacity(0) , size(size){
        capacity = size * 2 ;
        arr = new int[size];
        for(int i = 0 ; i < size ; i++){
            arr[i] = value ;
        }
    }
/*
        * DynamicArray(size, values) - constructor with given capacity and initial values --> DynamicArray arr(5, new int[5]{1, 2, 3, 4, 5});
*/
    DynamicArray(int size , std::initializer_list<int> list):capacity(0) , size(size){
        capacity = size * 2 ;
        arr = new int[size];
        int i = 0 ;
        for(auto val : list ){
            arr[i] = val ;
            i++ ; 
        }
    }
/*
        * DynamicArray(arr) - copy constructor (deep copy)
*/  
    DynamicArray(const DynamicArray &obj){
        this->size = obj.size ; 
        this->capacity = obj.capacity ; 
        arr = new int[size] ;
        for (int i = 0; i < size ; i++)
        {
            arr[i] = obj.arr[i];
        }
        
    }

    //* Appropriate destructor
    ~DynamicArray(){
        delete[] arr ;
    }

//        * resize() - resize the array to double the size
    void resize(int size){
        this->size = size * 2 ;
    }
//        * pushback(value) - add the value to the end of the array
    void pushback(int value){
        if(capacity > size){
            arr[size] = value ;
            size ++ ;
        }
        else{
            capacity *= 2 ;
            arr[size] = value ;
            size ++ ;
        }
        
    }
//        * popback() - remove the last element from the array
    int popback(int value){
        size -- ;
        return arr[size] ;
    }

//        * removeAt(index) - remove the element at the given index
    void removeat(int index){
        for(int i = index ; i<size ; i++){
            arr[i] = arr[i+1];
        }
        size -- ;
    }
//        * insertAt(index, value) - insert the value at the given index and shift the    elements to the right
    void insertat(int index , int value){
        for(int i = index+1 ; i<size ; i++){
            arr[i] = arr[i+1];
        }
        arr[index] = value ;
        size ++ ;
    }
//        * insertMiddle(value) - insert the value in the middle of the array
    void insertMiddle(int value){
        int index = size / 2 ;
        for(int i = index+1 ; i<size ; i++){
            arr[i] = arr[i+1];
        }
        arr[index] = value ;
        size ++ ;
    }
    
//        * removeMiddle() - remove the middle element from the array
    void removeMiddle(int value){
        int index = size / 2 ;
        for(int i = index; i<size ; i++){
            arr[i] = arr[i+1];
        } 
        size -- ;
    }
//        * size() - return the size of the array
    int showSize(){
        return size ;
    }
//        * print() - print the array
    void print(){
        for(int i = 0 ; i < size ; i++){
            cout << "Element No : " << i << "is equal = " << arr[i] << endl ;
        }
    }


};





int main(){

    DynamicArray vec(5, 0);

    vec.pushback(1);
    
    vec.popback();

    vec.insertat(2, 10);

    vec.removeat(1);

    vec.insertMiddle(15);

    vec.removeMiddle();

    vec.print();

    return 0;
}


