-- =====================================================
-- DATA.SQL - Base de datos de Torneos de Videojuegos
-- =====================================================

-- =====================================================
-- JUEGOS COMPETITIVOS MÁS IMPORTANTES
-- =====================================================

-- MOBA
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('League of Legends', 'MOBA', 'Riot Games', '2009-10-27');
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('Dota 2', 'MOBA', 'Valve Corporation', '2013-07-09');

-- FPS Táctico
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('Counter-Strike 2', 'FPS Táctico', 'Valve Corporation', '2023-09-27');
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('Valorant', 'FPS Táctico', 'Riot Games', '2020-06-02');
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('Rainbow Six Siege', 'FPS Táctico', 'Ubisoft', '2015-12-01');

-- Battle Royale
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('Fortnite', 'Battle Royale', 'Epic Games', '2017-07-25');
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('Apex Legends', 'Battle Royale', 'Respawn Entertainment', '2019-02-04');
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('PUBG: Battlegrounds', 'Battle Royale', 'PUBG Corporation', '2017-12-21');

-- FPS Hero Shooter
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('Overwatch 2', 'FPS Hero Shooter', 'Blizzard Entertainment', '2022-10-04');

-- Fighting Games
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('Street Fighter 6', 'Lucha', 'Capcom', '2023-06-02');
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('Tekken 8', 'Lucha', 'Bandai Namco', '2024-01-26');
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('Mortal Kombat 1', 'Lucha', 'NetherRealm Studios', '2023-09-19');
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('Guilty Gear Strive', 'Lucha', 'Arc System Works', '2021-06-11');
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('Super Smash Bros. Ultimate', 'Lucha de Plataformas', 'Nintendo', '2018-12-07');

-- Estrategia RTS
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('StarCraft II', 'Estrategia RTS', 'Blizzard Entertainment', '2010-07-27');
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('Age of Empires IV', 'Estrategia RTS', 'Relic Entertainment', '2021-10-28');

-- Deportes
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('Rocket League', 'Deportes/Carreras', 'Psyonix', '2015-07-07');
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('FIFA 24', 'Deportes/Fútbol', 'EA Sports', '2023-09-29');
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('NBA 2K24', 'Deportes/Baloncesto', 'Visual Concepts', '2023-09-08');

-- Card Games
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('Hearthstone', 'Cartas Digitales', 'Blizzard Entertainment', '2014-03-11');
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('Magic: The Gathering Arena', 'Cartas Digitales', 'Wizards of the Coast', '2019-09-26');

-- Auto Battler
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('Teamfight Tactics', 'Auto Battler', 'Riot Games', '2019-06-26');

-- Mobile Esports
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('Mobile Legends: Bang Bang', 'MOBA Mobile', 'Moonton', '2016-07-14');
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('Brawl Stars', 'Battle Arena Mobile', 'Supercell', '2018-12-12');
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('Clash Royale', 'Estrategia Mobile', 'Supercell', '2016-03-02');
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('Call of Duty: Mobile', 'FPS Mobile', 'TiMi Studio Group', '2019-10-01');
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('PUBG Mobile', 'Battle Royale Mobile', 'Tencent Games', '2018-03-19');

-- Simulación/Racing
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('iRacing', 'Simulación de Carreras', 'iRacing.com', '2008-08-26');
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('Gran Turismo 7', 'Simulación de Carreras', 'Polyphony Digital', '2022-03-04');

-- Call of Duty (FPS Arcade/Competitivo)
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('Call of Duty: Modern Warfare III', 'FPS', 'Sledgehammer Games', '2023-11-10');
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('Call of Duty: Warzone', 'Battle Royale', 'Infinity Ward', '2020-03-10');

-- Otros Competitivos Populares
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('Halo Infinite', 'FPS Arena', '343 Industries', '2021-12-08');
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('Gears 5', 'TPS', 'The Coalition', '2019-09-10');
INSERT IGNORE INTO juegos (nombre, genero, desarrollador, fecha_salida) VALUES ('Splatoon 3', 'TPS', 'Nintendo', '2022-09-09');

-- =====================================================
-- JUGADORES PROFESIONALES REALES (Mix Internacional)
-- =====================================================

-- League of Legends - T1 Roster (Corea + Internacional)
INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Lee Sang-hyeok', 'Faker', 'faker@t1.gg', '1996-05-07', 'Corea del Sur');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Ryu Ming-gyu', 'Keria', 'keria@t1.gg', '2002-10-14', 'Corea del Sur');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Choi Woo-je', 'Zeus', 'zeus@t1.gg', '2004-03-31', 'Corea del Sur');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Mun Hyeon-jun', 'Oner', 'oner@t1.gg', '2002-12-24', 'Corea del Sur');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Lee Min-hyeong', 'Gumayusi', 'guma@t1.gg', '2002-02-06', 'Corea del Sur');

-- League of Legends - G2 Esports (Europeos + Coreanos)
INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Rasmus Winther', 'Caps', 'caps@g2.gg', '1999-11-17', 'Dinamarca');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Mihael Mehle', 'Mikyx', 'mikyx@g2.gg', '1999-10-02', 'Eslovenia');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Sergen Çelik', 'BrokenBlade', 'bb@g2.gg', '2000-01-06', 'Alemania');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Martin Sundelin', 'Yike', 'yike@g2.gg', '2003-04-15', 'Suecia');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Steven Liv', 'Hans Sama', 'hans@g2.gg', '1999-06-27', 'Francia');

