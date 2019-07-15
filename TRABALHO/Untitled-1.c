// VERSÃO SÓ COM 1 LEITOR

sem_t mutex_area ; // controla o acesso à área (inicia em 1)

leitor () {
    while (1) {
        sem_down (&mutex_area) ; // requer acesso exclusivo à área
        //... // lê dados da área compartilhada
        sem_up (&mutex_area) ; // libera o acesso à área
        //...
    }
}
escritor () {
    while (1) {
        sem_down (&mutex_area) ; // requer acesso exclusivo à área
        //... // escreve dados na área compartilhada
        sem_up (&mutex_area) ; // libera o acesso à área
        //...
    }
}













//VERSÃO MAIS DE UM LEITOR

sem_t mutex_area ; // controla o acesso à área (inicia em 1)
int conta_leitores = 0 ; // número de leitores acessando a área
sem_t mutex_conta ; // controla o acesso ao contador (inicia em 1)

leitor () {
    while (1) {
        sem_down (&mutex_conta) ; // requer acesso exclusivo ao contador
        conta_leitores++ ; // incrementa contador de leitores
        if (conta_leitores == 1) // sou o primeiro leitor a entrar?
            sem_down (&mutex_area) ; // requer acesso à área
        sem_up (&mutex_conta) ; // libera o contador

       // ... // lê dados da área compartilhada
        
        sem_down (&mutex_conta) ; // requer acesso exclusivo ao contador
        conta_leitores-- ; // decrementa contador de leitores
        if (conta_leitores == 0) // sou o último leitor a sair?
            sem_up (&mutex_area) ; // libera o acesso à área
        sem_up (&mutex_conta) ; // libera o contador
        //...
    }
}
escritor () {
    while (1) {
        sem_down(&mutex_area) ; // requer acesso exclusivo à área
        //... // escreve dados na área compartilhada
        sem_up(&mutex_area) ; // libera o acesso à área
        //...
    }
}