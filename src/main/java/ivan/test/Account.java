package ivan.test;

/**
 * Created by Ivan.Luo
 * Date: 2/22/2017 9:23 AM
 */
public class Account
{
	private int id;
	private String name;

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Account account = (Account) o;

		if (id != account.id)
			return false;
		return !(name != null ? !name.equals(account.name) : account.name != null);

	}

	@Override
	public int hashCode()
	{
		int result = id;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		return result;
	}

	public int getId()
	{

		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
