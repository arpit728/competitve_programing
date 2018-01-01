#include <stdio.h>

int main() {
    long long t,n;
    scanf("%lld",&t);
    while(t--){
        scanf("%lld",&n);
        if(n&1)printf("NO\n");
        else printf("YES\n");
    }
	return 0;
}


