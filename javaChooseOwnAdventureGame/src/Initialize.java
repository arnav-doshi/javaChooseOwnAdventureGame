import java.util.*;

public class Initialize
{
    private ArrayList<Entity> enemies;// in case we want more than one;

    /**
     * Create a new Initialize object.
     */
    public Initialize()
    {
        enemies = new ArrayList<Entity>();
        Queue<String> entityNames = new LinkedList<String>();
        entityNames.add("mysterious creature");
        entityNames.add("mysterious creature v2");
        entityNames.add("mysterious creature v3");
        entityNames.add("mysterious creature v4");
        entityNames.add("mysterious creature v5");
        Queue<String> enemySprites = new LinkedList<String>();
        enemySprites.add("         .            )        )\r\n" +
            "                  (  (|              .\r\n" +
            "              )   )\\/ ( ( (\r\n" +
            "      *  (   ((  /     ))\\))  (  )    )\r\n" +
            "    (     \\   )\\(          |  ))( )  (|\r\n" +
            "    >)     ))/   |          )/  \\((  ) \\\r\n" +
            "    (     (      .        -.     V )/   )(    (\r\n" +
            "     \\   /     .   \\            .       \\))   ))\r\n" +
            "       )(      (  | |   )            .    (  /\r\n" +
            "      )(    ,'))     \\ /          \\( `.    )\r\n" +
            "      (\\>  ,'/__      ))            __`.  /\r\n" +
            "     ( \\   | /  ___   ( \\/     ___   \\ | ( (\r\n" +
            "      \\.)  |/  /   \\__      __/   \\   \\|  ))\r\n" +
            "     .  \\. |>  \\      | __ |      /   <|  /\r\n" +
            "          )/    \\____/ :..: \\____/     \\ <\r\n" +
            "   )   \\ (|__  .      / ;: \\          __| )  (\r\n" +
            "  ((    )\\)  ~--_     --  --      _--~    /  ))\r\n" +
            "   \\    (    |  ||               ||  |   (  /\r\n" +
            "         \\.  |  ||_             _||  |  /\r\n" +
            "           > :  |  ~V+-I_I_I-+V~  |  : (.\r\n" +
            "          (  \\:  T\\   _     _   /T  : ./\r\n" +
            "           \\  :    T^T T-+-T T^T    ;<\r\n" +
            "            \\..`_       -+-       _'  )\r\n" +
            "  )            . `--=.._____..=--'. ./         (\r\n" +
            " ((     ) (          )             (     ) (   )> \r\n" +
            "  > \\/^/) )) (   ( /(.      ))     ))._/(__))./ (_.\r\n" +
            " (  _../ ( \\))    )   \\ (  / \\.  ./ ||  ..__:|  _. \\\r\n" +
            " |  \\__.  ) |   (/  /: :)) |   \\/   |(  <.._  )|  ) )\r\n" +
            "))  _./   |  )  ))  __  <  | :(     :))   .//( :  : |\r\n" +
            "(: <     ):  --:   ^  \\  )(   )\\/:   /   /_/ ) :._) :\r\n" +
            " \\..)   (_..  ..  :    :  : .(   \\..:..    ./__.  ./\r\n" +
            "            ^    ^      \\^ ^           ^\\/^     ^");
        enemySprites.add("          ^\\\r\n" +
            "           )\\_\r\n" +
            "           |':\";=,-`;,._\r\n" +
            "            \\\\         \"._\r\n" +
            " ^\\         //            \";=,-._      ^\\\r\n" +
            "  )\\-._    ||         ;\"._      \"=.     )\\\r\n" +
            "  //  \";=,-.\\      ^\\    \".       \"`~,_.;/._\r\n" +
            " ||         \"=.     )\\    \";-._,`~;._      \".\r\n" +
            " \\\\           \"`~,_.;/_                     \";,\r\n" +
            "  ||                  \".      ;\"-._          \"=._\r\n" +
            "  ||                   \";,        \"-,           \";-,_\r\n" +
            "  //    ;\"-._            \"=.        \";:=.-,_         \";-._           ^\\\r\n" +
            " //         \"-,            \";-,_           \":=;-,_.-\";._ \";-._        )\\\r\n" +
            " \\\\           \";:=.-,_          \";-._    ^\\            \";=._  \"`~,;,_.'/\r\n" +
            "  \\\\                 \":=;-,_.-\";._  \";=\"._)\\               \";,-`~\";=-.\\\\\r\n" +
            "   \\\\    \"=.,_.;=._              \";=._   \";/                          //\r\n" +
            "    ||            \";:=,-'\"=._             \\\\      _..-======-.._     //\r\n" +
            "    ||                      \"`~.-=;\",_.\"-. \\\\   .-              -.  //\r\n" +
            "    \\\\                                  _,.-\\\\\"/.=._          _.=.\\ ||\r\n" +
            "     \\\\  ;\"~`._                      _.;\"     /     =-.    .-=     \\//\r\n" +
            "      \\\\      \";=,-`~._           _.\"        |   ,\"=\"'.\\  /,\"=\"'.   |\".,\r\n" +
            "       \\\\              \";=-.__,.-=\"\":.        |  '.--.'|!!|'.--.'  |   \",`\r\n" +
            "        ||                _.\"          _.,\"-=, '.      )!!(      .'      ;`.\r\n" +
            "        ||           _.\"=:\".         _.'-.\"-=\". \".    /-!!-\\    .\"       \";.\r\n" +
            "        \\\\    _.--==:;\".    \".      .-\":_:'\" \". |'.   \\U::U/   .'|       \"-_\r\n" +
            "        _\\\\=:\"=\".       \".         -\"_.-= `~;\", \\ /\\_.-====-._/\\ /        :,\r\n" +
            "     .'\".'=\\,.   \".                .'.'       \", ||  \\/\\/\\/\\/  ||         ,\"\r\n" +
            "   .'         \".                   \".'            \\\\/\\/\\/\\/\\/\\//           `,\r\n" +
            "  .'                              \".'            ;.\\.=-.__.-=./           .\"\r\n" +
            " .'                              ;.\"            ,_: '-......-'\";           ;\r\n" +
            ".'                               ;.\"           ,-\"            :.          ;,\r\n" +
            "/.            ;.                 ;.\"          ,-=             .\"_          )\r\n" +
            ".\\             \\                 ;.\"          ,\"               ;.        _.\"\r\n" +
            "\".              |                ;.\"          ,\"             ,;         ,-;\r\n" +
            "\";              |                ,;`          ,\"       ,_;  ,\"         ~,\"\r\n" +
            "\\,\"             |                .,\"          ,\"      _.;'-=/          ;\r\n" +
            " \"_-            |                .,\"          ,-:,.-=\" ,-=:\"         .\"\r\n" +
            " ,-:           /             _,.-=\";          ;,      /_)\\        _.=.\r\n" +
            " ,;           |           _.-\"     ;,         \".       _ /~\";.:;=\"',;\r\n" +
            " ,;           |=\".-_,:;'-,\"        ;.         ;,      ( / // // // /\r\n" +
            "  \\           \\|      ,;.          \",         '.       \\_// // // /\r\n" +
            "  |           \\         \".         /          ,;       ( / // /\\_/\r\n" +
            "   |          ,;.         \\       |;,`~ ;,'\"-.L'        \\_/\\_/\r\n" +
            "  ,\"             \". ,\":.`~.\\      .`.,' ;=.';. \".\r\n" +
            "  ;      -.=,\":.`~.\\\\ \\\\ \\\\ \\      \"., ; = - `~\\ \\\r\n" +
            "  `.==--._ \\\\ \\\\ \\\\ \\\".`./;./       \". \\\\ \\\\ \\\\ \\ \\\r\n" +
            "          \\,\\\\ \\\\ \\\\ \\(_/(_/         \". \\\\ \\\\ \\\\ \\/\r\n" +
            "          (_/\"./`,/;./                `,.\\\\ \\\\ \\\\,\\\r\n" +
            "            (_/(_/(_/                  '., \\ \\\\ \\`.'       \r\n" +
            "                                           `.\" `.'");
        enemySprites.add("                                          ,--,  ,.-.\r\n" +
            "               ,                   \\,       '-,-`,'-.' | ._\r\n" +
            "              /|           \\    ,   |\\         }  )/  / `-,',\r\n" +
            "              [ ,          |\\  /|   | |        /  \\|  |/`  ,`\r\n" +
            "              | |       ,.`  `,` `, | |  _,...(   (      .',\r\n" +
            "              \\  \\  __ ,-` `  ,  , `/ |,'      Y     (   /_L\\\r\n" +
            "               \\  \\_\\,``,   ` , ,  /  |         )         _,/\r\n" +
            "                \\  '  `  ,_ _`_,-,<._.<        /         /\r\n" +
            "                 ', `>.,`  `  `   ,., |_      |         /\r\n" +
            "                   \\/`  `,   `   ,`  | /__,.-`    _,   `\\\r\n" +
            "               -,-..\\  _  \\  `  /  ,  / `._) _,-\\`       \\\r\n" +
            "                \\_,,.) /\\    ` /  / ) (-,, ``    ,        |\r\n" +
            "               ,` )  | \\_\\       '-`  |  `(               \\\r\n" +
            "              /  /```(   , --, ,' \\   |`<`    ,            |\r\n" +
            "             /  /_,--`\\   <\\  V /> ,` )<_/)  | \\      _____)\r\n" +
            "       ,-, ,`   `   (_,\\ \\    |   /) / __/  /   `----`\r\n" +
            "      (-, \\           ) \\ ('_.-._)/ /,`    /\r\n" +
            "      | /  `          `/ \\\\ V   V, /`     /\r\n" +
            "   ,--\\(        ,     <_/`\\\\     ||      /\r\n" +
            "  (   ,``-     \\/|         \\-A.A-`|     /\r\n" +
            " ,>,_ )_,..(    )\\          -,,_-`  _--`\r\n" +
            "(_ \\|`   _,/_  /  \\_            ,--`\r\n" +
            " \\( `   <.,../`     `-.._   _,-`");
        enemySprites.add("                                       .\"\"--..__\r\n" +
            "                     _                     []       ``-.._\r\n" +
            "                  .'` `'.                  ||__           `-._\r\n" +
            "                 /    ,-.\\                 ||_ ```---..__     `-.\r\n" +
            "                /    /:::\\\\               /|//}          ``--._  `.\r\n" +
            "                |    |:::||              |////}                `-. \\\r\n" +
            "                |    |:::||             //'///                    `.\\\r\n" +
            "                |    |:::||            //  ||'                      `|\r\n" +
            "        jgs     /    |:::|/        _,-//\\  ||\r\n" +
            "        hh     /`    |:::|`-,__,-'`  |/  \\ ||\r\n" +
            "             /`  |   |'' ||           \\   |||\r\n" +
            "           /`    \\   |   ||            |  /||\r\n" +
            "         |`       |  |   |)            \\ | ||\r\n" +
            "        |          \\ |   /      ,.__    \\| ||\r\n" +
            "        /           `         /`    `\\   | ||\r\n" +
            "       |                     /        \\  / ||\r\n" +
            "       |                     |        | /  ||\r\n" +
            "       /         /           |        `(   ||\r\n" +
            "      /          .           /          )  ||\r\n" +
            "     |            \\          |     ________||\r\n" +
            "    /             |          /     `-------.|\r\n" +
            "   |\\            /          |              ||\r\n" +
            "   \\/`-._       |           /              ||\r\n" +
            "    //   `.    /`           |              ||\r\n" +
            "   //`.    `. |             \\              ||\r\n" +
            "  ///\\ `-._  )/             |              ||\r\n" +
            " //// )   .(/               |              ||\r\n" +
            " ||||   ,'` )               /              //\r\n" +
            " ||||  /                    /             || \r\n" +
            " `\\\\` /`                    |             // \r\n" +
            "     |`                     \\            ||  \r\n" +
            "    /                        |           //  \r\n" +
            "  /`                          \\         //   \r\n" +
            "/`                            |        ||    \r\n" +
            "`-.___,-.      .-.        ___,'        (/    \r\n" +
            "         `---'`   `'----'`");
        enemySprites.add("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
            "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWMMMMMMMMWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
            "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNXKKWWMMMMMMWKXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
            "MMMMMMMMMMMMMMMMMMMMMMMMMMWXNMMMMMMMMMMMMMMMMMMNkdxONMWMMMMMMXokMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
            "MMMMMMMMNXWMMMMMMMMMMMMMMMMK0NMMMMMMMMMMMWKXWW0ccKMMMMMMMMMMWx,xMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
            "MMMMMMMM0kNMMMMMMMMMMMMMMMMXx0MMMMMMMMMWKolOKd,c0NWWMMMWMMMW0;'kMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
            "MMMMMMMNooNMMMMMMMMMMMMMMMMKlkMMMMMNNW0d;',:;';old0XNXNWMMW0:.,OMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
            "MMMMMMM0;cXMMMMMMMMMMMMMMMMO:xWMMMKdkx;..,,..''..,;ccoKWWWO;..;0MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
            "MMMMMMMk.'OWMMMMMMMMMMMMMMWx,xNNN0:,;'...,,..''.....':odkd,.'.cXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
            "MMMMMMMx..lXMMMMMMMMMMMMMM0:,Ox;:,';..'..''''........''..'''..lKXNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
            "MMMMMMMO,.'oXMMMMMMMMMMMMNl.;:'...';'......'.....,;;;,'.,;'...';okOOKXNNWMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
            "MMMMMMMNl.',lKMMMMMMMMMMWx'''..............'..,,'',,'.':;'......',,,;cd0NMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
            "MMMMMMMM0;.'';xNMMWNXK00d,',...................','.'':c;............':xOO0KKNWMMMMMMMMMMMMMMMMMMMMMM\n" +
            "MMMMMMMMWO,.,;;ckX0o:,'..',.......'..............,::::,.................''',:d0NMMMMMMMMMMMMMMMMMMMM\n" +
            "MMMMMMMMMWO;.':;;:;'....';'......','.'''.....',;clc;'................,;;;'';lOXWMMMMMMMMMMMMMMMMMMMM\n" +
            "MMMMMMMMMMMXo'.';c;.....''.......',..,;',,'';cc::'...................,:loolllxkOXMMMMMMMMMMMMMMMMMMM\n" +
            "MMMMMMMMMWMW0;...,:;;,'...........,'';::,',;cc,......................',,;:::lx0KNWMMMMMMMMMMMMMMMMMM\n" +
            "MMMMMMMMWWW0c......',:c:'......';'.':::;.'',,'.............'.................':d0WMMMMMMMMMMMMMMMMMM\n" +
            "MMMMMMMMWXxc'.........,;;'......;;',:;:;'.....................................,cxKNMMMMMMMMMMMMMMMMM\n" +
            "MMMMMMMMWXOl'...................''.',;:;'.....................'''......''''....,oONMMMMMMMMMMMMMMMMM\n" +
            "MMMMMMMMWWO;....................''.......'.....'................................;oKWMMMMMMMMMMMMMMMM\n" +
            "MMMMMMMMXko,..................................'............''''''''.','.........:kXWMMMMMMMMMMMMMMMM\n" +
            "MMMMMMMWXKO:.....................,;,''''...............',;:c::cccc:clc;,'''.....':kNMMMMMMMMMMMMMWMM\n" +
            "MMMMMMWWWWKd'....................'::;,;,....''.........',;cccllc:::cc;;:c:;'......'xNMMMMMMMMMMMMXXM\n" +
            "MMMMMMXOXMK;.....................,::;:c;....'..........',,,,;,,,,,;colllolc:,....''oNMMMMMMWMWXNXx0M\n" +
            "MMMMWNKokNo......................;ccllc;...............','''''''';coxkxoxkdl;''....,kNMMMMMMWOxXdcKM\n" +
            "MMMM0kOclXl...................'',::cccl:'..............'''.......,:dkOkxxdol:;,'....;kNMWXOOxcxd.cNM\n" +
            "MMMWd,l,'xc....'',,'''......cc;:cclllolc:'.............',;'......,codxkOddxdolc;.....'col;',',:..xWM\n" +
            "MMMWo.........';;;;;;;;,'..;Od:::ccccclo:..............,cc,......':oxxxkkxxdoool;...........'...cXMM\n" +
            "MMMNl........',::;:llcc:,,:o0o;:clddoddc;'.............;lo;.......,llloxkkxdoool:,'........,'...dWMM\n" +
            "MMWKl........';:clooool:;d00N0o:;cddlcc,,,'...,,.......cdo,........;;:codddoocc:::,.......,,...'xWMM\n" +
            "WNNx'.......';;cldkdooccxNNNWWNx,;ll;;,.,;,..,,'.......:ol,........',,;clllc:;,;c:'......',....'oXMM\n" +
            "Nkkk,......'';cldxddlcdKWWWWMMMXkc:;...';::;'........';ldo,...........';::;,',;;c:,............'kWMM\n" +
            "Wd,;......',;:codolld0NMMMMWMMMNk;.....';:,'.....'',:lool:'............,,,'',cl:cc,'...........oNMMM\n" +
            "Md.......,;;;;::::;:kNWMMMMMMW0:..............',;::::;,'................',;colooc:;;'.........'OMMMM\n" +
            "M0' ....';;:;';:cc:,dNMMMMMMNx,.............';:;,'''.................',;:lodooddolc;'.........lKWMMM\n" +
            "MNo.....,;;;;,;;cl:,xWMMMMMWk,...........'';cc,'........,cl:,'....',;:llloddldxol:;;'........c0KWMMM\n" +
            "WW0, ...';:c::clodl:oKMMMMNx,..........'',:lc,''.....'cxKWWXd,...,:cclddlcdkoool:;,'........'oONMMMM\n" +
            "MXk;....',;ccclokkdc:dNMMMK:..........''';c:;,'''',:oONMMMMMKl'',:cloollc:lkdlc::;,'........;kNMMMMM\n" +
            "MXc.....'';:cccoxxc;:,oNMM0;.........''',;;,,'',,:ldOO0NWMMMWd;:clllddoc:::ol:;;;,'........c0WMMMMMM\n" +
            "MWd.....,;:clccloc,:l;,lKMO,....''''''',,,,,,,,,,,,;;;:cdXMNk:;looldxxoccccc;,,;,'.......;xXMMMMMMMM\n" +
            "MWx' ...':clllcll;,,,...oNO,.''''''',,,,,,,,,,,,,,;;;;;:dKOc,;:loodkxlccc::;,'''''......:0WWMMMMMMMM\n" +
            "MXl.....',:coolc:,'.....'ox:'''',,,,,,;,,,,,,,;;::;:::lkXO:'',cllodddl:::,',,..........;xNWMMWMMMMMM\n" +
            "MW0, ....,;:cll:,'....'...''...',,,,,;;,,,,,;;,;:;,'..,cc;'',:::cllllc:;;;,'.........;xXWMMMMMMMMMMM\n" +
            "MMWx......,:ccc;'..,::,'.......'',,,,,'''',,'..'........',;,''';cllc::;,,,'.........:okNMMMMMMMMMMMM\n" +
            "MMM0,.....':clc;..c0WNKo'......';cxxl,',,'................;:'..':lc::;,'''........':ccdXMMMMMMMMMMMM\n" +
            "MMMNd.....',:cc;.:KMMMMXxl;... .;dNXl;;,'...........':lllo0N0:..:l:,,,'...........'';lONMMMMMMMMMMMM\n" +
            "MMWMNo.....',;;,,xWMMMMMMWNd,...'l0x;;:,......,lxOOk0WMMMWWMM0;.::,'''...........',:lokNMMMMMMMMMMMM\n" +
            "MMMMMO' ....',,,:OMMMMMMMMMWk'...;ol::;....,cxXMMMMMMMMMMMMMMWd,:;'.............':cco0XNMMMMMMMMMMMM\n" +
            "MMMMMX:......''.:0MMMMMMMMMWXx;..';:c:...,oONMMMMMMMMMMMMMMMWXxc:,'............,:c:cOWMMMMMMMMMMMMMM\n" +
            "MMMMMWo.........lXMMMMMMMMMMMMk'..;cc,..:dOXMMMMMMMMMMMMMMNOdl:;,'...........';:::ckWMMMMMMMMMMMMMMM\n" +
            "MMMMMMK:.......'cOWMMMMMMMMMMW0:..,cc,.cxxKWMMMMMMMMMMMMMMNo'''''...........,;:;;:oKMMMMMMMMMMMMMMMM\n" +
            "MMMMMMMXl........oNMMMMMMMMMWKo;..,ll;:dddKMMMMMMMMMMMMMWN0:...............',;;,;:dXMMMMMMMMMMMMMMMM\n" +
            "MMMMMMMMNd.......oKKKXWWMMWWKo:c'.cddoodddKMMMMMMMMMMMMWk;'..........':,...',:;';:dNMMMMMMMMMMMMMMMM\n" +
            "MMMMMMMMMWk,.....,llldxkkkkxoloc,:oddxddxdkNMMMMMMMMMMWKc..........:xK0;.''.,:;';:oXMMMMMMMMMMMMMMMM\n" +
            "MMMMMMMWWNXO:......,cllooooooddllxddxxddxdoOWMMMMMMMNKOc.........cONMNo'..'';:,';:lOWMMMMMMMMMMMMMMM\n" +
            "MMMMMWXOkkxxxl'.....;clodddddxxxxkkxdddxxxokNMMMWWMWx''.......,o0WMW0c....'';;'';ccdXMMMMMMMMMMMMMMM\n" +
            "MMMMWKxoodddool;....';:odxxxdxkO0000KKXXNNNWWMNOOOxl'......,lONWMMNk;..'..'';c;',:co0MMMMMMMMMMMMMMM\n" +
            "MMMMNkooooolooodl,....;ldddxO0XWMWMMMMMMMMMWN0l..''.....:oOXWMMWN0l'.'''...,;c:,,;:cdKWMMMMMMMMMMMMM\n" +
            "MMMMW0dodoloddooooc,...,:lkXWMMMMMMMWXKOxxdl:,',;:ccldkKWMMMMMNx:,';:;'....,:c:,,,:lldKWMMMMMMMMMMMM\n" +
            "MMMMWWNNXxlodkO0Okkkdc,'.;dKNWWWMMMMWNXK0000KKXXNWMMMMMMMMMMMKc.';ccc,....',:cl:,,;:cclkXWMMMMMMMMMM\n" +
            "MMMMMMMMWKKXNWMMMWWMMWXOdlclxk0NMMMMMMMMMMMMMMMMMMMMMMMMMMMM0:..,;::,.......';:;''''',:cokKWMMMMMMMM\n" +
            "MMMMMMMMMMMMMMMMMMMMMMMMMMMWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0:....',,'........';;'......';:cONMMMMMMM\n" +
            "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXc......',.........','........lo:oXWMMMMMM\n" +
            "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM0;....':,..........'l:........,oodXMMMMMMM\n" +
            "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMk.....lx:...........do.........:x0WMMMMMMM\n" +
            "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMK;...,o:............;;.........;kNMMMMMMMM\n" +
            "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWd...''...';,.........ckOOko:''c0WMMMMMMMM\n" +
            "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXl...'cdkKNXOxo:'...;0MMMMMWKkONMMMMMMMMM\n" +
            "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNd;lKWMMMMMMMWWKo',OWMMMMMMMMMMMMMMMMMMM\n" +
            "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNNMMMMMMMMMWWMNO0WMMMMMMMMMMMMMMMMMMMM\n" +
            "");

        for (int i = 0; i < 5; i++)
        {
            //System.out.println(enemySprites.peek());
            enemies.add(new Enemy(entityNames.poll(), enemySprites.poll()));
        }
    }

    /**
     * holds all possible enemies
     * @return field enemies
     */
    public ArrayList<Entity> getEnemies()
    {
        return enemies;
    }

}
