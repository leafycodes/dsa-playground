#include <iostream>
#include <vector>
using namespace std;

class Edge {
   public:
    int src, dst, wt;

    Edge(int src, int dst, int wt) : src(src), dst(dst), wt(wt) {}
};

int main() {
    int v = 5;  // number of vertices
    vector<vector<Edge>> graph(v);
    // vectors are automatically initialized as empty, so no need for manual
    // initialization

    graph[0].push_back(Edge(0, 1, 5));

    graph[1].push_back(Edge(1, 0, 5));
    graph[1].push_back(Edge(1, 2, 1));
    graph[1].push_back(Edge(1, 3, 3));

    graph[2].push_back(Edge(2, 1, 1));
    graph[2].push_back(Edge(2, 3, 1));
    graph[2].push_back(Edge(2, 4, 2));

    graph[3].push_back(Edge(3, 1, 3));
    graph[3].push_back(Edge(3, 2, 1));

    graph[4].push_back(Edge(4, 2, 2));

    // neighbours of 2
    for (const Edge& e : graph[2]) {
        cout << e.dst << " ";
    }

    return 0;
}