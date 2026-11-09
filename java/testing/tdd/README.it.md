# TDD

Utilizzare la metodologia *Test-Driven Development (TDD)* per sviluppare quanto segue.

## 1. Fizz Buzz

**Obiettivo**: scrivere un programma che restituisca i numeri da 1 a 100. Per i multipli di tre, però, restituire "Fizz" al posto del numero e per i multipli di cinque restituire "Buzz". Per i numeri multipli sia di tre che di cinque restituire "FizzBuzz".

Output di esempio

	1
	2
	Fizz
	4
	Buzz
	Fizz
	7
	8
	Fizz
	Buzz
	11
	Fizz
	13
	14
	FizzBuzz
	16
	17
	Fizz
	19
	Buzz
	... e così via fino a 100


**Non proseguire nella lettura finché non si è sviluppata questa parte**

#### Nuovi requisiti

 - Un numero è Fizz se contiene la cifra 3
 - Un numero è Buzz se contiene la cifra 5
 - Un numero è FizzBuzz se
 	- contiene la cifra 3, e
 	- contiene la cifra 5

 - I requisiti precedenti restano validi.


## 2. Validatore di password

**Obiettivo**: progettare un componente "validatore di password" usando il TDD.

Ad esempio, si potrebbe configurare un validatore di password per verificare che la password di un utente:

	 - abbia più di 8 caratteri
	 - contenga una lettera maiuscola
	 - contenga una lettera minuscola
	 - contenga un numero
	 - contenga un underscore

Partire da una soluzione semplice e poi rendere il progetto più riutilizzabile applicando i principi e i pattern della programmazione a oggetti.