-- League of Legends - MAD Lions (Españoles + Europeos)
INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Álvaro Fernández', 'Alvaro', 'alvaro@mad.gg', '2004-03-12', 'España');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Javier Prades', 'Elyoya', 'elyoya@mad.gg', '2000-09-02', 'España');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Norman Kaiser', 'Kaiser', 'kaiser@mad.gg', '2001-07-14', 'Alemania');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Marek Brázda', 'Humanoid', 'humanoid@mad.gg', '2000-05-10', 'República Checa');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Zdravets Galabov', 'Hylissang', 'hyli@mad.gg', '1995-10-30', 'Bulgaria');

-- Counter-Strike 2 - Natus Vincere (Europa del Este)
INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Oleksandr Kostyliev', 's1mple', 's1mple@navi.gg', '1997-10-02', 'Ucrania');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Aleksandr Dashkevich', 'electroNic', 'electronic@navi.gg', '1998-09-08', 'Rusia');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Denis Sharipov', 'w0nderful', 'w0nderful@navi.gg', '2005-09-15', 'Ucrania');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Ihor Zhdanov', 'iM', 'im@navi.gg', '2003-01-31', 'Ucrania');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Justinas Lekavicius', 'jL', 'jl@navi.gg', '2002-05-03', 'Lituania');

-- Counter-Strike 2 - G2 Esports (Mix Europeo)
INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Nikola Kovač', 'NiKo', 'niko@g2.gg', '1997-02-16', 'Bosnia');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Ilya Zalutskiy', 'm0NESY', 'monesy@g2.gg', '2005-05-01', 'Rusia');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Nemanja Isaković', 'huNter-', 'hunter@g2.gg', '1996-01-03', 'Serbia');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Mario Samayoa', 'malbsMd', 'malbs@g2.gg', '1999-10-23', 'Guatemala');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Rasmus Steensborg', 'HooXi', 'hooxi@g2.gg', '1995-08-21', 'Dinamarca');

-- Counter-Strike 2 - MOUZ (Europeos + Latino)
INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('David Čerňanský', 'Frozen', 'frozen@mouz.gg', '2001-06-02', 'Eslovaquia');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Dorian Berman', 'xertioN', 'xertion@mouz.gg', '2003-03-19', 'Israel');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Ádám Torzsás', 'torszi', 'torszi@mouz.gg', '2004-04-18', 'Hungría');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Jon Ander Ferreiro', 'JDC', 'jdc@mouz.gg', '2003-09-07', 'España');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Jimmy Berndtsson', 'Jimpphat', 'jimpphat@mouz.gg', '2006-03-25', 'Finlandia');

-- Counter-Strike 2 - FaZe Clan (Mix Internacional)
INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Håvard Nygaard', 'rain', 'rain@faze.gg', '1994-08-27', 'Noruega');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Helvijs Saukants', 'broky', 'broky@faze.gg', '2001-03-21', 'Letonia');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Robin Kool', 'ropz', 'ropz@faze.gg', '1999-12-22', 'Estonia');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Finn Andersen', 'karrigan', 'karrigan@faze.gg', '1990-03-14', 'Dinamarca');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Justin Pocius', 'FrozenH', 'frozenh@faze.gg', '2004-09-12', 'Lituania');

-- Dota 2 - Team Liquid (Internacional)
INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Amer Al-Barkawi', 'Miracle-', 'miracle@liquid.gg', '1999-06-20', 'Jordania');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Lasse Urpalainen', 'MATUMBAMAN', 'matumba@liquid.gg', '1995-07-10', 'Finlandia');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Michael Ghannam', 'miCKe', 'micke@liquid.gg', '1998-03-14', 'Suecia');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Neta Shapira', '33', 'thirtythree@liquid.gg', '1997-05-18', 'Israel');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Samuel Svahn', 'Boxi', 'boxi@liquid.gg', '1996-04-29', 'Finlandia');

-- Dota 2 - Team Spirit (Europeos del Este)
INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Illya Mulyarchuk', 'Yatoro', 'yatoro@spirit.gg', '2001-12-30', 'Ucrania');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Alexander Khertek', 'TORONTOTOKYO', 'toronto@spirit.gg', '1999-09-15', 'Rusia');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Magomed Khalilov', 'Collapse', 'collapse@spirit.gg', '1999-10-05', 'Rusia');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Miroslaw Kolpakov', 'Mira', 'mira@spirit.gg', '1999-07-18', 'Rusia');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Yaroslav Naidenov', 'Miposhka', 'mipo@spirit.gg', '1999-03-02', 'Rusia');

