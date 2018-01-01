package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//This solution is incomplete
//problem link https://www.codechef.com/CDCRFT14/problems/SUBBXOR
public class SubarrayXor {

	static int a[]=new int[100001];
	static int prefix[]=new int[100001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t,n,k;
		String[]s;
		t=Integer.parseInt(br.readLine());
		while(t-->0) {
			s=br.readLine().split("\\s");
			n=Integer.parseInt(s[0]);
			k=Integer.parseInt(s[1]);
			s=br.readLine().split("\\s");
			for(int i=0;i<n;i++) {
				a[i]=Integer.parseInt(s[i]);
			}
			System.out.println(solve(a,n,k));
			System.out.println("executed all");
		}
	}
	private static int solve(int[] a, int n, int k) {
		
		Trie3 trie=new Trie3();
		int count=0;
		int pre=0;
		trie.insert(0);
		System.out.println("Zero inserted");
		for(int i=0;i<n;i++) {
			pre^=a[i];
			count+=trie.query(pre,k);
		}
		return count;
	}
	
}

class Trie3{
	
	TrieNode root;
	
	public Trie3() {
		
		root=new TrieNode();
	}

	class TrieNode{
		TrieNode trieNode[];
		public int count;
		public TrieNode() {
			trieNode=new TrieNode[2];
		}
	}
	
	void insert(int x) {
		TrieNode temp=root;
		for(int i=2;i>=0;i--) {
			int currentBit=x>>i;
			if(temp.trieNode[currentBit]==null) {
				temp.trieNode[currentBit]=new TrieNode();
			}
			temp.trieNode[currentBit].count++;
			temp=temp.trieNode[currentBit];
		}
	}
	
	int query(int p,int k) {
		
		return query(root,p,k,19);
	}

	private int query(TrieNode root, int p, int k, int level) {
		if (level>=0 && root!=null) {
			
			if((k>>level)==1) {
				if((p>>level)==1) {
					return root.trieNode[1].count+query(root.trieNode[0],p,k,level-1);
				}
				else {
					return root.trieNode[0].count+query(root.trieNode[1],p,k,level-1);
				}
			}//else block represents q=0
			else {
				if((p>>level)==1) {
					return query(root.trieNode[1],p,k,level-1);
				}
				else {
					return query(root.trieNode[0],p,k,level-1);
				}
			}
		}
		return 0;
	}
}
