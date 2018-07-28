<where>
  <if test="userName != null and userName != ''">
      and user_name like concat('%',#{userName},'%')
  </if>
  <if test="suerEmail != null and userEmail != ''">
      and user_email=#{userEmail}
  </if>
</where>
当if条件都不满足时，where元素中没有内容，所以在SQL中不会出现where。如果if满足条件where中的内容会出现,并会自动删除where后的第一个and.

<set>
	<if test="userName != null and userName != ''">
	    user_name=#{userName},
	</if>
	<if test="userEmail != null and userEmail != ''">
	    user_Email=#{userEmail},
	</if>
	    id=#{id},
</set>
使用set时要注意，最好把必选项放在最后并加"," set会去除","的。

where id in 
<foreach collection="list" open="(" close=")" separator="," item="id" index="i">
	#{id}
</foreach>
collection的取值取决于传入的参数类型。
private Object warpCollection(final Object object){
	if (object instanceof Collection) {
		StrictMap<Object> map=new StrictMap<Object>();
		map.put("collection",object);
		if (object instanceof List){
		  map.put("list",object);
		  }
		return map;
		}
	} else if(object!=null && object.getClass().isArray()){
	  StrictMap<Object> map=new StrictMap<Object>();
	  map.put("array",object);
	  return map;
	}
	return object;
 }

final 修饰符的作用
the final keyword in java is used to restrict the user.the java final keyword can be used in many context.final can be:
variable,method,class
1 stop value change
2 stop method overridding
3 stop class inheritance

1) example of final variable
public class HelloWorld{

public static void main(String []args){
     Bike9 obj=new Bike9();
      obj.run();
    }
        
}
class Bike9{
    final int speedlimit=90;//final variable
    void run(){
        speedlimit=400;
    }
}
oupput:error: cannot assign a value to final variable speedlimit speedlimit=400;

2) example of final method
if you make any mwthod as final,you can not override it.

public class HelloWorld{
     public static void main(String []args){
        Honda honda=new Honda();
        honda.run();
         }
}
class Bike9{
    final void run(){System.out.println("running");}
}
class Honda extends Bike9{
    void run(){System.out.println("running safely with 100kmph");}
}

output:run() in Honda cannot override run() in Bike9 void run(){System.out.println("running safely with 100kmph");}

3) java final class

if you make any class as final,you cannot extend it.

final class Bike9{
    void run(){System.out.println("running");}
}
class Honda extends Bike9{
    void run(){System.out.println("running safely with 100kmph");}
}

output: error: cannot inherit from final Bike9

Q) Is final method inherited?
Ans) Yes, final method is inherited but you cannot override it.

Q) What is blank or uninitialized final variable?
A final variable that is not initialized at the time of declaration is known as blank final variable.

If you want to create a variable that is initialized at the time of creating object and once initialized may not be changed, it is useful. 

It can be initialized only in constructor.

Q) Can we initialize blank final variable?
Yes, but only in constructor. 

static blank final variable
A static final variable that is not initialized at the time of declaration is known as static blank final variable. It can be initialized only in static block.

Q) What is final parameter?
If you declare any parameter as final, you cannot change the value of it.

Q) Can we declare a constructor final?
No, because constructor is never inherited.

instanceof
The java instanceof operator is used to test whether the object is an instance of the specified type(class or subclass or interface)

The instanceof in java is also known as type comparison operator because it compares the instance with type. it returns either true or flase. if we apply the instanceof operator with any vriable that has null value,it returns false.

Example


downcast 向下类型转化
interface Printable{}  
class A implements Printable{  
	public void a(){	
		System.out.println("a method");
		}  

}  
class B implements Printable{  
	public void b(){
		System.out.println("b method");
		}  
}  
  
class Call{  
	void invoke(Printable p){//upcasting  
		if(p instanceof A){  
			A a=(A)p;//Downcasting   
			a.a();  
		}  
		if(p instanceof B){  
			B b=(B)p;//Downcasting   
			b.b();  
		}  
  
	}  
}//end of Call class  
  
class Test4{  
	public static void main(String args[]){  
		Printable p=new B();  
		Call c=new Call();  
		c.invoke(p);  
	}  
}  

output:b method

Map 知识
Java List Interface

List Interface is the subinterface of collection.It contains methods to insert and deleete elements in index basic.It is a factory of ListIterator interface.

List Interface declaration

public interface List<E> extends Collection<E>

Methods of Java List Interface

void add(int index,Object element)
boolean addAll(int index,Collection c)
Object get(int index)
Object set(int index,Object element)
Object remove(int index)
ListIterator listIterator()
ListIterator listIterator(int index)

Java ListIterator Interface

ListIterator Interface is used to traverse element in forword and backword direction.

ListIteartor Interface Declaration

public interface ListIterator<E> extends Iterator<E>

Methods of ListIterator Interface

boolean hasNext()
Object nect()
boolean hasPrevious()
Object previous()

Java Map Interface

A map contains values on the basic of key i.e key and value pair.Each key and value pair is known as an entry.Map contains only unique keys.

Map is useful if you have to search,update or delete elements on the basic of key

Useful methods of Map interface

Object put(Object key,Object value)
void put(Map map)
Object remove(Object key)
boolean containsKey(Object key)
Set ketSet()
Set entrySet()

Map.Entry Interface

Entry is the sub interface of Map.Entry.So we will be accessed it by Map.Entry name.It provides methods to get key and value.

Methods of Map.Entry interface

Object getKey()
Object getValue()

Java Map Example

Map<Integer,String> map=new HashMap<Integer,String>()
map.put(100,"Amit)
map.put(101,"Vijay")
map.put(102,"Rahui")
for(Map.Entry m:map.entrySet()){
  System.out.println(m.getKey()+" "+m.getValue())
}

判断是否为数组类型的方法
1.instanceof
2.object.getClass().isArray()