-- Fortnite (Mix Internacional)
INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Kyle Giersdorf', 'Bugha', 'bugha@sentinels.gg', '2002-12-30', 'Estados Unidos');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Williams Aubin', 'Setty', 'setty@pro.gg', '2004-11-15', 'Francia');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Malachi Greiner', 'Mero', 'mero@fnatic.gg', '2004-05-13', 'Estados Unidos');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Anas El-Abd', 'Kami', 'kami@pro.gg', '2005-02-07', 'Austria');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Cooper Jackson', 'Coop', 'coop@nrg.gg', '2004-08-19', 'Estados Unidos');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Tyler Blevins', 'Ninja', 'ninja@team.gg', '1991-06-05', 'Estados Unidos');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Thomas Arnould', 'Th0mas', 'thomas@fnatic.gg', '2004-06-22', 'Francia');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Enzo Grondein', 'Queasy', 'queasy@team.gg', '2004-01-10', 'Francia');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('David Davo', 'Vico', 'vico@fortnite.gg', '2004-08-15', 'España');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Hugo Delgado', 'JannisZ', 'jannis@fortnite.gg', '2005-02-20', 'España');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Artur Lima', 'King', 'king@brazil.gg', '2003-11-12', 'Brasil');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Enzo Acosta', 'Enz0', 'enzo@arg.gg', '2004-05-30', 'Argentina');

-- Rocket League - Team Vitality (Franceses)
INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Maello Ernst', 'Seikoo', 'seikoo@vitality.gg', '2005-01-15', 'Francia');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Victor Locquet', 'Vatira', 'vatira@vitality.gg', '2004-07-18', 'Francia');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Yanis Champenois', 'Alpha54', 'alpha54@vitality.gg', '2003-06-14', 'Francia');

-- Rocket League - Gen.G (Franceses)
INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Nolan Herve', 'Zen', 'zen@gen.gg', '2007-07-30', 'Francia');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Evan Rogez', 'Monkey M.', 'monkey@gen.gg', '2002-10-03', 'Francia');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Damien Fauché', 'Jack', 'jack@gen.gg', '2003-08-17', 'Francia');

-- Rocket League - Karmine Corp (Franco-Español)
INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Alexis Carrio', 'AztraL', 'aztral@kc.gg', '2003-01-07', 'Francia');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Atow Ferchichi', 'Atow', 'atow@kc.gg', '2006-06-24', 'Francia');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Victor García', 'VatiraKC', 'vatira@kc.gg', '2004-03-11', 'España');

-- Rocket League - FURIA (Brasileños)
INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Caio Vinicius', 'CaioTG1', 'caio@furia.gg', '2002-09-14', 'Brasil');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Gabriel Zane', 'Yanxnz', 'yan@furia.gg', '2003-11-08', 'Brasil');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Luís Felipe', 'Caard', 'caard@furia.gg', '2003-05-22', 'Brasil');

-- Brawl Stars - STMN Esports (MENA)
INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Mohamed Light', 'MoLight', 'molight@stmn.gg', '2002-06-15', 'Túnez');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Achraf Ardh', 'Ardh', 'ardh@stmn.gg', '2003-03-22', 'Marruecos');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Ahmed Mohamed', 'Symantec', 'symantec@stmn.gg', '2003-07-14', 'Egipto');

-- Brawl Stars - TRIBE Gaming (Europa)
INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Patrik Slezák', 'PatCeex', 'patceex@tribe.gg', '2004-02-19', 'Eslovaquia');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Luka Živković', 'Luke', 'luke@tribe.gg', '2005-04-12', 'Serbia');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Egor Surkov', 'Eqwaak', 'eqwaak@tribe.gg', '2004-05-17', 'Rusia');

-- Brawl Stars - SK Gaming (Latinos + Europeos)
INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Javier López', 'Javititu', 'javititu@sk.gg', '2004-08-25', 'España');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Paulo Silva', 'PauloGG', 'paulo@sk.gg', '2003-07-12', 'Brasil');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Carlos Mendez', 'Carlitos', 'carlos@sk.gg', '2004-10-30', 'México');

-- Valorant - KRU Esports (Latinos)
INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Roberto Cano', 'Mazino', 'mazino@kru.gg', '1999-07-14', 'Chile');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Augusto Ramos', 'Klaus', 'klaus@kru.gg', '2000-09-25', 'Chile');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Ángel Mori', 'Shyy', 'shyy@kru.gg', '2002-12-08', 'Chile');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Emilio Silva', 'Daveeys', 'dave@kru.gg', '2003-03-15', 'Chile');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Matías Delipetro', 'Delz1k', 'delz1k@kru.gg', '2002-11-20', 'Chile');

-- Valorant - Team Heretics (Españoles)
INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Óscar Cañellas', 'mixwell', 'mixwell@heretics.gg', '1996-01-05', 'España');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Auni Reyes', 'AvovA', 'avova@heretics.gg', '2001-04-18', 'España');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Nil Montserrat', 'Boo', 'boo@heretics.gg', '2003-09-10', 'España');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Enzo Mestari', 'Wo0t', 'woot@heretics.gg', '2006-02-28', 'España');

INSERT IGNORE INTO jugadores (nombre, nickname, email, fecha_nacimiento, pais)
VALUES ('Benjamín Rabinovich', 'Benjyfishy', 'benjy@heretics.gg', '2004-04-02', 'Reino Unido');

