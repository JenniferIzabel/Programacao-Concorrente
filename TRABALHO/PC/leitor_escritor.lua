-- Mutex -> lock e  unlock
-- ThreadSafeQueue -> pop e push
require 'Mutex'
require 'ThreadSafeQueue'
local mutex_area 
local mutex_conta 
local conta_leitores = 0
local queue 

function leitor() 
    while (1) do
        mutex_conta.lock() -- requer acesso exclusivo ao contador
        conta_leitores = conta_leitores + 1 -- incrementa contador de leitores
        if conta_leitores == 1 then -- sou o primeiro leitor a entrar?
            mutex_area.lock() --   requer acesso à área
        end
        mutex_conta.unlock() --   libera o contador

       --  lê dados da área compartilhada
        
        mutex_conta.lock() --  requer acesso exclusivo ao contador
        conta_leitores = conta_leitores - 1 --   decrementa contador de leitores
        if conta_leitores == 0 then --  sou o último leitor a sair?
            mutex_area.unlock() --  libera o acesso à área
        end
        mutex_conta.unlock()--   libera o contador
        -- ...
    end
end

function escritor()
    while (1) do
        mutex_area.lock() -- requer acesso exclusivo à área
        -- escreve dados na área compartilhada
        mutex_area.unlock() -- libera o acesso à área
        -- ...
    end
end
