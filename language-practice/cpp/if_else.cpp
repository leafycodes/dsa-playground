#include <bits/stdc++.h>
using namespace std;

int main() {
  int age;
  cout << "enter your age: ";
  cin >> age;

  if (age >= 18) {
    cout << "you're an adult";
  } else if (age < 0) {
    cout << "be real";
  } else {
    cout << "not an adult";
  }

  char c = 'a';
  switch (c) {
    case 'a':
      cout << "a was the char";
      break;
    case 'b':
      cout << "b was the char";
      break;
    default:
      break;
  }
  return 0;
}