-- =====================================================
-- EQUIPOS PROFESIONALES REALES CON LOGOS
-- =====================================================
INSERT IGNORE INTO equipos (nombre, logo_url, fecha_creacion) VALUES ('T1', 'https://raw.githubusercontent.com/gamepedia/lolesports/master/images/t1_logo.png', '2002-01-01');
INSERT IGNORE INTO equipos (nombre, logo_url, fecha_creacion) VALUES ('Natus Vincere', 'https://upload.wikimedia.org/wikipedia/en/1/17/Natus_Vincere_logo.svg', '2009-12-17');
INSERT IGNORE INTO equipos (nombre, logo_url, fecha_creacion) VALUES ('G2 Esports', 'https://upload.wikimedia.org/wikipedia/en/1/1c/G2_Esports_logo.svg', '2014-02-24');
INSERT IGNORE INTO equipos (nombre, logo_url, fecha_creacion) VALUES ('Team Liquid', 'https://upload.wikimedia.org/wikipedia/en/8/83/Team_Liquid_logo.svg', '2000-01-01');
INSERT IGNORE INTO equipos (nombre, logo_url, fecha_creacion) VALUES ('Team Vitality', 'https://upload.wikimedia.org/wikipedia/en/4/43/Team_Vitality_logo.svg', '2013-09-18');
INSERT IGNORE INTO equipos (nombre, logo_url, fecha_creacion) VALUES ('Gen.G', 'https://cdn.escharts.com/uploads/public/659/ca1/12e/thumb_41979_256_256_0_0_crop.png', '2017-05-18');
INSERT IGNORE INTO equipos (nombre, logo_url, fecha_creacion) VALUES ('STMN Esports', 'https://cdn.escharts.com/uploads/public/60a/3f5/0e1/thumb_46523_256_256_0_0_crop.png', '2020-01-01');
INSERT IGNORE INTO equipos (nombre, logo_url, fecha_creacion) VALUES ('TRIBE Gaming', 'https://cdn.escharts.com/uploads/public/5f6/1d2/8ea/thumb_38261_256_256_0_0_crop.png', '2017-01-01');
INSERT IGNORE INTO equipos (nombre, logo_url, fecha_creacion) VALUES ('MAD Lions', 'https://upload.wikimedia.org/wikipedia/en/4/42/MAD_Lions_logo.svg', '2017-02-20');
INSERT IGNORE INTO equipos (nombre, logo_url, fecha_creacion) VALUES ('MOUZ', 'https://upload.wikimedia.org/wikipedia/en/a/a9/Mousesports_logo.svg', '2002-08-20');
INSERT IGNORE INTO equipos (nombre, logo_url, fecha_creacion) VALUES ('FaZe Clan', 'https://upload.wikimedia.org/wikipedia/commons/4/4a/Faze_Clan.svg', '2010-05-30');
INSERT IGNORE INTO equipos (nombre, logo_url, fecha_creacion) VALUES ('Team Spirit', 'https://upload.wikimedia.org/wikipedia/en/9/9c/Team_Spirit_logo.svg', '2015-04-01');
INSERT IGNORE INTO equipos (nombre, logo_url, fecha_creacion) VALUES ('Karmine Corp', 'https://upload.wikimedia.org/wikipedia/en/2/2d/Karmine_Corp_logo.svg', '2020-05-18');
INSERT IGNORE INTO equipos (nombre, logo_url, fecha_creacion) VALUES ('FURIA Esports', 'https://upload.wikimedia.org/wikipedia/en/f/f8/FURIA_Esports_logo.svg', '2017-08-01');
INSERT IGNORE INTO equipos (nombre, logo_url, fecha_creacion) VALUES ('SK Gaming', 'https://upload.wikimedia.org/wikipedia/commons/7/78/SK_Gaming_logo.svg', '1997-10-01');
INSERT IGNORE INTO equipos (nombre, logo_url, fecha_creacion) VALUES ('KRU Esports', 'https://upload.wikimedia.org/wikipedia/en/d/d0/KR%C3%9C_Esports_logo.svg', '2017-06-12');
INSERT IGNORE INTO equipos (nombre, logo_url, fecha_creacion) VALUES ('Team Heretics', 'https://upload.wikimedia.org/wikipedia/en/c/c8/Team_Heretics_logo.svg', '2016-01-14');

-- =====================================================
-- TORNEOS
-- =====================================================

-- League of Legends Worlds 2025 - FINALIZADO
INSERT IGNORE INTO torneos (nombre, descripcion, juego_id, fecha_inicio, fecha_final, miembros_por_equipo, max_equipos)
VALUES ('League of Legends Worlds 2025', 'Campeonato Mundial de League of Legends 2025. Los mejores equipos del mundo compiten por el título mundial.', 1, '2025-11-15', '2025-12-08', 5, 24);

-- The International Dota 2 2026 - EN PROGRESO
INSERT IGNORE INTO torneos (nombre, descripcion, juego_id, fecha_inicio, fecha_final, miembros_por_equipo, max_equipos)
VALUES ('The International Dota 2 2026', 'El torneo más prestigioso de Dota 2 con el mayor prize pool de la historia de los eSports.', 2, '2026-01-20', '2026-02-10', 5, 18);

