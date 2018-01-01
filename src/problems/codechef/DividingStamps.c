//Problem Link:-https://www.codechef.com/problems/DIVIDING

#include <stdio.h>
#define ll long long
int main() {
    int n,i,temp;
    ll sum=0,sum1=0;
    
    scanf("%lld",&n);
    
    for(i=0;i<n;i++){
        scanf("%lld",&temp);
        sum+=temp;
    }
    sum1=(ll)n*(n+1)/2;
    if(sum==sum1)printf("YES\n");
    else printf("NO\n");
	return 0;
}


