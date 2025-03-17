//실습과제 31
#include <stdio.h>

typedef struct student {
    char name[20];
    char sex;
    int stid;
    int sub1;
    int sub2;
    int sub3;
    double avg;
} ST;

int input(ST *st);

int main(void) {
    int i;
    ST st[3] = {{"kdhong", "m", 1508001, 0, 0, 0, 0.0},
        {"yhkim", "f", 1608021, 0, 0, 0, 0.0},
        {"cskim", "m", 1608026, 0, 0, 0, 0.0}};
    for (i = 0; i < 3; i++) {
        input(&st[i]);
        printf("main()함수에서 출력된 %s의 세 과목 점수는 %d, %d, %d입니다\n", st[i].name, st[i].sub1, st[i].sub2, st[i].sub3);

    }
};

int input(ST *st) {
    printf("%s 학생의 3과목 성적을 입력하세요: ", st -> name);
    scanf("%d", &st -> sub1 , &st -> sub2 ,&st -> sub3);

}

