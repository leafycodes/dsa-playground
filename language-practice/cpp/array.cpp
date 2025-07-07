#include <iostream>
using namespace std;

int main() {
  int arr[5];
  cin >> arr[0] >> arr[1] >> arr[2] >> arr[3] >> arr[4];

  arr[3] += 6;
  cout << arr[3];

  // 2D arrays
  int matrix[3][5];
  matrix[3][1] = 23;
  cout << endl << matrix[3][1];
  cout << matrix[0][0];  // garbage values

  return 0;
}