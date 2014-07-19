[kn2series] = xlsread('memsepdata.xlsx','series','U21:U26');
[kn2parallel] = xlsread('memsepdata.xlsx','parallel','U21:U26');
[f] = xlsread('memsepdata.xlsx','parallel','B1:B8');

plot(f,kn2series,'*', f, kn2parallel, '*');