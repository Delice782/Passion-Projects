
# Essentials Store Cash Management System

## Project Overview

The `EssentialsStore.java` program is a simple Java application developed for Essentials Shop to manage cash transactions effectively. It calculates the change due to a customer after a purchase and provides a detailed breakdown of the denominations (notes and coins) in Ghana Cedis (₵) to be given as change. The software ensures that the output is neatly formatted, suitable for printing on receipt slips, and adheres to the requirements of displaying currency figures accurately to two decimal places with the appropriate currency symbol.

## Features

- **Denomination Breakdown:** Calculates and provides a breakdown of notes and coins for the change due.
- **Currency Formatting:** Displays the Ghana Cedi currency symbol (₵) and formats currency figures to two decimal places.
- **Neat Output:** Formats the output to be print-friendly for receipt slips.
- **User Input:** Accepts user input for the total cost of items purchased and the amount paid by the customer.

## How It Works

- The program prompts the user to enter the total cost of items purchased and the amount paid.
- It then calls the `computeChangeBreakdown` method to calculate the change due and provide a detailed breakdown of the change in Ghana Cedis (₵), listing only the denominations required.
- The output is formatted according to the specified requirements, ready to be presented on a receipt slip.