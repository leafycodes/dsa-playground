#include <bits/stdc++.h>
using namespace std;

int main() {
  //   short x = 1;      // 2 bytes
  //   int x = 10;       // 4
  //   long x = 212121;  // 4

  //   long long x = 13123123123123;  // 8
  //   float x = 9.0303030;
  //   double x = 8.434343322323;

  //   string str;
  //   cin >> str;
  //   cout << str; // only picks up till an empty space is found, then you need
  //   to use a new string

  // to take full line (until a new line is encountered)
  string str = "do good";
  getline(cin, str);
  cout << str;

  char ch = '9';  // 1 byte
  cin >> ch;
  cout << ch;

  return 0;
}