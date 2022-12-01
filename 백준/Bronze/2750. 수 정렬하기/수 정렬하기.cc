#include <stdio.h>

int main()
{
	int  min, temp,number,index=0;
	int arr[1001]; // 인덱스를 0~1000로 이용하려고 1001로 ..
	scanf("%d", &number);
	for (int i = 0; i < number; i++)
	{
		scanf("%d", &arr[i]); 
	}
	
	for (int i = 0; i < number; i++)
	{
		min = 1001;
		for (int j = i; j < number; j++)
		{
			if (min > arr[j])
			{
				min = arr[j];
				index = j;
			}


		}
		temp = arr[i];
		arr[i] = min;
		arr[index] = temp;

	}


for (int i = 0; i < number; i++)
{
	printf("%d\n", arr[i]);
}
}
