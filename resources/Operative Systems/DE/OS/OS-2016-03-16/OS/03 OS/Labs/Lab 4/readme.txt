Ashraf Elsayed

1.

java deadlock a 2 2

time = 0 available = 2 blocked = 0
time = 1 available = 2 blocked = 0
time = 2 available = 2 blocked = 0
time = 3 available = 2 blocked = 0
time = 4 available = 2 blocked = 0
time = 5 available = 2 blocked = 0
time = 6 available = 2 blocked = 0
time = 7 available = 2 blocked = 0
time = 8 available = 2 blocked = 0
time = 9 available = 2 blocked = 0
time = 10 available = 0 blocked = 0
time = 11 available = 0 blocked = 0
time = 12 available = 0 blocked = 0
time = 13 available = 0 blocked = 0
time = 14 available = 0 blocked = 0
time = 15 available = 0 blocked = 0
time = 16 available = 0 blocked = 0
time = 17 available = 0 blocked = 0
time = 18 available = 0 blocked = 0
time = 19 available = 0 blocked = 0

No Deadlock because there're two instances available for the two processes.



2.

java deadlock b 2 1 1

time = 0 available = 1 1 blocked = 0
time = 1 available = 1 1 blocked = 0
time = 2 available = 1 1 blocked = 0
time = 3 available = 1 1 blocked = 0
time = 4 available = 1 1 blocked = 0
time = 5 available = 1 1 blocked = 0
time = 6 available = 1 1 blocked = 0
time = 7 available = 1 1 blocked = 0
time = 8 available = 1 1 blocked = 0
time = 9 available = 1 1 blocked = 0
time = 10 available = 0 0 blocked = 0
time = 11 available = 0 0 blocked = 0
time = 12 available = 0 0 blocked = 0
time = 13 available = 0 0 blocked = 0
time = 14 available = 0 0 blocked = 0
time = 15 available = 0 0 blocked = 0
time = 16 available = 0 0 blocked = 0
time = 17 available = 0 0 blocked = 0
time = 18 available = 0 0 blocked = 0
time = 19 available = 0 0 blocked = 0
time = 20 available = 0 0 blocked = 2

.:	b0 takes resource 0, while waiting for resource 1, at the same time b1 takes resource 1 and it waits for resource 0 , owned by b0, So they are waiting for resources owned by each other, thus leading to a deadlock.



java deadlock b 2 1 2


time = 0 available = 1 2 blocked = 0
time = 1 available = 1 2 blocked = 0
time = 2 available = 1 2 blocked = 0
time = 3 available = 1 2 blocked = 0
time = 4 available = 1 2 blocked = 0
time = 5 available = 1 2 blocked = 0
time = 6 available = 1 2 blocked = 0
time = 7 available = 1 2 blocked = 0
time = 8 available = 1 2 blocked = 0
time = 9 available = 1 2 blocked = 0
time = 10 available = 0 1 blocked = 0
time = 11 available = 0 1 blocked = 0
time = 12 available = 0 1 blocked = 0
time = 13 available = 0 1 blocked = 0
time = 14 available = 0 1 blocked = 0
time = 15 available = 0 1 blocked = 0
time = 16 available = 0 1 blocked = 0
time = 17 available = 0 1 blocked = 0
time = 18 available = 0 1 blocked = 0
time = 19 available = 0 1 blocked = 0
time = 20 available = 0 0 blocked = 1
time = 21 available = 0 0 blocked = 1
time = 22 available = 0 0 blocked = 1
time = 23 available = 0 0 blocked = 1
time = 24 available = 0 0 blocked = 1
time = 25 available = 0 0 blocked = 1
time = 26 available = 0 0 blocked = 1
time = 27 available = 0 0 blocked = 1
time = 28 available = 0 0 blocked = 1
time = 29 available = 0 0 blocked = 1
time = 30 available = 0 1 blocked = 0
time = 31 available = 0 1 blocked = 0
time = 32 available = 0 1 blocked = 0
time = 33 available = 0 1 blocked = 0
time = 34 available = 0 1 blocked = 0
time = 35 available = 0 1 blocked = 0
time = 36 available = 0 1 blocked = 0
time = 37 available = 0 1 blocked = 0
time = 38 available = 0 1 blocked = 0
time = 39 available = 0 1 blocked = 0
time = 40 available = 1 2 blocked = 0


.:	2 instances of resource 1, b0 will acquire resource 0, b1 acquires the first instance of resource 2, then when b1 needs the instance of resource 2 it can take the next availalbe instance, b1 has to wait for the only available instance of resource 1 that owned by b0, then b0 terminates, leaving resource 1 to be available for b1, then b1 can terminate, so that no deadlock happaned.
