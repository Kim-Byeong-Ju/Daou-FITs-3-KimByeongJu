#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>


int main() {
    struct student {
        char name[20];
        char sex;
        int stid;
        int sub1;
        int sub2;
        int sub3;
        double avg;
    } st1 = { "kdhong", 'm', 15080001, 98, 89, 92, 0.0 }, st2;
    st1.avg = (st1.sub1 + st1.sub2 + st1.sub3) / 3.0;
    st2 = st1;
    strcpy(st2.name, "yhkim");
    st2.sex = 'f';
    st2.stid = 1608024;
    printf("%s님(성별 : %s)의 학번은 %d이고,\n이번 시험 3과목 평균은 %5.2f입니다\n", st2.name, st2.sex == 'm' ? "남자" : "여자", st2.stid, st2.avg);
   
    return 0;
}
