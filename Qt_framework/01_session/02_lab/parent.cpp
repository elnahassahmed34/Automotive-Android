#include "parent.h"
#include "child.h"

Parent::Parent(QObject *parent)
    : QObject{parent}
{
    Child *child = new Child(this); // The child is created with 'this' as its parent
}
