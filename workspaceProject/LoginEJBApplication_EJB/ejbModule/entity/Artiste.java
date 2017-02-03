package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the artiste database table.
 * 
 */
@Entity
@Table(name="artiste")
@NamedQueries({
@NamedQuery(name="Artiste.findAll", query="SELECT a FROM Artiste a"),
@NamedQuery(name="Artiste.findById", query="SELECT a FROM Artiste a  where a.seat=:id_seat"),
@NamedQuery(name="Artiste.find", query="SELECT a FROM Artiste a where a.a_name=:a_name"),
@NamedQuery(name="Artiste.findBya_category", query="SELECT a FROM Artiste a where a.a_category=:a_category"),
@NamedQuery(name="Artiste.findBydate", query="SELECT a FROM Artiste a where a.date=:date"),
})
public class Artiste implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_artiste")
	private int id_artiste;
	@Column(name="a_name")
	private String a_name;
	@Column(name="a_category")
	private String a_category;
	@Column(name="date")
	private String date;

	//bi-directional many-to-one association to Seat
	@ManyToOne
	@JoinColumn(name="id_seat")
	private Seat seat;

	public Artiste() {
	}
	
	public int getId_artiste() {
		return this.id_artiste;
	}

	public void setId_artiste(int id_artiste) {
		this.id_artiste = id_artiste;
	}
	
	public String getA_name() {
		return this.a_name;
	}

	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	
	public String getA_category() {
		return this.a_category;
	}

	public void setA_category(String a_category) {
		this.a_category = a_category;
	}
		
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Seat getSeat() {
		return this.seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

}