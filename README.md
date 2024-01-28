![thumbnail-Formação Java](https://github.com/jacqueline-oliveira/3356-java-screenmatch-web/assets/66698429/d1e7755b-0a61-411f-bb99-9fcfda44f00c)

# Java: criando sua primeira API e conectando ao front

Projeto desenvolvido no terceiro curso da formação Avançando com Java da Alura

## 🔨 Objetivos do projeto

- Atualizar o projeto ScreenMatch, criado inicialmente com linha de comando, para se transformar em uma API REST;
- Entender a estrutura MVC no desenvolvimento de aplicações Web;
- Criar e mapear rotas utilizando as anotações do Spring;
- Utilizar boas práticas e entender o conceito de DTO (Data Transfer Object);
- Conectar dados disponibilizados pelo back-end à uma aplicação front-end, disponibilizada
  nesse [link](https://github.com/jacqueline-oliveira/3356-java-web-front)
- Tratar erros de CORS na disponibilização de dados;
- Fornecer uma experiência fullstack, demonstrando o fluxo ponta a ponta da aplicação.

## Anotações de um controlador

Para que o spring entenda se uma classe é um controlador ou não é preciso usar a anotação ``RestController``.
Apartir daí precisamos dizer qual o tipo de requisição o controlador irá fazer com o GET (@Getmapping)

## Estruturas de pacotes em projetos Java

O Package by Layer é uma abordagem que diz que você deve dividir seu código com base em suas responsabilidades
funcionais. Isso pode incluir coisas como 'model', 'view', 'controller', e 'repository'. Cada camada tem uma
responsabilidade específica. Por exemplo, a camada 'view' manipula a interface do usuário, enquanto a camada '
controller' lidará com a lógica de negócio.

O Package by Layer é uma abordagem que diz que você deve dividir seu código com base em suas responsabilidades
funcionais. Isso pode incluir coisas como 'model', 'view', 'controller', e 'repository'. Cada camada tem uma
responsabilidade específica. Por exemplo, a camada 'view' manipula a interface do usuário, enquanto a camada '
controller' lidará com a lógica de negócio.

````
com.myblog
    .controller
        .PostController
        .CommentController
    .model
        .Post
        .Comment
    .repository
        .PostRepository
        .CommentRepository


````

Neste exemplo, todas as classes relacionadas aos posts do blog estão espalhadas por diferentes pacotes, baseados na
função que desempenham. O mesmo se aplica às classes de comentários.

Porém, existe um outro tipo de organização, utilizado, por exemplo, na formação Spring Boot. Ele é chamado Package by
Feature, ou pacotes por funcionalidades. Ele sugere que você deve organizar seu código com base nos recursos individuais
do seu aplicativo. Em vez de dividir seu código com base em sua função, você divide com base no recurso que ele
implementa.

Usando o mesmo exemplo do blog, com 'Package by Feature', teríamos algo assim:

````
com.myblog
    .post
        .Post
        .PostController
        .PostRepository
    .comment
        .Comment
        .CommentController
        .CommentRepository

````

**Quando usar cada um?**

Então, qual abordagem você deve usar? Depende. 'Package by Layer' pode ser útil se você tiver uma equipe grande e
complexa, na qual muitas pessoas podem estar trabalhando em diferentes camadas ao mesmo tempo. Ele separa as
responsabilidades claramente, portanto, é menos provável que as pessoas pisem nos pés umas das outras.

No entanto, 'Package by Feature' é muitas vezes preferido para projetos menores e mais ágeis. Ele mantém todas as
classes relacionadas a um recurso juntas, tornando mais fácil para um desenvolvedor entender completamente um recurso.
Também é mais fácil de manter, porque quando um recurso é adicionado ou removido, você sabe exatamente onde todas as
classes relacionadas estão.

Aqui, optamos por utilizar o Package by Layer, mas é interessante que você analise todas as condições para ver a
estrutura que melhor se adequa a seu projeto.

## CORE configuration o que é?

A configuração do CORS (Cross-Origin Resource Sharing) é uma política de segurança que define como as requisições e
respostas entre diferentes origens devem ocorrer. Ela permite que um servidor especifique quais origens têm permissão
para acessar seus recursos. No contexto do curso, a classe CorsConfiguration é usada para configurar o back-end e
permitir o acesso da origem do front-end.

## O que é o live reload?

O Live Reload é uma funcionalidade que permite que as alterações feitas no código sejam refletidas imediatamente, sem a
necessidade de pausar e reiniciar o projeto. Isso facilita o desenvolvimento, pois permite testar e corrigir erros mais
rapidamente, acelerando o processo de desenvolvimento do projeto.

**Como habilita-lo?**

Depois de adicionarmos a dependência:

````
<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
</dependency>

````

Precisaremos configurar também o IntelliJ, porque o projeto já está configurado para utilizar o DevTools, mas devemos
ativar algumas permissões no IntelliJ.

Então, vamos em "File > Settings… > Build, Execution, Deployment > Compiler". Marcaremos a opção "Build project
automatically". Além dessa opção, precisaremos de mais uma. Primeiro, vamos aplicar a alteração anterior clicando em "
Apply" no canto inferior direito.

Em "Advanced Settings", último item do menu lateral esquerdo, vamos marcar a opção "Allow auto-make to start even if
developed application is currently running", que é a segunda opção da lista. Feito isso, podemos aplicar e clicar em "
OK".

