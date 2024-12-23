#include <iostream>

using namespace std;

int main() {
    long N, num;
    cin >> N;

    bool isSquare[1000001];

    for (long i = 0; i < 1000; i++) {
        isSquare[i*i] = true;
    }

    for (long i = 0; i < N; i++) {
        cin >> num;
        bool flag = false;

        if (num % 2 == 1) {
            flag = true;
            cout << 'O';
        }

        if (isSquare[num]) {
            flag = true;
            cout << "S";
        }

        if (!flag) {
            cout << "EMPTY";
        }

        cout << endl;
    }
}