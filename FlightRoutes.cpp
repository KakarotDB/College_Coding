#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main() {
    // Optimize standard I/O operations for performance
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m, k;
    if (!(cin >> n >> m >> k)) return 0;

    // Adjacency list: adj[u] storing pairs of {v, weight}
    vector<vector<pair<int, int>>> adj(n + 1);
    for (int i = 0; i < m; ++i) {
        int u, v, w;
        cin >> u >> v >> w;
        adj[u].push_back({v, w});
    }

    // Min-priority queue storing pair<cost, node>
    // Using std::greater ensures the smallest path cost is popped first
    priority_queue<pair<long long, int>, vector<pair<long long, int>>, greater<pair<long long, int>>> pq;

    vector<int> count(n + 1, 0);
    vector<long long> ans;
    ans.reserve(k);

    // Push initial node 1 with cost 0
    pq.push({0LL, 1});

    while (!pq.empty()) {
        auto [cost, u] = pq.top();
        pq.pop();

        if (count[u] >= k) continue;
        count[u]++;

        if (u == n) {
            ans.push_back(cost);
            if (ans.size() == k) {
                break;
            }
        }

        for (const auto& edge : adj[u]) {
            int v = edge.first;
            int w = edge.second;

            if (count[v] < k) {
                pq.push({cost + w, v});
            }
        }
    }

    // Print the k shortest path costs
    for (int i = 0; i < ans.size(); ++i) {
        cout << ans[i] << (i == ans.size() - 1 ? "" : " ");
    }
    cout << "\n";

    return 0;
}
