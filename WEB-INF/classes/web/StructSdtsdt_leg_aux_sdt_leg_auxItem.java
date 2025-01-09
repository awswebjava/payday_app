package web ;
import com.genexus.*;

public final  class StructSdtsdt_leg_aux_sdt_leg_auxItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_leg_aux_sdt_leg_auxItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_leg_aux_sdt_leg_auxItem.class ));
   }

   public StructSdtsdt_leg_aux_sdt_leg_auxItem( int remoteHandle ,
                                                ModelContext context )
   {
      gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegerroraux = "" ;
      gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegimpcontr = new java.math.BigDecimal(0) ;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   public int getLegnumero( )
   {
      return gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Legnumero ;
   }

   public void setLegnumero( int value )
   {
      gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_N = (byte)(0) ;
      gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Legnumero = value ;
   }

   public byte getLiqlegauxestado( )
   {
      return gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegauxestado ;
   }

   public void setLiqlegauxestado( byte value )
   {
      gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_N = (byte)(0) ;
      gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegauxestado = value ;
   }

   public String getLiqlegerroraux( )
   {
      return gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegerroraux ;
   }

   public void setLiqlegerroraux( String value )
   {
      gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_N = (byte)(0) ;
      gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegerroraux = value ;
   }

   public java.math.BigDecimal getLiqlegimpcontr( )
   {
      return gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegimpcontr ;
   }

   public void setLiqlegimpcontr( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_N = (byte)(0) ;
      gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegimpcontr = value ;
   }

   protected byte gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegauxestado ;
   protected byte gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_N ;
   protected int gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Legnumero ;
   protected String gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegerroraux ;
   protected java.math.BigDecimal gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegimpcontr ;
}

