import riak
riakClient = riak.RiakClient(pb_port=8087)

bucket = riakClient.bucket('s22778')

# dodanie
student = {'name': 'Sebastian', 'surname': 'Tomczuk', 'isVegan': True}
key = bucket.new('student', data=student)
key.store()
print('Dodano studenta')


# pobranie i wypisanie
student1 = bucket.get('student')
print('Dane nowo dodanego studenta: ' + str(student1.data))


# modyfikacja
student1.data['isVegan'] = False
student1.store()

student2 = bucket.get('student')
print('Zmodyfikowano pole isVegan: ' + str(student2.data.isVegan))


# usuwanie
student2.delete()
print('student usuniety')
student3 = bucket.get('student')
print('Pobrany usuniety student: ' + str(student3.data))

