
#include<stdio.h>

#include<stdlib.h>

#include<string.h>

#include<math.h>

typedef struct scoreNode{

    double score;

    char name[10];

    struct scoreNode *next;

}scoreNode,*scoreLink;

 

void findM(scoreNode *inLink,scoreNode *scLink,double aver){

    char name[10];

    char name1[10];

    double temp0,temp1; 

    scoreNode *p=NULL;

    p=scLink;

    temp0=temp1=fabs(inLink->score-aver);

    strcpy_s(name,strlen(inLink->name)+1,inLink->name);

    strcpy_s(name,strlen(inLink->name)+1,inLink->name);

    inLink=inLink->next; 

    //printf("%lf\n",inLink->score);

    while(inLink){      

        double temp2=fabs(inLink->score-aver);

        if(temp0>temp2){

            temp0=temp2;

            strcpy_s(name,strlen(inLink->name)+1,inLink->name);

        }

        if(temp1<temp2){

            temp1=temp2;

            strcpy_s(name1,strlen(inLink->name)+1,inLink->name);

        }

        inLink=inLink->next;

    }

    while(scLink){

        if(strcmp(name,scLink->name)==0){

            scLink->score=scLink->score+1;

        }

        if(strcmp(name1,scLink->name)==0){

            scLink->score=scLink->score-1;

        }

        scLink=scLink->next;

    }

     

    while(p){

        printf("%s�ĵ÷�Ϊ��%lf\n",p->name,p->score);

        p=p->next;

    }

}

//�ж�������Ƿ����

int isEqual(double e[10],double temp){

    //double *p;

    //p=e;

    int i;

    for(i=0;i<10;i++){

        if(e[i]==temp)

            return 1;

    }

    return 0;

}

void goldPoint(){

    int num;

    int time;

    double sum=0;

    double aver;

    int i,j;

    int m=0;//������ʼ�������±�

    scoreNode *head,*p,*q,*head0,*q0,*p0;

    double numArray[10]={0};

    head=NULL;

    head0=NULL;

    q=NULL;

    q=head;

    q0=head0;   

    printf("������μӵ�������\n");

    scanf_s("%d",&num); 

    printf("��������Ҫ���м��֣�\n");

    scanf_s("%d",&time);

    printf("��1�ֿ�ʼ\n");

    for(i=0;i<num;i++){

        p=(scoreNode *)malloc(sizeof(scoreNode));

        p0=(scoreNode *)malloc(sizeof(scoreNode));

        printf("������������֣�\n");

        scanf_s("%s",p->name,sizeof(p->name));

        printf("�������������\n");        

        scanf_s("%lf",&p->score,sizeof(p->score));<br>��������������������//ÿ����������ֲ�����ͬ

        while(isEqual(numArray,p->score)){

            printf("�Ѿ��������룬���������룺\n");

            scanf_s("%lf",&p->score,sizeof(p->score));            

        }

        numArray[i]=p->score;

 

        p0->next=NULL;

        p->next=NULL;

        if(head==NULL){

            head=p;

            q=p;

        }else{

            q->next=p;

            q=p;

        }

        sum+=p->score;

        strcpy_s(p0->name,strlen(p->name)+1,p->name);

        p0->score=0;

        if(head0==NULL){

            head0=p0;

            q0=p0;

        }else{

            q0->next=p0;

            q0=p0;

        }

 

    }

    aver=sum/num*0.618;

    //printf("aver=%lf\n",aver);

    q=head;

    q0=head0;

    findM(q,q0,aver);

    sum=0;

    printf("��1�ֽ���\n");

    for(i=0;i<time-1;i++){

        printf("��%d�ֿ�ʼ\n",(i+2));

        //���³�ʼ������

        for(j=0;j<10;j++){

            numArray[j]=0;

        }

        q=head;

        while(q){

            printf("%s�����������:\n",q->name);

            scanf_s("%lf",&q->score);

            while(isEqual(numArray,q->score)){

                printf("�Ѿ��������룬���������룺\n");

                scanf_s("%lf",&q->score,sizeof(q->score));            

            }

            numArray[m]=q->score;

            m++;

 

            sum+=q->score;

            q=q->next;

        }

        aver=sum/num*0.618;

        q=head;

        q0=head0;

        findM(q,q0,aver);

        sum=0;

        m=0;

        printf("��%d�ֽ���\n",(i+2));

    }

    printf("��Ϸ����\n");

}

 

void main(){

    goldPoint();

}