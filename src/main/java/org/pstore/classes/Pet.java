package org.pstore.classes;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Pet {

 private String id = null;
    private Category category = null;
    private String name = null;
    private List<String> photoUrls = new ArrayList<String>();
    private List<Tag> tags = new ArrayList<Tag>();
    private StatusEnum status = null;

    public Pet(String id, Category category, String name, List<String> photoUrls, List<Tag> tags, StatusEnum status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public Pet() {
        id = RandomStringUtils.randomNumeric(10);
        name = "PetName" + RandomStringUtils.randomAlphabetic(8);
        status = StatusEnum.available;
    }

    public Pet id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Pet category(Category category) {
        this.category = category;
        return this;
    }

    /**
     * Get category
     *
     * @return category
     **/

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Pet name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pet photoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
        return this;
    }

    public Pet addPhotoUrlsItem(String photoUrlsItem) {
        this.photoUrls.add(photoUrlsItem);
        return this;
    }

    /**
     * Get photoUrls
     *
     * @return photoUrls
     **/

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public Pet tags(List<Tag> tags) {
        this.tags = tags;
        return this;
    }

    public Pet addTagsItem(Tag tagsItem) {
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * Get tags
     *
     * @return tags
     **/

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Pet status(StatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * pet status in the store
     *
     * @return status
     **/

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pet pet = (Pet) o;
        return Objects.equals(this.id, pet.id) &&
                Objects.equals(this.category, pet.category) &&
                Objects.equals(this.name, pet.name) &&
                Objects.equals(this.photoUrls, pet.photoUrls) &&
                Objects.equals(this.tags, pet.tags) &&
                Objects.equals(this.status, pet.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, name, photoUrls, tags, status);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Pet {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    category: ").append(toIndentedString(category)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    photoUrls: ").append(toIndentedString(photoUrls)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
