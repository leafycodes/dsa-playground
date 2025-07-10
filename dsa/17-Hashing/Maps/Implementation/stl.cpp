#include <iostream>
#include <unordered_map>
using namespace std;

int main() {
    unordered_map<string, int> mp;
    mp["Anish"] = 1;
    mp["Anwesha"] = 2;
    mp["Anagh"] = 3;
    mp["Anagh"] = 4;

    cout << mp["Anwesha"] << endl;
    cout << (mp.count("Anish") == 0 ? "false" : "true") << endl;
    cout << (mp.count("Verstappen") == 0 ? "false" : "true") << endl;
    mp.erase("Anish");
    cout << mp["Anish"] << endl;
    return 0;
}