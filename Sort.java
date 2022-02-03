
voidsolve(intTC)throwsException{
    //sortinttechniques
    int[]arr=newint[]{5,8,1,4,2,10,11,3,7};
    intn=arr.length;

    //insertionsort
    for(inti=1;i<n;i++){
      intkey=arr[i];
      intj=i-1;
      while(j>=0&&arr[j]>key){
        arr[j+1]=arr[j];
        j--;
      }
      arr[j+1]=key;
    }

    for(intp:arr)p(p+"");
}

voidsolve(intTC)throwsException{
//sortinttechniques
int[]arr=newint[]{5,8,1,4,2,10,11,3,7};
intn=arr.length;

//mergesort
mergeSort(arr,0,n-1);

for(intp:arr)p(p+"");
}

privatevoidmergeSort(int[]arr,inti,intn){
if(i<n){
intmid=(i+n)/2;
mergeSort(arr,i,mid);
mergeSort(arr,mid+1,n);
merge(arr,i,mid,n);
}
}

privatevoidmerge(int[]arr,intp,intq,intr){

int[]left=Arrays.copyOfRange(arr,p,q+1);
int[]right=Arrays.copyOfRange(arr,q+1,r+1);
List<Integer>a=Arrays.stream(left).boxed().collect(Collectors.toList());
List<Integer>b=Arrays.stream(right).boxed().collect(Collectors.toList());
a.add(Integer.MAX_VALUE);
b.add(Integer.MAX_VALUE);
inti=0,j=0;
for(intk=p;k<=r;k++){
if(a.get(i)<b.get(j)){arr[k]=a.get(i);i++;}
else{arr[k]=b.get(j);j++;}
}
}

