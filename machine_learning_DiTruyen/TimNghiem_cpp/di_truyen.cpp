#include <iostream>
#include <cmath>

using namespace std;

//danganhphu 61134177
int ct[10], GTTN[10];
int n = 4, kq;
int max1, max2;
int max1Moi = 0, max2Moi = 0;
int A[5], B[5];

void taoQuanThe(int n)
{
	for (int i = 0; i < n; i++)
	{
		cout << "Nhap ca the thu " << i << ": ";
		cin >> ct[i];
	}
}

void giaTriThichNghi(int n)
{
	int gttn;
	for (int i = 0; i < n; i++)
	{
		gttn = (1000 - (ct[i] * ct[i] - 64));
		GTTN[i] = gttn;
	}
}

int kiemTra(int n)
{
	for (int i = 0; i < n; i++)
	{
		if (GTTN[i] == 1000)
			return (ct[i]);
	}
	return 0;
}

void timCaTheLai()
{
	for (int i = 0; i < n; i++)
	{
		for (int j = i + 1; j < n; j++)
		{
			if (GTTN[i] < GTTN[j])
			{
				int a = GTTN[i];
				GTTN[i] = GTTN[j];
				GTTN[j] = a;
			}
		}
	}
		max1 = sqrt(1064 - GTTN[0]);
		max2 = sqrt(1064 - GTTN[1]);
}

void laiCaThe()
{
	for (int i = 0; i < 5; i++)
	{
		A[i] = 0;
		B[i] = 0;
	}

	while(max1 != 0)
	{
		for (int j = 0; j < 5; j++)
		{
			A[j] = max1 % 2;
			max1 = max1 / 2;
		}
	}

	while(max2 != 0)
	{
		for (int k = 0; k < 5; k++)
		{
			B[k] = max2 % 2;
			max2 = max2 / 2;
		}
	}

	for (int l = 4; l > 1; l--)
	{
		int b = A[l];
		A[l] = B[l];
		B[l] = b;
	}

	for (int m = 4; m >= 0; m--)
	{
		max1Moi += A[m] * pow(2, m);
		max2Moi += B[m] * pow(2, m);
	}
}

void taoQuanTheMoi()
{
	ct[0] = max1;
	ct[1] = max2;
	ct[2] = max1Moi;
	ct[3] = max2Moi;
}

//danganhphu 61134177
int main()
{
	cout << "\nGiai phuong trinh x*x = 64 bang thuat toan di truyen" << endl;
	cout << "\nTao quan the co 4 ca the" << endl;
	taoQuanThe(n);
	giaTriThichNghi(n);
	kq = kiemTra(n);

	while (kq == 0)
	{
		timCaTheLai();
		laiCaThe();
		taoQuanTheMoi();
		giaTriThichNghi(n);
		kq = kiemTra(n);
		
	}
	cout << "\nKet qua phuong trinh x = " << kq;
	
	return 0;
}