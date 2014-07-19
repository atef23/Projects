[xo2series] = xlsread('memsepdata.xlsx','series','V11:V15');
[xo2parallel] = xlsread('memsepdata.xlsx','parallel','V11:V15');
[p] = xlsread('memsepdata.xlsx','parallel','W11:W15');

plot(p,xo2series,'*', p, xo2parallel, '*');