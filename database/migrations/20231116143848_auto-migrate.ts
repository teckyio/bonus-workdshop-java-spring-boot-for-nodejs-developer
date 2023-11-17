import { Knex } from 'knex'

export async function up(knex: Knex): Promise<void> {
  await knex('order').delete()
  await knex.schema.alterTable('order', table => {
    table.enum('status', ['pending', 'delivered', 'cancelled']).notNullable()
  })
}

export async function down(knex: Knex): Promise<void> {
  await knex.schema.alterTable('order', table => {
    table.dropColumn('status')
  })
}
