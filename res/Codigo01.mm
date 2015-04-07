////DECLARACIÓN DE FUNCIONES (SINTAXIS C)

void unaFuncion();

int otraFuncion();

char otraFuncion2();

char otraFuncion3();

//DECLARACIÓN DE FUNCIONES (SINTAXIS Objective-C))

-(float) *unaFuncion;

-(void) unaFuncion : (int) argumento;

-(NSString) unaFuncion : (int) argumento : (int) argumento : (int) argumento;

int main(int argc, const char argv[]) {

    //DECLARACIÓN DE VARIABLES

    int algo, x, y, u;
    char otroAlgo;
    BOOL flag;
    float variableFlotante;
    NSString unString;

    //DECLARACIÓN CON ASIGNACIONES

    int algoConValor = (5 * 4) / 2;
    char otroAlgoConValor = algoConValor;
    BOOL flag = a && a;
    BOOL flag2 = YES;
    NSString otroString = algo;
    NSString otroString = "CADENA DE CARACTERES";
    NSString otroString = @"CADENA DE CARACTERES";
    
    //LLAMADOS A FUNCIONES
    
    funcion1();
    funcion2(a);
    funcion3(1 + 2);
    funcion4(1 + 5 * 8);
    funcion5(1 + (5 * 8));
    funcion6((1 + 5) * 8);
    funcion7(a && b);
    funcion8(1 + 4, b);
    funcion8(a, 1 + 2);

    //EXPRESIONES ARITMETICAS
    //1 + 2
    //1 + (2 + 3)
    //(1 + 2 )+ 3
    //(1 - 2) + (2 + 3)
    //1 + 3 * 5

    //EXPRESIONES LÓGICAS

    //a && YES
    //A || B
    //C ^ D
    //E && (R || C)

    //EXPRESIONES RELACIONALES
    //(5 - 5 - 35 - 2 + 6) < 6


    for (;;) {
    }
    for (int x;;) {
    }
    for (int x, y;;) {
    }
    for (; a && b;) {
    }
    for (; a < 4;) {
    }
    for (; a && b || c;) {
    }
    for (; a && (b || c);) {
    }
    for (; a && b || c;) {
    }
    for (; a && a + 2 < g || c;) {
    }
    for (;; nada()) {
    }

    if (TRUE) {
        int x;
    }

    if (a && b) {
    }
    if (a || b) {
    }
    if (a ^ b) {
    }
    if (a == b) {
    }
    if (a != b) {
    }
    if (a < b) {
    }
    if (a > b) {
    }
    if (a <= b) {
    }
    if (a >= b) {
    }

}