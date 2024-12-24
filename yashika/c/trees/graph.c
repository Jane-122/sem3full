//structure for adjacency list

#define MAXV 50

struct node
{
	int vertex;
	struct node* link;
};

typedef struct node* NODE

NODE graph[MAXV];
int n=0 //initially vertices are 0


//structure for adjacency multilists

struct edge
{
	short int marked;
	int vertex1, vertex2;
	struct edge* path1;
	struct edge* path2;
};

typedef struct edge* EDGE;

EDGE graph[MAXV];


//dfs
short int visited[MAXV];
void dfs(int v)
{
	NODE w;
	visited[v]=TRUE;
	printf("%5d",v);
	for (w=graph[v];w;w=w->link)
		if (!visited[w->vertex])
			dfs(w->vertex);
}

//bfs
struct queue
{
	int vertex;
	struct queue* link;
};

typedef struct queue *Q;

void addq(Q*,Q*,int);
int deleteq(Q*);

void bfs(int v)
{
	NODE w;
	Q front,rear;
	front=rear=NULL;
	printf("%5d",v);
	visited[v]=TRUE;
	addq(&front,&rear,v);

	while (front)
	{
		v=deleteq(&front);
		for (w=graph[v];w;w->link)
			if (!visited[w->vertex])
			{
				printf("%5d",w->vertex);
				addq(&front, &rear, w->vertex);
				visited[w->vertex]=TRUE;
			}
	}
}

//connected components
void connected(void)
{
	for(i=0;i<n;i++)
	{
		if (!visited[i])
		{
			dfs(i);
			printf("\n");
		}
	}
}






















