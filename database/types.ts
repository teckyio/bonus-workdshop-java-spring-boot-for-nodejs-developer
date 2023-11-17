export type Category = {
  id?: null | number
  name: string
}

export type Food = {
  id?: null | number
  name: string
  price: number
  image_url: string
  category_id: number
  category?: Category
}

export type Order = {
  id?: null | number
  food_id: number
  food?: Food
  quantity: number
  status: ('pending' | 'delivered' | 'cancelled')
}
