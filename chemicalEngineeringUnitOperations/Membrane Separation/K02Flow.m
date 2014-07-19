[ko2series] = xlsread('memsepdata.xlsx','series','Q21:Q26');
[ko2parallel] = xlsread('memsepdata.xlsx','parallel','Q21:Q26');
[f] = xlsread('memsepdata.xlsx','parallel','B1:B8');

plot(f,ko2series,'*', f, ko2parallel, '*');