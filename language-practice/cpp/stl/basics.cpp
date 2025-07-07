#include <bits/stdc++.h>
using namespace std;

void print() { cout << "anish"; }

bool comp(pair<int, int> p1, pair<int, int> p2) {
    if (p1.second < p2.second) {
        return true;
    }

    if (p1.second > p2.second) {
        return false;
    }

    // they're same
    if (p1.first > p2.first) {
        return true;
    }
    return false;
}

int main() {
    // // we'll learn about STL (standard template library)

    // // stl - algo, containers, funcs, iterators

    // // containers
    // // pair
    // pair<int, int> p = {1, 3};
    // cout << p.first << " " << p.second << endl;

    // pair<int, int> arr[] = {{1, 2}, {3, 4}, {5, 6}};
    // cout << arr[1].second;

    // // vectors
    // vector<int> v;
    // v.push_back(1);     // slower due to temp obj creation
    // v.emplace_back(2);  // faster

    // vector<pair<int, int>> vp;
    // vp.push_back({1, 2});
    // vp.emplace_back(1, 2);  // emplace_back assumes it to be a pair

    // vector<int> nv(5, 100);  // size 5, all values initila;ised to 100
    // vector<int> k(5);        // size 5 garbage value

    // vector<int> v1(5, 20);
    // vector<int> v2(v1);  // copy of v1 into v2

    // // access similar to array
    // // v[1], v[2] ,etc
    // // v.at(0), v.at(1)

    // // the other way is iterators
    // vector<int>::iterator it = v.begin();  // points to the memory address
    // // v.begin() is the memory
    // // to access, use *(it)

    // cout << *(it) << " ";
    // it += 2;

    // vector<int>::iterator it =
    //     v.end();  // points to the next one after the last element, so use
    //     it--

    // // not really used
    // // v.rend() reverse end //end after reverse. i.e before the start one
    // it++
    // // v.rbegin() reverse begin it++

    // cout << v.back() << endl;  // the last element

    // for (vector<int>::iterator it = v.begin(); it != v.end(); it++) {
    //     cout << *(it) << " ";
    // }

    // for (auto it = v.begin(); it != v.end(); it++) {
    //     cout << *(it) << " ";
    // }

    // for (auto it : v) {     // means int
    //     cout << it << " ";  // not iterator, but the element
    // }

    // v.erase(v.begin() + 1);                 // location
    // v.erase(v.begin() + 2, v.begin() + 4);  // start end
    // vector<int> v(2, 100);                  //{100,100}
    // v.insert(v.begin(), 300);               //{300,100,100}
    // v.insert(v.begin() + 1, 2, 10);         //{300,10,10,100,100}

    // vector<int> copy(2, 50);
    // v.insert(v.begin(), copy.begin(), copy.end());
    // //{50,50, 300,10,10,100,100}

    // cout << v.size();
    // v.pop_back();  // last element popped
    // v1.swap(v2);   // swaps the two vectors
    // v.clear();     // clears the entire vector

    // cout << v.empty();

    // list
    // list<int> ls;
    // ls.push_back(2);
    // ls.emplace_back(4);
    // ls.push_front(5);  // cheaper as compared to insert at 0 in the vector
    // ls.emplace_front(1);
    // ls.max_size();

    // for (int i : ls) {
    //     cout << i << " ";
    // }
    // // rest func same as vector begin, end, rend , rbegin , clear, insert,
    // size,
    // // swap

    // // Deque
    // deque<int> dq;
    // dq.push_back(1);
    // dq.emplace_back(2);
    // dq.push_front(4);
    // dq.emplace_front(3);

    // dq.pop_back();
    // dq.pop_front();

    // dq.back();
    // dq.front();

    // // rest all func same as vector

    // // stack - LIFO
    // stack<int> st;
    // st.push(1);
    // st.push(2);
    // st.push(3);
    // st.push(3);
    // st.emplace(5);

    // cout << st.top();
    // st.pop();
    // cout << st.top();
    // cout << st.size();
    // cout << st.empty();

    // stack<int> st1, st2;
    // st1.swap(st2);

    // // Queue - FIFO

    // queue<int> q;
    // q.push(1);
    // q.push(2);
    // q.emplace(4);

    // q.back() + -5;  // it means the last element (4)
    // cout << q.front();
    // q.pop();

    // // size, swap,empty same as stack

    // priority queue
    // priority_queue<int> pq;
    // pq.push(5);
    // pq.push(2); //logn
    // pq.push(8);
    // pq.emplace(10);

    // cout << pq.top() << "\n";  // the largest one by default //O(1)
    // pq.pop();                  // 10 is popped logn
    // cout << pq.top() << endl;  // 8

    // size swap empty are same as others

    // to have a min_heap
    // priority_queue<int, vector<int>, greater<int>> pq;

    // pq.push(5);
    // pq.push(2);
    // pq.push(8);
    // pq.emplace(10);

    // cout << pq.top();

    // set - sorted, unique
    // set<int> s;
    // s.insert(1);
    // s.emplace(2);
    // s.insert(2);
    // s.insert(4);
    // s.insert(3);

    // // functionality of insert in vector can be used to increase efficiency

    // // begin ,end, rbegin, rend, size, empty, swap are same as others

    // auto it = s.find(3);  //{1,2,3,4,5} it points to 3
    // auto it = s.find(6);  // as 6 is not in the set, it will return s.end()
    // s.erase(5);           // erases 5 and maintains the sorted order // logn

    // int cnt = s.count(1);  // if exits-> 1, else 0

    // auto it = s.find(3);
    // s.erase(it);  // constant time - element or iterator

    // auto it1 = s.find(2);
    // auto it2 = s.find(4);

    // s.erase(it1, it2);  // erase from start to end, end is exclusive

    // // lower_bound and upper_bound works in same way as in vector (it) does

    // auto it = s.lower_bound(2);  // first element which is equal or greater
    // to
    //                              // 2
    // auto it = s.upper_bound(3);  // first strictly greater element that 3

    // // everyting is logn

    // multiset - sorted (not unique)
    // multiset<int> ms;
    // ms.insert(1);   // 1
    // ms.insert(1);   // 1 1
    // ms.emplace(1);  // 1 1 1

    // ms.erase(1);            // all 1's are erased
    // int cnt = ms.count(1);  // number of 1's in the multiset

    // ms.erase(ms.find(1));  // only a single 1 is erased // erase address only
    //                        // erases that address
    //                        // erase element erasese all elements same as that
    // ms.erase(ms.find(1),
    //          next(ms.find(1),
    //               2));  // cant use + to advance an iterator here, so use
    //               next

    // unordered set - unique( but not sorted)
    // unordered_set<int> us;
    // // //lower_bound and upper_bound do not work
    // // rest all funcs are same as above
    // // not aprticular order, but better complxity
    // // than set in most cases, except some cases when collision happens
    // then (O(n))

    // // randomized order

    // map - key-value pairs/// duplicate values but key /// unique keys in
    // sorted order of key
    // map<int, int> mp;
    // map<int, pair<int, int>> mp;
    // map<pair<int, int>, int> mp;

    // mp[1] = 2; //key 1, value 2
    // mp.emplace(make_pair(make_pair(3, 11), 2));
    // mp.insert(1, 2);
    // mp[{2, 3}] = 10;

    // for (auto it : mp) {
    //     cout << it.first << " " << it.second << endl;
    // }

    // cout << mp[1];  // value 2
    // cout << mp[5];  // null or 0 as it does not exists

    // auto it = mp.find(3);  // iterator // if not there, then points to
    // mp.end()
    //                        // ir after the end of map
    // cout << *(it).second;

    // auto it = mp.lower_bound(2);
    // auto it = mp.upper_bound(2);  // already we know how it works

    // // erase swap size empty are same as above
    // logn

    // // multimaps
    // multimap<int, int> mp;  // can store duplicate keys
    // everything same as map. mp[key] cannot be used here

    // unordered_map - same as set and unordred_set difference O(1)
    // O(n) worst case
    //
    ///
    ///\
    // /\
    //
    ///
    //

    // Algorithms

    // vectors and arrays
    // sort(a, a + n);  // start to end exclusive
    // sort(v.begin(), v.end());
    // sort(a + 2, a + 4);

    // sort(a, a + n, greater<int>);  // descending comparator

    // pair<int, int> a[] = {{1, 2}, {2, 1}, {4, 1}};

    // // to sort according to second element/ if second eleemnt is same, then
    // // decreasing according to first
    // sort(a, a + n, comp);  // comp is a self written comaprator (bool func)->
    // // shown at the top of int main

    // int num = 7;                        // binary= 1 1 1
    // int cnt = __builtin_popcount(num);  // how many set bits

    // long long k = 87498237498237598237;
    // int cnt = __builtin_popcountll(k);  // how many set bits in long long

    // string s = "123";
    // do {
    //     cout << s << endl;
    // } while (next_permutation(s.begin(),
    //                           s.end()));  // all permutations of the string
    // // after all permutations done, next_permutation() goes to null, thus it
    // // returns a false and the while loop breaks

    // // if started with "231", then -> "312" -> "321" -> null
    // // so to get all the permutations, start from teh sorted string ->
    // // sort(s.begin(),s.end());

    // int max = *max_element(
    //     a, a + n);  // memory address of the max element in this array

    return 0;
}