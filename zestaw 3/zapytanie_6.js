// 6. Dodaj siebie do bazy, zgodnie z formatem danych użytych dla innych osób (dane dotyczące karty kredytowej, adresu zamieszkania i wagi mogą być fikcyjne)
db.people.insert({
  sex: 'Male',
  first_name: 'Sebastian',
  last_name: 'Tomczuk',
  job: 'Student',
  email: 'stomczuk@gmail.com',
  location: {
    city: 'Warsaw',
    address: { streetname: 'Warszawska', streetnumber: '21' }
  },
  description: "desc",
  height: 183,
  weight: 90,
  birth_date: '1993-12-24T05:44:11Z',
  nationality: 'Poland',
  credit: [
    {
      type: 'mastercard',
      number: '3386083122891962',
      currency: 'PLN',
      balance: '100'
    }
  ]
});
