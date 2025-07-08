#include <iostream>
#include <memory>
#include <string>
#include <vector>

// 1. Stack Allocation
void stackAllocation() {
    std::cout << "\n=== Stack Allocation ===\n";

    int num = 42;                   // Primitive type on stack
    double values[5] = {1.1, 2.2};  // Array on stack
    std::string name = "Alice";     // Object on stack

    std::cout << "Stack variables:\n";
    std::cout << "num: " << num << "\n";
    std::cout << "values[0]: " << values[0] << "\n";
    std::cout << "name: " << name << "\n";

    // All memory automatically freed when function exits
}

// 2. Heap Allocation (Raw pointers)
void heapAllocation() {
    std::cout << "\n=== Heap Allocation (Raw pointers) ===\n";

    int* ptr = new int(100);       // Allocate single int
    double* arr = new double[10];  // Allocate array
    std::string* str = new std::string("Bob");

    std::cout << "Heap variables:\n";
    std::cout << "*ptr: " << *ptr << "\n";
    std::cout << "arr[0]: " << arr[0] << "\n";
    std::cout << "*str: " << *str << "\n";

    // Must manually free memory to avoid leaks
    delete ptr;
    delete[] arr;
    delete str;
}

// 3. Smart Pointers (Modern C++)
void smartPointerAllocation() {
    std::cout << "\n=== Smart Pointers ===\n";

    // Unique pointer (exclusive ownership)
    std::unique_ptr<int> uniquePtr = std::make_unique<int>(200);
    std::unique_ptr<std::string> uniqueStr =
        std::make_unique<std::string>("Charlie");

    // Shared pointer (shared ownership)
    std::shared_ptr<double> sharedPtr = std::make_shared<double>(3.14);
    std::shared_ptr<double> anotherRef = sharedPtr;

    std::cout << "Smart pointers:\n";
    std::cout << "*uniquePtr: " << *uniquePtr << "\n";
    std::cout << "*uniqueStr: " << *uniqueStr << "\n";
    std::cout << "*sharedPtr: " << *sharedPtr << "\n";
    std::cout << "use_count: " << sharedPtr.use_count() << "\n";

    // Memory automatically freed when pointers go out of scope
}

// 4. Custom Memory Management
void customMemoryManagement() {
    std::cout << "\n=== Custom Memory Management ===\n";

    // Allocate raw memory
    void* rawMemory = malloc(1024);  // Allocate 1KB

    if (rawMemory) {
        // Placement new - construct object in pre-allocated memory
        int* intPtr = new (rawMemory) int(300);

        std::cout << "Custom allocation:\n";
        std::cout << "*intPtr: " << *intPtr << "\n";

        // No destructor call needed for primitive types

        // Free memory
        free(rawMemory);
    }
}

int main() {
    stackAllocation();
    heapAllocation();
    smartPointerAllocation();
    customMemoryManagement();

    return 0;
}