require 'class'

ThreadSafeQueue = class {
    new = function(cls)
        return getmetatable(cls).new(cls, {
            mx_queue = Mutex:new(),
            mx_push = Mutex:new(),
        })
    end,
    pop = function(self)
        local lock_queue = self.mx_queue:lock(self)
        local val
        if #self then
            val = table.remove(self, 1)
        else
            val = nil
        end
        self.mx_queue:unlock(lock_queue)
        return val
    end,
    push = function(self, val)
        if val == nil then return end
        -- don't `push()` from few threads at the same time
        local lock_push = self.mx_push:lock(val)
        -- don't `pop()` when `push()` and `push()` when `pop()`
        local lock_queue = self.mx_queue:lock(self)
        self[#self + 1] = val
        self.mx_queue:unlock(lock_queue)
        self.mx_push:unlock(lock_push)
    end
}

Account = class(function(acc,balance)
    acc.balance = balance
 end)

function Account:withdraw(amount)
self.balance = self.balance - amount
end

-- can create an Account using call notation!
acc = Account(1000)
acc:withdraw(100)