package web ;
import com.genexus.*;

public final  class StructSdtsdt_migrleg_sdt_migrlegItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_migrleg_sdt_migrlegItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_migrleg_sdt_migrlegItem.class ));
   }

   public StructSdtsdt_migrleg_sdt_migrlegItem( int remoteHandle ,
                                                ModelContext context )
   {
      gxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegid = "" ;
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

   public int getMigrlegnumero( )
   {
      return gxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegnumero ;
   }

   public void setMigrlegnumero( int value )
   {
      gxTv_Sdtsdt_migrleg_sdt_migrlegItem_N = (byte)(0) ;
      gxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegnumero = value ;
   }

   public String getMigrlegid( )
   {
      return gxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegid ;
   }

   public void setMigrlegid( String value )
   {
      gxTv_Sdtsdt_migrleg_sdt_migrlegItem_N = (byte)(0) ;
      gxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegid = value ;
   }

   protected byte gxTv_Sdtsdt_migrleg_sdt_migrlegItem_N ;
   protected int gxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegnumero ;
   protected String gxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegid ;
}

