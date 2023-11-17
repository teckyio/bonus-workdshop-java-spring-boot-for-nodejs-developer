import { Knex } from 'knex'
import { Category, Food } from '../types'

export async function seed(knex: Knex): Promise<void> {
  async function seedRow(table: string, data: object) {
    let row = await knex(table).where(data).select('id').first()
    if (row) {
      return row.id
    }
    let rows = await knex(table).insert(data).returning('id')
    return rows[0].id
  }

  async function seedCategory(data: Category) {
    return await seedRow('category', data)
  }
  async function seedFood(data: Food) {
    return await seedRow('food', data)
  }

  let main_dish_id = await seedCategory({ name: 'main dish' })
  let drink_id = await seedCategory({ name: 'drink' })
  await seedCategory({ name: 'snack' })

  await seedFood({
    category_id: main_dish_id,
    name: 'Burger',
    price: 60,
    image_url: 'https://picsum.photos/seed/burger/200/200',
  })
  await seedFood({
    category_id: main_dish_id,
    name: 'Pasta',
    price: 45,
    image_url: 'https://picsum.photos/seed/pasta/200/200',
  })
  await seedFood({
    category_id: drink_id,
    name: 'Orange Juice',
    price: 12,
    image_url: 'https://picsum.photos/seed/orange-juice/200/200',
  })
}
