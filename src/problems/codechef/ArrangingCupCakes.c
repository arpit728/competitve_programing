//Problem link:-https://www.codechef.com/problems/RESQ
#include <stdio.h>
#include<math.h>
#include<stdlib.h>
#define min(x,y) ((x<y)?x:y);
int main() {
    int n,t,diff,diff1,i,l;
    scanf("%d",&t);
    while(t--){
        scanf("%d",&n);
        diff=n-1;
        l=sqrt(n);
        for(i=2;i<=l;i++){
            if(n%i==0){
                diff=min(diff,(n/i)-i);
            }
        }
        printf("%d\n",diff);
    }
	return 0;
}


