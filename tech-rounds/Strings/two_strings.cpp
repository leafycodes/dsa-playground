// This is from LGSI: LG Soft India Coding round (1/2) only asled for c/c++

// question in short

// two strings input
// only lowecase letters and '#'
// if '#' comes then backspace (clear one word back).
// backspace on empty string is empty string

// print if both are same or different

#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main()
{
    string str1, str2;
    cin >> str1;
    cin >> str2;

    stack<char> s1, s2;

    for (int i = 0; i < str1.length(); i++)
    {
        if (str1[i] == '#')
        {
            if (!s1.empty())
            {
                s1.pop();
            }
        }
        else
        {
            s1.push(str1[i]);
        }
    }

    for (int i = 0; i < str2.length(); i++)
    {
        if (str2[i] == '#')
        {
            if (!s2.empty())
            {
                s2.pop();
            }
        }
        else
        {
            s2.push(str2[i]);
        }
    }

    while (!s1.empty() && !s2.empty())
    {
        if (s1.top() != s2.top())
        {
            cout << "Different";
            return 0;
        }
        s1.pop();
        s2.pop();
    }

    if (s1.empty() && !s2.empty() || !s1.empty() && s2.empty())
    {
        cout << "Different";
        return 0;
    }

    cout << "Same";
    return 0;
}