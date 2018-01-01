//problem link :- https://www.codechef.com/problems/P1Z2S
#include <stdio.h>
#define max(x,y)((x>y)?x:y)
int a[100001];
 
int main() {
    
    int n,i,sum=0;
    scanf("%d",&n);
    
    for(i=0;i<n;i++){
        
        scanf("%d",(a+i));
        sum+=a[i];
        
    }
    sum++;//This helps in considering ceil value of sum/2
    printf("%d\n",max(sum/2,n));
	return 0;
}
