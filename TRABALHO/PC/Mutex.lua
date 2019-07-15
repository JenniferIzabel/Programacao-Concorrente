require "class"

local Mutex = class {
    identities = {},
    new = function(cls, identity)
        assert(not cls.identities[identity])
        local inst = getmetatable(cls).new(cls, {
            port = identity,
            server = nil
        })
        cls.identities[identity] = inst
        return inst
    end,
    lock = function(self, wait)
        local wait = wait or 0.01
        local server
        local ts = Timestamp.get()
        repeat
            server = socket.bind("*", self.port)
            if server then
                self.server = server
                return true
            else
                sleep(wait)
            end
            assert(Timestamp.get() - ts < 3, 'deadlock')
        until server
    end,
    unlock = function(self)
        self.server:close()
        self.server = nil
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