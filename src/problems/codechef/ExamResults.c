#include <stdio.h>
#include <math.h>
#define gc getchar_unlocked 
long long read_int();
int main(){
	long long t,n1,n2,m,ans,l,s,sol,min,real;
	t=read_int();
	while(t--){
		n1=read_int();
		n2=read_int();
		m=read_int();
		
		s=(n1<n2?n1:n2);
		min=s;
		s=s*2;
		
		ans=pow(s,0.5);
		
		l=ans*(ans+1)/2;
		real=m*(m+1)/2;
		
		if (l>min)ans-=1;
		
		if (l>real)l=real;
		
		sol=n1+n2-2*l;
		printf("%lld\n",sol);
	}
	return 0;
}
long long read_int() {
  char c = gc();
  while(c<'0' || c>'9') c = gc();
  long long ret = 0;
  while(c>='0' && c<='9') {
    ret = 10 * ret + c - 48;
    c = gc();
  }
  return ret;
}