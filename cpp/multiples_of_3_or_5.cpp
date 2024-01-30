#include <iostream>
#include <string>

using namespace std;

int main() {
    cout << "Input an integer n: " << endl;
    int n = 0;
    cin >> n;

    int sum = 0;
    for (int i = 0; i < n; i++) {
        if (i % 3 == 0 || i % 5 == 0) {
            sum += i;
        }
    }
    
    cout << sum << endl;
    return 0;
}