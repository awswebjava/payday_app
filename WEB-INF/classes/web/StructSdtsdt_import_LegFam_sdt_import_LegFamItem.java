package web ;
import com.genexus.*;

public final  class StructSdtsdt_import_LegFam_sdt_import_LegFamItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_import_LegFam_sdt_import_LegFamItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_import_LegFam_sdt_import_LegFamItem.class ));
   }

   public StructSdtsdt_import_LegFam_sdt_import_LegFamItem( int remoteHandle ,
                                                            ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Parcod = "" ;
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnrodoc = "" ;
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famtomadeducimpgan = new java.math.BigDecimal(0) ;
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac = cal.getTime() ;
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnomape = "" ;
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac_N = (byte)(1) ;
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

   public String getParcod( )
   {
      return gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Parcod ;
   }

   public void setParcod( String value )
   {
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_N = (byte)(0) ;
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Parcod = value ;
   }

   public boolean getFamdiscap( )
   {
      return gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famdiscap ;
   }

   public void setFamdiscap( boolean value )
   {
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_N = (byte)(0) ;
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famdiscap = value ;
   }

   public String getFamnrodoc( )
   {
      return gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnrodoc ;
   }

   public void setFamnrodoc( String value )
   {
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_N = (byte)(0) ;
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnrodoc = value ;
   }

   public java.math.BigDecimal getFamtomadeducimpgan( )
   {
      return gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famtomadeducimpgan ;
   }

   public void setFamtomadeducimpgan( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_N = (byte)(0) ;
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famtomadeducimpgan = value ;
   }

   public boolean getFamadherente( )
   {
      return gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famadherente ;
   }

   public void setFamadherente( boolean value )
   {
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_N = (byte)(0) ;
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famadherente = value ;
   }

   public java.util.Date getFamfecnac( )
   {
      return gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac ;
   }

   public void setFamfecnac( java.util.Date value )
   {
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac_N = (byte)(0) ;
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_N = (byte)(0) ;
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac = value ;
   }

   public String getFamnomape( )
   {
      return gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnomape ;
   }

   public void setFamnomape( String value )
   {
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_N = (byte)(0) ;
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnomape = value ;
   }

   protected byte gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac_N ;
   protected byte gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_N ;
   protected String gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Parcod ;
   protected String gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnrodoc ;
   protected boolean gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famdiscap ;
   protected boolean gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famadherente ;
   protected String gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnomape ;
   protected java.math.BigDecimal gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famtomadeducimpgan ;
   protected java.util.Date gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac ;
}

