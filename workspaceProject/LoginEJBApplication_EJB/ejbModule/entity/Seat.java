package entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the seat database table.
 * 
 */
@Entity
@Table(name="seat")
@NamedQueries({
@NamedQuery(name="Seat.findAll", query="SELECT s FROM Seat s"),
@NamedQuery(name="Seat.findById", query="SELECT s FROM Seat s  where s.idSeat=:idSeat"),
@NamedQuery(name="Seat.find", query="SELECT s FROM Seat s where s.idSeat=:idSeat"),
})
	public class Seat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_seat")
	private int idSeat;

	private String seat_CA;

	private String seat_CB;

	private String seat_CC;

	private String seat_CD;

	//bi-directional many-to-one association to Artiste
	@OneToMany(mappedBy="seat", cascade = CascadeType.ALL)
	private List<Artiste> artistes = new ArrayList<>();

	public Seat() {
	}

	public int getIdSeat() {
		return this.idSeat;
	}

	public void setIdSeat(int idSeat) {
		this.idSeat = idSeat;
	}

	public String getSeat_CA() {
		return this.seat_CA;
	}

	public void setSeat_CA(String seat_CA) {
		this.seat_CA = seat_CA;
	}

	public String getSeat_CB() {
		return this.seat_CB;
	}

	public void setSeat_CB(String seat_CB) {
		this.seat_CB = seat_CB;
	}

	public String getSeat_CC() {
		return this.seat_CC;
	}

	public void setSeat_CC(String seat_CC) {
		this.seat_CC = seat_CC;
	}

	public String getSeat_CD() {
		return this.seat_CD;
	}

	public void setSeat_CD(String seat_CD) {
		this.seat_CD = seat_CD;
	}

	public List<Artiste> getArtistes() {
		return this.artistes;
	}

	public void setArtistes(List<Artiste> artistes) {
		this.artistes = artistes;
	}

	public Artiste addArtiste(Artiste artiste) {
		getArtistes().add(artiste);
		artiste.setSeat(this);

		return artiste;
	}

	public Artiste removeArtiste(Artiste artiste) {
		getArtistes().remove(artiste);
		artiste.setSeat(null);

		return artiste;
	}

}