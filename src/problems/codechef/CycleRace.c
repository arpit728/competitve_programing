#include <stdio.h>

int main() {
    int t,n;
    scanf("%d",&t);
    while(t--){
        scanf("%d",&n);
        if(n&1)printf("JENNY\n");
        else printf("JACK\n");
    }
	return 0;
}

