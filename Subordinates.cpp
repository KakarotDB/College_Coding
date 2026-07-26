#include <iostream>
#include <vector>
using namespace std;

void dfs(vector<int> adj[], int treeSize[], int u) {
    treeSize[u] = 1;

    for (int v : adj[u]) {
        dfs(adj, treeSize, v);
        treeSize[u] += treeSize[v];
    }
}

int main() {
    int n, m;
    cin >> n;

    vector<int> adj[n + 1];

    for (int i = 2; i <= n; i++) {
        int boss;
        cin >> boss;
        adj[boss].push_back(i);
    }

    int treeSize[n + 1];

    dfs(adj, treeSize, 1);

    for (int i = 1; i < n + 1; i++) {
        cout << treeSize[i] - 1 << " ";
    }

    cout << endl;
}
