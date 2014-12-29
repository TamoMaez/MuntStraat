package domain;

public class Business {
	private String name;
	private String type;
	private Address address;
	private String url;
	private String imageUrl;
	private String tel;
	private String slogan;
	
	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public Business() {}

	public Business(String name, String type, Address address) {
		setName(name);
		setType(type);
		setAddress(address);
	}
	
	public Business(String name, String type, Address address, String url) {
		this(name, type, address);
		setUrl(url);
	}
	
	public Business(String name, String type, Address address, String url, String tel) {
		this(name, type, address, tel);
	}
	
	public Business(String name, String type, String street, String number, String url, String tel, String imgUrl, String slogan) {
		this(name, type, new Address(street, number), tel);
		setUrl(url);
		setImageUrl(imgUrl);
		setSlogan(slogan);
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null");
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		if(type == null || type.isEmpty()) throw new IllegalArgumentException("Type cannot be null");
		this.type = type;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Business other = (Business) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
