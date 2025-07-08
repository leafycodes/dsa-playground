#include <algorithm>
#include <iostream>
#include <numeric>
#include <vector>
using namespace std;

int main() {
    vector<int> numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    // Using a lambda with for_each to print each element
    for_each(numbers.begin(), numbers.end(),
             [](int number) { cout << number << " "; });
    cout << endl;

    // Using a lambda with transform to square each element
    transform(numbers.begin(), numbers.end(), numbers.begin(),
              [](int n) { return n * n; });

    // Print the transformed vector
    for (int num : numbers) {
        cout << num << " ";
    }
    cout << endl;

    // Using a lambda with count_if to count even numbers
    int even_count = count_if(numbers.begin(), numbers.end(),
                              [](int n) { return n % 2 == 0; });
    cout << "Even numbers count: " << even_count << endl;

    // Using a lambda with sort to sort in descending order
    sort(numbers.begin(), numbers.end(), [](int a, int b) { return a > b; });

    // Print the sorted vector
    for (int num : numbers) {
        cout << num << " ";
    }
    cout << endl;
    return 0;
}