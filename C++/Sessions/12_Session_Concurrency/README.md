# Concurrency 2

## Deadlock

### conditions:
1. mutex
2. hold and wait
3. no preemtion
4. circular wait

### how to prevent
1. RAII functions (locking)
2. Avoid Hold & wait
3. Use preemtion
4. RAG (Resource alloction graph)

## Atomic operation 
- (Reentrant) 
- primitive data types -> else use mutex
- std::atomic<>

## mutex
- sync mechanism
- provide unique lock for recource
- std::mutex myMutex;
    - lock
    - unlock
    - try_lock
- RAII -> classes or functions as smart ptrs
    - used with threads
    - std::lock_guard() 
    - std::unique_guard();
    - std::scope_block 
- timed_mutex
- recursive_mutex
- condition variable

## - semaphores -> counter sync mechanism
- acquire
- release
- binary vs counting


