#include <algorithm>
#include <iostream>
#include <vector>
#define ll long long
using namespace std;

int main() {
    int n = 0,m,q;
    cin >> n >> m >> q;
    ll inf = 1e18;

    vector<vector<ll>> dist(n + 1, vector<ll>(n + 1, inf));

    for(int i = 1; i <= n; i++) dist[i][i] = 0;

    for(int i = 0; i < m; i++) {
        ll u, v, w;
        cin >> u >> v >> w;

        dist[u][v] = min(dist[u][v], w);
        dist[v][u] = min(dist[v][u], w);
    }

    for(int k = 1; k <= n; k++) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(dist[i][k] < inf && dist[k][j] < inf) {
                    dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    for(int i = 0; i < q; i++) {
        int u, v; cin >> u >> v;

        if(dist[u][v] >= inf) cout << -1 << endl;
        else cout << dist[u][v] << endl;
    }
}
