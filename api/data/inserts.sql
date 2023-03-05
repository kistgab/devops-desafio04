-- Inserção de usuários
INSERT INTO usuario (nome, email, apelido, data_nascimento, senha, imagem_url) 
VALUES 
('Paulo Silveira', 'usuario@cwi.com.br', 'p.silveira', '1990-01-01', '$2a$10$VrIbJURwINOR5HOrWFFTNOwSILsioRJSuOGAg8Luvr9qZDSOl5JXG', 'https://pbs.twimg.com/profile_images/930602367887822850/2v0lXfIR_400x400.jpg'),
('Nina Talks', 'usuario2@cwi.com.br', 'm.souza', '1995-05-05', '$2a$10$VrIbJURwINOR5HOrWFFTNOwSILsioRJSuOGAg8Luvr9qZDSOl5JXG', 'https://pbs.twimg.com/profile_images/1531309492775837696/I6X-5DQl_400x400.jpg'),
('Fabio Akita', 'usuario3@cwi.com.br', 'p.alves', '1998-12-15', '$2a$10$VrIbJURwINOR5HOrWFFTNOwSILsioRJSuOGAg8Luvr9qZDSOl5JXG', 'https://yt3.googleusercontent.com/ytc/AL5GRJVr4LwZq8L8_Yj1mMM1bwCOYNDx8jQjASKC5vRUWnY=s900-c-k-c0x00ffffff-no-rj'),
('Erick Wendel', 'usuario4@cwi.com.br', 'j.santos', '1992-07-20', '$2a$10$VrIbJURwINOR5HOrWFFTNOwSILsioRJSuOGAg8Luvr9qZDSOl5JXG', 'https://yt3.googleusercontent.com/EP4HtvEeMu0Fu4ZX2rmRtu0bByGlou6fk8qhoA-oY1G59tmDy87PNlzPzTxRCqXaBW_kv9rzEAg=s900-c-k-c0x00ffffff-no-rj');

-- Inserção de permissões
INSERT INTO permissao (funcao, id_usuario) 
VALUES 
('USUARIO', 1),
('USUARIO', 2),
('USUARIO', 3),
('USUARIO', 4);

-- Inserção de amizades
INSERT INTO amizade (id_usuario, id_amigo, status) 
VALUES 
(1, 2, 'ACEITA'),
(3, 1, 'ACEITA'),
(4, 1, 'PENDENTE'),

(2, 3, 'PENDENTE'),

(3, 4, 'ACEITA');

-- Inserção de postagens
INSERT INTO postagem (id_usuario, conteudo, data_postagem, privado) 
VALUES 
(1, 'Comecei a aprender Python hoje, estou empolgado!', '2022-01-01 12:00:00', true),
(2, 'Qual a melhor linguagem de programação para desenvolvimento web?', '2022-01-02 13:30:00', false),
(3, 'Compartilhando minha nova biblioteca de funções em JavaScript para manipulação de DOM', '2022-01-02 18:20:00', true),
(4, 'Finalmente consegui fazer meu primeiro deploy no AWS! Agora é só escalar!', '2022-01-03 09:10:00', false),

(1, 'Fiz uma correção de bug em um projeto open source. É muito legal contribuir para a comunidade!', '2022-01-04 14:00:00', true),
(2, 'Estou fazendo um curso de segurança da informação e estou impressionado com a quantidade de vulnerabilidades que existem na web!', '2022-01-06 15:20:00', false),
(3, 'Alguém tem alguma dica para melhorar o desempenho de uma aplicação em Node.js?', '2022-01-05 10:45:00', false),

(1, 'Acho que finalmente entendi o conceito de funções lambda em Python. Foi difícil, mas consegui!', '2022-01-08 18:30:00', false),
(3, 'Fiz um projeto em React e estou muito feliz com o resultado! Quem quiser dar uma olhada, o link está na minha bio.', '2022-01-09 16:15:00', true),
(4, 'Gostei bastante do novo framework PHP que eu usei em um projeto recente. Alguém mais já experimentou?', '2022-01-07 11:00:00', true),

--novos
(2, 'Acabei de concluir um projeto de inteligência artificial que utiliza redes neurais para detecção de objetos em imagens. Foi um grande desafio!', '2022-01-10 10:00:00', false),
(3, 'Estou estudando C# para desenvolvimento de jogos e estou adorando! Alguém mais aqui curte game development?', '2022-01-11 14:20:00', true),
(4, 'Comecei a aprender Docker hoje e já estou impressionado com a facilidade de gerenciar aplicações em containers. Recomendo!', '2022-01-12 09:10:00', false),

(1, 'Acabei de participar de um hackathon e minha equipe desenvolveu um sistema de gerenciamento de estoque usando RFID. Foi incrível ver como tecnologias diferentes podem ser integradas para resolver problemas!', '2022-01-13 17:00:00', true),
(3, 'Compartilhando um tutorial que fiz sobre como implementar autenticação com JWT em aplicações Node.js. Espero que ajude alguém!', '2022-01-14 12:20:00', true),
(2, 'Estou trabalhando em um projeto de realidade virtual para treinamento de profissionais de saúde. É muito legal ver como a tecnologia pode ser usada para melhorar a qualidade da educação.', '2022-01-15 10:45:00', false),

(1, 'Participei de um webinar sobre desenvolvimento de chatbots usando Python e fiquei muito interessado no assunto. Alguém aqui já desenvolveu algum chatbot?', '2022-01-16 18:30:00', false),
(4, 'Recentemente comecei a usar um banco de dados NoSQL em um projeto e estou gostando bastante da experiência. Quem mais aqui já usou?', '2022-01-17 11:15:00', true),
(2, 'Estou aprendendo a utilizar o framework React Native para desenvolvimento de aplicativos mobile e já estou animado para colocar em prática!', '2022-01-18 16:00:00', false);

-- select * from permissao;
-- select * from usuario;
-- select * from amizade;
-- select * from postagem;
-- select * from curtida;
-- select * from comentario;
