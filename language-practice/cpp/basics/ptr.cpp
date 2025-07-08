#include <bits/stdc++.h>
using namespace std;

template <typename T>
T add(T a, T b) {
    return a + b;
}

template <typename T>
class Box {
   public:
    T value;
    Box(T v) { value = v; }
    void show() {
        // code to display value
    }
};

class Complex {
   private:
    double real;
    double imag;

   public:
    Complex(double r = 0.0, double i = 0.0) : real(r), imag(i) {}

    // Overloading the + operator
    Complex operator+(const Complex& other) {
        return Complex(real + other.real, imag + other.imag);
    }

    void display() { std::cout << real << " + " << imag << "i" << std::endl; }
};

// Declare a function pointer 'funcPtr' that points to a function taking two
// ints and returning an int
int (*funcPtr)(int, int);

// Assuming 'add' is a function with the signature int add(int a, int b)
int add(int a, int b) { return a + b; }

int main() {
    int val = 10;
    int* ptr = &val;

    cout << *ptr;
    cout << " " << sizeof(ptr);

    // int* k;  // wild pointer - random address that may or may not be valid
    // int* n = NULL;  // NULL pointer
    // cout << *k << " " << *n;

    // void* vp = &val;  // void pointer
    // also there is dangling pointers
    // int* ptra = nullptr;
    // cout << *ptra;

    // unique_ptr, shared_ptr - smart pointers

    // Initialize the function pointer to point to the 'add' function
    funcPtr = add;  // The address-of operator '&' is optional here

    try {
        int numerator = 10;
        int denominator = 0;

        if (denominator == 0) {
            throw std::runtime_error(
                "Division by zero is not allowed.");  // Throw a standard
                                                      // exception
        }

        double result = static_cast<double>(numerator) / denominator;
        std::cout << "Result: " << result << std::endl;

    } catch (const std::runtime_error& e) {  // Catch a std::runtime_error
        std::cerr << "Caught exception: " << e.what() << std::endl;
    } catch (...) {  // Catch-all block for any other unhandled exceptions
        std::cerr << "Caught an unknown exception." << std::endl;
    }

    std::cout << "Program continues after exception handling." << std::endl;

    char c = add('A', 'A');
    cout << c;

    Box<string> stringBox("hello");
    cout << stringBox.value << endl;

    return 0;
}