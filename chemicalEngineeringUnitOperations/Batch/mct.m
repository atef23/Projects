[xe] = xlsread('batchData.xlsx','mlab','A16:A30');
[ye] = xlsread('batchData.xlsx','mlab','B16:B30');

y10 = .9091*xe + .02727;

y7 = .875*xe + .0375;

y4 = .8*xe + .06;

y45 = xe;

plot(xe,ye,xe,y10,xe,y7,xe,y4,xe,y45);