-- CS2 Major 2025 - FINALIZADO
INSERT IGNORE INTO torneos (nombre, descripcion, juego_id, fecha_inicio, fecha_final, miembros_por_equipo, max_equipos)
VALUES ('CS2 Major Championship 2025', 'Major de Counter-Strike 2. Los mejores equipos tácticos del mundo en mapa tras mapa.', 3, '2025-12-10', '2025-12-22', 5, 16);

-- Valorant Champions 2026 - EN PROGRESO
INSERT IGNORE INTO torneos (nombre, descripcion, juego_id, fecha_inicio, fecha_final, miembros_por_equipo, max_equipos)
VALUES ('Valorant Champions 2026', 'El evento más importante del año de Valorant. Equipos de 5 jugadores por la gloria mundial.', 4, '2026-01-28', '2026-02-12', 5, 16);

-- Fortnite FNCS 2026 Solo - FUTURO
INSERT IGNORE INTO torneos (nombre, descripcion, juego_id, fecha_inicio, fecha_final, miembros_por_equipo, max_equipos)
VALUES ('Fortnite FNCS 2026 Solo', 'Fortnite Champion Series Invierno 2026 - Modalidad Solo. Competencia individual.', 5, '2026-03-01', '2026-03-15', 1, 200);

-- Fortnite FNCS 2026 Duo - FUTURO
INSERT IGNORE INTO torneos (nombre, descripcion, juego_id, fecha_inicio, fecha_final, miembros_por_equipo, max_equipos)
VALUES ('Fortnite FNCS 2026 Duo', 'Fortnite Champion Series Primavera 2026 - Modalidad Dúo. Equipos de 2 jugadores.', 5, '2026-04-15', '2026-04-30', 2, 100);

-- Rocket League Championship 2026 - FINALIZADO
INSERT IGNORE INTO torneos (nombre, descripcion, juego_id, fecha_inicio, fecha_final, miembros_por_equipo, max_equipos)
VALUES ('RLCS Winter Major 2026', 'Rocket League Championship Series - Major de Invierno 2026. Equipos de 3 jugadores.', 7, '2026-01-10', '2026-01-20', 3, 16);

-- Brawl Stars World Finals 2025 - FINALIZADO
INSERT IGNORE INTO torneos (nombre, descripcion, juego_id, fecha_inicio, fecha_final, miembros_por_equipo, max_equipos)
VALUES ('Brawl Stars World Finals 2025', 'Finales Mundiales de Brawl Stars 2025. Los mejores equipos mobile del mundo. Equipos de 3 jugadores.', 8, '2025-11-20', '2025-11-24', 3, 16);

-- Overwatch Champions Series 2026 - FUTURO
INSERT IGNORE INTO torneos (nombre, descripcion, juego_id, fecha_inicio, fecha_final, miembros_por_equipo, max_equipos)
VALUES ('Overwatch Champions Series 2026', 'La liga oficial de Overwatch 2. Equipos de 5 jugadores en intensas batallas de objetivos.', 9, '2026-05-10', '2026-05-25', 5, 12);

-- Apex Legends Global Series 2026 - FUTURO
INSERT IGNORE INTO torneos (nombre, descripcion, juego_id, fecha_inicio, fecha_final, miembros_por_equipo, max_equipos)
VALUES ('ALGS Championship 2026', 'Apex Legends Global Series - El campeonato mundial. Equipos de 3 jugadores.', 10, '2026-06-15', '2026-06-22', 3, 40);

-- Call of Duty Championship 2026 - FUTURO
INSERT IGNORE INTO torneos (nombre, descripcion, juego_id, fecha_inicio, fecha_final, miembros_por_equipo, max_equipos)
VALUES ('CDL Championship 2026', 'Call of Duty League Championship. Equipos de 4 jugadores en Warzone competitivo.', 11, '2026-07-05', '2026-07-12', 4, 16);

-- Mobile Legends M6 World Championship 2026 - EN PROGRESO
INSERT IGNORE INTO torneos (nombre, descripcion, juego_id, fecha_inicio, fecha_final, miembros_por_equipo, max_equipos)
VALUES ('M6 World Championship 2026', 'Campeonato Mundial de Mobile Legends temporada 6. Equipos de 5 jugadores mobile.', 12, '2026-01-15', '2026-02-05', 5, 16);

-- Tekken World Tour Finals 2025 - FINALIZADO
INSERT IGNORE INTO torneos (nombre, descripcion, juego_id, fecha_inicio, fecha_final, miembros_por_equipo, max_equipos)
VALUES ('Tekken 8 World Tour Finals 2025', 'Las finales del Tekken World Tour. Competencia individual 1v1.', 13, '2025-12-15', '2025-12-17', 1, 64);

-- Street Fighter 6 CPT 2026 - FUTURO
INSERT IGNORE INTO torneos (nombre, descripcion, juego_id, fecha_inicio, fecha_final, miembros_por_equipo, max_equipos)
VALUES ('Street Fighter 6 Capcom Pro Tour 2026', 'Capcom Pro Tour - La gira oficial de Street Fighter 6. Competencia individual.', 6, '2026-08-01', '2026-08-05', 1, 128);

