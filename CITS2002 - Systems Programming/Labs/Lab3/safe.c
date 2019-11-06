#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <stdbool.h>

bool isSafe(char password[])
{
	int uppercase = 0;
	int lowercase = 0;
	int digits = 0;
	bool result = false;
	int length = strlen(password);
	
	for(int i = 0; i < length; i++)
	{
	    {
		if(isalpha(password[i]))
		{
			if(isupper(password[i]))
			{
				uppercase++;
			}
			else
			{
				lowercase++;
			}
		}
		else if(isdigit(password[i]))
		{
			digits++;
		}
	    }
	}
	
	if(uppercase == 2 && lowercase == 2 && digits == 2)
	{
		result = true;	
	}
	
	return result;
}

int main(int argc, char *argv[])
{
	if (argc < 2)
	{
		fprintf(stderr, "Usage: %s argument\n" ,argv[0]);
		exit(EXIT_FAILURE);
	}
	else
	{
		bool safe = isSafe(argv[1]);
		if(safe == true)
		{
			printf("Your password is safe.");
		}	
		else
		{
			printf("Your password is not safe.");
		}
		exit(EXIT_SUCCESS);
	}
	return 0;
}
