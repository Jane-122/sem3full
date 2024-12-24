

int eval(NODE root)
{
	float num;
	switch(root->info)
	{
		case ‘+’:return eval(root->llink)+ eval(root->rlink);
		case ‘-’ :return eval(root->llink)- eval(root->rlink);
		case ‘/’:return eval(root->llink)/ eval(root->rlink);
		case ‘*’ :return eval(root->llink)* eval(root->rlink);
		case ‘^’:return pow(eval(root->llink), eval(root->rlink));
		default :return(root->info – ‘0’); //base case
	}
}