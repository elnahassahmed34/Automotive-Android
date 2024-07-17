#include <iostream>
#include <initializer_list>

template<typename T>
class DynamicArray {
    T* arr;
    int size;
    int capacity;

public:
    
    DynamicArray() : size(0), capacity(1) {
        arr = new T[capacity];
    }

    DynamicArray(int size) : size(size), capacity(size * 2) {
        arr = new T[capacity];
    }

    DynamicArray(int size, T value) : size(size), capacity(size * 2) {
        arr = new T[capacity];
        for (int i = 0; i < size; i++) {
            arr[i] = value;
        }
    }

    DynamicArray(int size, std::initializer_list<T> list) : size(size), capacity(size * 2) {
        arr = new T[capacity];
        int i = 0;
        for (auto val : list) {
            arr[i] = val;
            i++;
        }
    }

    DynamicArray(const DynamicArray& obj) : size(obj.size), capacity(obj.capacity) {
        arr = new T[capacity];
        for (int i = 0; i < size; i++) {
            arr[i] = obj.arr[i];
        }
    }

    ~DynamicArray() {
        delete[] arr;
    }

    void resize(int newSize) {
        if (newSize > capacity) {
            capacity = newSize * 2;
            T* newArr = new T[capacity];
            for (int i = 0; i < size; i++) {
                newArr[i] = arr[i];
            }
            delete[] arr;
            arr = newArr;
        }
        size = newSize;
    }

    void pushback(T value) {
        if (size >= capacity) {
            resize(size + 1);
        }
        arr[size] = value;
        size++;
    }

    T popback() {
        if (size > 0) {
            size--;
            return arr[size];
        }
        return -1; 
    }

    void removeat(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }
            size--;
        }
    }

    void insertat(int index, T value) {
        if (index >= 0 && index <= size) {
            if (size >= capacity) {
                resize(size + 1);
            }
            for (int i = size; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = value;
            size++;
        }
    }

    void insertMiddle(T value) {
        int index = size / 2;
        insertat(index, value);
    }

    void removeMiddle() {
        int index = size / 2;
        removeat(index);
    }

    int showSize() const {
        return size;
    }

    void print() const {
        for (int i = 0; i < size; i++) {
            std::cout << "Element No: " << i << " is equal to " << arr[i] << std::endl;
        }
    }
};

int main() {
    DynamicArray<int> vec(5, 0);

    vec.pushback(1);
    vec.pushback(2);
    vec.pushback(3);

    vec.popback();

    vec.insertat(2, 10);

    vec.removeat(1);

    vec.insertMiddle(15);

    vec.removeMiddle();

    vec.print();

}
