Projeto Final individual feito em Setembro de 2022 durante o Treinamento Java realizado pela Grande Porte Treinamentos no qual participei.

Essa aplicação tem como objetivo praticar o que foi mostrado durante o treinamento Java, como aprendizado e evolução, esse projeto realiza conexão 
com banco de bados local Mysql, que possui duas tabelas (cliente e pedido) e se relacionam entre si, através dessa aplicação é possível 
realizar o CRUD nessas tabelas e exibir os dados de cliente e pedidos através de interfaces gráficas JFrame.

# Clientes do Restaurante

![image](https://user-images.githubusercontent.com/68198636/194935379-4302ab13-78ed-4c10-80aa-87ff44c825c9.png)

 
## Menu de Funções Cliente do Restaurante

  * Inserir Cliente
  * Alterar
  * Remover
  * Atualizar
  
  Sendo assim, o funcionário  seleciona os respectivas botões: 
  
   1. Inserir Cliente - o funcionário digita o nome, cpf e contato do cliente a ser inserido. Esse cliente é inserido na tabela de cliente e é exibido na interface.  
   
   ![image](https://user-images.githubusercontent.com/68198636/194936716-32aac772-d3ae-421e-bd8e-0748c64d15a1.png)
    
   ![image](https://user-images.githubusercontent.com/68198636/194936760-88572c8b-c945-4921-b205-610e74e35f50.png)
   
   ![image](https://user-images.githubusercontent.com/68198636/194936899-81135b0d-05b6-48bb-960b-d5788610e41a.png)
  
   ![image](https://user-images.githubusercontent.com/68198636/194936976-236424b8-cc55-4771-b11e-9d754e50a1ef.png)
   
   ![image](https://user-images.githubusercontent.com/68198636/194937025-adc3ca1e-59c7-49ad-acf0-b62bfaf03750.png)

   2. Alterar Cliente - o funcionário seleciona na tabela o cliente que deseja ser alterado alguma informação. 
      Após isso o cliente é alterado na tabela e é exibido na interface após uma atualiza-la;
   
   ![image](https://user-images.githubusercontent.com/68198636/194937226-7283aaf3-2f31-4fe0-9284-72aecac1935a.png)
   
   ![image](https://user-images.githubusercontent.com/68198636/194937607-f68e7ceb-e541-4400-91aa-bb5148a8afc1.png)

   ![image](https://user-images.githubusercontent.com/68198636/194937685-16cbd96e-2848-40f8-94b8-f9364fc716de.png)
   
   3. Remover Cliente -  o funcionário seleciona na tabela o cliente que deseja ser removido. 
      Após isso cliente é removido da tabela cliente e a interface é atualizada sem o cliente;
   
   ![image](https://user-images.githubusercontent.com/68198636/194938099-bb43b58c-f098-4986-84cd-7c0656b2af0c.png)
   
   ![image](https://user-images.githubusercontent.com/68198636/194938161-2f5807a4-a856-4c0e-a32a-97551480b65f.png)
   
   ![image](https://user-images.githubusercontent.com/68198636/194938201-0b645c85-c977-45f0-8ae5-32217acbc1a1.png)

   4. Atualizar a interface após a alteração de um cliente;
   
   ![image](https://user-images.githubusercontent.com/68198636/194938321-2ac93c56-c694-4a90-b4bf-ac981a1bae0d.png)

  ## Menu de inserção de pedidos do cliente
  
  ![image](https://user-images.githubusercontent.com/68198636/194938707-e8caf35e-6bd1-4a8a-8776-37940809d6a6.png)
  
  O funcionário seleciona o cliente a ter realizado o pedido digita o valor do pedido, e seleciona o prato e bebida  pré definidos e escolhido pelo cliente.
  
  ![image](https://user-images.githubusercontent.com/68198636/194938974-aa1a1795-b64a-4562-b1cb-d060c88b8815.png)

  ![image](https://user-images.githubusercontent.com/68198636/194939002-bf7004d7-e046-4487-982e-8cf40a784b09.png)
  
  ![image](https://user-images.githubusercontent.com/68198636/194939246-d657cfb0-1c1b-4216-93f1-da4d1d3b62a6.png)
  
  ![image](https://user-images.githubusercontent.com/68198636/194939280-3558cdbe-285b-417d-b3d3-7ecf8aabc373.png)

  Ao selecionar o cliente e clicar na aba de pedidos, será exibido os pedidos realizados pelo cliente.
  
  ![image](https://user-images.githubusercontent.com/68198636/194939405-bcfbd1f6-ea49-4210-b4ab-f9d1ae54e70c.png)

  ## Menu de pedidos
  
  * Alterar
  * Remover
  
  Assim como na aba de clientes, também é possível o funcionário ao selecionar um pedido e realizar a alteração ou a remoção do pedido, atualizando na tabela pedido.
  
  Regras de Negócio:
  
  * Só é possível alterar o nome e o contato do cliente;
  * Ao remover um cliente da tabela, seus pedidos são removidos;