-- StarCraft II GSL 2026 - EN PROGRESO
INSERT IGNORE INTO torneos (nombre, descripcion, juego_id, fecha_inicio, fecha_final, miembros_por_equipo, max_equipos)
VALUES ('GSL Code S 2026 Season 1', 'Global StarCraft II League - La liga coreana más prestigiosa. Competencia individual 1v1.', 14, '2026-01-10', '2026-02-28', 1, 32);

-- =====================================================
-- INSCRIPCIONES
-- =====================================================

-- League of Legends Worlds 2025 - T1 (5 jugadores)
INSERT IGNORE INTO inscripciones (jugador_id, torneo_id, equipo_id, estado, fecha_inscripcion)
VALUES (1, 1, 1, 'CONFIRMADA', '2025-10-15'), -- Faker
       (2, 1, 1, 'CONFIRMADA', '2025-10-15'), -- Keria
       (3, 1, 1, 'CONFIRMADA', '2025-10-15'), -- Zeus
       (4, 1, 1, 'CONFIRMADA', '2025-10-15'), -- Oner
       (5, 1, 1, 'CONFIRMADA', '2025-10-15'); -- Gumayusi

-- League of Legends Worlds 2025 - G2 Esports (5 jugadores)
INSERT IGNORE INTO inscripciones (jugador_id, torneo_id, equipo_id, estado, fecha_inscripcion)
VALUES (6, 1, 3, 'CONFIRMADA', '2025-10-15'), -- Caps
       (7, 1, 3, 'CONFIRMADA', '2025-10-15'), -- Mikyx
       (8, 1, 3, 'CONFIRMADA', '2025-10-15'), -- BrokenBlade
       (9, 1, 3, 'CONFIRMADA', '2025-10-15'), -- Yike
       (10, 1, 3, 'CONFIRMADA', '2025-10-15'); -- Hans Sama

-- League of Legends Worlds 2025 - MAD Lions (5 jugadores)
INSERT IGNORE INTO inscripciones (jugador_id, torneo_id, equipo_id, estado, fecha_inscripcion)
VALUES (11, 1, 9, 'CONFIRMADA', '2025-10-15'), -- Alvaro
       (12, 1, 9, 'CONFIRMADA', '2025-10-15'), -- Elyoya
       (13, 1, 9, 'CONFIRMADA', '2025-10-15'), -- Kaiser
       (14, 1, 9, 'CONFIRMADA', '2025-10-15'), -- Humanoid
       (15, 1, 9, 'CONFIRMADA', '2025-10-15'); -- Hylissang

-- CS2 Major 2025 - Natus Vincere (5 jugadores)
INSERT IGNORE INTO inscripciones (jugador_id, torneo_id, equipo_id, estado, fecha_inscripcion)
VALUES (16, 3, 2, 'CONFIRMADA', '2025-11-10'), -- s1mple
       (17, 3, 2, 'CONFIRMADA', '2025-11-10'), -- electroNic
       (18, 3, 2, 'CONFIRMADA', '2025-11-10'), -- w0nderful
       (19, 3, 2, 'CONFIRMADA', '2025-11-10'), -- iM
       (20, 3, 2, 'CONFIRMADA', '2025-11-10'); -- jL

-- CS2 Major 2025 - G2 Esports (5 jugadores)
INSERT IGNORE INTO inscripciones (jugador_id, torneo_id, equipo_id, estado, fecha_inscripcion)
VALUES (21, 3, 3, 'CONFIRMADA', '2025-11-10'), -- NiKo
       (22, 3, 3, 'CONFIRMADA', '2025-11-10'), -- m0NESY
       (23, 3, 3, 'CONFIRMADA', '2025-11-10'), -- huNter-
       (24, 3, 3, 'CONFIRMADA', '2025-11-10'), -- malbsMd
       (25, 3, 3, 'CONFIRMADA', '2025-11-10'); -- HooXi

-- CS2 Major 2025 - MOUZ (5 jugadores)
INSERT IGNORE INTO inscripciones (jugador_id, torneo_id, equipo_id, estado, fecha_inscripcion)
VALUES (26, 3, 10, 'CONFIRMADA', '2025-11-10'), -- Frozen
       (27, 3, 10, 'CONFIRMADA', '2025-11-10'), -- xertioN
       (28, 3, 10, 'CONFIRMADA', '2025-11-10'), -- torszi
       (29, 3, 10, 'CONFIRMADA', '2025-11-10'), -- JDC (Español)
       (30, 3, 10, 'CONFIRMADA', '2025-11-10'); -- Jimpphat

-- CS2 Major 2025 - FaZe Clan (5 jugadores)
INSERT IGNORE INTO inscripciones (jugador_id, torneo_id, equipo_id, estado, fecha_inscripcion)
VALUES (31, 3, 11, 'CONFIRMADA', '2025-11-10'), -- rain
       (32, 3, 11, 'CONFIRMADA', '2025-11-10'), -- broky
       (33, 3, 11, 'CONFIRMADA', '2025-11-10'), -- ropz
       (34, 3, 11, 'CONFIRMADA', '2025-11-10'), -- karrigan
       (35, 3, 11, 'CONFIRMADA', '2025-11-10'); -- FrozenH

