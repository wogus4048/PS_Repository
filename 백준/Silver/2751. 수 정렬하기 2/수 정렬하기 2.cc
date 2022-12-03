#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int sorted[1000001];
int arr[1000001];
int number;

void merge(int* arr, int left, int mid, int right)
{
	int i = left;
	int j = mid + 1;
	int k = left;

	while (i <= mid && j <= right)
	{
		if (arr[i] <= arr[j])
		{
			sorted[k] = arr[i];
			i++;
			k++;
		}
		else
		{
			sorted[k] = arr[j];
			j++;
			k++;

		}

	}

	if (i > mid)
	{
		for (int t = j; t <= right; t++)
		{
			sorted[k] = arr[t];
			k++;
		}

	}
	else
	{
		for (int t = i; t <= mid ;t++)
		{
			sorted[k] = arr[t];
			k++;
		}
	}


	for (int t = left; t <= right; t++)
	{
		arr[t] = sorted[t];
	}


}


void merge_sort(int* arr, int left, int right)
{
	if (left < right)
	{
		int mid = (left + right) / 2;

		merge_sort(arr, left, mid);
		merge_sort(arr, mid + 1, right);
		merge(arr, left, mid, right);

	}
	
}

int main(void)
{
	
	
	scanf("%d", &number);
	for (int i = 0; i < number; i++)
	{
		scanf("%d", &arr[i]);

	}

	merge_sort(arr, 0, number-1);
	for (int i = 0; i < number; i++)
	{
		printf("%d\n", arr[i]);
	}
	return 0;
}