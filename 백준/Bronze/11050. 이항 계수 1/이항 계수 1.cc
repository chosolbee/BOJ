#include <iostream>

int fact(int n) {
    if (n <= 1) return 1;
    else return n * fact(n - 1);
}

int calc(int n, int k) {
    return fact(n) / (fact(k) * fact(n - k));
}

int main() {
    int n, k;

    std::cin >> n >> k;

    // 이항 계수 출력
    std::cout << calc(n, k) << std::endl;


    return 0;
}
