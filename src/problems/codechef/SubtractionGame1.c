//Problem Link:-https://www.codechef.com/problems/AMSGAME1

#include <stdio.h>

int gcd(int a,int b){
    
    if(a==0 || b==0)return (a?a:b);
    
    else if(a>b)return gcd(b,a%b);
    else return gcd(a,b%a);
}
int a[1001];
int main() {

    int t,n,res,i;
    scanf("%d",&t);
    while(t--){
        scanf("%d",&n);
        for(i=0;i<n;i++)scanf("%d",(a+i));
        res=a[0];
        for(i=1;i<n;i++)res=gcd(res,a[i]);
        printf("%d\n",res);
    }
	return 0;
}


