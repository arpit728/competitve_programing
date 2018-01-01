//problem link:-https://www.codechef.com/problems/BUYING2

#include <stdio.h>

int main() {
    int a[101],n,x,t,i,sum,ans,ans1,flag;
    scanf("%d",&t);
    while(t--){
        sum=ans=ans1=0;
        scanf("%d %d",&n,&x);
        for(i=0;i<n;i++){
            scanf("%d",(a+i));
            sum+=a[i];
        }
        ans=sum/x;
        for (i = 0;i<n;i++) {
            ans1=(sum-a[i])/x;
            if(ans==ans1){
                ans=-1;
                break;
            }
        }
        printf("%d\n",ans);
    }
	return 0;
}


