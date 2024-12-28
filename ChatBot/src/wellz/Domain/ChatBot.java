package wellz.Domain;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ChatBot {
    private final List<Pokemon> pokemons = List.of(
//          new Pokemon("", new String[]{"", ""}, new String[]{"", ""}, ""),
            new Pokemon("Charmander", new String[]{"Fogo"}, new String[]{"Água", "Terra", "Rocha"}, "A chama que possui na ponta de seu rabo mostra a força de sua vida. Se ele estiver fraco, a chama irá diminuir. Quando está saudável, a chama brilhará intensamente. Tem preferência por coisas quentes. Quando chove, diz-se que o vapor jorra da ponta da cauda. Sua vida acabaria se essa chama se apagasse."),
            new Pokemon("Charmeleon", new String[]{"Fogo"}, new String[]{"Água", "Terra", "Rocha"}, "Gosta muito de brigas, por isso busca constantemente por adversários. Ele ataca com suas garras afiadas e usando sua cauda como chicote de fogo. Pode soltar chamas azuis quando muito animado. Quando ele balança sua cauda em chamas, ele eleva a temperatura do ar a níveis insuportavelmente altos. Nas montanhas rochosas onde vive Charmeleon, suas caudas de fogo brilham à noite como estrelas."),
            new Pokemon("Charizard", new String[]{"Fogo", "Voador"}, new String[]{"Água", "Elétrico", "Rocha"}, "Seu fogo é quente o suficiente para derreter rochas. Quando nervoso, a chama em sua cauda queimará intensamente. É orgulhoso e voa pelos céus em busca de adversários poderosos. Suas asas podem transportar este pokémon até uma altitude de 1.400 metros. Expele fogo em temperaturas muito altas."),
            new Pokemon("Bulbasaur", new String[]{"Planta", "Veneno"}, new String[]{"Fogo", "Psíquico", "Voador", "Gelo"}, "Desde o dia em que nasceu possui uma semente estranha plantada em suas costas. O bulbo em suas costas está cheio de nutrientes. Nele, Bulbasaur armazena suas energias. O bulbo vai crescendo à medida que envelhece porque ele absorve os raios de sol."),
            new Pokemon("Ivysaur", new String[]{"Planta", "Veneno"}, new String[]{"Fogo", "Gelo", "Voador", "Psíquico"}, "A exposição à luz solar aumenta sua força. A luz do sol fará a flor em suas costas crescer. Conforme Ivysaur for crescendo, essa flor irá desabrochar. Ela irá soltar um doce aroma quando florescer. Quando o bulbo em sua parte traseira fica grande, parece perder a capacidade de ficar em pé sobre as patas traseiras."),
            new Pokemon("Venusaur", new String[]{"Planta", "Veneno"}, new String[]{"Fogo", "Gelo", "Voador", "Psíquico"}, "A luz solar que a flor de suas costas absorve produz energia para seu corpo. Por esta razão, ele fica mais forte no verão. O aroma dessa flor pode acalmar as emoções das pessoas. Depois de um dia chuvoso, a flor nas costas tem um cheiro mais forte. O cheiro atrai outros pokémons."),
            new Pokemon("Squirtle", new String[]{"Água"}, new String[]{"Planta", "Elétrico"}, "Quando nasce, seu casco é mole, mas logo endurece. Cutucando com o dedo fará os pedaços de seu casco saltar. Ele entra dentro do casco quando se sente ameaçado. Esguicha água com uma força vigorosa para atacar. A forma arredondada do casco e as ranhuras em sua superfície ajudam a minimizar a resistência na água, p,ermitindo-o nadar em alta velocidade."),
            new Pokemon("Wartortle", new String[]{"Água"}, new String[]{"Planta", "Elétrico"}, "É muito inteligente, sabe controlar as orelhas e o rabo para manter o equilíbrio na água e nadar em altas velocidades. Seu rabo felpudo é símbolo de longevidade. Se seu casco tiver algas, este Wartortle é muito velho. Os arranhões em seu casco são evidências da resistência deste pokémon como lutador."),
            new Pokemon("Blastoise", new String[]{"água"}, new String[]{"Planta", "Elétrico"}, "O casco em suas costas possuem canhões que jorram água pressurizada forte o suficiente para perfurar uma parede de concreto. Eles podem disparar balas de água com precisão suficiente para atingir latas vazias a uma distância de mais de 50 metros. Também usa o seu casco pesado para atacar e esmagar seus ,oponentes."),
            new Pokemon("Caterpie", new String[]{"Inseto"}, new String[]{"Fogo", "Voador", "Pedra"}, "Como forma de proteção, Caterpie libera um cheiro horrível através de suas antenas. Suas patas pegajosas são capazes de andar em qualquer tipo de superfície. Seu corpo é macio e fraco. Na natureza, é visto como alimento para vários pokémons pássaros. É fácil de capturar e cresce rapidamente, tornan,do-se uma das principais recomendações para treinadores novatos."),
            new Pokemon("Metapod", new String[]{"Inseto"}, new String[]{"Fogo", "Voador", "Pedra"}, "Este pokémon é totalmente vulnerável a ataques enquanto seu casulo é mole, correndo risco de expor seu corpo frágil e sensível. Por isso, fica endurecendo o seu casulo para se proteger. Batalhas intensas com ele devem ser evitadas. Seu casulo é preenchido com um líquido espesso. Todas as células de s,eu corpo estão sendo reconstruídas em preparação para a evolução."),
            new Pokemon("Butterfree", new String[]{"Inseto", "Voador"}, new String[]{"Fogo", "Elétrico", "Gelo", "Voador", "Pedra"}, "Gosta de coletar mel das plantas. Suas asas batem tão rapidamente que acaba deixando um rastro de poeira tóxica pelo ar. As asas resistem a água, permitindo-o voar em fortes chuvas. Coleta mel todos os dias e o leva para seu ninho. Um exame atento de seus olhos grandes, revela que cada olho é composto por uma miríade de olhos minúsculos."),
            new Pokemon("Weedle", new String[]{"Inseto", "Veneno"}, new String[]{"Fogo", "Voador", "Psíquico", "Pedra"}, "É frequentemente encontrado em florestas, comendo folhas. Em sua cabeça existe um ferrão afiado e venenoso. Qualquer um pode se machucar com ele se não tomar cuidado onde pisa. Seu corpo de cores vivas tem o objetivo de alertar seus inimigos. Weedle tem um olfato extremamente aguça,do. Ele é capaz de distinguir seus tipos favoritos de folhas daqueles de que não gosta apenas farejando."),
            new Pokemon("Kakuna", new String[]{"Inseto", "Veneno"}, new String[]{"Fogo", "Voador", "Psíquico", "Pedra"}, "Enquanto aguarda sua evolução, os Kakunas vivem agarrados em árvores para se esconder dos predadores. Embora ainda seja um casulo, consegue se mexer um pouco. Quando em perigo, pode esticar o ferrão e envenenar o inimigo. Na maioria dos casos, só consegue endurecer seu casulo para s,e proteger."),
            new Pokemon("Beedrill", new String[]{"Inseto", "Veneno"}, new String[]{"Fogo", "Voador", "Psíquico", "Pedra"}, "Possui dois grandes ferrões nos braços e um em seu rabo. O ferrão de seu rabo é o mais venenoso. Costumam voar em altas velocidades e atacar em enxame. É extremamente territorial. Ninguém deve se aproximar de seu ninho. Se irritados, eles atacarão furiosos e repetidamente."),
            new Pokemon("Pidgey", new String[]{"Normal", "Voador"}, new String[]{"Elétrico", "Gelo", "Pedra"}, "Não gosta muito de lutar. Em vez disso, prefere bater as asas próximo ao chão para levantar uma poeira de areia e com isso afastar o inimigo. Possui um ótimo senso de direção. É capaz de retornar infalivelmente para seu ninho, por mais distante que possa ser removido de seu ambiente familiar. É comum de ser encontrado em florestas e bosques."),
            new Pokemon("Pidgotto", new String[]{"Normal", "Voador"}, new String[]{"Elétrico", "Gelo", "Pedra"}, "Ele é muito protetor de seu território, sempre irá atacar brutalmente qualquer intruso. Possui uma ótima visão, mesmo voando bem alto irá localizar sua presa. Suas garras afiadas e bastante desenvolvidas são a sua arma de ataque. Ele pode carregar presas como um Exeggcute para seu ninho a mais de 100 km de distância."),
            new Pokemon("Pidgeot", new String[]{"Normal", "Voador"}, new String[]{"Elétrico", "Gelo", "Pedra"}, "É capaz de voar numa velocidade Mach 2. Suas grandes garras são temidas como armas perversas. Ele desliza pela superfície da água em alta velocidade para pegar presas desavisadas como o Magikarp. Com seus músculos bem desenvolvidos, consegue fazer fortes furacões capazes de derrubar árvores ao bater suas asas. Possui uma plumagem deslumbrante de penas lindamente brilhantes."),
            new Pokemon("Rattata", new String[]{"Normal"}, new String[]{"Lutador"}, "Morde qualquer coisa quando está atacando. Vive procurando objetos duros para roer. Com sua forte capacidade de sobrevivência, eles podem viver em lugares sujos sem preocupação. Se reproduzem muito depressa, podem virar uma praga nas cidades. Seus dentes crescem continuamente até sua morte. Se crescerem demais, não conseguem comer e morrem de fome."),
            new Pokemon("Raticate", new String[]{"Normal"}, new String[]{"Lutador"}, "Para assustar os adversários, ele posiciona-se de pé e mostra as presas de sua boca. Seus dentes são fortes, capazes até mesmo de roer uma parede de concreto. Suas patas traseiras são palmadas, então é um nadador forte. Pode atravessar rios e às vezes até oceanos. Não importa o quão amigável você seja, ele ficará zangado e o morderá se você tocar em seus bigodes."),
            new Pokemon("Spearow", new String[]{"Normal", "Voador"}, new String[]{"Elétrico", "Gelo", "Pedra"}, "Ele bate suas asas sobre a grama para encontrar insetos. Quando encontra, puxa-os do chão com o seu bico. Fazendeiros cujos campos são afetados por insetos apreciam Spearow pelo seu apetite por inseto. Suas asas são curtas, por isso não pode voar por longas distâncias. Sua natureza imprudente o fará enfrentar os outros, mesmo pokémons maiores, se tiver que proteger seu território. Seu grito pode ser ouvido a 1 km de distância."),
            new Pokemon("Fearow", new String[]{"Normal", "Voador"}, new String[]{"Elétrico", "Gelo", "Pedra"}, "Fearow é famoso por seu pescoço longo e bico comprido. Eles foram desenvolvidos especialmente para ajudá-lo a apanhar presas no solo ou na água. Adora comer pokémons peixes. Consegue manter-se voando no céu por bastante tempo sem pousar. Carregar comida pelo território de Fearow é perigoso. Ele vai tirar a comida de você!"),
            new Pokemon("Ekans", new String[]{"Veneno"}, new String[]{"Terra", "Psíquico"}, "Rasteja silenciosamente pelo chão. Anda pela grama sem fazer barulho e atinge uma presa desavisada por trás. Alimenta-se de ovos nos ninhos de pokémons pássaros. Ele sente o cheiro com sua língua. Suas mandíbulas são capazes de devorar seres bem maiores que ele. Depois de uma refeição, ele se enrola e descansa."),
            new Pokemon("Arbok", new String[]{"Veneno"}, new String[]{"Terra", "Psíquico"}, "As marcas no pescoço de Arbok podem ser diferentes de região para região. Elas indicam o quão venenoso este pokémon é. Inimigos fracos fugirão apenas ao ver essas marcas. Ele também pode sufocar suas vítimas enrolando-se em torno delas. Sua força ao enrolar pode espremer tambores de aço."),
            new Pokemon("Pikachu", new String[]{"Elétrico"}, new String[]{"Terra"}, "Para ter uma melhor percepção de tudo o que está em sua volta, mantém o seu rabo levantado. Ele armazena energia elétrica dentro de suas bochechas vermelhas. Quando dois deles se encontram, eles tocam suas caudas e trocam eletricidade através deles como uma forma de saudação. As florestas onde vivem Pikachu são perigosas, pois as árvores são frequentemente atingidas por raios."),
            new Pokemon("Raichu", new String[]{"Elétrico"}, new String[]{"Terra"}, "Pode tornar-se agressivo caso acumule muita eletricidade no corpo. Pode dar choques de até dez mil volts. Ele mantém o seu longo rabo no solo para controlar seus raios elétricos e descarregar eletricidade. Se suas bolsas elétricas ficarem vazias, ele levanta a cauda para coletar eletricidade da atmosfera. Ele pode brilhar no escuro."),
            new Pokemon("Sandshrew", new String[]{"Terra"}, new String[]{"Água", "Planta", "Gelo"}, "Faz sua toca no subterrâneo, longe de água. Geralmente sai apenas para caçar. Se ele cair de uma grande altura, consegue se salvar enrolando o corpo e rolando como uma bola. Ele adora banhar-se na areia de áreas secas e arenosas. fazendo isso, se livra da sujeira e da umidade presa em seu corpo. Ele se enterra no solo para criar seu ninho. Se pedras duras impedem sua escavação, ele usa suas garras afiadas para espalhá-los."),
            new Pokemon("Sandslash", new String[]{"Terra"}, new String[]{"Água", "Planta", "Gelo"}, "Suas costas possuem espinhos muito duros, usados como sua defesa. É habilidoso para fazer arranhões com suas garras. Se as garras ou espinhos quebrarem, irão crescer de novo em um dia. Ele usa suas garras para escalar árvores e então enrola seu corpo em uma bola espinhosa, pronta para cair sobre qualquer presa que apareça."),
            new Pokemon("Nidorana", new String[]{"Veneno"}, new String[]{"Terra", "Psíquico"}, "As fêmeas de Nidoran possuem chifres menores. Embora pequena, deve se ter muito cuidado com os espinhos venenosos de seu corpo. Ela não gosta muito de lutar. As fêmeas são mais sensíveis a cheiros do que os machos. Usam seus bigodes para verificar a direção do vento e ficar a favor dos predadores. Ela usa seus dentes incisivos duros para esmagar e comer frutas. Se enfurecida, libera uma toxina horrível de seu chifre."),
            new Pokemon("Nidorina", new String[]{"Veneno"}, new String[]{"Terra", "Psíquico"}, "O chifre em sua cabeça desenvolve-se lentamente. Ela prefere golpear com ataque físicos, como mordidas e arranhões. É dócil, mas não hesita em atacar quando perturbada. Emite gritos ultrassônicos que têm o poder de confundir os inimigos. Se o grupo for ameaçado, se unem para atacar o inimigo. O chifre em sua cabeça atrofiou. Pensa-se que isso aconteça para que os filhotes de Nidorina não sejam cutucados enquanto a mãe os estiver alimentando."),
            new Pokemon("Nidoqueen", new String[]{"Veneno", "Terra"}, new String[]{"Água", "Gelo", "Terra", "Psíquico"}, "Duras escamas crescem no corpo robusto deste pokémon. Isso lhe permite realizar movimentos brutais. É perito em enviar inimigos voando com ataques violentos. Ela defende a sua cria com sua própria vida. É melhor na defesa do que no ataque. Ela acalma a sua prole, colocando-os nas lacunas entre os espinhos em suas costas. Os espinhos nunca secretarão veneno enquanto os pequenos estiverem presentes."),
            new Pokemon("Nidorano", new String[]{"Veneno"}, new String[]{"Terra", "Psíquico"}, "Ele endurece suas orelhas para sentir o perigo. Com elas, examina os arredores e consegue escutar o mais leve dos sons. As orelhas podem ser movidas livremente em qualquer direção. Quanto maior for o seu chifre, mais venenoso ele será. Pequeno mas corajoso, irá manter-se firme e até arriscar a sua vida na batalha para proteger a fêmea de quem é amigo."),
            new Pokemon("Nidorino", new String[]{"Veneno"}, new String[]{"Terra", "Psíquico"}, "Possui um chifre mais duro que diamante. Sai por aí quebrando pedras enquanto procura uma pedra da lua. Caso ele sinta alguma presença hostil, todas as farpas de suas costas irão erguer-se de uma só vez. Suas picadas podem ser fatais. A potência de seu veneno aumenta junto com o nível de adrenalina presente em seu corpo."),
            new Pokemon("Nidoking", new String[]{"Veneno", "Terra"}, new String[]{"Água", "Gelo", "Terra", "Psíquico"}, "Utiliza-se de sua cauda poderosa para bater e enrolar seus oponentes. Combates corpo a corpo são a sua especialidade. Com um golpe, ele pode derrubar uma torre de transmissão de metal. Seu chifre é capaz de perfurar diamantes. É reconhecido por sua pele dura como pedra e seu chifre alongado. Quando faz um alvoroço, é impossível controlar. Se acalma na presença de uma Nidoqueen com quem vive há muito tempo."),
            new Pokemon("Clefairy", new String[]{"Fada"}, new String[]{"Veneno", "Metálico"}, "A luz lunar que pode absorver com suas asas aparentemente lhe dá a capacidade de voar. Raramente é encontrado, vive em locais específicos. Costumam sair de seus esconderijos em noites de lua cheia para dançar. Dizem que a felicidade virá para aqueles que virem um grupo de Clefairy dançando sob a lua cheia. Seu comportamento e aparência adoráveis o tornam popular entre homens e mulheres, jovens e idosos."),
            new Pokemon("Clefable", new String[]{"Fada"}, new String[]{"Veneno", "Metálico"}, "Um pokémon muito tímido, foge sempre que percebe estar sendo observado. Ele dá leves saltos para se locomover, permitindo-o passear sobre lagos em noites de luar. Seus ouvidos são sensíveis o suficiente para ouvir o barulho de um alfinete caindo a 1 km de distância. Vivem em locais silenciosos, como montanhas. As pessoas que vêem um par de Clefable passando podem esperar um casamento feliz."),
            new Pokemon("Vulpix", new String[]{"Fogo"}, new String[]{"Água", "Terra", "Pedra"}, "Quando nasce, possui apenas um rabo. Ele vai se dividindo conforme for envelhecendo. Conforme cada rabo cresce, seu pelo se torna mais lustroso. Astuto, para fugir do perigo, finge estar debilitado e engana o adversário. Dentro do corpo de Vulpix queima uma chama que nunca se apaga. Eles expelem chamas que se assemelham aos espíritos dos mortos. Algumas pessoas pensam que este fogo é um fantasma."),
            new Pokemon("Ninetales", new String[]{"Fogo"}, new String[]{"Água", "Terra", "Pedra"}, "É extremamente vingativo. Dizem que cairá uma maldição de mil anos sobre aquele que puxar uma de suas caudas por brincadeira. Acredita-se que cada uma de suas nove caudas possui um poder místico especial. Diz a lenda que este pokémon místico foi formado quando nove santos se uniram em um. As chamas que solta de sua boca deixam seus oponentes hipnotizados. Então, aproveita para atacar. A vida de Ninetales dura mil anos."),
            new Pokemon("Jigglypuff", new String[]{"Normal", "Fada"}, new String[]{"Veneno", "Metálico"}, "Seus grandes olhos são usados para encantar o inimigo. Depois, canta uma bela melodia que coloca o adversário para dormir. Ele pode inflar o corpo como um balão e sair flutuando. Possui um alcance vocal que ultrapassa 12 oitavas, mas a habilidade de canto de cada indivíduo depende de seu próprio esforço. Tem uma capacidade pulmonar excelente. Gravações das canções de ninar de Jigglypuff podem ser compradas em lojas de departamentos."),
            new Pokemon("Wigglytuff", new String[]{"Normal", "Fada"}, new String[]{"Veneno", "Metálico"}, "Sua pele é macia e seu corpo é bastante flexível. Quando está com raiva, consegue inalar o ar repetidas vezes, inflando seu corpo cada vez mais. Faz isso para intimidar os inimigos. Às vezes, eles podem crescer 20 vezes o seu tamanho! Seu pelo é fino e delicado. A mecha em sua testa tem uma textura celestial. Ele perde seu pelo fino quando as estações mudam. Seus olhos, cobertos por uma fina camada de lágrimas, repelem a poeira."),
            new Pokemon("Zubat", new String[]{"Veneno", "Voador"}, new String[]{"Elétrico", "Gelo", "Psíquico", "Pedra"}, "Sua audição é bem apurada. Para identificar aquilo que estiver em seu caminho, Zubat solta de sua boca ondas ultrassônicas. Isso lhe permite voar com segurança mesmo em locais escuros. De manhã, eles se reúnem em cavernas para se aquecerem enquanto dormem. Quando expostos ao sol, sofrem queimaduras. A frequência de suas ondas ultrassônicas pode variar ligeiramente de colônia para colônia."),
            new Pokemon("Golbat", new String[]{"Veneno", "Voador"}, new String[]{"Elétrico", "Gelo", "Psíquico", "Pedra"}, "Com os dentes bastante afiados, morde suas vítimas para sugar o sangue. Ele não irá parar de drenar a energia da vítima até estar satisfeito. Se chupa muito sangue, fica pesado e voa desajeitadamente. Dizem que, se encontrar um dos seus passando fome, compartilha o sangue que coletou. Eles podem sugar mais de 300 gramas de sangue de uma só vez. Seus dentes são ocos como canudos, tornando-os inesperadamente frágeis"),
            new Pokemon("Oddish", new String[]{"Planta", "Veneno"}, new String[]{"Fogo", "Gelo", "Voador", "Psíquico"}, "Durante o dia costuma ficar enterrado no chão, deixando apenas as suas folhas expostas. Ele irá berrar caso alguém tente arrancá-lo de lá. Quanto mais fértil o solo, mais brilhantes se tornam suas folhas. À noite sai para espalhar suas sementes. Dizem que caminha por 300 metros fazendo isso. Ele cresce ao se banhar ao luar."),
            new Pokemon("Gloom", new String[]{"Planta", "Veneno"}, new String[]{"Fogo", "Gelo", "Voador", "Psíquico"}, "O fedor proveniente da flor de sua cabeça pode ser sentido à distância. Pode causar desmaios a 2 km. Ele fede mais ainda quando se sente ameaçado. Uma a cada mil pessoas irá gostar do seu cheiro. Se estiver calmo e seguro, não vai liberar seu aroma fedorento. A baba que escorre de sua boca na verdade é um néctar pegajoso."),
            new Pokemon("Vileplume", new String[]{"Planta", "Veneno"}, new String[]{"Fogo", "Gelo", "Voador", "Psíquico"}, "Quanto maiores forem as suas pétalas, mais tóxico será o pólen contido nelas. Elas são tão pesadas que é difícil para ele aguentar. Ao sacudir as pétalas, o ar ao seu redor fica amarelo. Dizem que possui as maiores pétalas do mundo. O pólen tóxico de Vileplume desencadeia ataques de alergia atrozes. É aconselhável nunca se aproximar de flores atraentes na selva, por mais bonitas que sejam."),
            new Pokemon("Parasect", new String[]{"Inseto", "Planta"}, new String[]{"Fogo", "Gelo", "Veneno", "Voador", "Inseto", "Pedra"}, "Parasect está quase morto, sendo totalmente controlado pelo cogumelo que cresceu em suas costas. O cogumelo parece fazer todo o pensamento. Graças a ele, vive em locais úmidos e escuros. Ele solta esporos tóxicos por onde passa. Depois de colhidos, esses esporos podem ser mergulhados e fervidos para preparar medicamentos fitoterápicos. Muitas vezes, Parasect disputa território com Shiinotic."),
            new Pokemon("Venonat", new String[]{"Inseto", "Veneno"}, new String[]{"Fogo", "Voador", "Psíquico", "Pedra"}, "Seus olhos grandes podem atuar como radares. Eles são compostos por diversos outros olhos menores. São ótimos para enxergar no escuro ou ver coisas minúsculas. À noite, sua espécie é atraída pela luz. Vive nas sombras de árvores altas, onde se alimenta de insetos. Possui uma camada de cabelo fino e duro que cobre todo o corpo para proteção."),
            new Pokemon("Venomoth", new String[]{"Inseto", "Veneno"}, new String[]{"Fogo", "Voador", "Psíquico", "Pedra"}, "As asas são cobertas por escamas semelhantes a poeira. Quando ele ataca, bate suas grandes asas escuras violentamente para espalhar seu pó venenoso por todos os lados. Se suas asas tiverem uma coloração mais clara, seu pó é paralisante. Sua presa favorita são pequenos insetos que se aglomeram ao redor dos postes de luz, atraídos pela luz na escuridão."),
            new Pokemon("Diglett", new String[]{"Terra"}, new String[]{"Água", "Planta", "Gelo"}, "Passa a maior parte do tempo enterrado no subsolo. Ele deixa terra elevada em seu rastro, facilitando sua localização. Seu método de escavação pode deixar um campo perfeito para o cultivo. Muitos fazendeiros o valorizam pois suas fezes enriquecem o solo. Ele se alimenta das raízes das árvores. Ele prefere lugares escuros, passando a maior parte do tempo no subsolo."),
            new Pokemon("Dugtrio", new String[]{"Terra"}, new String[]{"Água", "Planta", "Gelo"}, "Dugtrio são realmente trigêmeos que surgiram de um corpo. Como resultado, cada indivíduo pensa exatamente como os outros dois. Eles trabalham cooperativamente para escavar sem parar. Ele desencadeia terremotos gigantes cavando a 100 km abaixo da terra. Em raras ocasiões, uma grande briga acontecerá sobre qual cabeça comerá primeiro. Ninguém nunca viu as partes dele escondidas no subsolo."),
            new Pokemon("Meowth", new String[]{"Normal"}, new String[]{"Lutador"}, "Meowth retira suas garras afiadas das patas para silenciosamente esgueirar-se furtivamente sem deixar nenhum rastro. Tem hábitos noturnos. Por alguma razão, este pokémon ama objetos brilhantes, em especial as moedas. Se estiver de bom humor, pode até deixar seu treinador dar uma olhada em seu tesouro. Lava o rosto regularmente para manter a moeda na testa sem manchas."),
            new Pokemon("Persian", new String[]{"Normal"}, new String[]{"Lutador"}, "Tem um temperamento vicioso. Cuidado se ele levanta a cauda. É um sinal de que ele está prestes a atacar e morder. Embora seu pelo tenha muitos admiradores, é difícil criar como um animal de estimação por causa de sua mesquinhez. É difícil sua conquistar amizade, logo irá te arranhar no momento em que for irritado. É alvo de caçadores que estão atrás da joia em sua testa. A relação dele com Perrserker é de mútuo desdenho."),
            new Pokemon("Psyduck", new String[]{"Água"}, new String[]{"Planta", "Elétrico"}, "Oprimido por habilidades enigmáticas, ele sofre uma dor de cabeça constante. Quando sua dor de cabeça chega ao ápice, ele usa seus misteriosos poderes psíquicos para mandar pra longe o que está o irritando. Se ele usa seu poder misterioso, Psyduck não se lembra de tê-lo feito. Aparentemente, ele não consegue formar uma memória de tal evento porque entra em um estado alterado que é muito parecido com o sono profundo."),
            new Pokemon("Golduck", new String[]{"Água"}, new String[]{"Planta", "Elétrico"}, "Ele é visto nadando de forma dinâmica e elegante usando seus membros e nadadeiras bem desenvolvidos. É constantemente confundido com o Kappa, um assassino monstro japonês. Velhos contos falam de Golduck punindo os que contaminaram seu rio, arrastando-os para a água e levando-os embora. Dizem que a parte vermelha de sua testa concede poderes sobrenaturais àqueles que o possuem, por isso foi muito caçado no passado."),
            new Pokemon("Mankey", new String[]{"Lutador"}, new String[]{"Voador", "Psíquico", "Fada"}, "Vive em colônias nas copas das árvores. Se você enfurecer um deles, vai ter que lidar com um bando furioso de Mankey. Não é seguro se aproximar dele quando está violento e furioso por nenhum motivo, pois quando isso acontece, ele não consegue distinguir amigos de inimigos. Sua fúria o cansa e o faz adormecer, mas a raiva que ressoa em seus sonhos o faz acordar, o enfurecendo novamente."),
            new Pokemon("Primeape", new String[]{"Lutador"}, new String[]{"Voador", "Psíquico", "Fada"}, "Se você se aproximar enquanto ele dorme você pode acabar acordando-o, começando assim uma furiosa caçada com esse primata bêbado de sono. Ele persegue qualquer um que faça contato visual. Ele nunca perdoará os oponentes que o irritaram. Quando Primeape fica furioso, sua circulação sanguínea aumenta. Por sua vez, seus músculos ficam ainda mais fortes. Ele morre de tanta raiva, mas seu rosto parece em paz na morte."),
            new Pokemon("Growlithe", new String[]{"Fogo"}, new String[]{"Água", "Terra", "Pedra"}, "Um pokémon naturalmente leal, fiel e obediente. Ele permanece imóvel até receber ordem de seu treinador. Se ordenado, ele não hesitará em atacar inimigos maiores e mais fortes, porém seu senso de justiça impede que ele ataque imediatamente oponentes mais fracos e menores. Latirá sem medo para proteger seu treinador em perigo. Tem um olfato excelente. Assim que sentir algum cheiro, jamais esquecerá."),
            new Pokemon("Arcanine", new String[]{"Fogo"}, new String[]{"Água", "Terra", "Pedra"}, "Este lendário pokémon chinês é considerado magnífico. Muitas pessoas se encantam por sua enorme juba. Seu imponente latido transmite uma ideia de líder. Todos que ouvem não podem fazer nada além de se ajoelhar para sua majestade. É conhecido por sua alta velocidade, podendo correr 10.000 km em um dia e uma noite. O fogo queimando dentro de seu corpo é sua fonte de energia."),
            new Pokemon("Poliwag", new String[]{"Água"}, new String[]{"Planta", "Elétrico"}, "Sua pele é tão fina que se você prestar bastante atenção você consegue enxergar seus órgãos internos. O espiral em sua barriga é, na verdade, parte de suas vísceras aparecendo através da pele. A direção do giro desse espiral difere dependendo de onde eles vivem. Eles possuem dificuldade para andar com seus pés recém-crescidos e por isso tropeçam toda hora. São melhores nadando."),
            new Pokemon("Poliwhril", new String[]{"Água"}, new String[]{"Planta", "Elétrico"}, "A espiral na sua barriga gira sutilmente. Olhar para essa espiral pode te deixar desde sonolento até, no máximo, hipnotizado. Suas duas pernas são bem desenvolvidas, logo ele não tropeça mais. Pode viver tranquilamente na terra, mas ele prefere viver na água. Seu suor é um muco viscoso. Se for pego, irá escorregar nas mãos do inimigo e escapar. Sua saúde é prejudicada quando a pele seca, precisa estar sempre hidratado."),
            new Pokemon("Poliwrath", new String[]{"Água", "Lutador"}, new String[]{"Planta", "Elétrico", "Voador", "Psíquico", "Fada"}, "Poliwrath tem um corpo altamente desenvolvido e não importa o quão exaustivo é o trabalho, seus músculos nunca ficam cansados. É tão incansavelmente forte que ele pode nadar de um lado ao outro do Oceano Pacífico sem fazer muito esforço. Ele desenvolve seus músculos através da natação. É bom em nado de peito e nado de crawl. Ao nadar em mares frios, usa seus braços para quebrar o gelo à deriva."),
            new Pokemon("Abra", new String[]{"Psíquico"}, new String[]{"Inseto", "Fantasma", "Noturno"}, "Ele usa seus poderes psíquicos enquanto dorme. Usar poderes psíquicos causa tanta tensão em seu cérebro que ele precisa dormir 18 horas por dia. Por essa razão, é difícil ver um Abra usando qualquer golpe diferente do teletransporte. Quanto mais profundo for o seu sono, mais pra longe se teletransporta. Quando acorda, não sabe onde está, então entra em pânico. Também consegue ler a mente dos outros."),
            new Pokemon("Kadabra", new String[]{"Psíquico"}, new String[]{"Inseto", "Fantasma", "Noturno"}, "Logo após evoluir seu poder mental aumenta deixando ele utilizar vários golpes psíquicos poderosos, porém que precisam de maior concentração. Ele olha para a sua colher de prata para esvaziar sua mente e acaba emitindo mais ondas alfa. Existem rumores que um menino que usava poderes psíquicos se transformou nesse pokémon. A presença de Kadabra infesta televisões e monitores com sombras assustadoras que trazem azar."),
            new Pokemon("Alakazam", new String[]{"Psíquico"}, new String[]{"Inseto", "Fantasma", "Noturno"}, "Dizem que as colheres em suas mãos foram feitas com seus poderes psíquicos. Seu cérebro é tão grande que dizem que é o pokémon mais inteligente que já existiu. Seu QI é de aproximadamente 5.000. Alguns dizem que Alakazam se lembra de tudo o que acontece com ele, do nascimento até a morte. Suas células cerebrais continuam a aumentar até sua morte. Quanto mais velho o Alakazam, maior será sua cabeça."),
            new Pokemon("Machop", new String[]{"Lutador"}, new String[]{"Voador", "Psíquico", "Fada"}, "Embora seja baixinho, ele é forte o suficiente para levantar e arremessar uma série de Geodudes de uma só vez. Ele adora malhar. Para ficar mais forte, ele ergue repetidamente um Graveler usando uma mão só. Com sua força sobre-humana, é capaz de derrubar cem pessoas ao mesmo tempo. Gosta de alimentos altamente nutritivos porque os seus instintos o levam a construir músculos de forma eficiente."),
            new Pokemon("Machoke", new String[]{"Lutador"}, new String[]{"Voador", "Psíquico", "Fada"}, "O poder ilimitado de Machoke é muito perigoso, por isso usa um cinto que suprime a sua energia. Usando esse poder, ele ajuda as pessoas com trabalhos pesados. Ele faz isso porque sabe que o trabalho é um bom treinamento para seus músculos. Ele é muito procurado por pedreiros e engenheiros. Ao encontrar um inimigo verdadeiramente poderoso, este pokémon remove o cinto da cintura e libera todo o seu poder."),
            new Pokemon("Machamp", new String[]{"Lutador"}, new String[]{"Voador", "Psíquico", "Fada"}, "Seus quatro braços musculosos acertam seus inimigos com socos potentes e cortes em uma velocidade estonteante. Ele pode dar até mil socos em apenas dois segundos. Com quatro braços, pode atacar e defender simultaneamente. Dizem que domina todas as artes marciais do mundo. Seus dedos desajeitados o impedem de fazer qualquer trabalho que requeira cuidado e destreza."),
            new Pokemon("Bellsprout", new String[]{"Planta", "Veneno"}, new String[]{"Fogo", "Gelo", "Voador", "Psíquico"}, "Ele planta seus pés profundamente no subsolo para se reabastecer com água. Prefere ambientes quentes e úmidos. Embora seu corpo seja extremamente magro, ele rapidamente captura sua presa com suas vinhas. Ele consegue se curvar e balançar para evitar qualquer ataque, por mais forte que seja. Seu botão de flor parece um rosto humano. Por causa do botão, dizem que é um tipo de planta de mandrágora lendária."),
            new Pokemon("Weepinbell", new String[]{"Planta", "Veneno"}, new String[]{"Fogo", "Gelo", "Voador", "Psíquico"}, "Um pokémon que parece ser uma planta para capturar presas desavisadas nocauteando-as com um pó venenoso. Os músculos de sua boca são bastante desenvolvidos. Ele cospe um fluido que dissolve tudo. As partes com folhas atuam como cortadores para cortar os inimigos. À noite, ele se engancha em um galho de árvore e vai dormir."),
            new Pokemon("Victreebel", new String[]{"Planta", "Veneno"}, new String[]{"Fogo", "Gelo", "Voador", "Psíquico"}, "Ele tem uma 'piscina' em sua boca com um fluido com cheiro de mel que é na verdade um ácido que digere qualquer coisa. O ácido que se dissolveu muitas presas se torna mais doce, tornando ainda mais eficiente para atraí-las. Dizem que vive em enormes colônias nas selvas, embora ninguém jamais tenha voltado para contar. Possui uma longa trepadeira que se estende desde sua cabeça. Quando uma presa se aproxima, ele a engole inteira."),
            new Pokemon("Tentacool", new String[]{"Água", "Veneno"}, new String[]{"Elétrico", "Terra", "Psíquico"}, "Seu corpo é 99% composto de água. O 1% restante contém o órgão que fabrica seu veneno. Ele dispara feixes estranhos de seus olhos que parecem cristais. Incontáveis pescadores são feridos por seu ferrão todo dia. Seus tentáculos venenosos se quebram às vezes, mas depois de um tempo, eles voltam a crescer. Alguns são encontrados desidratados na praia. Basta colocá-los na água para reanimá-los."),
            new Pokemon("Tentacrue", new String[]{"Água", "Veneno"}, new String[]{"Elétrico", "Terra", "Psíquico"}, "Ele estende seus 80 tentáculos para formar redes de cerco venenoso que é difícil escapar. Seus tentáculos absorvem a água e esticam quase infinitamente para prender suas presas e inimigos. Seus tentáculos são curtos, estica apenas para caçar. Quanto mais velho, menos tentáculos terá. Quando as orbes vermelhas na cabeça de Tentacruel brilharem intensamente, tome cuidado. Ele está prestes a disparar uma explosão de ondas ultrassônicas."),
            new Pokemon("Geodude", new String[]{"Pedra", "Terra"}, new String[]{"Água", "Planta", "Gelo", "Lutador", "Terra", "Metálico"}, "Muitos vivem por trilhas das montanhas e permanecem semi-enterrados, mantendo um olho em escaladores. Essa atitude faz com que sejam confundidos por pedras na maioria das vezes. Ele se choca contra os outros em disputas de dureza. Quanto mais tempo um Geodude vive, mais suas bordas são lascadas e gastas, tornando-o mais arredondado na aparência. De manhã, rola ladeira abaixo em busca de comida."),
            new Pokemon("Graveler", new String[]{"Pedra", "Terra"}, new String[]{"Água", "Planta", "Gelo", "Lutador", "Terra", "Metálico"}, "Ele caminha muito devagar, logo ele rola para se locomover. Ele não presta atenção em nenhum objeto que passa em seu caminho. Com uma natureza livre e indiferente, ele não se importaria se pedaços quebram enquanto ele desce montanhas. Com impulso suficiente, sua velocidade pode ultrapassar 100 km/h. Rochas cobertas de musgo são sua comida favorita. Pode devorar uma tonelada por dia."),
            new Pokemon("Golem", new String[]{"Pedra", "Terra"}, new String[]{"Água", "Planta", "Gelo", "Lutador", "Terra", "Metálico"}, "Nem dinamite pode explodir seu resistente corpo de pedra. Quando está rolando, nada pode pará-lo e ele não para por nada. Ele detona seu próprio corpo. O poder dessa explosão pode impulsioná-lo por caminhos de montanha íngremes com velocidade incrível. Ele pode facilmente rolar por cima da lava sem se queimar ou afundar. Uma vez por ano, ele passa por uma muda e seu casco retorna ao solo."),
            new Pokemon("Ponyta", new String[]{"Fogo"}, new String[]{"Água", "Terra", "Pedra"}, "Exímios corredores, eles sempre ganham corridas de velocidade. Porém se competir com um Ponyta bebê dificilmente irá perder. Os bebês não correm muito bem. Conforme ele corre com outros de sua espécie, suas pernas ficam mais fortes. Seu fogo só queima quem com ele teima. Se você foi aceito por Ponyta, sua crina em chamas não será mais quente ao toque."),
            new Pokemon("Rapidash", new String[]{"Fogo"}, new String[]{"Água", "Terra", "Pedra"}, "Com uma grande aceleração, ele alcança sua velocidade máxima, 240 km/h, em apenas 10 passos. Com a sua juba flamejando ferozmente, ele corre como se fosse uma flecha. O corredor mais rápido se torna o líder e decide o ritmo do rebanho e a direção da viagem. Muito competitivo, perseguirá qualquer coisa que se mova rápido na esperança de competir com ela."),
            new Pokemon("Slowpoke", new String[]{"Água", "Psíquico"}, new String[]{"Planta", "Elétrico", "Inseto", "Fantasma", "Noturno"}, "Ele é tão inteligente quanto um Wobbuffet e tão veloz quanto um Caterpie. Apesar de lerdo, ele é muito habilidoso com sua cauda. Ele a utiliza para pescar. Não sente dor se alguém morder ou arrancar sua cauda e não perceberá quando ela crescer de volta. Suas caudas são um ingrediente precioso para culinária. Uma crença antiga dizia que sempre que Slowpoke boceja, chove."),
            new Pokemon("Slowbro", new String[]{"Água", "Psíquico"}, new String[]{"Planta", "Elétrico", "Inseto", "Fantasma", "Noturno"}, "Quando um Shellder morde a cauda de Slowpoke ele se torna um lesado Slowbro, se o Shellder é retirado durante uma batalha ele volta a ser um Slowpoke. Shellder, em sua avidez por sugar cada vez mais doçura da cauda de Slowbro, se metamorfoseou em uma concha em forma de espiral. Slowbro adora olhar para o vazio. Sempre que Shellder morde seu rabo com força, dá a ele um lampejo de inspiração… que ele esquece um momento depois."),
            new Pokemon("Magnemite", new String[]{"Elétrico", "Metálico"}, new String[]{"Fogo", "Lutador", "Terra"}, "Ele usa ondas eletromagnéticas para flutuar, porém isso não impede que ele receba um enorme dano de golpes terrestres. Alimenta-se de eletricidade. Eles se reúnem em locais onde há eletricidade. Ele emite ondas eletromagnéticas dos imãs em cada lado do corpo. Às vezes, Magnemite fica sem eletricidade e acaba no chão. Se você der baterias para um Magnemite aterrado, ele começará a se mover novamente."),
            new Pokemon("Magneton", new String[]{"Elétrico", "Metálico"}, new String[]{"Fogo", "Lutador", "Terra"}, "Ele é resultado de uma junção de três Magnemite unidos pelo magnetismo. Ao se unirem, seus cérebros também se tornam um. Um grupo de Magneton pode causar uma tempestade magnética. A maioria dos computadores enlouquece quando um deles se aproxima. Envia ondas de rádio poderosas para estudar seus arredores. Surtos desse pokémon acontecem quando muitas manchas solares aparecem."),
            new Pokemon("Farfetch’d", new String[]{"Normal", "Voador"}, new String[]{"Elétrico", "Gelo", "Pedra"}, "Ele nunca vai a luta sem seu fiel toco de alho-poró. Ele serve como uma espada para cortar todos os tipos de coisas. Ele só come seu alho-poró em casos de emergência e mesmo assim logo acha um substituto. Também pode usar o alho-poró para construir seu ninho. Eles vivem onde crescem as plantas de alho-poró. Farfetch’d raramente é visto, então pensa-se que seu número esteja diminuindo."),
            new Pokemon("Doduo", new String[]{"Normal", "Voador"}, new String[]{"Elétrico", "Gelo", "Pedra"}, "Os cérebros de sua cabeça compartilham emoções por telepatia. Eles também compartilham a fome e estão constantemente brigando entre si por comida. Percorre planícies relvadas com passadas poderosas, deixando pegadas de até dez centímetros de profundidade. As duas cabeças de Doduo nunca dormem ao mesmo tempo. Elas se revezam, uma cabeça vigia os inimigos enquanto a outra dorme."),
            new Pokemon("Dodrio", new String[]{"Normal", "Voador"}, new String[]{"Elétrico", "Gelo", "Pedra"}, "Quando Doduo evolui, uma de suas cabeças se divide em duas. Essas duas cabeças compartilham as mesmas memórias. Ele pode correr a 60 km/h. Suas cabeças representam alegria, fúria e tristeza. Cuidado se as três cabeças de Dodrio estão olhando em três direções diferentes. É um sinal claro de que está em guarda. Além de 3 cabeças, possui 3 pares de pulmões e 3 corações, que lhe permitem correr longas distâncias sem descanso."),
            new Pokemon("Seel", new String[]{"Água"}, new String[]{"Planta", "Elétrico"}, "Um pokémon que vive em icebergs. O chifre de sua cabeça é bastante duro, capaz de perfurar o mar congelado. Mergulha para caçar. Usa o chifre para quebrar as geleiras e voltar a superfície. Adora viver num clima frio. Não consegue andar bem em terra, porém é um ótimo nadador. Graças à sua gordura espessa, os mares frios não o incomodam em nada, mas cansa-se facilmente em águas quentes."),
            new Pokemon("Dewgong", new String[]{"Água", "Gelo"}, new String[]{"Planta", "Elétrico", "Lutador", "Pedra"}, "Armazena uma energia térmica em seu corpo. Mesmo num frio intenso permanece ileso, conseguindo nadar poderosamente em águas geladas. Quanto mais fria a temperatura, mais agitado ele fica. Consegue se camuflar bem na neve. Dewgong adora cochilar no gelo extremamente frio. Toma banho de sol após as refeições. O aumento da temperatura corporal ajuda a digestão."),
            new Pokemon("Grimer", new String[]{"Veneno"}, new String[]{"Terra", "Psíquico"}, "As plantas deixarão de nascer por onde passar. Enquanto caminha, pedaços de seu corpo podem ficar para trás, formando novos Grimers. Gosta de viver nos esgotos das cidades. Sua principal fonte de alimento são os resíduos industriais viscosos das fábricas. Ele nasceu da lama transformada pela exposição aos raios X da lua. Quando sua carga interna de germes diminui, ele morre."),
            new Pokemon("Muk", new String[]{"Veneno"}, new String[]{"Terra", "Psíquico"}, "Um pokémon sujo e feito de lama. É tão tóxico que mesmo suas pegadas contém veneno. Seu cheiro é tão horrível que pode causar desmaios. Sua comida favorita é qualquer coisa repugnantemente suja. Como eles espalham germes por toda parte, são alvos de extermínio, levando a um declínio em sua população. Após as recentes melhorias ambientais, quase não é mais visto. As pessoas especulam que pode ser extinto em algum momento."),
            new Pokemon("Shellder", new String[]{"Água"}, new String[]{"Planta", "Elétrico"}, "Sua concha dura repele qualquer tipo de ataque. É vulnerável somente quando sua concha é aberta. Grãos de areia que caem em sua concha podem se tornar pérolas com os fluídos de seu corpo. Como a pérola o atrapalha, ele logo a cospe. Nada voltado para trás, abrindo e fechando sua concha. Mesmo quando sua concha está fechada, sua língua ainda fica para fora. Dê um bom puxão e o choque fará com que Shellder abra a concha."),
            new Pokemon("Cloyster", new String[]{"Água", "Gelo"}, new String[]{"Planta", "Elétrico", "Lutador", "Pedra"}, "Sua concha é tão dura quanto diamante, ele a utiliza como forma de defesa. Não pode ser destruída, mesmo com uma bomba. Se áreas da concha forem danificadas, essas áreas incham, crescendo gradualmente em grandes espinhos afiados. Ele agarra seus inimigos fechando a concha. Pode lançar vários espinhos a partir dela. Ninguém nunca viu como são suas entranhas. Nada no mar engolindo água e depois jogando-a para trás."),
            new Pokemon("Gastly", new String[]{"Fantasma", "Veneno"}, new String[]{"Terra", "Psíquico", "Fantasma", "Noturno"}, "Seu corpo é todo feito de gás. Nunca irão surgir quando venta muito, pois acabam sendo levados pelo vento. Sua pele é venenosa e pode enfraquecer qualquer um que entrar em contato. Qualquer um desmaiará se for engolfado por seu corpo gasoso, que contém veneno. O gás venenoso compreende 95% de seu corpo. Dizem que os 5% restantes são almas daqueles que morreram ao aspirar o gás."),
            new Pokemon("Haunter", new String[]{"Fantasma", "Veneno"}, new String[]{"Terra", "Psíquico", "Fantasma", "Noturno"}, "Consegue atravessar paredes e usar sua língua para paralisar os outros. Se você tem a sensação de estar sendo observado na escuridão, tropeçar do nada ou escutar um ruído quando ninguém está por perto, pode ser um Haunter aprontando. Sua língua é feita de gás. Se lambido, sua vítima começa a tremer constantemente até que a morte venha. Tem medo da luz e deleita-se com a escuridão."),
            new Pokemon("Gengar", new String[]{"Fantasma", "Veneno"}, new String[]{"Terra", "Psíquico", "Fantasma", "Noturno"}, "Em noites de lua cheia, este pokémon sai para imitar as sombras das pessoas e assustá-las. Caso você sinta um calafrio repentino, quer dizer que há um Gengar por perto. Emerge das trevas para roubar a vida daqueles que se perderam nas montanhas. Como já foi humano, ele tenta criar um companheiro de viagem tirando a vida de outros humanos. Contos dizem que Gengar fará uma visita às crianças que são travessas."),
            new Pokemon("Onix", new String[]{"Pedra", "Terra"}, new String[]{"Água", "Planta", "Gelo", "Lutador", "Terra", "Metálico"}, "Conforme vai crescendo, seu corpo rochoso vai ficando cada vez mais duro. Ele consegue cavar no solo em uma velocidade de 80 km/h, girando e contorcendo as pedras de seu corpo para isso. À medida que cava no solo, ele absorve muitos objetos duros. É isso que torna seu corpo tão sólido. Onix tem um ímã em seu cérebro. Ele atua como uma bússola para que o pokémon não perca a direção durante o túnel."),
            new Pokemon("Drowzee", new String[]{"Psíquico"}, new String[]{"Inseto", "Fantasma", "Noturno"}, "Coloca seus oponentes para dormir e em seguida come os seus sonhos. Algumas vezes acaba ficando doente por comer sonhos ruins. Parece que os pesadelos têm gosto azedo. Quando faz amizade com outras pessoas, pode mostrar-lhes os sonhos mais deliciosos que já teve. Acredita-se que ele tenha ancestrais comuns com Munna e Musharna. Se você teve um sonho bom, mas não consegue se lembrar, provavelmente um Drowzee o comeu."),
            new Pokemon("Hypno", new String[]{"Psíquico"}, new String[]{"Inseto", "Fantasma", "Noturno"}, "Caso você encontrar um desses, evite o contato olho a olho. Ele vai tentar fazer dormir usando seu pêndulo. Seus poderes hipnóticos são bastante desenvolvidos. As pessoas que precisam de um sono profundo o chamam de seu salvador. Existem alguns Hypnos que ajudam médicos com pacientes que não conseguem dormir à noite em hospitais. Certa vez, houve um incidente em que levou uma criança que o hipnotizou."),
            new Pokemon("Krabby", new String[]{"Água"}, new String[]{"Planta", "Elétrico"}, "Ele pode ser encontrado perto do mar. Nas praias, costuma se enterrar em buracos cavados na areia. Suas pinças, além de serem uma arma poderosa, servem de equilíbrio para andar de lado. Se uma pinça cair, irá nascer uma nova e mais resistente. Ele fica espumando a boca quando se sente ameaçado. Em praias com pouca comida, disputam entre si por território."),
            new Pokemon("Kingler", new String[]{"Água"}, new String[]{"Planta", "Elétrico"}, "Sua garra cresceu maciçamente e tão duro quanto aço. Porém, por ser muito pesada, é difícil manuseá-la. Ela tem uma potência de 10.000 cavalos. Ele agita sua enorme garra no ar para se comunicar com os outros. Por ser muito grande, logo fica cansado. Se ele levantar a pinça muito rápido, ele perde o equilíbrio e cambaleia."),
            new Pokemon("Voltorb", new String[]{"Elétrico"}, new String[]{"Terra"}, "Normalmente encontrados em usinas de energia. Muitas vezes é confundido com uma pokébola e acaba dando choque em pessoas. Ele pode até explodir em alguns casos. Foi avistado pela primeira vez em uma empresa que fabrica pokébolas. Há rumores de que foi criado quando uma pokébola foi exposta a um poderoso pulso de energia."),
            new Pokemon("Electrode", new String[]{"Elétrico"}, new String[]{"Terra"}, "Ele armazena uma quantidade abundante de energia elétrica dentro de seu corpo. Mesmo um pequeno choque pode fazê-lo explodir. É temido, com o apelido de 'A Bola Bomba'. São muito usados como geradores de energia em usinas de força. Consome eletricidade da atmosfera. Em dias de queda de raios, você pode vê-lo explodindo por toda parte por comer muita eletricidade."),
            new Pokemon("Exeggcute", new String[]{"Planta", "Psíquico"}, new String[]{"Fogo", "Gelo", "Veneno", "Voador", "Inseto", "Fantasma", "Noturno"}, "Este pokémon é formado por seis ovos comunicam-se entre si por telepatia. Quando aparecem cada vez mais rachaduras nos ovos, é sinal que Exeggcute está para evoluir. No minuto em que um membro do grupo desaparece, Exeggcute torna-se covarde. Deve haver seis cabeças para manter o equilíbrio. Mesmo que pareça ser algum tipo de ovo, descobriu-se que era uma forma de vida mais parecida com sementes de plantas,."),
            new Pokemon("Exeggutor", new String[]{"Planta", "Psíquico"}, new String[]{"Fogo", "Gelo", "Veneno", "Voador", "Inseto", "Fantasma", "Noturno"}, "Exeggutor veio originalmente dos trópicos. Apesar de cada uma de suas 3 cabeças pensar por si, nunca vão brigar. Eles usam a telepatia para discutir seus planos antes de chegar a uma decisão conjunta. Quando trabalham juntos, podem liberar uma poderosa energia psíquica. Os dias nublados tornam este pokémon lento. Se uma de suas cabeças crescer muito, ela cai e se torna um Exeggcute."),
            new Pokemon("Cubone", new String[]{"Terra"}, new String[]{"Água", "Planta", "Gelo"}, "ua cabeça é coberta pelo crânio de sua falecida mãe. Ninguém sabe como é o seu rosto. Ele chora sempre que se lembra se sua mãe. As marcas desse crânio foram causadas pelas lágrimas de Cubone que escorreram. De acordo com alguns, seu choro o deixa mais forte até que supere a morte da mãe. Seu choro, por azar, pode acabar atraindo Mandibuzz, seu predador."),
            new Pokemon("Marowak", new String[]{"Terra"}, new String[]{"Água", "Planta", "Gelo"}, "Este pokémon superou sua tristeza ao evoluir para um novo corpo robusto. O crânio de sua mãe se fundiu a ele. Guarda ossos desde que nasceu. Possui uma grande habilidade para usá-los como armas. Manda mensagens para outros de sua espécie dando marretadas em pedras com o osso que carrega. Tem um temperamento violeto. Ele atira ossos em Mandibuzz para derrubá-lo."),
            new Pokemon("Hitmonlee", new String[]{"Lutador"}, new String[]{"Voador", "Psíquico", "Fada"}, "Suas pernas podem se esticar para o dobro do tamanho. Quando está com pressa, pode correr dando passos bem largos. Consegue dar vários chutes consecutivos sem sair do lugar. Pode aprender qualquer tipo de chute. Tem um incrível senso de equilíbrio, podendo chutar sucessivamente de qualquer posição. Após a batalha, ele esfrega as pernas e relaxa os músculos para superar a fadiga."),
            new Pokemon("Hitmonchan", new String[]{"Lutador"}, new String[]{"Voador", "Psíquico", "Fada"}, "Seus socos são tão velozes que rasgam o ar. Eles são lançados em alta velocidade, mesmo um leve arranhão pode causar queimaduras. Os socos que ele lança pulverizam até mesmo o concreto. Possui um espírito indomável de nunca desistir perante as adversidades. Precisa de um tempo para descansar a cada 3 minutos de batalha. Dizem que possui o espírito de um boxeador que estava treinando para um campeonato mundial."),
            new Pokemon("Lickitung", new String[]{"Normal"}, new String[]{"Lutador"}, "Sua língua tem mais de dois metros de comprimento. Quem for lambido será paralisado. Quando ele a estica por completo, sua cauda balança. Acredita-se que língua e cauda estão de alguma forma conectados. Se a saliva pegajosa desse pokémon encostar em você e você não a limpar, uma coceira intensa irá se manifestar. Sua principal fonte de alimento são os pokémons insetos."),
            new Pokemon("Koffing", new String[]{"Veneno"}, new String[]{"Terra", "Psíquico"}, "Este pokémon consegue soltar gases explosivos. O seu gás venenoso é mais leve que o ar, o que mantém ele flutuando. Seu gás é ainda mais tóxico em ambientes quentes ou quando fica irritado. Ele flutua em depósitos de lixo, procurando a fumaça do lixo cru e apodrecido. Se ele inflar demais o corpo, pode explodir. Ele fede quando está próximo."),
            new Pokemon("Weezing", new String[]{"Veneno"}, new String[]{"Terra", "Psíquico"}, "Onde dois tipos de gases venenosos se encontram, dois Koffings podem se fundir em um Weezing durante muitos anos. Quando uma cabeça infla, a outra murcha. Embora muito raros, trigêmeos foram encontrados. Ele mistura substâncias tóxicas em seu corpo. Weezing adora os gases emitidos pelo lixo podre da cozinha. Este pokémon encontrará uma casa suja e mal cuidada e fará dela seu lar."),
            new Pokemon("Rhyhorn", new String[]{"Terra", "Pedra"}, new String[]{"Água", "Planta", "Gelo", "Lutador", "Terra", "Metálico"}, "Ele é lento e tem dificuldade para virar o corpo para o lado devido às suas patas curtas. Seus ossos são mil vezes mais duros do que os dos homens. Não é muito cauteloso, podendo destruir o que estiver em seu caminho. Pode quebrar até mesmo um arranha-céu com suas investidas. Não muito inteligente, assim que começa a correr, ele esquece por que começou. Ele pode se lembrar apenas de uma coisa de cada vez"),
            new Pokemon("Rhydon", new String[]{"Terra", "Pedra"}, new String[]{"Água", "Planta", "Gelo", "Lutador", "Terra", "Metálico"}, "Seu cérebro se desenvolveu depois que passou a andar sobre duas patas. A pele grossa que possui pode protegê-lo ainda que esteja sob o magma de 2.000° C. Seu chifre pode girar como uma broca, sendo capaz de quebrar até mesmo diamantes. Um golpe violento de sua cauda pode derrubar um edifício. Sua pele é tão resistente que mesmo golpes diretos de um canhão não deixam um arranhão."),
            new Pokemon("Chansey", new String[]{"Normal"}, new String[]{"Lutador"}, "Sendo raros e de difícil captura, é dito que ela traz felicidade para o treinador que a pega. Seus ovos são nutritivos e recomendados para uma alimentação balanceada. É usado como ingrediente culinário de alta classe. Anda com cautela para evitar ter seu ovo quebrado. Mesmo assim, aprendeu a fugir rapidamente, tendo em vista que muitos humanos e pokémons querem pegar os seus ovos. Por ser compassiva, compartilha seus ovos com os feridos."),
            new Pokemon("Tangela", new String[]{"Planta"}, new String[]{"Fogo", "Gelo", "Veneno", "Voador", "Inseto"}, "Seu corpo é coberto por um emaranhado de vinhas. Elas são compostas por finos fios de cabelo. Sua tática é enrolar os adversários com suas vinhas. A verdadeira aparência deste pokémon permanece um mistério. Suas vinhas possuem um perfume distinto. Em algumas lugares, elas são usadas como ervas. As vinhas se quebram facilmente se forem agarradas. As vinhas perdidas são substituídas por vinhas recém-crescidas no dia seguinte."),
            new Pokemon("Kangaskhan", new String[]{"Normal"}, new String[]{"Lutador"}, "Este pokémon guarda seus filhotes em sua bolsa marsupial. Ela fará de tudo para proteger o bebê, ainda que judiada em batalha. Seu amor maternal é tão profundo que enfrentará a morte para proteger sua cria. Raramente o bebê sai da bolsa, eles permanecem lá até completarem 3 anos de idade. Não perdoa quem machucar seu filhote. Existem registros de uma criança humana perdida sendo criada por uma Kangaskhan sem filhos."),
            new Pokemon("Horsea", new String[]{"Água"}, new String[]{"Planta", "Elétrico"}, "Ele faz o seu ninho entre corais. Quando está assustado, esguicha um jato de tinta. Se cai em uma correnteza, enrola sua cauda numa pedra ou planta para não ser levado. Consegue nadar de costas com a sua nadadeira dorsal. Eles nadam com movimentos de dança e causam a formação de redemoinhos. Competem entre si para ver quem gera o maior redemoinho. Se alimenta de pequenos insetos e musgo das rochas."),
            new Pokemon("Seadra", new String[]{"Água"}, new String[]{"Planta", "Elétrico"}, "A barriga dele possui grossas cerdas que são venenosas. Os espinhos em suas costas secretam veneno. Seus redemoinhos são fortes o suficiente para engolir barcos de pesca. Geralmente são os machos que cuidam dos filhotes. Ossos e nadadeiras deste pokémon são ingredientes de uma medicina caseira. Sua boca é fina, mas seu poder de sucção é forte, podendo sugar alimentos maiores do que a boca. Dorme depois de se contorcer entre os galhos de coral."),
            new Pokemon("Goldeen", new String[]{"Água"}, new String[]{"Planta", "Elétrico"}, "Em época de desova, eles são vistos nadando em rios e cachoeiras em grandes grupos. São ótimos e belos nadadores. Se colocados em um grande aquário de vidros resistentes, irão quebrá-lo com a força de seu chifre para escapar. Quando o clima fica quente, eles formam grupos e nadam rio acima. Competem entre si para ver quem tem o chifre mais grosso e afiado. Suas nadadeiras ondulam elegantemente na água."),
            new Pokemon("Seaking", new String[]{"Água"}, new String[]{"Planta", "Elétrico"}, "Com o seu poderoso chifre, faz buracos nas pedras dos leitos dos rios para fazer o ninho de seus ovos. Ele dá a própria vida para defender seus ovos. No outono, seu corpo fica mais gordo ao se preparar para pedir um par. Ele assume belas cores. A coloração do macho é mais viva. Para atrair as fêmeas, os machos dançam no fundo do rio. As fêmeas se reúnem em torno do macho que dança com mais elegância."),
            new Pokemon("Staryu", new String[]{"Água"}, new String[]{"Planta", "Elétrico"}, "Mesmo que seus membros sejam cortados, Staryu conseguirá regenerá-los desde que a jóia no centro de seu corpo não tenha sido danificada. Quando está muito fraco, a jóia de Staryu começa a piscar. Se você visitar uma praia no final do verão, poderá ver grupos de Staryu piscando em um ritmo constante. Em muitos lugares, existem contos populares de poeira estelar caindo no oceano e se tornando Staryu."),
            new Pokemon("Starmie", new String[]{"Água", "Psíquico"}, new String[]{"Planta", "Elétrico", "Inseto", "Fantasma", "Noturno"}, "Seu corpo se desenvolve num formato geometricamente simétrico. Ela se movimenta nas águas girando o corpo como uma hélice. A jóia no núcleo de seu corpo brilha nas sete cores do arco-íris. Pensa-se que seu núcleo brilhante recebe e transmite sinais enigmáticos. Sabe-se que causa dores de cabeça em quem se aproxima. Seu núcleo cintilante é chamado de 'a joia do mar'. Existe um mercado de tráfico dessas joias."),
            new Pokemon("Mr. Mime", new String[]{"Psíquico", "Fada"}, new String[]{"Veneno", "Fantasma", "Metálico"}, "Ele cria paredes invisíveis vibrando os seus dedos minuciosamente para parar as moléculas no ar. Seus gestos de mímico acabam enganando os outros que pensam que não há nada no caminho. A largura de suas mãos pode não ser coincidência, muitos cientistas acreditam que suas palmas aumentaram especificamente para os seus números de pantomima."),
            new Pokemon("Scyther", new String[]{"Inseto", "Voador"}, new String[]{"Fogo", "Elétrico", "Gelo", "Voador", "Pedra"}, "As foices afiadas em seus braços ficam ainda mais afiadas quando cortam objetos duros. Ele é tão rápido e veloz quanto um ninja. Ele se esconde pelo gramado pois a cor de seu corpo ajuda a camuflá-lo. Se você encontrar uma área em uma floresta onde muitas árvores foram cortadas, trata-se de um território de Scyther. Com um único corte, Scyther pode derrubar uma árvore enorme. Vivem em bandos treinando nas montanhas."),
            new Pokemon("Jynx", new String[]{"Gelo", "Psíquico"}, new String[]{"Fogo", "Inseto", "Pedra", "Fantasma", "Noturno", "Metálico"}, "Ela fala uma linguagem semelhante à dos seres humanos. No entanto, ela parece usar a dança para se comunicar. Ela rebola os quadris enquanto anda. Existem alguns músicos que compõem canções para Jynx cantar. Costuma ter vozes bonitas e delicadas. Alguns Jynx até reuniram uma base de fãs. Já foi temida e adorada como a Rainha do Gelo."),
            new Pokemon("Electabuzz", new String[]{"Elétrico"}, new String[]{"Terra"}, "O corpo dele descarrega energia constante mente. Ao chegar perto dele, os cabelos de uma pessoa irão se arrepiar. Electabuzz gosta de se alimentar da energia de usinas de força, causando grandes apagões nas cidades. Com a chegada de uma tempestade, muitos deles se reunirão sob as árvores altas e ficarão sentados esperando que um raio caia. Ele balança os braços e gira para carregar eletricidade antes de desferir um soco."),
            new Pokemon("Magmar", new String[]{"Fogo"}, new String[]{"Água", "Terra", "Pedra"}, "Magmar não gosta de lugares frios, por isso, sopra um fogo abrasador para tornar o ambiente adequado para si. Quando respira profundamente, emana ondas de calor de seu corpo. Vive próximo às bocas de vulcões, seu corpo resiste a lava. Ele embebe seu corpo em magma para aliviar seu cansaço. Seu corpo queima a 1.200° C. Ele despacha sua presa com fogo, mas logo se arrepende quando percebe que torrou o que ia comer."),
            new Pokemon("Pinsir", new String[]{"Inseto"}, new String[]{"Fogo", "Voador", "Pedra"}, "Pinsir possui grandes chifres com espinhos. Com eles, agarra seus adversários como uma pinça e aperta-os. É forte o bastante para partir uma árvore. Também utiliza os chifres para cavar buracos onde dorme à noite. Julgam uns aos outros com base em suas pinças. Pinças mais grossas e impressionantes tornam-se mais populares com o sexo oposto. Embora seja resistente, não suporta bem o frio. Vive em lugares quentes."),
            new Pokemon("Tauros", new String[]{"Normal"}, new String[]{"Lutador"}, "É um pokémon de natureza violenta. Ele chicoteia a si mesmo usando seus três rabos para incentivá-lo a batalhar. Quando corre junto com a manada, não para até colidir com algo. Aquele com os chifres mais longos, grossos e marcados é o chefe do rebanho. Se não houver oponente para Tauros lutar, ele irá atacar árvores grossas e derrubá-las para se acalmar."),
            new Pokemon("Magikarp", new String[]{"Água"}, new String[]{"Planta", "Elétrico"}, "Dizem que este é um dos pokémons mais fracos que existem. Seu golpe de respingar água é simplesmente inútil. Tem dificuldade mesmo para nadarm, sendo facilmente levado pela correnteza. Em raras ocasiões, consegue dar grandes saltos. Embora fraco e indefeso, é incrivelmente fértil. Existem em tantas multidões que você logo se cansará de vê-los. Graças ao seu forte controle da vida, a água suja não os incomoda em nada."),
            new Pokemon("Gyarados", new String[]{"Água", "Voador"}, new String[]{"Elétrico", "Pedra"}, "A energia da evolução estimulou fortemente suas células cerebrais, tornando-as muito ferozes. Uma vez que fique irado, não irá se acalmar até ter destruído tudo que estiver pelo seu caminho. Ele tem um instinto agressivo. É conhecido por ter incendiado cidades com seus raios. Existem algumas regiões onde é chamado de 'A Divindade da Destruição'."),
            new Pokemon("Lapras", new String[]{"Água", "Gelo"}, new String[]{"Planta", "Elétrico", "Lutador", "Pedra"}, "Adora atravessar os mares carregando pessoas e pokémons em suas costas. Lapras é capaz de entender a fala humana. Ele é gentil e tem o hábito de cantar graciosamente quando está de bom humor. Sua pele lisa é um pouco fria ao toque. Lapras já estiveram perto da extinção devido à caça ilegal. Seguindo os regulamentos de proteção, agora há uma superabundância deles. Possuem coração gentil e raramente lutam."),
            new Pokemon("Ditto", new String[]{"Normal"}, new String[]{"Lutador"}, "Tem a capacidade de reconstituir sua estrutura celular para se transformar em qualquer coisa que esteja vendo. Se tentar se transformar em algo baseando-se no que tem na memória, acaba errando vários detalhes. Com sua surpreendente capacidade de metamorfose, pode conviver com qualquer coisa. Quando encontrar outro Ditto, ele se moverá mais rápido do que o normal para duplicar exatamente esse oponente."),
            new Pokemon("Eevee", new String[]{"Normal"}, new String[]{"Lutador"}, "Por possuir uma composição genética irregular, Eevee pode evoluir seu corpo para as mais diversificadas formas, dependendo daquilo que o cerca. Por esta razão, consegue adaptar-se facilmente a qualquer tipo de ambiente. Até seu rosto começa a se parecer com o de seu treinador. A questão de por que apenas Eevee tem genes tão instáveis ainda não foi resolvida."),
            new Pokemon("Vaporeon", new String[]{"Água"}, new String[]{"Planta", "Elétrico"}, "Sua composição celular é semelhante às moléculas de água. Quando suas barbatanas começam a vibrar, é sinal que uma chuva está para cair. Ele pode fundir o seu corpo na água, ficando completamente invisível. Misturando-se com a água e apagando todos os sinais de sua presença, ele espera pacientemente por sua presa, os pokémons peixes. Quando está prestes a ser atacado por um inimigo invasor, ele mergulha na água para se esconder."),
            new Pokemon("Jolteon", new String[]{"Elétrico"}, new String[]{"Terra"}, "Ele pode descarregar uma força de dez mil volts. Para tanto, acumula íons negativos na atmosfera. Os pelos de seu corpo são tão espetados quanto uma agulha afiada. Ele arruma sua pelugem com eletricidade. Quando seu pelo fica de pé, é um sinal de que está prestes a soltar uma descarga elétrica. Tome cuidado, pois às vezes um raio cai próximo a ele também. Seus pulmões contêm um órgão que cria eletricidade."),
            new Pokemon("Flareon", new String[]{"Fogo"}, new String[]{"Água", "Terra", "Pedra"}, "As chamas que ele dispara são tão quentes que podem chegar a mais de 1700ºC. Sua temperatura corporal ultrapassa os 800ºC. Ele armazena parte do ar que inala em sua bolsa de chama interna. Quando inspira profundamente, dispara as chamas. Ele afofa sua pelugem com a temperatura do corpo. Quando pega uma presa ou encontra frutas, ele sopra fogo sobre elas até que estejam bem passadas e então as engole."),
            new Pokemon("Porygon", new String[]{"Normal"}, new String[]{"Lutador"}, "Este pokémon artificial foi criado por tecnologias científicas avançadas. No entanto, esta era uma ciência de ponta de 20 anos atrás, então muitas partes dele se tornaram obsoletas. Ele pode converter seu corpo em dados digitais, o que permite mover-se livremente no ciberespaço, sendo uma boa ferramenta para investigar dados suspeitos. Está programado apenas com emoções básicas e não precisa respirar para sobreviver."),
            new Pokemon("Omanyte", new String[]{"Pedra", "Água"}, new String[]{"Planta", "Elétrico", "Lutador", "Terra"}, "Este pokémon nadava pelos mares torcendo os seus 10 tentáculos desde os tempos antigos. Ele usa o ar armazenado em sua concha para emergir e submergir na água. Se atacado por um inimigo, ele se retira para dentro de sua concha dura. Eles são revividos de fósseis por cientistas. Seus fósseis já foram encontrados com mordidas de Archeops, seu predador. Como alguns Omanytes conseguem escapar após serem restaurados ou são soltos na natureza pelas pessoas, essa espécie está se tornando um problema."),
            new Pokemon("Omastar", new String[]{"Pedra", "Água"}, new String[]{"Planta", "Elétrico", "Lutador", "Terra"}, "Acredita-se que este pokémon tenha se extinguido por sua concha espiral ter crescido muito e ficado pesado demais para suportar. Omastar não conseguia se mover muito rápido. Ele agarra suas vítimas com seus tentáculos e as tritura com seus dentes afiados. Seus dentes podem esmagar pedras, mas só consegue atacar a presa que estiver ao alcance de seus tentáculos. Aparentemente, é um ancestral distante de Octillery."),
            new Pokemon("Kabuto", new String[]{"Terra", "Água"}, new String[]{"Planta", "Elétrico", "Lutador", "Terra"}, "Acredita-se que ele tenha habitado praias 300 milhões de anos atrás. Seu corpo é protegido por um duro casco. Ele também possui olhos nesse casco. Ele faz uma muda a cada 3 dias, tornando seus cascos cada vez mais duros. Já foram encontrados alguns exemplares de seu fóssil ainda vivos em alguns lugares. Eles permanecerem escondidos no fundo do oceano todo esse tempo."),
            new Pokemon("Kabutops", new String[]{"Terra", "Água"}, new String[]{"Planta", "Elétrico", "Lutador", "Terra"}, "Kabutops eram agressivos que habitavam mares quentes. Estudos dizem que esse pokémon deixou os mares porque suas presas adaptaram-se a viver em terra firme. Ele ataca suas presas cortando-as com as lâminas de suas garras afiadas. Ele suga os fluidos da presa e descarta o resto, que era consumido por outros pokémons. Na água, ele encolhe os membros para se tornar mais compacto, depois balança o casco para nadar rápido."),
            new Pokemon("Aerodactyl", new String[]{"Pedra", "Voador"}, new String[]{"Água", "Elétrico", "Gelo", "Pedra", "Metálico"}, "O extinto pokémon percorria os céus na era dos dinossauros. Era feroz. Seus dentes se movem como uma serra ao mastigar. Conseguem rasgar até mesmo a pele de um pokémon tipo aço. Cientistas conseguem ressuscitá-lo a partir de um material genético de dinossauro extraído de um velho âmbar. Uma teoria amplamente aceita é que ele foi extinto devido ao impacto de um grande meteoro. Mesmo a tecnologia moderna é incapaz de produzir um espécime perfeitamente restaurado."),
            new Pokemon("Snorlax", new String[]{"Normal"}, new String[]{"Lutador"}, "Se torna muito preguiçoso quando está de estômago cheio. Sua barriga se torna elástica, fazendo pular qualquer coisa que cair sobre ela. Ele não fica satisfeito a menos que coma mais de 400 kg de comida todos os dias. Seu estômago pode digerir qualquer tipo de veneno. Uma comida mofada ou estragada não o afetará. Dorme por um longo período após comer bastante. Quando se propõe a fazer um esforço, ele exibe um poder incrível."),
            new Pokemon("Articuno", new String[]{"Gelo", "Voador"}, new String[]{"Fogo", "Elétrico", "Pedra", "Metálico"}, "Pode criar nevascas congelando a umidade do ar. Dizem que suas asas são feitas de gelo. O bater de suas asas esfria o ar. Como resultado, dizem que quando esse pokémon voa, começa a nevar. Com uma cauda longa e brilhante, sua forma de voar é magnífica. Ele aparece para pessoas perdidas em montanhas congeladas."),
            new Pokemon("Zapdos", new String[]{"Elétrico", "Voador"}, new String[]{"Gelo", "Pedra"}, "É dito que este pokémon vive em nuvens de trovão. Nuvens negras de tempestade é o local perfeito para o seu ninho. Ele consegue controlar livremente os relâmpagos e a eletricidade. Dizem que quando Zapdos esfrega suas penas, um raio cai imediatamente depois. Ganha forças quando é atingido por um raio. Costuma soltar alguns estrondos enquanto voa."),
            new Pokemon("Moltres", new String[]{"Fogo", "Voador"}, new String[]{"Água", "Elétrico", "Pedra"}, "A aparição de Moltres indica a chegada da primavera. Quando bate suas asas flamejantes, elas brilham com um vermelho estonteante. Usa suas asas radiantes envoltas em chamas para iluminar caminhos para aqueles que se perderam nas montanhas. Quando ele é ferido, mergulha seu corpo no magma de um vulcão para queimar e curar o seu corpo. Atletas carregam uma tocha com sua chama em algumas Ligas Pokémon."),
            new Pokemon("Dratini", new String[]{"Dragão"}, new String[]{"Gelo", "Dragão", "Fada"}, "É conhecido como 'pokémon miragem' pois poucos já o viram. Depois de uma luta de 10 horas, um pescador conseguiu fisgar um e confirmar sua existência. Ele troca de pele continuamente e fica cada vez maior. Ele faz isso porque sua energia vital aumenta constantemente, atingindo níveis incontroláveis. Dratini mora perto de corpos de água que fluem rapidamente. O pequeno caroço em sua testa é na verdade um chifre que ainda está aparecendo."),
            new Pokemon("Dragonair", new String[]{"Dragão"}, new String[]{"Gelo", "Dragão", "Fada"}, "Se o seu corpo adquire uma aura, o tempo muda instantaneamente. As jóias cristalinas que possui dão a ele o poder de controlar o clima. Por isso, é venerado pela população agrícola. Diz-se que vive em mares e lagos, mas também é visto voando. Quando envolvido por uma aura, Dragonair tem uma aparência mística. Alguns dizem que se você o vir no início do ano, voando pelo céu e retorcendo o corpo, terá saúde o ano todo."),
            new Pokemon("Dragonite", new String[]{"Dragão"}, new String[]{"Gelo", "Pedra", "Dragão", "Fada"}, "É conhecido como 'A Encarnação do Mar'. Ele constrói sua casa em algum lugar do oceano. O formato de seu corpo permite que consiga voar tranquilamente sobre mares agitados. É um pokémon de bom coração. Se avistar alguém se afogando, irá ajudar. Ele ajuda os navios a encontrar terra firme em tempestades. Dizem que existe uma ilha remota, um paraíso ocupado exclusivamente por Dragonite. Ele é capaz de dar a volta ao mundo em 16 horas."),
            new Pokemon("Mewtwo", new String[]{"Psíquico"}, new String[]{"Inseto", "Fantasma", "Noturno"}, "Um pokémon que foi clonado geneticamente de Mew. Foi criado por um cientista após experimentos de processamento de genes e engenharia de DNA. O poder científico dos humanos não conseguiu dar a ele um coração compassivo. Seu coração é selvagem e seu poder é avassalador. Geralmente ele permanece imóvel para conservar sua energia, de forma que possa liberar seu poder total em batalha."),
            new Pokemon("Mew", new String[]{"Psíquico"}, new String[]{"Inseto", "Fantasma", "Noturno"}, "Se mostra apenas para pessoas de coração puro. Seu DNA contém códigos genéticos de todos os pokémons. Como é capaz de aprender qualquer tipo de golpe, muitos cientistas acreditam que ele é o antepassado de todos os pokémons. Muitos acreditam estar extinto, mas avistamentos dele ainda estão sendo relatados até hoje. Ele é capaz de se tornar invisível à vontade, então evita ser notado quando as pessoas se aproximam.")
    );

    private final String[] keyWords = {
            "tipo",
            "fraqueza",
            "fraco",
            "descricao",
    };

    private final String[] pokeTypes = {
            "Normal",
            "Fogo",
            "Água",
            "Planta",
            "Elétrico",
            "Gelo",
            "Lutador",
            "Veneno",
            "Terra",
            "Voador",
            "Psíquico",
            "Inseto",
            "Pedra",
            "Fantasma",
            "Dragão",
            "Noturno",
            "Metálico",
            "Fada",
    };

    private final String[] messages = {
            "Não entendi, você poderia reformular sua frase?",
    };
    private String question;
    private String[] questionSplitted;

    public void respond(String question) {
        init(question);
        ArrayList<ArrayList<String>> questionKeyWords = detectKeyWords(this.questionSplitted);
        if (questionKeyWords.get(0).size() >= 2) {
            System.out.println("Não pode ser digitado mais de um pokémon por vez");
            return;
        }
        String resposta = generateResponse(questionKeyWords);
        System.out.println(resposta);
    }

    //    Este método inicia o objeto para elaborar a resposta com a pergunta reinicializando a pergunta
    private void init(String question) {
        this.question = question;
//        Formata a pergunta tirando pontuações e deixando em caixa baixa
        this.questionSplitted = formatText(question).split("\\W+");
    }

    private ArrayList<ArrayList<String>> detectKeyWords(String[] text) {
        ArrayList<ArrayList<String>> keys = new ArrayList<>();
        keys.add(new ArrayList<>());
        keys.add(new ArrayList<>());
        keys.add(new ArrayList<>());
        Pokemon pokemon;
        String pokeName;

        for (int i = 0; i < text.length; i++) {
            for (int j = 0; j < pokemons.size(); j++) {
                pokemon = pokemons.get(j);
                pokeName = pokemon.getName();

                if (!keys.get(0).contains(pokeName)) {
                    if (formatText(pokeName).equals(formatText(text[i]))) {
                        keys.get(0).add(pokeName);
                    }
                }

//                Faz a verificação e adiciona os tipos de pokémons presentes na pergunta do usuário

//                Esse for percorre todo o array dos tipos de pokémons
                for (int k = 0; k < pokeTypes.length; k++) {
//                    Verifica se o arraylist keys ja possuí o tipo que está sendo verificado agora, para evitar repetições
                    if (!keys.get(1).contains(pokeTypes[k])) {
//                        Verifica se o tipo de pokémon é igual a palavra atual da pergunta do usuário
                        if (formatText(pokeTypes[k]).equals(formatText(text[i]))) {
//                            Adiciona o tipo para o arraylist keys
                            keys.get(1).add(pokeTypes[k]);
                        }
                    }
                }

                ////////////////////////////////////////////////////////////////////////////////////
            }

//            Esse for faz a verificação de palavras chaves como, 'fraqueza' no texto(pergunta) percorrido

//            Percorre todo os array de palavras chaves
            for (int j = 0; j < this.keyWords.length; j++) {
                /*
                Verficia se a palavra chave já esta no array chave(keys), e caso não esteja,
                verifica se pertence ás palavras chaves e a adiciona ao array chave(keys)
                */
                if (!keys.get(2).contains(this.keyWords[j])) {
                    if (formatText(text[i]).equals(keyWords[j]) || formatText(text[i]).equals(toPlural(keyWords[j]))) {
                        keys.get(2).add(keyWords[j]);
                    }
                }
            }
        }
        return keys;
    }

    private String generateResponse(ArrayList<ArrayList<String>> questionKeyWords) {
        ArrayList<String> pokeNamesKey = questionKeyWords.get(0);
        ArrayList<String> pokeTypesKey = questionKeyWords.get(1);
        ArrayList<String> utilKey = questionKeyWords.get(2);
        String response = "";

        //Verifica se há alguma palavra chave
        if (pokeNamesKey.isEmpty() && pokeTypesKey.isEmpty() && utilKey.isEmpty()) {
            //Retorna uma mensagem de erro
            response = messages[0];
            return response;
        }

        if (!pokeNamesKey.isEmpty()) {
            for (int i = 0; i < pokeNamesKey.size(); i++) {
                Pokemon pokemon = pokemons.get(getPokemonIndex(pokeNamesKey.get(i)));
                if (!response.isEmpty()) {
                    response += "\n\n";
                }
                response += pokemon.getName() + ":";
                if (!utilKey.isEmpty()) {
                    for (int j = 0; j < utilKey.size(); j++) {
                        if (utilKey.get(j).equals("descricao")) {
                            response = getMessageOfDescription(response, pokemon);
                        }

                        if (utilKey.get(j).equals("fraqueza")) {
                            response = getMessageOfWeakeness(response, pokemon);
                        }

                        if (utilKey.get(j).equals("tipo")) {
                            response = getMessageOfType(response, pokemon);
                        }
                    }
                    return response;
                }
            }

        }

        if (!pokeTypesKey.isEmpty()) {
            if (!utilKey.isEmpty()) {
                for (int j = 0; j < utilKey.size(); j++) {
                    if (utilKey.get(j).equals("fraqueza") || utilKey.get(j).equals("fraco")) {
                        ArrayList<Pokemon> compatibles = getPoke(pokeTypesKey, "weakness");
                        response = generateMessage(response, compatibles);
                        return response;
                    }
                    if (utilKey.get(j).equals("tipo")) {
                        ArrayList<Pokemon> compatibles = getPoke(pokeTypesKey, "type");
                        response = generateMessage(response, compatibles);
                        return response;
                    }
                }
            }
        }
        response = messages[0];
        return response;
    }

    private String generateMessage(String response, ArrayList<Pokemon> compatibles) {
        if (!response.isEmpty()) {
            response += "\n";
        }
        System.out.println("Os pokémons que se enquadram nos requisitos, são:");
        for (int i = 0; i < compatibles.size(); i++) {
            response += compatibles.get(i).getName();
            if (i < compatibles.size() - 1) {
                response += "\n";
            }
        }
        return response;
    }

    private ArrayList<Pokemon> getPoke(ArrayList<String> keys, String characteristic) {
        ArrayList<Pokemon> targetPokemons = new ArrayList<>();

        for (int i = 0; i < pokemons.size(); i++) {
            Pokemon pokemon = pokemons.get(i);
            List<String> key;
            switch (characteristic) {
                case "type":
                    key = Arrays.stream(pokemon.getType()).toList();
                    break;
                case "weakness":
                    key = Arrays.stream(pokemon.getWeaknesses()).toList();
                    break;
                default:
                    key = Arrays.stream(pokemon.getType()).toList();
                    break;
            }

            boolean compatible = false;
            for (int j = 0; j < keys.size(); j++) {

                if (key.contains(keys.get(j))) {
                    compatible = true;
                    continue;
                }
                compatible = false;
                break;
            }
            if (compatible) {
                targetPokemons.add(pokemon);
            }
        }

        return targetPokemons;
    }

    private String getMessageOfType(String response, Pokemon pokemon) {
        if (!response.isEmpty()) {
            response += "\n";
        }
        response += "Este é um pokémon de tipo ";
        for (int i = 0; i < pokemon.getType().length; i++) {
            response += pokemon.getType()[i];
            if (i + 1 == pokemon.getType().length) {
                break;
            }
            response += "/";
        }
        return response;
    }

    private String getMessageOfWeakeness(String response, Pokemon pokemon) {
        if (!response.isEmpty()) {
            response += "\n";
        }
        response += "É vulnerável a pokémons do tipo ";
        for (int i = 0; i < pokemon.getWeaknesses().length; i++) {
            response += pokemon.getWeaknesses()[i];
            if (i + 1 == pokemon.getWeaknesses().length) {
                break;
            }
            response += "/";
        }
        return response;
    }

    private String getMessageOfDescription(String response, Pokemon pokemon) {
        if (!response.isEmpty()) {
            response += "\n";
        }
        response += pokemon.getDescription();

        return response;
    }

    private String toPlural(String word) {
        char plural = 's';

        return word + plural;
    }

    private int getPokemonIndex(String name) {
        for (int i = 0; i < pokemons.size(); i++) {
            if (formatText(name).equals(formatText(pokemons.get(i).getName()))) {
                return i;
            }
        }
        return 0;
    }

    private String formatText(String string) {
        String normalized = Normalizer.normalize(string, Normalizer.Form.NFD);
        String withoutAccents = normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        String withoutPunctuation = withoutAccents.replaceAll("\\p{Punct}", "");

        return withoutPunctuation.toLowerCase();
    }

    public String[] getMessages() {
        return messages;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public String[] getKeyWords() {
        return keyWords;
    }

    public String[] getPokeTypes() {
        return pokeTypes;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getQuestionSplitted() {
        return questionSplitted;
    }

    public void setQuestionSplitted(String[] questionSplitted) {
        this.questionSplitted = questionSplitted;
    }
}
