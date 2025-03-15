#include <iostream>
using namespace std;

int N;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N;
	while (N > 4) cout << 'V', N -= 5;
	while (N--) cout << 'I';
}