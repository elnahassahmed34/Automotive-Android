# smart pointer + rules

## types of smart ptrs
- unique , shared , weak

## unique ptrs
- std::unique_ptr<int> uptr(new int(100));

- std::unique_ptr<class> uptr2 = std::make_unique<class>();

- error : std::unique_ptr<int> uptr = new int(100);


## shred ptr
- shared_ptr<c> p1(new c) p1;
- 
