
**Démarer consul**<br>
![1](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/49b27c4d-f6e8-4e29-b9d4-c58dfdf2e9c3)<br>
![2](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/5ed302e6-3575-4ef7-bf76-cece8cd58c66)<br>


<details>
<summary>Config service</summary><br>

-Ce fichier contient le lien du référentiel qui regroupe tous les fichiers de configuration d'autres services :<br>
![4](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/a0a96ba0-8237-4fa8-a196-2e1beae46105)<br><br>
 -l'annotation @EnableConfigServer active le serveur de configuration, tandis que l'annotation @EnableDiscoveryClient active le client de découverte pour faciliter la gestion des microservices dans un environnement distribué.<br>
![5](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/421a2ab0-fafb-4c5b-935a-9eb07497027b)<br>
-aprés le démmarage de config service:<br>
![6](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/175ecaef-21ea-41e5-ba2a-486c0b4ee64e)<br>
</details>
<br><br>

<details>
  <summary>Customer service</summary>
  -L'entité Customer :<br><br>
  
 ![Description de l'image](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/31ad9f1b-2f8e-4d2a-831c-fa54c1d6f176)<br>
-La ligne spring.config.import=optional:configserver:http://localhost:8080 dans un fichier de configuration indique que Customer-service  doit importer sa configuration depuis un serveur de configuration 
 distant (Config Server) .<br><br>
 ![Description de l'image](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/e84bc4d4-64cf-4f6e-8634-ecd7b0fe8675)<br>
 Le fichier de configuration distant :<br>
 ![Description de l'image](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/4cfbbdbd-baac-4599-a6f8-ae2a81e5ff20)<br>

 ![Description de l'image](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/50b11260-7fcf-4fa4-bf9c-ca76887686f2)<br><br>
  http://localhost:8081/customers 
 ![Description de l'image](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/96803024-4121-4db3-9bb2-43206375bae9)<br>
 
</details>

<br><br>

<details>
  <summary>inventory service</summary>
  
![Description de l'image](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/a0cdcbf1-091b-47b0-b076-e076ca4eda64)<br><br>
![Description de l'image](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/72dcc3a0-a76c-431f-84cd-98a7bd0d7bf8)<br><br>
-L'entité Product :<br><br>
![Description de l'image](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/2fb04636-ae53-441c-ad25-fa1f86674349)<br><br>
![Description de l'image](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/8f3462f5-eed3-4474-8bab-f25f07d9b923)<br><br>
</details>


<br><br>

<details>
  <summary>Gateway service</summary>

  ![16](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/4487be31-07e4-4ce4-87b6-fd5ae6fd13f1)<br><br>
   Gateway service configure une passerelle (gateway) utilisant Spring Cloud Gateway et utilise la découverte de service pour configurer dynamiquement les routes de la passerelle à partir d'un service de découverte. Cela offre une flexibilité et une évolutivité accrues dans un environnement de microservices où de nouveaux services peuvent être ajoutés sans avoir à mettre à jour manuellement la configuration de la passerelle.
  ![17](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/cf9cb46d-05da-4b6b-b348-8af323716fc9) <br><br>
  On peut consulter une API REST depuis la passerelle sans avoir besoin de connaître le port du service.
  ![18](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/172dc596-4a02-4777-a4b2-b0b14ad2e98e)<br><br>

</details>

<br><br>
<details>
  <summary>Order service</summary>
  
  ![19](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/efb98dd4-1250-4ed4-9c68-149d7b2e3acc)<br>
 
  ![20](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/99acbf94-4d1e-413a-87f9-2774f7467a18)<br>
   cette interface Feign définit les méthodes permettant d'interagir avec le service "costumer-service" via des requêtes HTTP GET:
  ![21](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/f83da9d5-f113-4c0d-939b-87ee92b32950)
  L'application initialise des données de commande de manière aléatoire en utilisant des clients Feign pour récupérer des informations depuis d'autres services (customer et inventory). <br>
  ![22](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/f9201c19-1464-4fc5-8747-4224366ee7ee)<br>

</details>

<br><br>

<details>
  <summary>BILLING-SERVICE</summary>

  démarrage du vault :
  ![23](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/0b9fc063-47bf-4e20-99b1-b7f09e22d95c)
  ![24](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/cfeb7586-f0fc-4cc4-af29-e40431047918)
  
  -Dans le fichier de configuration, on définit le token Vault :
  
  ![25](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/2f10e0cc-35f5-4a89-89d6-7867e9bb2cd8)

  -Configuration des secrets avec Vault et Consul  :
  
  ![26](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/b7f4e8d4-c0bc-4101-bdd0-0dfbfc5253b6)
  ![27](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/b78c501f-da1a-41d7-8b16-3a0dc789060d)
  ![28](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/a9a9384f-92c8-4de3-9e58-69672391705e)
  ![30](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/96161fbd-0357-4ae5-9b96-c5badf2db94d)
  ![31](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/e85357b7-b456-4c6a-a424-fc48510a6dcc)
  ![32](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/73cdc415-b8f9-4d69-aeaa-5f70c89296ad)
  ![33](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/98263bb8-1ca3-4e6e-97a5-bb4bca55ecdd)
  ![34](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/ab4a97b5-1360-447f-9893-04585c2364db)
  ![35](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/fe73d1de-d099-4a9b-b2ca-425670b779da)
  ![36](https://github.com/aymanzinabidine14/Architectures-Micro-services-avec-Spring-Cloud-/assets/128410611/c45daf13-4dba-4b05-8a8c-00133759e52e)

</details>









