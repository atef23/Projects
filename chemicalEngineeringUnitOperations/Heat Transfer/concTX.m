
% hot flow = .192
% cold flow = .4087

x = [0 50 100];
hot = .0017*(x.^2) - .42*(x) + 190;
cold = .00014*(x.^2) - .16*(x) + 110;
plot(x,hot, x, cold);