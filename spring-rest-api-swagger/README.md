### Subindo aplicação com docker

1. No diretório raiz da aplicação:
```
docker build -t nome_da_imagem_do_docker .
```
2. Para verificar se imagem foi criada:
```
docker images
```
3. Rodando um container a partir da imagem criada
```
docker run --name nome_docker_container -p 8080:8080 nome_da_imagem_do_docker
```