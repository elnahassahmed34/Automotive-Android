#include <iostream>
#include <typeinfo>

enum DataType { INT, DOUBLE, CHAR, NONE };

class VointerArray {
private:
    void** array;
    int size;

public:
    VointerArray(int size) : size(size) {
        array = new void*[size];
        for (int i = 0; i < size; ++i) {
            array[i] = nullptr;
        }
    }

    ~VointerArray() {
        for (int i = 0; i < size; ++i) {
            deleteData(i);
        }
        delete[] array;
    }

    void setValue(int index, void* value, DataType type) {
        if (index >= 0 && index < size) {
            deleteData(index);
            switch (type) {
                case INT:
                    array[index] = new int(*(int*)value);
                    break;
                case DOUBLE:
                    array[index] = new double(*(double*)value);
                    break;
                case CHAR:
                    array[index] = new char(*(char*)value);
                    break;
                default:
                    array[index] = nullptr;
                    break;
            }
        }
    }

    void* getValue(int index) const {
        if (index >= 0 && index < size) {
            return array[index];
        }
        return nullptr;
    }

    int getSize() const {
        return size;
    }
    
    auto getDataType(int index) const {
    if (index >= 0 && index < size && array[index] != nullptr) {
        if (typeid((array[index])) == typeid(int)) {
            return INT;
        } else if (typeid(*static_cast<double*>(array[index])) == typeid(double)) {
            return DOUBLE;
        } else if (typeid(*static_cast<char*>(array[index])) == typeid(char)) {
            return CHAR;
        }
    }
    return NONE;
}
    

    void printArray() const {
        for (int i = 0; i < size; ++i) {
            std::cout << "Index " << i << ": ";
            if (array[i] == nullptr) {
                std::cout << "NONE" << std::endl;
            } else if (typeid(*(int*)array[i]) == typeid(int)) {
                std::cout << "INT, Value: " << *(int*)array[i] << std::endl;
            } else if (typeid(*(double*)array[i]) == typeid(double)) {
                std::cout << "DOUBLE, Value: " << *(double*)array[i] << std::endl;
            } else if (typeid(*(char*)array[i]) == typeid(char)) {
                std::cout << "CHAR, Value: " << *(char*)array[i] << std::endl;
            }
        }
    }

private:
    // Helper function to delete data at index
    void deleteData(int index) {
        if (array[index] != nullptr) {
            if (typeid(*(int*)array[index]) == typeid(int)) {
                delete (int*)array[index];
            } else if (typeid(*(double*)array[index]) == typeid(double)) {
                delete (double*)array[index];
            } else if (typeid(*(char*)array[index]) == typeid(char)) {
                delete (char*)array[index];
            }
            array[index] = nullptr;
        }
    }
};

int main() {
    VointerArray va(5);

    int intValue = 10;
    double doubleValue = 3.14;
    char charValue = 'A';

    va.setValue(0, &intValue, INT);
    va.setValue(1, &doubleValue, DOUBLE);
    va.setValue(2, &charValue, CHAR);

    va.printArray();

    std::cout << "Value at index 0: " << *(int*)va.getValue(0) << std::endl;
    std::cout << "Value at index 1: " << *(double*)va.getValue(1) << std::endl;
    std::cout << "Value at index 2: " << *(char*)va.getValue(2) << std::endl;
    
    std::cout << "type at index 2: " << va.getDataType(1) << std::endl;



    return 0;
}
