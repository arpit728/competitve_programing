#include <stdio.h>
#include <math.h>

void sort(long wp[],int n);

int calculateMinimumCoins(long coins[],int n,int knapsack);

int read_int();
void swap(long arr[],int i,int j);
void heapify(long arr[],int i,int size);
void buildMinHeap(long arr[],int n);
void heapsort(long arr[],int n);
void swap(long arr[],int i,int j);

int main() {
	int t,i,j;
	long sum,knapsack,minCoin,n,coins[10000];
	t=read_int();
	
	while(t--){
		sum=0,knapsack=0;
		n=read_int();
		n++;
		coins[0]=0;
		for (j = 1; j <n; j++) {
			coins[j]=read_int();
			sum=sum+coins[j];
		}
		
		heapsort(coins,n);
		
		printf("%d\n",calculateMinimumCoins(coins, n, sum));
	}

}


int calculateMinimumCoins(long coins[],int n,int sum){
	int minCoin=0,i,p=0;
	for(i = 1;i<n; i++) {
		p=p+coins[i];
		sum=sum-coins[i];
		if (p>sum)
		{
			break;
		}
	}
	return i;
}
	
int read_int() {
  char c =  getchar();
  while(c<'0' || c>'9') c =  getchar();
  int ret = 0;
  while(c>='0' && c<='9') {
    ret = 10 * ret + c - 48;
    c =  getchar();
  }
  return ret;
}
void swap(long arr[],int i,int j){
	int temp;
	temp=arr[i];
	arr[i]=arr[j];
	arr[j]=temp;
}
void heapify(long arr[],int i,int size){
	int l,r,smallest;
	l=2*i;
	r=2*i+1;
	smallest=i;
	
	if(l<=size&&arr[l]<arr[i])smallest=l;
	if(r<=size&&arr[r]<arr[smallest])smallest=r;
	if(smallest!=i){
		swap(arr,smallest,i);
		heapify(arr,smallest,size);
	
	}
}

void buildMinHeap(long arr[],int n){
	int i;
	for(i=n/2;i>0;i--){
		heapify(arr,i,n);
	}
}

void heapsort(long arr[],int n){
	int i=0;
	buildMinHeap(arr,n);
	for(i=n;i>0;i--)
	{
		swap(arr,1,i);
		heapify(arr,1,i-1);
	}
}