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

### Passo 1: Autenticação na Azure

Abra o terminal no Visual Studio Code e faça login na sua conta Azure usando o comando:

```bash
az login




