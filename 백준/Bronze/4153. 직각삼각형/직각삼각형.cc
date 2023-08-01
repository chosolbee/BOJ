#include <iostream>
#include <algorithm>

int main() {
    int a, b, c;

    while (true) {
        // 세 변의 길이 입력 받기
        std::cin >> a >> b >> c;

        // 입력이 모두 0인 경우 종료
        if (a == 0 && b == 0 && c == 0)
            break;

        // 가장 긴 변을 찾기 위해 정렬
        int sides[3] = { a, b, c };
        std::sort(sides, sides + 3);

        // 직각 삼각형인지 판별
        if (sides[2] * sides[2] == sides[0] * sides[0] + sides[1] * sides[1])
            std::cout << "right\n";
        else
            std::cout << "wrong\n";
    }

    return 0;
}
