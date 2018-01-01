#include <stdio.h>
#include<stdlib.h>

int vis[1001]={0};
int a[1001]={0};

void dfs(int s,int i,int flag);

int main() {
    
    int n,i,cnt=0;
    scanf("%d",&n);
    
    for(i=1;i<=n;i++) scanf("%d",(a+i));
    
    for(i=1;i<=n;i++){
        if(!vis[i]){
            vis[i]=1;
            cnt++;
            dfs(i,i,0);
        }
    }
    //memset(vis,0,n+1);
    
    for(i=1;i<=n;i++)vis[i]=0;
    
    for(i=1;i<=n;i++){
        
        if(!vis[i]){
            vis[i]=1;
            cnt++;
            dfs(i,i,1);
        }
    }
	return 0;
}

void dfs(int s,int i,int flag){
    
    if(flag){
        printf("%d ",i);
    }
    
    if(a[i]!=s){
        dfs(s,a[i],flag);
        vis[a[i]]=1;
    }
    else{
        if(flag)printf("%d\n",s);
    }
}

