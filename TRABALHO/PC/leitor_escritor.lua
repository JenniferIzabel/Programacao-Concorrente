require "class"
require "Mutex"
require "ThreadSafeQueue"


local mutex_area=Mutex{} -- controla o acesso à área (inicia em 1)
local conta_leitores = 0 -- número de leitores acessando a área
local mutex_conta=Mutex{} -- controla o acesso ao contador (inicia em 1)









------------ to be able to use classes -----------------

Account = class(function(acc,balance)
    acc.balance = balance
 end)

function Account:withdraw(amount)
self.balance = self.balance - amount
end

-- can create an Account using call notation!
acc = Account(1000)
acc:withdraw(100)