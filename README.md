# AeroParts

## Integrantes do Grupo
- Leonardo Paganini RM96562
- Matheus Leite RM96893
- Jhonn Brandon RM97305
- Regina Pompeo RM97032

## Descrição
Este projeto visa o desenvolvimento de um sistema de automação destinado a simplificar o 
processo de cotação de compras de peças pequenas e médias para a indústria da aviação. No 
âmbito da aviação, a aquisição de peças de alta qualidade é essencial para garantir a segurança 
e eficiência das operações aéreas. O sistema proposto busca otimizar a interação entre 
compradores e fornecedores, oferecendo uma plataforma eficaz para o registro de cotações, 
gerenciamento de fornecedores, pedidos e produtos. A automação desse processo 
proporciona maior eficiência, reduzindo o tempo necessário para obter cotações competitivas 
e facilitando o controle e a análise dos dados de aquisição.

## Guia de Implantação do AeroParts na Nuvem Azure

Este guia fornece instruções passo a passo para implantar a aplicação AeroParts na nuvem Azure usando Docker e Azure Container Registry (ACR).

### Pré-requisitos

Antes de começar, certifique-se de ter os seguintes pré-requisitos instalados e configurados:

- [Azure CLI](https://docs.microsoft.com/pt-br/cli/azure/install-azure-cli)
- [Docker Desktop](https://www.docker.com/products/docker-desktop)
- [Visual Studio Code](https://code.visualstudio.com/)

Além disso, instale as seguintes extensões no Visual Studio Code:

- Azure Account
- Docker

### Guia de Implantação do Projeto na Nuvem Azure com Docker e Azure Container Registry

### Passo 1: Autenticação na Azure

Abra o terminal no Visual Studio Code e faça login na sua conta Azure usando o comando:

```bash
az login

### Passo 2: Criação de Recursos na Azure

Crie um grupo de recursos na Azure com o seguinte comando, substituindo `nome-resourse-group` pelo nome desejado e `eastus` pela região desejada:

```bash
az group create --name nome-resourse-group --location eastus

### Passo 3: Criação do Azure Container Registry (ACR)

Para criar um registro de container na Azure, execute o seguinte comando no terminal do Azure CLI, substituindo `nome-resourse-group-criado` pelo nome do grupo de recursos criado anteriormente e `nome-container` pelo nome desejado para o registro de container:

```bash
az acr create --resource-group nome-resourse-group-criado --name nome-container --sku Basic

### Passo 4: Clonagem do Repositório

```bash
git clone repositorio-github

### Passo 5: Construção da Imagem Docker

Construa a imagem Docker usando o seguinte comando, substituindo nome-imagem pelo nome desejado:

```bash
docker build -t nome-imagem .

### Passo 6: Configuração do Acesso ao ACR

Acesse o portal Azure, vá para o ACR criado e ative o Utilizador Administrador. Anote o Nome de Utilizador e a Senha gerados.

### Passo 7: Login no ACR

Faça login no ACR usando o terminal do Visual Studio Code com o seguinte comando, substituindo nome-Servidor-de-início-de-sessão, Nome do Utilizador e password pelos valores correspondentes:

```bash
docker login nome-Servidor-de-início-de-sessão.io

### Passo 9: Tag e Envio da Imagem para o ACR

Tagueie a imagem criada com o nome do ACR e envie para o ACR com os seguintes comandos:

```bash
docker tag nome-imagem Servidor-de-início-de-sessão.io/nome-imagem
docker push Servidor-de-início-de-sessão.io/nome-imagem












