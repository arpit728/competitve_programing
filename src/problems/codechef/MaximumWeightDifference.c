//Problem link:-https://www.codechef.com/problems/MAXDIFF

#include <stdio.h>
#include <stdlib.h>
#define max(a,b)((a>b)?a:b);

int a[101];

int compare(const void *p, const void *q) {
    int x = *(const int *)p;
    int y = *(const int *)q;

    if (x < y)
        return -1;  // Return -1 if you want ascending, 1 if you want descending order. 
    else if (x > y)
        return 1;   // Return 1 if you want ascending, -1 if you want descending order. 

    return 0;
}

int main() {
    
    int i,t,n,k,s1,s2,sum,ans;
    scanf("%d",&t);
    
    while(t--){
        
        scanf("%d %d",&n,&k);
        s1=s2=sum=0;
        
        for(i=0;i<n;i++){
            
            scanf("%d",(a+i));
            sum+=a[i];

        }
        qsort(a,n,sizeof(int),compare);
        
        for(i=0;i<n;i++){
            if(i<k)s1+=a[i];
            if(i>=(n-k))s2+=a[i];
        }
        ans=max(abs(sum-(2*s1)),abs(sum-(2*s2)));
        printf("%d\n",ans);
    }

	return 0;
}


