#include <bits/stdc++.h>
using namespace std;

void print_it(string str) { cout << "hey " + str << endl; }

int sum(int a, int b) {
    int c = a + b;
    return c;
}

// pass by value (wihtout &)
void do_something(int &num) {  // &num makes it pass by reference
    cout << num << endl;
    num += 10;
    cout << num << endl;
}

int main() {
    // print_it("Anish");
    // cout << sum(3, 7) << endl;
    // cout << max(3, 7) << endl;
    // cout << abs(3 - 7.8) << endl;
    // return 0;

    int num = 10;
    do_something(num);
    // arrays, vectors, maps, lists are always passed by reference by default

    cout << num << endl;
}
