#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin >> n;
    // cout << (int)(log10(n) + 1);

    // int rev = 0;
    // while (n > 0) {
    //     int last_digit = n % 10;
    //     rev = rev * 10 + last_digit;
    //     n /= 10;
    // }
    // cout << rev;

    // int rev = 0;
    // int temp = n;
    // while (n > 0) {
    //     int last_digit = n % 10;
    //     rev = rev * 10 + last_digit;
    //     n /= 10;
    // }
    // cout << (temp == rev ? "palindrome" : "not palindrome");

    // int armstrong = 0;
    // int temp = n;
    // while (n > 0) {
    //     int last_digit = n % 10;
    //     armstrong += pow(last_digit, 3);
    //     n /= 10;
    // }
    // cout << (temp == armstrong ? "armstrong number" : "not armstrong
    // number");

    // cout << "divisors of " << n << " are: ";
    // for (int i = 1; i <= sqrt(n); i++) {
    //     if (n % i == 0) {
    //         cout << i << " ";
    //         if (n / i != i) {
    //             cout << n / i << " ";
    //         }
    //     }
    // }

    // int count = 0;
    // for (int i = 1; i * i <= n; i++) {
    //     if (n % i == 0) {
    //         count++;
    //         if (n / i != i) {
    //             count++;
    //         }
    //     }

    //     if (count > 2) {
    //         cout << "not prime";
    //         break;
    //     }
    // }
    // if (count == 2) {
    //     cout << "prime";
    // }

    // gcd(a,b)= gcd(a - b,b) // a>b when one becomes 0, the otehr is the gcd
    // now for this gcd(52,10) -> gcd(42,10) -> gcd(32,10) -> gcd(22,10) ->
    // gcd(12,10) -> gcd(2,10)
    // we can directly get there by doing a%b instead of a-b
    // greater % smaller

    // logfi min(m,n)
    int m;
    cin >> m;
    while (n > 0 && m > 0) {
        if (m > n) {
            m = m % n;
        } else {
            n = n % m;
        }
    }
    cout << "gcd: " << (m == 0 ? n : m);

    return 0;
}