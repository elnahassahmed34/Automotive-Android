# Concurrency 

## Multi Threading
1. Sequential Excution
2. Parellelism 
    - multi core
    - multi processor (CPU)
3. Concurrency : Seemingly Parllel (like RTOS)

## Scheduling Type
1. Priority Based
2. Round Robin
3. FCFS First come first serve
4. SJF shortest job first  
5. EDF Earliest deadlline first 


## CPU freq
- 1MHz -> Tick Time = 1 us
- One Instruction 
    - machine cycle F + D + E 
    - Instruction cycle F | D | E
- Advanced CPU -> 1 GHZ = tick time = 1 ns

## Context Switching
- Schedular (1ms)
- SP , PC , Regs -> save TCB = Task control block
- Time Slicing : All tasks share same timing of excution


## Why multi threading ?
1. Efficiency
2. Avoid blocking


## multi threading in c++ 11
- pthread
- Boost
- 3rd lib party

## process vs Thread
### Process = app 
    - main.cpp + compile = a.out (passive entity)
    - system loader + a.out = Active entity (running)

- PCB = process control block
    - stack 
    - PID
    - childs

### thread
#### HW thread SMT (hyper threading) 
- 1 core = 2 threads

#### SW thread  
- Instructions to be excuted

#### sw thread + OS schedule -> hw thread

## process vs thread
|      proces                 |      thread      |
|:--------------------------- |:----------------------|
| hard to create + mange      | Easier |
| don't share same addr       | share |
| hard to share data          | easier | 
| more context seitching      | less |


## Implementation Details of std::ref


- **std::reference_wrapper** Class:The core of std::ref is the std::reference_wrapper class. This class is a simple wrapper around a reference to an object. It allows the reference to be copied and stored in standard containers, which typically require value types.
- **Reference Storage**:std::reference_wrapper stores a reference to an object of type T. This reference is stored internally as a pointer (T*), since pointers can be copied and assigned, which isn't the case with references.
- **Construction and Access**:std::reference_wrapper can be constructed from a reference to an object. The stored reference can be accessed using the get() member function or by using the type-cast operator to T&.
- **Usage with std::ref**:The std::ref function template creates a std::reference_wrapper for the provided object. This is useful when you want to pass arguments to a function, like a thread or a callback, by reference.

