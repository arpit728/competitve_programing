//Problem link:- https://www.codechef.com/problems/NAME2

#include <stdio.h>
#include <string.h>
char s1[25002],s2[25002];

int isSubSequence(char s1[],char s2[],int l1,int l2);

int main() {
    
    int l1,l2,t;
    scanf("%d",&t);
    while(t--)
    {
        
        scanf("%s %s",s1,s2);
        l1=strlen(s1);
        l2=strlen(s2);
        
        if(isSubSequence(s1,s2,l1,l2) || isSubSequence(s2,s1,l2,l1))
            printf("YES\n");
            
        else printf("NO\n");
    }
	return 0;
}

int isSubSequence(char s1[],char s2[],int l1,int l2){
    int i,j;
    for(i=0,j=0;i<l1 && j<l2;i++){
        if(s2[j]==s1[i])j++;
    }
    if(j==l2)return 1;
    
    return 0;
}
