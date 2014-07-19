[kn2series] = xlsread('memsepdata.xlsx','series','V3:V7');
[kn2parallel] = xlsread('memsepdata.xlsx','parallel','V3:V7');
[p] = xlsread('memsepdata.xlsx','parallel','X3:X7');

plot(p,kn2series,'*', p, kn2parallel, '*');