-- Dota 2 TI 2026 - Team Liquid (5 jugadores) - EN PROGRESO
INSERT IGNORE INTO inscripciones (jugador_id, torneo_id, equipo_id, estado, fecha_inscripcion)
VALUES (36, 2, 4, 'CONFIRMADA', '2026-01-05'), -- Miracle-
       (37, 2, 4, 'CONFIRMADA', '2026-01-05'), -- MATUMBAMAN
       (38, 2, 4, 'CONFIRMADA', '2026-01-05'), -- miCKe
       (39, 2, 4, 'CONFIRMADA', '2026-01-05'), -- 33
       (40, 2, 4, 'CONFIRMADA', '2026-01-05'); -- Boxi

-- Dota 2 TI 2026 - Team Spirit (5 jugadores) - EN PROGRESO
INSERT IGNORE INTO inscripciones (jugador_id, torneo_id, equipo_id, estado, fecha_inscripcion)
VALUES (41, 2, 12, 'CONFIRMADA', '2026-01-05'), -- Yatoro
       (42, 2, 12, 'CONFIRMADA', '2026-01-05'), -- TORONTOTOKYO
       (43, 2, 12, 'CONFIRMADA', '2026-01-05'), -- Collapse
       (44, 2, 12, 'CONFIRMADA', '2026-01-05'), -- Mira
       (45, 2, 12, 'CONFIRMADA', '2026-01-05'); -- Miposhka

-- Fortnite FNCS 2026 Solo (Individual - sin equipo) - 12 inscritos
INSERT IGNORE INTO inscripciones (jugador_id, torneo_id, equipo_id, estado, fecha_inscripcion)
VALUES (46, 4, NULL, 'CONFIRMADA', '2026-02-01'), -- Bugha
       (47, 4, NULL, 'CONFIRMADA', '2026-02-01'), -- Setty
       (48, 4, NULL, 'CONFIRMADA', '2026-02-01'), -- Mero
       (49, 4, NULL, 'CONFIRMADA', '2026-02-01'), -- Kami
       (50, 4, NULL, 'CONFIRMADA', '2026-02-01'), -- Coop
       (51, 4, NULL, 'CONFIRMADA', '2026-02-01'), -- Ninja
       (52, 4, NULL, 'CONFIRMADA', '2026-02-01'), -- Th0mas
       (53, 4, NULL, 'CONFIRMADA', '2026-02-01'), -- Queasy
       (54, 4, NULL, 'CONFIRMADA', '2026-02-01'), -- Vico (Español)
       (55, 4, NULL, 'CONFIRMADA', '2026-02-01'), -- JannisZ (Español)
       (56, 4, NULL, 'PENDIENTE', '2026-02-01'), -- King (Brasil)
       (57, 4, NULL, 'PENDIENTE', '2026-02-01'); -- Enz0 (Argentina)

-- Rocket League RLCS 2026 - Team Vitality (3 jugadores)
INSERT IGNORE INTO inscripciones (jugador_id, torneo_id, equipo_id, estado, fecha_inscripcion)
VALUES (58, 7, 5, 'CONFIRMADA', '2026-01-05'), -- Seikoo
       (59, 7, 5, 'CONFIRMADA', '2026-01-05'), -- Vatira
       (60, 7, 5, 'CONFIRMADA', '2026-01-05'); -- Alpha54

-- Rocket League RLCS 2026 - Gen.G (3 jugadores)
INSERT IGNORE INTO inscripciones (jugador_id, torneo_id, equipo_id, estado, fecha_inscripcion)
VALUES (61, 7, 6, 'CONFIRMADA', '2026-01-05'), -- Zen
       (62, 7, 6, 'CONFIRMADA', '2026-01-05'), -- Monkey M.
       (63, 7, 6, 'CONFIRMADA', '2026-01-05'); -- Jack

-- Rocket League RLCS 2026 - Karmine Corp (3 jugadores)
INSERT IGNORE INTO inscripciones (jugador_id, torneo_id, equipo_id, estado, fecha_inscripcion)
VALUES (64, 7, 13, 'CONFIRMADA', '2026-01-05'), -- AztraL
       (65, 7, 13, 'CONFIRMADA', '2026-01-05'), -- Atow
       (66, 7, 13, 'CONFIRMADA', '2026-01-05'); -- VatiraKC (Español)

-- Rocket League RLCS 2026 - FURIA (3 jugadores - Brasil)
INSERT IGNORE INTO inscripciones (jugador_id, torneo_id, equipo_id, estado, fecha_inscripcion)
VALUES (67, 7, 14, 'CONFIRMADA', '2026-01-05'), -- CaioTG1
       (68, 7, 14, 'CONFIRMADA', '2026-01-05'), -- Yanxnz
       (69, 7, 14, 'CONFIRMADA', '2026-01-05'); -- Caard

-- Brawl Stars World Finals 2025 - STMN Esports (3 jugadores)
INSERT IGNORE INTO inscripciones (jugador_id, torneo_id, equipo_id, estado, fecha_inscripcion)
VALUES (70, 8, 7, 'CONFIRMADA', '2025-10-20'), -- MoLight
       (71, 8, 7, 'CONFIRMADA', '2025-10-20'), -- Ardh
       (72, 8, 7, 'CONFIRMADA', '2025-10-20'); -- Symantec

