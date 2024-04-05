#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef enum{
  PADARIA,
  CARNES,
  FARMACIA,
  BAZAR,
  BEBIDAS
}SetorMercado;

typedef struct{
  char nome[15];
  SetorMercado setor;
  int quantidade;
  float preco;
}Produtos;

void inserirProduto(Produtos *produto, int *num);
void totalProdutos(Produtos *produto, int num);
void balanco(Produtos *produto);
void pesquisaProduto(Produtos *produto, int num);
void pesquisaSetor(Produtos *produto, int num);
void vendaProduto(Produtos *produto, int num);
const char* getSetorMercado(SetorMercado setor);


int main(){
  int num;
  printf("Quantidade de produtos para cadastrar: \n");
  scanf("%i", &num);
  Produtos *produto =malloc(num*sizeof(Produtos));
  int op;

  do {
    printf("----------MERCADO----------\n");
    printf("(1) Novo Produto\n");
    printf("(2) ??\n");
    printf("(3) Produtos\n");
    printf("(4) Balanco\n");
    printf("(5) Pesquisa de Produto\n");
    printf("(6) Setores\n");
    printf("(7) Venda\n");
    printf("(8) Sair\n");
    printf("Selecione: ");
    scanf("%d", &op);

    switch (op) {
        case 1:
            inserirProduto(produto, &num);
            break;
        case 2:

            break;
        case 3:
            totalProdutos(produto, num);
            break;
        case 4:
            balanco(produto);
            break;
        case 5:
            pesquisaProduto(produto, num);
            break;
        case 6:
            pesquisaSetor(produto, num);
            break;
        case 7:
            vendaProduto(produto, num);
            break;
        case 8:
            printf("FIM");
            break;
        default:
            printf("Escolha um opcao existente!\n");
    }
  } while (op != 8);

  return 0;
}
void inserirProduto(Produtos *produto, int *num){
  getchar();
  for(int i = 0; i < *num; i++){
    printf("Produto %d\n", i+1);
    printf("Nome: ");
    fgets(produto[i].nome, sizeof(produto[i].nome), stdin);

    printf("Setor: \n(0-Padaria, 1-Carnes, 2-Farmacia, 3-Bazar, 4-Bebidas): ");
    scanf("%d", (int*)&produto[i].setor);

    printf("Quantidade: ");
    scanf("%d", &produto[i].quantidade);

    printf("Preco: ");
    scanf("%f", &produto[i].preco);
    getchar();

    printf("\n");
  }

}
void totalProdutos(Produtos *produto, int num){
  printf("------------PRODUTOS----------\n");
  for (int i = 0; i < num; i++) {
      printf("Nome: %s", produto[i].nome);
      printf("Setor: %s\n", getSetorMercado(produto[i].setor));
      printf("Quantidade: %d\n", produto[i].quantidade);
      printf("Preco: R$%0.2f\n", produto[i].preco);
      printf("\n");
  }

}
void balanco(Produtos *produto){

}
void pesquisaProduto(Produtos *produto, int num){
  char nome[15];
  getchar();

  printf("Nome: ");
  fgets(nome, sizeof(nome), stdin);

  for (int i = 0; i < num; i++) {
    if (strcmp(nome, produto[i].nome) == 0) {
      printf("----------PRODUTO %d-----------\n", i+1);
      printf("Nome: %sSetor: %s\nQuantidade: %d\nPreco: %0.2f\n", produto[i].nome, getSetorMercado(produto[i].setor), produto[i].quantidade, produto[i].preco);
    }
    printf("-------------------------------\n");

  }
}
void pesquisaSetor(Produtos *produto, int num){
  int set;

  printf("Setor: \n(0-Padaria, 1-Carnes, 2-Farmacia, 3-Bazar, 4-Bebidas): ");
  scanf("%d", &set);

  for (int i = 0; i <num; i++) {
    if(produto[i].setor == set){
      printf("----------SETOR %s-----------\n", getSetorMercado(produto[i].setor));
      printf("Nome: %sSetor: %s\nQuantidade: %d\nPreco: %0.2f\n", produto[i].nome, getSetorMercado(produto[i].setor), produto[i].quantidade, produto[i].preco);
    }
    printf("-------------------------------\n");
  }
}
void vendaProduto(Produtos *produto, int num){
  char nome[15];
  getchar();

  printf("Nome para venda: ");
  fgets(nome, sizeof(nome), stdin);

  for (int i = 0; i < num; i++) {
    if (strcmp(nome, produto[i].nome) == 0) {
      produto[i].quantidade=(produto[i].quantidade-1);
      printf("%d\n", produto[i].quantidade);
    }
  }
}
const char* getSetorMercado(SetorMercado setor) {
    switch (setor) {
        case PADARIA:
            return "Padaria";
        case CARNES:
            return "Carnes";
        case FARMACIA:
            return "Farmacia";
        case BAZAR:
            return "Bazar";
        case BEBIDAS:
            return "Bebidas";
        default:
            return "Desconhecido";
    }
}
