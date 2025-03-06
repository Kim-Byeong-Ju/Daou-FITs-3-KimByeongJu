
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <math.h>

// 10-1
double get_radius() {
    double r;
    printf("반지름을 입력하세요: ");
    scanf("%lf", &r);
    return r;
}

double circle_perimeter(double r) {
    return 2 * M_PI * r;
}

double circle_area(double r) {
    return M_PI * r * r;
}

double sphere_volume(double r) {
    return (4.0 / 3.0) * M_PI * r * r * r;
}


int main() {
    int choice;
    do {
        printf("\n1. 원의 둘레 구하기\n2. 원의 넓이 구하기\n3. 구의 부피 구하기\n4. 그만두기\n");
        printf("원하는 작업을 선택하세요: ");
        scanf("%d", &choice);

        if (choice == 1) {
            double r = get_radius();
            printf("원의 둘레는 %.2lf입니다.\n", circle_perimeter(r));
        }
        else if (choice == 2) {
            double r = get_radius();
            printf("원의 넓이는 %.2lf입니다.\n", circle_area(r));
        }
        else if (choice == 3) {
            double r = get_radius();
            printf("구의 부피는 %.2lf입니다.\n", sphere_volume(r));
        }
        else if (choice == 4) {
            printf("프로그램을 종료합니다.\n");
        }
        else {
            printf("잘못된 입력입니다.\n");
        }
    } while (choice != 4);

    return 0;
}



// 10-2
int main() {
    int n;
    printf("정수 n을 입력: ");
    scanf("%d", &n);
    int sum = 0;
	for (int i = 1; i <= n; i++) {
		sum += i % 2 == 0 ? i : 0;
	}
    printf("정수 1에서 %d 이하 짝수들의 합은 %d입니다.", n, sum);  
    return 0;
}