-- Brawl Stars World Finals 2025 - TRIBE Gaming (3 jugadores)
INSERT IGNORE INTO inscripciones (jugador_id, torneo_id, equipo_id, estado, fecha_inscripcion)
VALUES (73, 8, 8, 'CONFIRMADA', '2025-10-20'), -- PatCeex
       (74, 8, 8, 'CONFIRMADA', '2025-10-20'), -- Luke
       (75, 8, 8, 'CONFIRMADA', '2025-10-20'); -- Eqwaak

-- Brawl Stars World Finals 2025 - SK Gaming (3 jugadores - Mix Latino/Europeo)
INSERT IGNORE INTO inscripciones (jugador_id, torneo_id, equipo_id, estado, fecha_inscripcion)
VALUES (76, 8, 15, 'CONFIRMADA', '2025-10-20'), -- Javititu (Español)
       (77, 8, 15, 'CONFIRMADA', '2025-10-20'), -- PauloGG (Brasil)
       (78, 8, 15, 'CONFIRMADA', '2025-10-20'); -- Carlitos (México)

-- Valorant Champions 2026 - KRU Esports (5 jugadores - Chilenos) - EN PROGRESO
INSERT IGNORE INTO inscripciones (jugador_id, torneo_id, equipo_id, estado, fecha_inscripcion)
VALUES (79, 9, 16, 'CONFIRMADA', '2026-01-20'), -- Mazino
       (80, 9, 16, 'CONFIRMADA', '2026-01-20'), -- Klaus
       (81, 9, 16, 'CONFIRMADA', '2026-01-20'), -- Shyy
       (82, 9, 16, 'CONFIRMADA', '2026-01-20'), -- Daveeys
       (83, 9, 16, 'CONFIRMADA', '2026-01-20'); -- Delz1k

-- Valorant Champions 2026 - Team Heretics (5 jugadores - Españoles) - EN PROGRESO
INSERT IGNORE INTO inscripciones (jugador_id, torneo_id, equipo_id, estado, fecha_inscripcion)
VALUES (84, 9, 17, 'CONFIRMADA', '2026-01-20'), -- mixwell
       (85, 9, 17, 'CONFIRMADA', '2026-01-20'), -- AvovA
       (86, 9, 17, 'CONFIRMADA', '2026-01-20'), -- Boo
       (87, 9, 17, 'CONFIRMADA', '2026-01-20'), -- Wo0t
       (88, 9, 17, 'CONFIRMADA', '2026-01-20'); -- Benjyfishy

-- =====================================================
-- RESULTADOS
-- =====================================================

-- League of Legends Worlds 2025 - FINALIZADO (Top 3)
INSERT IGNORE INTO resultados (equipo_id, torneo_id, posicion, puntuacion)
VALUES (1, 1, 1, 3100), -- T1 - Campeones
       (3, 1, 2, 2850), -- G2 Esports - Subcampeones
       (9, 1, 3, 2600); -- MAD Lions - 3er lugar

-- CS2 Major 2025 - FINALIZADO (Top 4)
INSERT IGNORE INTO resultados (equipo_id, torneo_id, posicion, puntuacion)
VALUES (2, 3, 1, 3500), -- Natus Vincere - Campeones
       (3, 3, 2, 3200), -- G2 Esports - Subcampeones
       (10, 3, 3, 2950), -- MOUZ - 3er lugar
       (11, 3, 4, 2700); -- FaZe Clan - 4to lugar

-- Dota 2 TI 2026 - EN PROGRESO (Top 2 parcial)
INSERT IGNORE INTO resultados (equipo_id, torneo_id, posicion, puntuacion)
VALUES (4, 2, 1, 1850), -- Team Liquid
       (12, 2, 2, 1650); -- Team Spirit

-- Rocket League RLCS 2026 - FINALIZADO (Top 4)
INSERT IGNORE INTO resultados (equipo_id, torneo_id, posicion, puntuacion)
VALUES (5, 7, 1, 2400), -- Team Vitality - Campeones
       (6, 7, 2, 2100), -- Gen.G - Subcampeones
       (13, 7, 3, 1900), -- Karmine Corp - 3er lugar
       (14, 7, 4, 1650); -- FURIA - 4to lugar

-- Brawl Stars World Finals 2025 - FINALIZADO (Top 3)
INSERT IGNORE INTO resultados (equipo_id, torneo_id, posicion, puntuacion)
VALUES (7, 8, 1, 2800), -- STMN Esports - Campeones
       (8, 8, 2, 2500), -- TRIBE Gaming - Subcampeones
       (15, 8, 3, 2200); -- SK Gaming - 3er lugar

-- Valorant Champions 2026 - EN PROGRESO (Top 2 parcial)
INSERT IGNORE INTO resultados (equipo_id, torneo_id, posicion, puntuacion)
VALUES (17, 9, 1, 1420), -- Team Heretics (Españoles)
       (16, 9, 2, 1350); -- KRU Esports (Chilenos)