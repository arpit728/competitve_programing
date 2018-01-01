//problem link:-https://www.codechef.com/problems/NUMGAME2

#include <stdio.h>

int main() {
    long long t,n;
    scanf("%lld",&t);
    while(t-->0){
        scanf("%lld",&n);
        if(n%4==1)printf("ALICE\n");
        else printf("BOB\n");
    }
	return 0;
}


