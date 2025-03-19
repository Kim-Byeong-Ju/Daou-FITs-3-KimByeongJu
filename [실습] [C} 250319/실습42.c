#include <stdio.h>

struct Flags {
    unsigned int isVisible : 1;
    unsigned int isActive : 1;
    unsigned int isDeleted : 1;
    unsigned int type : 2;

};

int main(void) {

    struct Flags flags = { 1, 0, 0, 2 };

    printf("isVisible: %u\n", flags.isVisible);
    printf("isActive: %u\n", flags.isActive);
    printf("isDeleted: %u\n", flags.isDeleted);
    printf("type: %u\n", flags.type);

    return 0;
}