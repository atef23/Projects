[tAer] = xlsread('heatExData.xlsx','ferm','N2:N14');
[conc] = xlsread('heatExData.xlsx','ferm','O2:O14');

plot(tAer, conc, '*');