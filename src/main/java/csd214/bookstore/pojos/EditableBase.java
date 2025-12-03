package csd214.bookstore.pojos;

public abstract class EditableBase implements Editable {
    private Long id;

    protected EditableBase() { }

    protected EditableBase(Long id) { this.id = id; }

    @Override
    public Long getId() { return id; }

    @Override
    public void setId(Long id) { this.id = id; }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " Editable{id=" + id + "}";
    }
}
