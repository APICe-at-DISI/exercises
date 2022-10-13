package it.unibo.collections.design.impl;

import it.unibo.collections.design.api.Product;

/**
 * Product implementation.
 * 
 */
public final class ProductImpl implements Product {

    private final String name;
    private final double quantity;

    /**
     * @param n
     *            the product name
     * @param q
     *            the product quantity
     */
    public ProductImpl(final String n, final double q) {
        super();
        this.name = n;
        this.quantity = q;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getQuantity() {
        return quantity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        return obj == this || obj instanceof ProductImpl p && p.name.equals(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "ProductImpl [name=" + name + ", quantity=" + quantity + "]";
    }
}
