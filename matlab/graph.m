% Object Oriented Concurrent Programming - Homework-I
% @author NubilaPardus
%
n = [2,3,4,8,12,16,24];
% Ideal Lock
ideal = 6546233 * ones(1,7);
% Test-and-set (TAS) Lock
tas = [
6546233
11301194
12896636
26640040
122133493
184299909
687610405
];
%  Test-and-test-and-set (TTAS) Lock
ttas = [
7892238
9065389
12673091
28169111
119504206
136201457
673659865
];
%  Exponential Backoff Lock
backoff = [
6012717
9925286
23718286
31780462
81377717
68032534
605643741
];
%  Anderson Queue Lock with capacity=numberOfThread=n
anderson_with_n = [
7791588
10183838
11877741
22887199
94186467
235237701
804514862
];

%------ Plotting
figure(1)
plot(n, ideal, 'r-p')
grid on
hold on
xlim([0,25])
ylim([0,9e8])
plot(n, tas, 'c-o')
plot(n, ttas, 'b-*')
plot(n, backoff, 'm-.')
plot(n, anderson_with_n, 'g-+')
legend({'Ideal lock with no overhead.', 'Test-and-set (TAS) Lock', 'Test-and-test-and-set (TTAS) Lock', 'Exponential Backoff Lock', 'Anderson Queue Lock with capacity of n'},'Location','northwest')
title('Schematic performance of a TASLock, a TTASLock, a Backoff Lock, an Anderson Lock with n capacity, and an ideal lock with no overhead.')
xlabel('number of threads (n)')
ylabel('total time (nanosec)')




%  Anderson Queue Lock with capacity=n/2
anderson_with_n_over2 = [
4330848
4475623
7499486
13106687
19146025
58824559
307544924
];
%  Anderson Queue Lock with capacity=n/2 + 2
anderson_with_n_plus1_over2 = [
7151589
10435462
12710653
19687198
83924589
181338771
326493296
];
ideal = 4330848 * ones(1,7);
figure(2)
plot(n, ideal, 'r-p')
grid on
hold on
xlim([0,25])
ylim([0,9e8])
plot(n, anderson_with_n, 'g-+')
plot(n, anderson_with_n_over2, 'b-*')
plot(n, anderson_with_n_plus1_over2, 'm-.')

legend({'Ideal lock with no overhead','Anderson Queue Lock with capacity of n', 'Anderson Queue Lock with capacity of n/2' 'Anderson Queue Lock with capacity of n/2 + 2'},'Location','northwest')
title('Schematic performance of Anderson Lock with different capacity, and an ideal lock with no overhead.')
xlabel('number of threads (n)')
ylabel('total time (nanosec)')