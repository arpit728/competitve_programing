//problem link:-https://www.codechef.com/problems/JOHNY

#include <stdio.h>

int main() {
    int t,n,k,i,count;
    long long a[101];
    scanf("%d",&t);
    while(t--){
        
        scanf("%d",&n);
        count=0;
        
        for (i = 1; i<=n ; i++) {
            scanf("%lld",(a+i));
        }
        
        scanf("%lld",&k);
        
        for (i = 1; i<=n ; i++) {
            if(a[i]<=a[k])count++;
        }
        printf("%d\n",count);
    }
	return 0;
}


