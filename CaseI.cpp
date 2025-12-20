#include <stdio.h>

int main() {
    int n, m;
    
	if (scanf("%d %d", &n, &m) != 2) {
    	return 0;
	}
    

    char g[n][m + 1];
    for (int i = 0; i < n; ++i){
    	scanf("%s", g[i]);
	} 

    int pool = 0;
    for (int i = 0; i + 1 < n; ++i){
    	for (int j = 0; j + 1 < m; ++j) {
            int c = (g[i][j] =='.') + (g[i][j+1] =='.') + (g[i+1][j] =='.') + (g[i+1][j+1] =='.');
            if (c == 3) {
            	pool++;
			}
        }
	}
        

    int Q;
	if (scanf("%d", &Q) != 1){
		return 0;
	} 
    
	while (Q--) {
        int r, c; 
        if (scanf("%d %d", &r, &c) != 2){
		return 0;
	} 
	
        int a = r - 1, b = c - 1;

        int oldBloks = (g[a][b] == '.');
        
		if(oldBloks){
        	g[a][b] = '#';
		} else {
			g[a][b] = '.';
		}
        
        int newBloks = (g[a][b] == '.');

        for (int di = -1; di <= 0; ++di) {
            for (int dj = -1; dj <= 0; ++dj) {
                int i = a + di, j = b + dj;
                if (i < 0 || j < 0 || i + 1 >= n || j + 1 >= m) continue;

                int after =
                    (g[i][j] == '.') + (g[i][j+1] == '.') +
                    (g[i+1][j] == '.') + (g[i+1][j+1] == '.');

                int before = after + (oldBloks - newBloks);

                if (before == 3){
                	pool--;
				}
				
                if (after  == 3){
                	pool++;
				} 
            }
        }

        if (pool == 0) {
        	printf("RECTANGLES\n");
		} else {
			printf("NO\n");
		}     
    }
    return 0;
}

