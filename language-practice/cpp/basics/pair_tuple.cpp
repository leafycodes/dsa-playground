#include <iostream>
#include <string>
#include <tuple>
using namespace std;

int main() {
    pair<int, string> p = {1, "anish"};
    tuple<int, char, string> t = {2, 'c', "anishTuple"};

    cout << p.first << " " << p.second << endl;
    cout << get<0>(t) << " " << get<1>(t) << " " << get<2>(t) << endl;
    return 0;
}